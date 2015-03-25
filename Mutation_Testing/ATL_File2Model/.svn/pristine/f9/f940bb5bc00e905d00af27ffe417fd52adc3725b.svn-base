package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;

import exceptions.*;
import ruleTypeExtraction.files.*;

public class Window extends JFrame implements View {

	private static final long serialVersionUID = 1L;

	Button srcMMEcoreButton, trgMMEcoreButton, atlTransButton, outputFileButton, obtainButton;
	
	JTextField srcMMEcoreTField, trgMMEcoreTField, atlTransTField, outputFileTField;
	
	JTextArea messageLabel, messageLabel2;
	
	JFileChooser srcMMecoreChooser, trgMMecoreChooser,  atlTransformationChooser, csvChooser;
	
	String ATLTransName;
	
	public Window() {

		Dimension buttonsDimension = new Dimension(300, 25);
		//Components of the panels: Buttons and TFields
		srcMMEcoreButton = new Button ("Select source metamodel (.ecore file)");
		srcMMEcoreButton.setPreferredSize(buttonsDimension);
		srcMMEcoreTField = new JTextField();
		srcMMEcoreTField.setPreferredSize(buttonsDimension);
		
		trgMMEcoreButton = new Button("Select target metamodel (.ecore file)");
		trgMMEcoreButton.setPreferredSize(buttonsDimension);
		trgMMEcoreTField = new JTextField();
		trgMMEcoreTField.setPreferredSize(buttonsDimension);
		
		atlTransButton = new Button("Select transformation (.atl file)");
		atlTransButton.setPreferredSize(buttonsDimension);
		atlTransTField = new JTextField();
		atlTransTField.setPreferredSize(buttonsDimension);
		
		outputFileButton = new Button("Select directory for output file");
		outputFileButton.setPreferredSize(buttonsDimension);
		outputFileTField = new JTextField();
		outputFileTField.setPreferredSize(buttonsDimension);
		
		messageLabel = new JTextArea("");
		messageLabel.setForeground(Color.black);
		messageLabel2 = new JTextArea("");
		//JScrollPane scroll = new JScrollPane();
		//scroll.setViewportView(messageLabel);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(messageLabel);
		
		obtainButton = new Button("Get ATL Transformation Types");
		Font newButtonFont= new Font("DIALOG",Font.BOLD,12);
		obtainButton.setFont(newButtonFont);

		Panel panelLeft = new Panel(new BorderLayout());
		panelLeft.add(srcMMEcoreButton, BorderLayout.NORTH);
		
		BorderLayout bl1 = new BorderLayout(); bl1.setVgap(10);
		Panel panelbl1 = new Panel(bl1);
		panelLeft.add(panelbl1, BorderLayout.CENTER);
		panelbl1.add(srcMMEcoreTField, BorderLayout.NORTH);
		
		BorderLayout bl2 = new BorderLayout();
		Panel panelbl2 = new Panel(bl2);
		panelbl1.add(panelbl2, BorderLayout.CENTER);
		panelbl2.add(trgMMEcoreButton, BorderLayout.NORTH);
		
		BorderLayout bl3 = new BorderLayout(); bl3.setVgap(10);
		Panel panelbl3 = new Panel(bl3);
		panelbl2.add(panelbl3, BorderLayout.CENTER);
		panelbl3.add(trgMMEcoreTField, BorderLayout.NORTH);
		
		BorderLayout bl4 = new BorderLayout();
		Panel panelbl4 = new Panel(bl4);
		panelbl3.add(panelbl4, BorderLayout.CENTER);
		panelbl4.add(atlTransButton, BorderLayout.NORTH);
		
		BorderLayout bl5 = new BorderLayout(); bl5.setVgap(10);
		Panel panelbl5 = new Panel(bl5);
		panelbl4.add(panelbl5, BorderLayout.CENTER);
		panelbl5.add(atlTransTField, BorderLayout.NORTH);
		
		BorderLayout bl6 = new BorderLayout();
		Panel panelbl6 = new Panel(bl6);
		panelbl5.add(panelbl6, BorderLayout.CENTER);
		panelbl6.add(outputFileButton, BorderLayout.NORTH);
		
		BorderLayout bl7 = new BorderLayout(); bl7.setVgap(10);
		Panel panelbl7 = new Panel(bl7);
		panelbl6.add(panelbl7, BorderLayout.CENTER);
		panelbl7.add(outputFileTField, BorderLayout.NORTH);
		
		BorderLayout bl8 = new BorderLayout();
		Panel panelbl8 = new Panel(bl8);
		panelbl7.add(panelbl8, BorderLayout.CENTER);
		panelbl8.add(obtainButton, BorderLayout.NORTH);
		
		BorderLayout bl15 = new BorderLayout(); bl15.setVgap(10);
		Panel panelRight = new Panel(bl15);
		messageLabel.setBackground(null);
		messageLabel.setEditable(false);
		messageLabel.setBorder(null);
		messageLabel.setLineWrap(true);
		messageLabel.setWrapStyleWord(true);
		messageLabel.setFocusable(false);
		JScrollPane sp = new JScrollPane(messageLabel);
		panelRight.add(sp, BorderLayout.CENTER);
		//panelRight.add(scroll, BorderLayout.CENTER);
		
		//BorderLayout bl16 = new BorderLayout(); bl16.setVgap(10);
		//Panel panelRightDown = new Panel(bl16);
		messageLabel2.setBackground(null);
		messageLabel2.setEditable(false);
		messageLabel2.setBorder(null);
		messageLabel2.setLineWrap(true);
		messageLabel2.setWrapStyleWord(true);
		messageLabel2.setFocusable(false);
		panelRight.add(messageLabel2, BorderLayout.SOUTH);
		
		BorderLayout bl = new BorderLayout(); bl.setVgap(100); bl.setHgap(10);
		Panel panelTop = new Panel(bl);
		panelTop.add(panelLeft, BorderLayout.WEST);
		panelTop.add(panelRight, BorderLayout.CENTER);
		
		Panel panel = new Panel(new BorderLayout());
		panel.add(panelTop, BorderLayout.CENTER);
		
		BorderLayout blFinal = new BorderLayout(); blFinal.setVgap(10); Panel pFinal = new Panel(blFinal);
		pFinal.add(panel, BorderLayout.CENTER);
		
		add("Center", pFinal);
		
		
		this.setTitle("ATL Transformation Types Extractor");
		this.pack();
		this.setVisible(true);
		this.setSize(650, 320);
		this.setLocation(300, 300);
//		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void controller(ActionListener controller) {

		atlTransButton.addActionListener(controller);
		atlTransButton.setActionCommand(ATL_TRANS);

		srcMMEcoreButton.addActionListener(controller);
		srcMMEcoreButton.setActionCommand(SRC_MM);

		trgMMEcoreButton.addActionListener(controller);
		trgMMEcoreButton.setActionCommand(TRG_MM);

		outputFileButton.addActionListener(controller);
		outputFileButton.setActionCommand(CSV_FILE);

		obtainButton.addActionListener(controller);
		obtainButton.setActionCommand(GET_SM);		
	}


