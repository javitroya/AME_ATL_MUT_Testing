This ATL scenario shows up a traduction of KM3 into OWL (Web Ontology language) ontology language. This scenario is composed 
of one transformation (KM32OWL) and an OWL extractor that produces XML documents conform to the OWL syntax 
defined by the W3C. Resulting ontology can be used into ontology development tools like Protégé 
(see http://protege.stanford.edu).

See also: 
	-- UML2OWL scenario http://www.eclipse.org/m2m/atl/usecases/ODMImplementation/
	-- OWL (Web Ontology language) http://www.w3.org/2004/OWL/

Transformation files:
	- KM32OWL.atl: The core transformation of the scenario. It is the implementation in ATL of
	  the QVT mapping UML2OWL from ODM specification. It produces an OWL Model from a UML 2.0 Model.
	- OWL2XML.atl: ATL transformation that transforms an OWL Model into
	  an XML models with OWL/XML syntax elements.
	- build.xml: An ANT script that automatically executes the 2 ATL transformations and
	  the XML extractor to produce from a uml model an owl document that contains the ontology.
	  It can be executed by right-clicking on it, then clicking on "Run As->Ant Build". To execute 
	  this transformation on other km3 examples, place your km3 models in the Samples folder and make
	  necessary changes in ANT script.
	  
Metamodel files:
	- XML.ecore: XML metamodel in EMF XMI 2.0 format.
	  This metamodel is part of standard metamodels used with ATL.
	  It is used when models are tranformed into XML documents or vice versa.
	- OWL.km3: OWL Metamodel in km3 textual syntax. This Metamodel has been designed
	  by following the ODM specification.
	- OWL.ecore: OWL Metamodel in Ecore EMF XMI 2.0 format.
	
Sample files:
	- Samples/Museum.km3: This metamodel represents is an excerpt of a Museum metamodel and is used as input 
	  example by this transformation scenario.
	  	
	- Samples/Museum.owl: This file is the Museum ontology in OWL/XML format after executing the OWL2XML 
	  transformation and the XML extractor. This file can be used in an ontology editor like Protégé.
	