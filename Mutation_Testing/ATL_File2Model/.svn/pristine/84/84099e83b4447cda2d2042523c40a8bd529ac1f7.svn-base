********************************************************
** Description: WSDL2R2ML ATL transformation scenario
** Author: 	Marko Ribaric <marko.ribaric at gmail.com>
** Date: 	July 24, 2007
********************************************************

This ATL scenario transforms WSDL (Web Services Definition Language) into R2ML (REWERSE I1 Markup Language). It is composed of the following transformations: XML2WSDL, WSDL2R2ML (see below), and an R2ML extractor that produces XML documents that conform to the R2ML syntax defined by REWERSE I1 group. (also there are transformations in the other direction: XML2R2ML. R2ML2WSDL and WSDL2XML) To find more details about this transformation scenario, please refer to [1].  

See also: 
	-- XSD metamodel from http://www.eclipse.org/xsd/
	-- WSDL metamodel (by prof Gerd Wagner, Institute of Informatics, Brandenburg Technical University at Cottbus, Germany)
	-- R2ML (REWERSE I1 Rule Markup Language) - http://oxygen.informatik.tu-cottbus.de/rewerse-i1/?q=node/6

Transformation files:
---------------------
- XML2WSDL.atl: ATL transformation that transforms an XML documents that conform to the WSDL syntax to an WSDL model. (also in the other direction WSDL2XML)

	- WSDLR2ML.atl: The core transformation, that produced an R2ML model from
                a WSDL model (instance of WSDL metamodel). (also in the other direction R2ML2WSDL)
 

	- R2ML2XML.atl: ATL transformation that transforms an R2ML model into an
	an XML model with R2ML syntax elements. (also in the other direction XML2R2ML). These transformations were originally developed by Milan Milanovic, and now they are extended with Reaction Rules.


  
Metamodel files:
----------------
	- XML.xmi: XML metamodel in MOF XMI 1.2 format (MOF-1.4). This metamodel is part of standard metamodels used with ATL. It is used when models are tranformed into XML documents or vice versa.

	- WSDL.xmi: WSDL metamodel in MOF XMI 1.2 format (MOF-1.4). This model represents an abstract syntax for the WSDL language. It also contains the XSD metamodel (http://www.eclipse.org/xsd/)

	- R2ML.xmi: R2ML metamodel in MOF XMI 1.2 format (MOF-1.4). Metamodel of the R2ML language.
		    
	- Each metamodel has KM3 and Ecore EMF XMI 2.0 format versions.
	
Sample files:
-------------
	- Models/wsdl-xml/hotelReservation.wsdl: This file is simple WSDL file and is used as input example by this transformation scenario.

	- Models/r2ml-xml/R2MLRule.xml: This file is simple R2ML with Reaction Rules file and is used as input example by this transformation scenario.

Other files:
------------


References:
-----------
[1] Lukichev, S., Guirca, A., Wagner, G., Gašević, D., Ribarić, M., “Rule-based Modeling of Web services,” International Journal on Data Management, 2007 
