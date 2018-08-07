package javaxmdomForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class App {

	public static void main(String[] args) {

		// la dbf est une fabrique de Document Builder
		// configurable sur les schema/validation/etc
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			// le Document Builder, comme son nom l'indique
			// permet de construire des document (fabrique de document)
			// 2 moyens de construire un document
			// 		A -> en lisant un fichier xml
			//		B -> depuis un document vide
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			// l'objet Document est la représentation objet du XML
			// c'est lui qui fournit l'API DOM
			Document doc = db.parse(new File("plant_catalog.xml"));
			
			// récuperer toutes les balises botanical du document
			NodeList balises = doc.getElementsByTagName("BOTANICAL");
			for (int i = 0; i < balises.getLength(); i++) {
				// recuperer un noeud rencontré
				Node n = balises.item(i);
				Element elem  = (Element)n;
				System.out.println(elem.getTagName() + " -> " + elem.getTextContent());
			}
			
			System.out.println("-------------------------");
			
			// je récupere la premiere  (et unique) balise catalogue qui est la racine
			// de mon document
			Element racine = (Element)(doc.getElementsByTagName("CATALOG").item(0));
			System.out.println("tag -> " + racine.getTagName());
			NodeList nl = racine.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				System.out.println(n.getNodeName() + " - " + n.getClass().getSimpleName());
			}
			/*
			 * API XPATH -> chemin xml
			 * permet de requeter un document xml
			 * avec une syntaxe ressemblant au parcours d'un systeme de fichier
			 * 
			 */
			System.out.println("--------------------------------------------");
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xp = xpf.newXPath();
			
			//XPathExpression request = xp.compile("//CATALOG/PLANT/BOTANICAL/text()");
		XPathExpression request = xp.compile("//CATALOG/PLANT/ZONE[text() = '3']/../BOTANICAL/text()");
			NodeList nl2 = (NodeList)request.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nl2.getLength(); i++) {
				System.out.println(nl2.item(i).getNodeValue());
			}
			
			System.out.println("----------------------------------");
			
			// création d'un document vide
			Document doc2 = db.newDocument();
			
			// balise "atachée" au document, mais non positionée dedans
			Element root = doc2.createElement("livres");
			// ajout de la balise au document, donc racine du document
			doc2.appendChild(root);
			
			Element livre1 = doc2.createElement("livre");
			livre1.setAttribute("id", "1");
			// livre1 balise enfant de root
			root.appendChild(livre1);
			Element titre1 = doc2.createElement("titre");
			Text contenu1 = doc2.createTextNode("2000 lieux sous les mers");
			titre1.appendChild(contenu1);
			livre1.appendChild(titre1);
			
			Element livre2 = doc2.createElement("livre");
			livre2.setAttribute("id", "2");
			// livre2 balise enfant de root
			root.appendChild(livre2);
			Element titre2 = doc2.createElement("titre");
			Text contenu2 = doc2.createTextNode("de la terre a la lune");
			titre2.appendChild(contenu2);
			livre2.appendChild(titre2);
			
			// ecrire le contenu
			TransformerFactory tfact = TransformerFactory.newInstance();
			Transformer tf = tfact.newTransformer();
			
			DOMSource source = new DOMSource(doc2);
			StreamResult destination = new StreamResult(
											new FileOutputStream(
												new File("livres.xml")));
			
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			// ecriture
			tf.transform(source, destination);
			
			
		} catch (ParserConfigurationException e) {e.printStackTrace();} 
		catch (SAXException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();	} 
		catch (XPathExpressionException e) {e.printStackTrace();} 
		catch (TransformerConfigurationException e) {e.printStackTrace();}
		catch (TransformerException e) {e.printStackTrace();}

	}

}
