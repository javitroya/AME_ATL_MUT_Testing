package mutations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.ClassModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
//import org.eclipse.uml2.uml.resource.UMLResource;

public class Launcher {

	public void run() throws IOException {
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		
		ResourceSet rs = new ResourceSetImpl();
//		rs.getPackageRegistry().put(org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getNsURI(), org.eclipse.uml2.uml.UMLPackage.eINSTANCE);
		rs.getPackageRegistry().put(EmftvmPackage.eNS_URI,	EmftvmPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		
//		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
//		Map uriMap = rs.getURIConverter().getURIMap();
//		URI uri = URI.createURI("jar:file:/C:/Software/eclipse/plugins/org.eclipse.uml2.uml.resources_4.1.0.v20140202-2055.jar!/"); // for example
//		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri.appendSegment("libraries").appendSegment(""));
//		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri.appendSegment("metamodels").appendSegment(""));
//		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri.appendSegment("profiles").appendSegment(""));
		
		
		// Load metamodels
		Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		metaModel.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/uml2/4.0.0/UML"), true));
		env.registerMetaModel("UMLMM", metaModel);

		// Load models
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(rs.getResource(URI.createURI("test/resources/artist/umlprofiles/objectify_profile.profile.uml", true), true));
		env.registerInputModel("OBJECTIFY", inModel);

		Model inOutModel = EmftvmFactory.eINSTANCE.createModel();
		inOutModel.setAllowInterModelReferences(true);
		inOutModel.setResource(rs.getResource(URI.createURI("test/resources/artist/model/petstore_domain_objectified.uml", true), true));
		env.registerInOutModel("UMLM", inOutModel);
		
		Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(rs.createResource(URI.createFileURI("test/resources/artist/model/petstore_domain_objectified_daox.uml")));
		env.registerOutputModel("UMLM_OUT", outModel);

		// Load and run module
		ResourceSet moduleRS = new ResourceSetImpl();
		moduleRS.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());
		
		DefaultModuleResolver mr = new DefaultModuleResolver("test/resources/artist/trafo/", moduleRS);
		TimingData td = new TimingData();
		env.loadModule(mr, "DomainModelObjectificationDAO");
		td.finishLoading();
		env.run(td);
		td.finish();
		

		// Save models
		//inOutModel.getResource().save(Collections.emptyMap());
		
		URI outputURI = URI.createURI("test/resources/artist/model/petstore_domain_objectified_dao.uml", true);
		
		for(Model m : env.getInoutModels().values()) {
			System.out.println("Saving " + m);
			m.getResource().setURI(outputURI);
			m.getResource().save(Collections.emptyMap());
		}
		
		//FileOutputStream x = new FileOutputStream(new File("test/resources/artist/model/petstore_domain_objectified_dao.uml"));
		//inOutModel.getResource().save(x, Collections.emptyMap());
		outModel.getResource().save(Collections.emptyMap());
	}
	

}
