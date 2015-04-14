package mutations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.atl.core.*;

public class MainProgram {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException, ATLCoreException {
		
		/**PURPOSE OF THE FOLDERS IN THE PROJECT
		 * 
		 * HOTs needs to have all the generic HOTs as well as the second order HOT
		 * HOTs/temp will be storing temporal files when the program is executed, namely transformations injected into models
		 * HOTs/specific will store, when executing the program, the specific version of the generic HOTs
		 * 
		 * metamodels contains metamodels needed for the execution, such as the ATL metamodel
		 * 
		 * transformation contains as input the transformation that is going to be mutated, together with is input and output metamodels
		 * transformation/temp will be storing temporal files when the program is executed, namely transformations injected into models
		 */
		
		/**Input generic transformations**/
		List<String> HOTsGenericMutations = new ArrayList<String>();
		HOTsGenericMutations.add("AddInPatternElement_FirstRule");
		HOTsGenericMutations.add("DeleteLastOutPatternElement_LastRule");
		HOTsGenericMutations.add("DeleteBindingsWithoutReferredVariable");
		HOTsGenericMutations.add("ValueChangeBinding_All");
		
		/**Name of transformation to mutate, plus input and output metamodels**/
		String trans2Mutate = "PetriNet2PNML";
		String inputMM = "PetriNet.ecore";
		String outputMM = "PNML_simplified.ecore";
		
		String HOTs = "HOTs/";
		String transformation = "transformation/";
		String ATLMM = "metamodels/ATL.ecore";		
		
		/** All HOTs with generic mutations need to be injected into models: 
		 * AddInPatternElement.atl (HOTs with Generic Mutations) needs to be injected into model -> AddInPatternElement.xmi
		 * DeleteLastOutPatternElement_LastRule.atl needs to be injected into model -> DeleteLastOutPatternElement_LastRule.xmi */
		for (String hot : HOTsGenericMutations){
			ATLFile2Model t2m = new ATLFile2Model(HOTs + hot + ".atl", HOTs + "temp/" + hot + ".xmi");
			t2m.injectATLTrafo();
		}	
		
		/** The SecondOrderHOT takes as input, one by one, each of the generic HOTs (together with the input and
		 * output metamodels of the transformation we want to mutate) and generates one specific mutation for each of the generic ones.
		 * Since the generic HOTs (that serve as input) are rewritten by the in-place SecondOrderHOT, we first copy them
		 * into the folder HOTs/specific
		 */
		for (String hot : HOTsGenericMutations){
			copyFile(HOTs + "temp/" + hot + ".xmi", HOTs + "specific/" + hot + ".xmi");
			TransfoRunnerEMFTVM tr = new TransfoRunnerEMFTVM();
			tr.runTransformation(HOTs + "specific/" + hot + ".xmi", "ATL",
					transformation + inputMM, "IN_MM",
					transformation + outputMM, "OUT_MM",
					HOTs, "SecondOrderHOT"); //path name plus module name of the transformation
		}	

		/** The obtained models, stored in HOTs/specific/ are specific HOTs with mutations, in model format, 
		 * that need to be extracted to a file. They are kept in HOTs/specific
		*/
		for (String hot : HOTsGenericMutations){
			ATL_M2T m2t = new ATL_M2T(ATLMM,
					HOTs + "specific/" + hot + ".xmi",
					HOTs + "specific/" + hot + ".atl");
			m2t.extractATLTrafo();
		}

		/** The transformation to be mutated has to be injected to a model, which is kept in transformation/temp*/
		ATLFile2Model t2m_PetriNet = new ATLFile2Model(transformation + trans2Mutate + ".atl", 
												       transformation + "temp/" + trans2Mutate + ".xmi");
		t2m_PetriNet.injectATLTrafo();
		
		/** The specific HOTs that have been generated, stored in HOTs/specific, are to be applied on the original transformation,
		 * one by one, so that a real in-place behavior is achieved. The first step is to copy the original transformation into
		 * another one that will be mutated
		 */
		copyFile(transformation + "temp/" + trans2Mutate + ".xmi", transformation + "temp/" + trans2Mutate + "_Mutated" + ".xmi");
		for (String hot : HOTsGenericMutations){
			TransfoRunnerEMFTVM tr2 = new TransfoRunnerEMFTVM();
			tr2.runTransformation( transformation + "temp/" + trans2Mutate + "_Mutated" + ".xmi", "ATL",
					HOTs + "specific/", hot); //path name plus module name of the transformation
		}
		
		/** The obtained model is a transformation that has to be extracted into a file (ATL file) */ 
		ATL_M2T m2t_PetriNet = new ATL_M2T(ATLMM,
				transformation + "temp/" + trans2Mutate + "_Mutated" + ".xmi",
				transformation + trans2Mutate + "_Mutated" + ".atl");
		m2t_PetriNet.extractATLTrafo();
		
		System.out.println("The transformation " + trans2Mutate + ".atl has been successfully mutated!");
		System.out.println("The mutated transformation can be found in transformation/" + trans2Mutate + "_Mutated.atl");
	}
	
	public static void copyFile(String sourceFilePath, String destFilePath) throws IOException {
	   
		File sourceFile = new File(sourceFilePath);
		File destFile = new File(destFilePath);
		
		if(!destFile.exists()) {
	        destFile.createNewFile();
	    }

	    FileChannel source = null;
	    FileChannel destination = null;

	    try {
	        source = new FileInputStream(sourceFile).getChannel();
	        destination = new FileOutputStream(destFile).getChannel();
	        destination.transferFrom(source, 0, source.size());
	    }
	    finally {
	        if(source != null) {
	            source.close();
	        }
	        if(destination != null) {
	            destination.close();
	        }
	    }
	}
	
}
