*********************************************************
** Description: OCL2SWRL ATL transformation scenario
** Author: 	Milan Milanovic <milan at milanovic.org>
** Date: 	Febrauary 15 , 2007
********************************************************

This ATL scenario transforms OCL (Object Constraint Language) invariants into the R2ML (REWERSE I1 Markup Language) rules,
which is used as intermediary language, and then into the SWRL rules (Semantic Web Rule Language). It is composed of OCL 
EBNF injector (to OCL metamodel), transformations (OCL2R2ML, R2ML2RDM) and an R2ML extractor that produces 
XML documents that conform to the SWRL XML syntax and R2ML syntax defined by REWERSE I1 group. To find more 
details about this transformation scenario, please refer to [1]-[2]-[3]. This transformation scenario includes
two other transformation scenarios (OCL2R2ML and R2ML2SWRL), see below.

See also: 
	-- OCL2R2ML transformation scenario - http://www.eclipse.org/m2m/atl/atlTransformations/#OCL2R2ML
    -- R2ML2SWRL transformation scenario - http://www.eclipse.org/m2m/atl/atlTransformations/#R2ML2SWRL
	-- R2ML (REWERSE I1 Rule Markup Language) - http://oxygen.informatik.tu-cottbus.de/rewerse-i1/?q=node/6
	-- SWRL (Semantic Web Rule Language) - http://www.w3.org/Submission/SWRL/
	-- RDM metamodel - http://www.aifb.uni-karlsruhe.de/WBS/sbr/publications/owl-metamodeling.pdf
	-- OWL Web Ontology Language: XML Presentation Syntax - http://www.w3.org/TR/owl-xmlsyntax/
	-- OWL (Web Ontology language) - http://www.w3.org/2004/OWL/
	-- Object Constraint Language - OMG Available Specification, Version 2.0, formal/06-05-01. 
                                    [Online] http://www.omg.org/cgi-bin/doc?formal/06-05-01

Transformation files:
---------------------
	- R2ML2XML.atl: ATL transformation that transforms an R2ML model into an
	                an XML models with R2ML syntax elements.
                       
    - RDM2XML.atl: ATL transformation that transforms an RDM model into an
	               an XML models with SWRL/OWL syntax elements.
	               
	- OCL2R2ML.atl: The core transformation, that produced an R2ML model from
                    a OCL model (instance of OCL metamodel).
             
	- R2ML2RDM.atl: The core transformation, that produced an RDM model from
                    a R2ML model (instance of R2ML metamodel).

	- OCL2SWRL.xml: An ANT script that automatically executes the 2 main ATL transformations (OCL2R2ML and R2ML2RDM), 
	                EBNF injector to produce OCL model from OCL file, and a XML extractor
                    to produce R2ML XML documents from R2ML model and SWRL XML documents from RDM model. 
                    It can be  executed by right-clicking on it, then clicking on "Run As->Ant Build". 
                    To execute this transformation on other SWRL examples, place your OCL invariant files
                    in the models/ocl folder and make necessary changes in ANT script.
	  
Metamodel files:
----------------
	- XML.xmi: XML metamodel in MOF XMI 1.2 format (MOF-1.4). This metamodel is part of standard metamodels 
                   used with ATL. It is used when models are tranformed into XML documents or vice versa.

	- OCL.xmi: OCL metamodel in MOF XMI 1.2 format (MOF-1.4). This model represents an abstract syntax for
                   the OCL language.
 
    - RDM.xmi: RDM metamodel in MOF XMI 1.2 format (MOF-1.4). This model represents an abstract syntax for
                   the SWRL language.

	- R2ML.xmi: R2ML metamodel in MOF XMI 1.2 format (MOF-1.4). Metamodel of the R2ML language.
		    
	- Every metamodel have KM3 and Ecore EMF XMI 2.0 format versions.
	
Sample files:
-------------
	- Models/ocl/m1.ocl: This file is simple OCL invariant and is used as input example by 
                         this transformation scenario (it must be invariant with implication, because
                         SWRL rules are represented as implications).

	- Models/r2ml-xml/R2MLRule.xml: This file is R2ML rule in the R2ML XML format after executing OCL EBNF injector,
                                    the OCL2R2ML transformation, the R2ML2XML transformation and XML extractor.
                                        
    - Models/swrl-xml/SWRLRule.xml: This file is SWRL rule in the SWRL XML format after executing the R2ML2RDM 
    								transformation, the RDM2XML transformation and XML extractor.

Other files:
------------
	- OCL-ebnfinjector.jar: OCL EBNF injector that is used to translate OCL code into OCL model.

References:
-----------
[1] Milanović, M., Gašević, D., Guirca, A., Wagner, G., Devedžić, V., "Towards Sharing Rules Between OWL/SWRL and UML/OCL", Electronic Communications of the European Association of Software Science and Technology, Volume 5, 2006.
[2] Milanović, M. "Modeling rules on the Semantic Web", master thesis, GOOD OLD AI Lab, Faculty of organizational sciences, University of Belgrade.
[3] Milanović, M., Gašević, D., Guirca, A., Wagner, G., Devedžić, V., "Bridging Concrete and Abstract Syntax of Web Rule Languages", In Proceedings of the First International Conference on Web Reasoning and Rule Systems (RR2007), Innsbruck, Austria, 2007.