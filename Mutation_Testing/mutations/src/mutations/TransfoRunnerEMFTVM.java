package mutations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Map;

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
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.engine.compiler.*;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;

import ATL.ATLPackage;
import ATL.impl.ATLPackageImpl;
import OCL.impl.OCLPackageImpl;
import PrimitiveTypes.impl.PrimitiveTypesPackageImpl;

public class TransfoRunnerEMFTVM {
	

	public void runTransformation(String pathSrcModel, String srcMMname,
			String modulePath, String moduleName)
					throws ATLCoreException, IOException, MalformedURLException, FileNotFoundException {
		
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(EmftvmPackage.eNS_URI,	EmftvmPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());
		
		rs.getPackageRegistry().put("http://www.eclipse.org/gmt/2005/ATL", ATLPackageImpl.eINSTANCE);
		
		
		// Load metamodels
		Metamodel mm1 = EmftvmFactory.eINSTANCE.createMetamodel();
//		mm1.setResource(( (EMFReferenceModel) AtlParser.getDefault().getAtlMetamodel()).getResource());
		mm1.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/gmt/2005/ATL"), true));
//		mm1.setResource(rs.getResource(URI.createURI("metamodels/ATL.ecore"), true));
		env.registerMetaModel(srcMMname, mm1);
		
//		// Load models
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(rs.getResource(URI.createURI(pathSrcModel, true), true));
		env.registerInOutModel("IN", inModel);

//		Model outModel = EmftvmFactory.eINSTANCE.createModel();
//		outModel.setResource(rs.createResource(URI.createFileURI("files/PetriNet2PNML-out.xmi")));
//		env.registerOutputModel("OUT", outModel);

		// Load and run module
		ModuleResolver mr = new DefaultModuleResolver(modulePath, rs);
		TimingData td = new TimingData();
		env.loadModule(mr, moduleName);
		td.finishLoading();
		env.run(td);
		td.finish();

		// Save models
		inModel.getResource().save(Collections.emptyMap());
//		outModel.getResource().save(Collections.emptyMap());
		
		
	}	

	public void runTransformation(String pathSrcModel1, String srcMMname1,
			String pathSrcModel2, String srcMMname2,
			String pathSrcModel3, String srcMMname3,
			String modulePath, String moduleName)
					throws ATLCoreException, IOException, MalformedURLException, FileNotFoundException {
		
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(EmftvmPackage.eNS_URI,	EmftvmPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());
		
		rs.getPackageRegistry().put("http://www.eclipse.org/gmt/2005/ATL", ATLPackageImpl.eINSTANCE);
		rs.getPackageRegistry().put("http://www.eclipse.org/gmt/2005/OCL", OCLPackageImpl.eINSTANCE);
		rs.getPackageRegistry().put("http://www.eclipse.org/gmt/2005/ATL-PrimitiveTypes", PrimitiveTypesPackageImpl.eINSTANCE);
		
		// Load metamodels
		Metamodel mm1 = EmftvmFactory.eINSTANCE.createMetamodel();
		mm1.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/gmt/2005/ATL"), true));
		env.registerMetaModel("ATL", mm1);
		
		Metamodel mm2 = EmftvmFactory.eINSTANCE.createMetamodel();
		mm2.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/emf/2002/Ecore"), true));
//		mm2.setResource(rs.getResource(URI.createURI("Metamodels/Ecore.ecore"), true));
		env.registerMetaModel("IN_MM", mm2);
		
		Metamodel mm3 = EmftvmFactory.eINSTANCE.createMetamodel();
		mm3.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/emf/2002/Ecore"), true));
//		mm2.setResource(rs.getResource(URI.createURI("Metamodels/Ecore.ecore"), true));
		env.registerMetaModel("OUT_MM", mm3);
		
		Metamodel mm4 = EmftvmFactory.eINSTANCE.createMetamodel();
		mm4.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/gmt/2005/OCL"), true));
		env.registerMetaModel("OCL", mm4);
		
//		for (String s : env.getMetaModels().keySet()){
//			System.out.println(s + " --- " + env.getMetaModels().get(s));
//		}
		
//		// Load models
		Model inOutModel = EmftvmFactory.eINSTANCE.createModel();
		inOutModel.setResource(rs.getResource(URI.createURI(pathSrcModel1, true), true));
		env.registerInOutModel("IN", inOutModel);

		Model inModel1 = EmftvmFactory.eINSTANCE.createModel();
		inModel1.setResource(rs.getResource(URI.createURI(pathSrcModel2, true), true));
		env.registerInputModel("IN_MM", inModel1);
		
		Model inModel2 = EmftvmFactory.eINSTANCE.createModel();
		inModel2.setResource(rs.getResource(URI.createURI(pathSrcModel3, true), true));
		env.registerInputModel("OUT_MM", inModel2);

		// Load and run module
		ModuleResolver mr = new DefaultModuleResolver(modulePath, rs);
		TimingData td = new TimingData();
		env.loadModule(mr, moduleName);
		td.finishLoading();
		env.run(td);
		td.finish();

		// Save models
		inOutModel.getResource().save(Collections.emptyMap());
//		outModel.getResource().save(Collections.emptyMap());
		
		
	}	

}