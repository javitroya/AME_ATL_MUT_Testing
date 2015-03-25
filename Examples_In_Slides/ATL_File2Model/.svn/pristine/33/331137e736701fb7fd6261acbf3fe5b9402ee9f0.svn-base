*********************************************************
** Description: SWRL2R2ML ATL transformation scenario
** Author: 	Milan Milanovic <milan at milanovic.org>
** Date: 	August 10, 2006
********************************************************

This ATL scenario transforms SWRL (Semantic Web Rule Language) into R2ML (REWERSE I1 Markup Language). 
It is composed of SWRL injector (to RDM metamodel), transformations (RDM2R2ML) and an R2ML extractor 
that produces XML documents that conform to the R2ML syntax defined by REWERSE I1 group. To find more 
details about this transformation scenario, please refer to [1]-[2]. 

See also: 
	-- R2ML2SWRL transformations scenario
	-- R2ML (REWERSE I1 Rule Markup Language) - http://oxygen.informatik.tu-cottbus.de/rewerse-i1/?q=node/6
	-- SWRL (Semantic Web Rule Language) - http://www.w3.org/Submission/SWRL/
	-- RDM metamodel - http://www.aifb.uni-karlsruhe.de/WBS/sbr/publications/owl-metamodeling.pdf
	-- OWL Web Ontology Language: XML Presentation Syntax - http://www.w3.org/TR/owl-xmlsyntax/
	-- OWL (Web Ontology language) - http://www.w3.org/2004/OWL/

Transformation files:
---------------------
	- R2ML2XML.atl: ATL transformation that transforms an R2ML model into an
	                an XML models with R2ML syntax elements.

	- RDM2R2ML.atl: The core transformation, that produced an R2ML model from
                        a RDM model (instance of SWRL metamodel).

	- XML2RDM.atl: ATL transformation that transforms an XML model that are 
                       injected from SWRL XML documents, into RDM model.

	- SWRL2R2ML.xml: An ANT script that automatically executes the 3 ATL transformations and
	                 the pair XML injector/extractor to produce a RDM model from SWRL document,
                         and to produce R2ML XML documents from R2ML model, respectively. It can be 
                         executed by right-clicking on it, then clicking on "Run As->Ant Build". 
                         To execute this transformation on other SWRL examples, place your SWRL models 
                         in the models/swrl-xml folder and make necessary changes in ANT script.
	  
Metamodel files:
----------------
	- XML.xmi: XML metamodel in MOF XMI 1.2 format (MOF-1.4). This metamodel is part of standard metamodels 
                   used with ATL. It is used when models are tranformed into XML documents or vice versa.

	- RDM.xmi: RDM metamodel in MOF XMI 1.2 format (MOF-1.4). This model represents an abstract syntax for
                   the SWRL language.

	- R2ML.xmi: R2ML metamodel in MOF XMI 1.2 format (MOF-1.4). Metamodel of the R2ML language.
		    
	- Every metamodel have KM3 and Ecore EMF XMI 2.0 format versions.
	
Sample files:
-------------
	- Models/swrl-xml/SWRLRule1.xml: This file is the SWRL rule in the SWRL/XML from the SWRL specification,
					 and is used as input example by this transformation scenario.

	- Models/r2ml-xml/R2MLRule.xml: This file is R2ML rule in the R2ML XML format after executing XML injector,
                                        the XML2RDM transformation, the RDM2R2ML transformation, the R2ML2XML transformation
                                        and XML extractor.

References:
-----------
[1] Milanović, M., Gašević, D., Guirca, A., Wagner, G., Devedžić, V., "Towards Sharing Rules Between OWL/SWRL and UML/OCL", Electronic Communications of the European Association of Software Science and Technology, Volume 5, 2006.
[2] Milanović, M. "Modeling rules on the Semantic Web", master thesis, GOOD OLD AI Lab, Faculty of organizational sciences, University of Belgrade.
