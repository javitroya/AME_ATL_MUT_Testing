package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrllView implements ActionListener{

	Window w;
	
	public CtrllView(Window w){
		this.w = w;
	}	

	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(View.ATL_TRANS)){
			w.atlTransformationClick();
		} else if(e.getActionCommand().equals(View.SRC_MM)){
			w.srcMMEcoreClick();
		} else if(e.getActionCommand().equals(View.TRG_MM)){
			w.trgMMEcoreClick();
		} else if(e.getActionCommand().equals(View.CSV_FILE)){
			w.csvFileClick();
		} else if(e.getActionCommand().equals(View.GET_SM)){
			w.getSMClick();
		} 
	}	
}
