package runGUI;

import java.io.IOException;

import org.eclipse.emf.ecore.xmi.PackageNotFoundException;
import org.eclipse.m2m.atl.core.ATLCoreException;

import gui.*;
import exceptions.TransformationException;
import exceptions.UseCommandException;

public class RunTE {

	public static void main(String[] args) {
		try{
			runEcoreExample();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void runEcoreExample() throws PackageNotFoundException, InterruptedException, IOException, UseCommandException, TransformationException, ATLCoreException{
		Window w = new Window();
		CtrllView cv = new CtrllView(w);
		w.controller(cv);
	}

}
