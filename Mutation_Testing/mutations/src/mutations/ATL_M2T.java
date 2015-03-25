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
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.engine.parser.AtlParser;


public class ATL_M2T {
	
	String atlMM;
	String atlFile;
	String atlModel;
	
	public ATL_M2T (String atlMM, String atlModel, String atlFile) {
		this.atlMM = atlMM;
		this.atlModel = atlModel;
		this.atlFile = atlFile;
	}
	
	public void extractATLTrafo() throws FileNotFoundException, ATLCoreException {
		
		AtlParser parser = new AtlParser();
		
		ModelFactory modelFactory = new EMFModelFactory();		
		IInjector injector = new EMFInjector();
		
		IReferenceModel srcMMRefM = modelFactory.newReferenceModel();
		injector.inject(srcMMRefM, atlMM);
		
		IModel srcMRefM = modelFactory.newModel(srcMMRefM);
		injector.inject(srcMRefM, atlModel);
		
		parser.extract(srcMRefM, atlFile);
		
	}

}