	public void atlTransformationClick() {
		atlTransformationChooser = new JFileChooser();
		atlTransformationChooser
				.setFileFilter(new javax.swing.filechooser.FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".atl") ||
							   f.isDirectory();
					}

					public String getDescription() {
						return "atl";
					}
				});
		atlTransformationChooser.setCurrentDirectory(new File("."));
		atlTransformationChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int s = atlTransformationChooser.showSaveDialog(new JFrame());
		if (s == JFileChooser.APPROVE_OPTION) {
			atlTransTField.setText(atlTransformationChooser
					.getSelectedFile().getAbsolutePath());
			ATLTransName = atlTransformationChooser.getSelectedFile().getName();
		}
	}

	
	public void srcMMEcoreClick() {
		srcMMecoreChooser = new JFileChooser();
		srcMMecoreChooser
				.setFileFilter(new javax.swing.filechooser.FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".ecore")
								|| f.isDirectory();
					}

					public String getDescription() {
						return "ecore";
					}
				});
		srcMMecoreChooser.setCurrentDirectory(new File("."));
		srcMMecoreChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int s = srcMMecoreChooser.showSaveDialog(new JFrame());
		if (s == JFileChooser.APPROVE_OPTION) {
			srcMMEcoreTField.setText(srcMMecoreChooser.getSelectedFile()
					.getAbsolutePath());
		}
	}
	
	public void trgMMEcoreClick() {
		trgMMecoreChooser = new JFileChooser();
		trgMMecoreChooser
				.setFileFilter(new javax.swing.filechooser.FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".ecore")
								|| f.isDirectory();
					}

					public String getDescription() {
						return "ecore";
					}
				});
		trgMMecoreChooser.setCurrentDirectory(new File("."));
		trgMMecoreChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int s = trgMMecoreChooser.showSaveDialog(new JFrame());
		if (s == JFileChooser.APPROVE_OPTION) {
			trgMMEcoreTField.setText(trgMMecoreChooser.getSelectedFile()
					.getAbsolutePath());
		}
	}
	
	public void csvFileClick() {
		csvChooser = new JFileChooser();
		csvChooser.setCurrentDirectory(new File("."));
		csvChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int s = csvChooser.showSaveDialog(new JFrame());
		if (s == JFileChooser.APPROVE_OPTION) {
			outputFileTField.setText(csvChooser.getSelectedFile()
					.getAbsolutePath());
		}
	}	
	
	/*Button that executes the whole thing. First, the ATL file is injected into a model.
	 *Then, types from the model are extracted. Finally, the Similarity Matrix is calculated */
	public void getSMClick() {
		try{
			String pathSrcEcoreMMFile = srcMMEcoreTField.getText();
			String pathTrgEcoreMMFile = trgMMEcoreTField.getText();
			String pathATLTransformation = atlTransTField.getText();
			String pathOUTFile = outputFileTField.getText();

			messageLabel.setText("");
			messageLabel.update(messageLabel.getGraphics());
			messageLabel2.setText("");
			messageLabel2.update(messageLabel.getGraphics());
			
			
			boolean ok = checkFields(pathATLTransformation, pathSrcEcoreMMFile,
					pathTrgEcoreMMFile, pathOUTFile);

			if (ok){
				//ATLFile2Model afm = new ATLFile2Model(pathATLTransformation, pathOUTFile + "\trans_injected.xmi");
				ATLFile2Model afm = new ATLFile2Model(pathATLTransformation, "tempModel.xmi");
				try{
					//messageLabel.setText(afm.injectATLTrafo());
					afm.injectATLTrafo();
					messageLabel.setText("Textual ATL transformation injected into a model --> OK \n --- \n");
					messageLabel.update(messageLabel.getGraphics());
					messageLabel.append("Extracting types from model (this may take some time depending on the size of the model transformation)...... \n");
					messageLabel.update(messageLabel.getGraphics());
				} catch (FileNotFoundException e){
					messageLabel.setForeground(Color.red);
					messageLabel.append("FileNotFoundException: " + e.toString());
					messageLabel.update(messageLabel.getGraphics());
					e.printStackTrace();
				} catch (ATLCoreException e){
					messageLabel.setForeground(Color.red);
					messageLabel.append("ATLCoreException: " + e.toString());
					messageLabel.update(messageLabel.getGraphics());
					e.printStackTrace();
				}
				try {
					ExtractRuleTypes runner = new ExtractRuleTypes();
					runner.loadModels("tempModel.xmi", "file:/"+pathSrcEcoreMMFile, "file:/"+pathTrgEcoreMMFile);
					runner.doExtractRuleTypes(new NullProgressMonitor());
					runner.saveModels("tempTypesExtracted.xmi");
					
					//runner.saveModels(pathOUTFile + "/" + 
						//	ATLTransName.substring(0, ATLTransName.lastIndexOf('.')) + "Types.xmi");
					messageLabel.append(" --- \n Types extracted from model --> OK \n");
					messageLabel.update(messageLabel.getGraphics());
				
					/*SimilarityMatrix sm = new SimilarityMatrix("tempTypesExtracted.xmi", pathOUTFile + "/" + 
										ATLTransName.substring(0, ATLTransName.lastIndexOf('.')) + "SM.csv");
					sm.main();
					messageLabel.append(" --- \n File with Similarity Matrix created --> OK \n");
					messageLabel.update(messageLabel.getGraphics());*/
					
					File f = new File("tempTypesExtracted.xmi"); // This file contains the model with the types extracted
					File fl = new File (pathOUTFile + "/" +      // We want to copy the model before into this one
							ATLTransName.substring(0, ATLTransName.lastIndexOf('.')) + "Types.xmi");
								
					InputStream input = null;
					OutputStream output = null;
					try {
					 input = new FileInputStream(f);
					 output = new FileOutputStream(fl);
					 byte[] buf = new byte[1024];
					 int bytesRead;
					 while ((bytesRead = input.read(buf)) > 0) {
					         output.write(buf, 0, bytesRead);
					 }
					 input.close();
					 output.close();
					 f.delete();

					 //Deleting temporal files:
					 File tmp2 = new File("tempModel.xmi");
					 tmp2.delete();
					 
					}catch (FileNotFoundException e){
						messageLabel.setForeground(Color.red);
						messageLabel.append("FileNotFoundException: " + e.toString());
						messageLabel.update(messageLabel.getGraphics());
						e.printStackTrace();
					} catch (IOException e){
						messageLabel.setForeground(Color.red);
						messageLabel.append("IOException: " + e.toString());
						messageLabel.update(messageLabel.getGraphics());
						e.printStackTrace();
					}
				
				} catch (ATLCoreException e) {
					messageLabel.setForeground(Color.red);
					messageLabel.append("ATLCoreException: " + e.toString());
					messageLabel.update(messageLabel.getGraphics());
					e.printStackTrace();
				} catch (IOException e) {
					messageLabel.setForeground(Color.red);
					messageLabel.append("IOException: " + e.toString());
					messageLabel.update(messageLabel.getGraphics());
					e.printStackTrace();
				} catch (ATLExecutionException e) {
					messageLabel.setForeground(Color.red);
					messageLabel.append("ATLExecutionException: " + e.toString());
					messageLabel.update(messageLabel.getGraphics());
					e.printStackTrace();
				}
			}
			else{
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Error while loading files, please check that files and paths are correct");
				messageLabel.update(messageLabel.getGraphics());
			}
		} catch (ParametersException e) {
			messageLabel.setText(e.toString());
			e.printStackTrace();
		}
		

	}
	
	private boolean checkFields(String pathSrcMMEcoreFile, String pathTrgMMEcoreFile, String pathATLTransformation,
			String csvPath)	throws ParametersException {

		try {
			
			boolean ok = true;
			
			if (!new File(pathATLTransformation).exists()) {
				messageLabel
						.setText("  ERROR. File for the ATL transformation not found.");
				ok = false;
			} else if (!new File(pathSrcMMEcoreFile).exists() && !pathSrcMMEcoreFile.startsWith("http://")) {
				messageLabel
						.setText("  ERROR. File for source metamodel not found.");
				ok = false;
			} else if (!new File(pathTrgMMEcoreFile).exists() && !pathTrgMMEcoreFile.startsWith("http://")) {
				messageLabel
						.setText("  ERROR. File for the target metamodel not found.");
				ok = false;
			} else if (!new File(csvPath).exists() && !csvPath.contains(" ")) {
				File file = new File(csvPath);
				file.mkdir();
			}
			
			return ok;
			
		} catch (NumberFormatException e) {
			throw new ParametersException(
					"ERROR. Insert a natural number for the number model generated with the ASSL file.");
		}
	}
}
