package mutations;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.parser.AtlParser;


public class ATL_T2M {

	String atlFile;
	String atlModelPath;

	public ATL_T2M(String atlFile, String atlModel) {
		this.atlFile = atlFile;
		this.atlModelPath = atlModel;
	}

	/*public String injectATLTrafo() throws FileNotFoundException, ATLCoreException {

		AtlParser parser=new AtlParser();

		InputStream stream = new FileInputStream(atlFile);
		IModel parseToModel = parser.parseToModel(stream);
   
		IExtractor extractor = new EMFExtractor();
		extractor.extract(parseToModel, atlModel);
		
		return atlModel;
		
		//System.out.println("OK");
	}*/
	
	public void injectATLTrafo() throws FileNotFoundException, ATLCoreException {

		AtlParser parser=new AtlParser();

		InputStream stream = new FileInputStream(atlFile);
		IModel parseToModel = parser.parseToModel(stream);
   
		IExtractor extractor = new EMFExtractor();
		extractor.extract(parseToModel, atlModelPath);
		
		System.out.println("AtlFile2Model done!");
	}
	
	/*public void getModel(String atlFile, String atlModel) throws FileNotFoundException, ATLCoreException {
		ATLFile2Model injector;

		injector = new ATLFile2Model(atlFile, atlModel);
		injector.injectATLTrafo();
	}*/

}
