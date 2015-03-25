package mutations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.m2m.atl.engine.compiler.*;

public class TransfoRunner {

	public static void main(String[] args) throws ATLCoreException, IOException {

		
		String srcMM = "example_3\\sWML.ecore";
		String srcMM_name = "sWML";
		String trgMM_name = "MVC";
		String trgMM = "example_3\\smvcml.ecore";
		String srcM = "example_3\\sWML_Model.xmi";
		String trgM = "example_3\\smvcml_Model.xmi";
		String transformation = "example_3/SWML2MVC.atl";
		String asmFile = transformation.replaceFirst(".atl", ".asm");
		
		TransfoRunner atr = new TransfoRunner();
		atr.compileTransformation(transformation, asmFile);
		
		atr.runTransformation(srcMM, srcMM_name, trgMM_name, trgMM, srcM, trgM,
				asmFile);
	}
	
	public void transform(String pathSrcMM,
			String pathSrcModel, String pathTrgMM, String pathTrgModel,
			String pathTransfo, String srcMMname, String trgMMname,
			String pathTempFolder) throws InterruptedException,
			MalformedURLException, IOException, ATLCoreException {

		String asmFile = pathTempFolder+"/transformationToTest.asm";
		
		TransfoRunner tr = new TransfoRunner();
		tr.compileTransformation(pathTransfo, asmFile);
		
		if (pathSrcMM.contains("http://") || pathSrcMM.contains("www.")){
			tr.runTransformation(pathSrcMM, srcMMname,
					trgMMname, "file:/"+pathTrgMM, 
					"file:/"+pathSrcModel, "file:/"+pathTrgModel, asmFile);
		}else{
			tr.runTransformation("file:/"+pathSrcMM, srcMMname,
					trgMMname, "file:/"+pathTrgMM, 
					"file:/"+pathSrcModel, "file:/"+pathTrgModel, asmFile);
		}
	}
	

	private void runTransformation(String srcMM, String srcMM_name,
			String trgMM_name, String trgMM, String srcM, String trgM,
			String asmFile) throws ATLCoreException, IOException,
			MalformedURLException, FileNotFoundException {
		
		ILauncher transformationLauncher = new EMFVMLauncher();
		ModelFactory modelFactory = new EMFModelFactory();
		IInjector injector = new EMFInjector();
		IExtractor extractor = new EMFExtractor();
		
		IReferenceModel srcMMRefM = modelFactory.newReferenceModel();
		injector.inject(srcMMRefM, srcMM);
		
		IReferenceModel trgMMRefM = modelFactory.newReferenceModel();
		injector.inject(trgMMRefM, trgMM);
		
		//****/
//		ModelFactory factory = new EMFModelFactory();
//		IInjector injector = new EMFInjector();
//	 	IReferenceModel ecoreMetamodel = factory.newReferenceModel();
//		injector.inject(srcMetamodel, getMetamodelUri("http://www.eclipse.org/emf/2002/Ecore"));
//		
//		IModel srcMMRefM = factory.newModel(ecoreMetamodel);
//		injector.inject(srcMMRefM, srcMM);
//		
//		IModel trgMMRefM = factory.newModel(ecoreMetamodel);
//		injector.inject(srcMMRefM, srcMM);
		//****/

		IModel srcMRefM = modelFactory.newModel(srcMMRefM);
		injector.inject(srcMRefM, srcM);
		
		IModel trgMRefM = modelFactory.newModel(trgMMRefM);
		
		System.out.println(srcMM + srcMM_name);
		
		transformationLauncher.initialize(new HashMap<String,Object>());
		transformationLauncher.addInModel(srcMRefM, "IN", srcMM_name);
		transformationLauncher.addOutModel(trgMRefM, "OUT", trgMM_name);
		transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), 
				new HashMap<String,Object>(),
		new FileInputStream(asmFile));

		extractor.extract(trgMRefM, trgM);
	}

	public void compileTransformation(String transformation, String asmFile) throws IOException, MalformedURLException {
		AtlCompiler.getCompiler(AtlCompiler.DEFAULT_COMPILER_NAME).
		 	compile(new File(transformation).toURL().openStream(), asmFile);
	}

	
	private ResourceSet readInModel(String pathEcoreMMFile) {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE; //Factory fuer Resourcen
		Map m = reg.getExtensionToFactoryMap();
		m.put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		
		Resource metamodel = resSet.getResource(URI.createURI(pathEcoreMMFile), true);
		EPackage ep0 = (EPackage) metamodel.getContents().get(0); 
		resSet.getPackageRegistry().put(ep0.getNsURI(), ep0);
		
		EPackage ep1 = (EPackage) metamodel.getContents().get(1); 
		resSet.getPackageRegistry().put(ep1.getNsURI(), ep1);
		
		EPackage ep2 = (EPackage) metamodel.getContents().get(2); 
		resSet.getPackageRegistry().put(ep2.getNsURI(), ep2);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put
		("xmi", new XMIResourceFactoryImpl(){ public Resource createResource(URI uri)
		{   XMIResource xmiResource = new XMIResourceImpl(uri);
			return xmiResource;
		} });
		return resSet;
	}
}


// Code that may be used to automatically read in model names from transformations...

//AtlParser parser=new AtlParser();
//InputStream stream = new FileInputStream(transformation);
//IModel parseToModel = parser.parseToModel(stream);
//extractor.extract(parseToModel, "example_3/transformation.xmi");
//
//ResourceSet resSet = readInModel("src\\metaModels\\ATL.ecore"); 
//Resource model = resSet.getResource(URI.createURI("example_3/transformation.xmi"), true);
//
//EObject rootObj = (EObject) model.getContents().get(0);
//
//EStructuralFeature inModelFeature = rootObj.eClass().getEStructuralFeature("inModels");
//EObject oclModel = (EObject)((List)rootObj.eGet(inModelFeature)).get(0);
//
//EStructuralFeature metamodelFeature = oclModel.eClass().getEStructuralFeature("metamodel");
//EObject srcOCLModel = (EObject) oclModel.eGet(metamodelFeature);
//
//System.out.println(srcOCLModel);
//
//EStructuralFeature nameFeature = srcOCLModel.eClass().getEStructuralFeature("location");
//System.out.println(srcOCLModel.eIsSet(nameFeature));
//srcMM_name = (String) srcOCLModel.eGet(nameFeature);
//
//EStructuralFeature outModelFeature = rootObj.eClass().getEStructuralFeature("outModels");
//EObject oclModel2 = (EObject)((List)rootObj.eGet(outModelFeature)).get(0);
//
//EObject oclModel_2 = (EObject) oclModel.eGet(metamodelFeature);
//trgMM_name = (String) oclModel_2.eGet(nameFeature);
//
//System.out.println(srcMM_name + " " +  trgMM_name);
