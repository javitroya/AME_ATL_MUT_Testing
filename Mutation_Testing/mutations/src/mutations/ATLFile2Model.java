package mutations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.engine.parser.AtlParser;


public class ATLFile2Model {

	String atlFile;
	String atlModel;

	public ATLFile2Model(String atlFile, String atlModel) {
		this.atlFile = atlFile;
		this.atlModel = atlModel;
	}

	public void injectATLTrafo() throws FileNotFoundException, ATLCoreException {

		AtlParser parser=new AtlParser();

		InputStream stream = new FileInputStream(atlFile);
		IModel parseToModel = parser.parseToModel(stream);
   
		IExtractor extractor = new EMFExtractor();
		extractor.extract(parseToModel, atlModel);
	}
	
public static void main(String args[]) throws FileNotFoundException, ATLCoreException {
		ATLFile2Model injector;
/*//		ATLFile2Model injector = new ATLFile2Model("Example/Grafcet2PetriNet/Transformations/PNML2PetriNet.atl", "Example/Grafcet2PetriNet/Transformations/PNML2PetriNet_injected.xmi");
//		ATLFile2Model injector = new ATLFile2Model(args[0], args[1]);
//		injector.injectATLTrafo();
		
//		ATLFile2Model injector = new ATLFile2Model("Example/Grafcet2PetriNet/Transformations/PNML2XML.atl", "Example/Grafcet2PetriNet/Transformations/PNML2XML_injected.xmi");
//		ATLFile2Model injector = new ATLFile2Model(args[0], args[1]);
	//	injector.injectATLTrafo();
		
		ATLFile2Model injector = new ATLFile2Model("Example/IEEE1471_2_MoDAF/transformation/IEEE1471_2_MoDAF.atl", "Example/IEEE1471_2_MoDAF/transformation/IEEE1471_2_MoDAF_injected.xmi");
//		ATLFile2Model injector = new ATLFile2Model(args[0], args[1]);
		injector.injectATLTrafo();

	ATLFile2Model injector = new ATLFile2Model("Example/KM32OWL/Transformations/KM32OWL.atl", "Example/KM32OWL/Transformations/KM32OWL_injected.xmi");
	injector.injectATLTrafo();

	ATLFile2Model injector = new ATLFile2Model("Example/KM32OWL/Transformations/OWL2XML.atl", "Example/KM32OWL/Transformations/OWL2XML_injected.xmi");
	injector.injectATLTrafo();
	
	ATLFile2Model injector = new ATLFile2Model("Example/MySQL2KM3/Transfos/MySQL2KM3.atl", "Example/MySQL2KM3/Transfos/MySQL2KM3_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/MySQL2KM3/Transfos/XML2MySQL.atl", "Example/MySQL2KM3/Transfos/XML2MySQL_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/MySQL2KM3/Transfos/XML2XML.atl", "Example/MySQL2KM3/Transfos/XML2XML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/OCL2R2ML/transformations/OCL2R2ML/OCL2R2ML.atl", "Example/OCL2R2ML/transformations/OCL2R2ML/OCL2R2ML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/OCL2R2ML/transformations/R2ML2XML/R2ML2XML.atl", "Example/OCL2R2ML/transformations/R2ML2XML/R2ML2XML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/OCL2SWRL/transformations/R2ML2RDM/R2ML2RDM.atl", "Example/OCL2SWRL/transformations/R2ML2RDM/R2ML2RDM_injected.xmi");
	injector.injectATLTrafo();
	/*injector = new ATLFile2Model("Example/OCL2SWRL/transformations/RDM2XML/RDM2XML.atl", "Example/OCL2SWRL/transformations/RDM2XML/RDM2XML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/SWRL2R2ML/transformations/RDM2R2ML/RDM2R2ML.atl", "Example/SWRL2R2ML/transformations/RDM2R2ML/RDM2R2ML_injected.xmi");
	injector.injectATLTrafo();
	//injector = new ATLFile2Model("Example/SWRL2R2ML/transformations/XML2RDM/XML2RDM.atl", "Example/SWRL2R2ML/transformations/XML2RDM/XML2RDM_injected.xmi");
	//injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/WSDL2R2ML/transformations/R2ML2WSDL/R2ML2WSDL.atl", "Example/WSDL2R2ML/transformations/R2ML2WSDL/R2ML2WSDL_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/WSDL2R2ML/transformations/WSDL2R2ML/WSDL2R2ML.atl", "Example/WSDL2R2ML/transformations/WSDL2R2ML/WSDL2R2ML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/WSDL2R2ML/transformations/WSDL2XML/WSDL2XML.atl", "Example/WSDL2R2ML/transformations/WSDL2XML/WSDL2XML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/WSDL2R2ML/transformations/XML2WSDL/XML2WSDL.atl", "Example/WSDL2R2ML/transformations/XML2WSDL/XML2WSDL_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/Measure2Table/transformations/Measure2Table.atl", "Example/Measure2Table/transformations/Measure2Table_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/Measure2XHTML/transformations/Measure2XHTML.atl", "Example/Measure2XHTML/transformations/Measure2XHTML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/Measure2XHTML/transformations/XHTML2XML.atl", "Example/Measure2XHTML/transformations/XHTML2XML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/PathExp2PetriNet/ATL/PathExp2PetriNet.atl", "Example/PathExp2PetriNet/ATL/PathExp2PetriNet_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/PathExp2PetriNet/ATL/PathExp2TextualPathExp.atl", "Example/PathExp2PetriNet/ATL/PathExp2TextualPathExp_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/PathExp2PetriNet/ATL/PetriNet2PathExp.atl", "Example/PathExp2PetriNet/ATL/PetriNet2PathExp_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/PathExp2PetriNet/ATL/PetriNet2XML.atl", "Example/PathExp2PetriNet/ATL/PetriNet2XML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/PathExp2PetriNet/ATL/TextualPathExp2PathExp.atl", "Example/PathExp2PetriNet/ATL/TextualPathExp2PathExp_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/PathExp2PetriNet/ATL/XML2PetriNet.atl", "Example/PathExp2PetriNet/ATL/XML2PetriNet_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/RSS2ATOM/ATLTransformations/ATOM2RSS.atl", "Example/RSS2ATOM/ATLTransformations/ATOM2RSS_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/RSS2ATOM/ATLTransformations/ATOM2XML.atl", "Example/RSS2ATOM/ATLTransformations/ATOM2XML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/RSS2ATOM/ATLTransformations/RSS2ATOM.atl", "Example/RSS2ATOM/ATLTransformations/RSS2ATOM_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/RSS2ATOM/ATLTransformations/RSS2XML.atl", "Example/RSS2ATOM/ATLTransformations/RSS2XML_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/RSS2ATOM/ATLTransformations/XML2ATOM.atl", "Example/RSS2ATOM/ATLTransformations/XML2ATOM_injected.xmi");
	injector.injectATLTrafo();
	injector = new ATLFile2Model("Example/RSS2ATOM/ATLTransformations/XML2RSS.atl", "Example/RSS2ATOM/ATLTransformations/XML2RSS_injected.xmi");
	injector.injectATLTrafo();*/
	injector = new ATLFile2Model("Example/CopyTransformation/copyTrans.atl", "Example/CopyTransformation/copyTrans_injected.xmi");
	injector.injectATLTrafo();
	//injector = new ATLFile2Model("Example/XSLT2XQuery/ATLFile/XSLT2XQuery.atl", "Example/XSLT2XQuery/ATLFile/XSLT2XQuery_injected.xmi");
	//injector.injectATLTrafo();

}

}
