/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.pk.gyak10;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author Admin
 */
public class XMLProba {
    
    public static void main(String[] args) {
        
        try{
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
        
        //Fájlba való írás
        
        Document doc = dBuilder.newDocument();
        
        Element gyokerElem = doc.createElement("beosztottak");
        doc.appendChild(gyokerElem);
        
        Element programozok = doc.createElement("programozok");
        gyokerElem.appendChild(programozok);
        
        Element programozo = doc.createElement("programozo");
        Attr attributum = doc.createAttribute("azonosito");
        
        attributum.setValue("asdfgh");
        programozo.setAttributeNode(attributum);
        
        Text szoveg = doc.createTextNode("Programozo Benő");
        programozo.appendChild(szoveg);
        
        programozok.appendChild(programozo);
        
        //Programozó 2
        
        programozo = doc.createElement("programozo");
        attributum = doc.createAttribute("azonosito");
        
        attributum.setValue("hgfdsa");
        programozo.setAttributeNode(attributum);
        
        Text szoveg2 = doc.createTextNode("Programozo Józsi");
        programozo.appendChild(szoveg2);
        
        programozok.appendChild(programozo);
        
        //XML létrehozás és beírás
        
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\Progtech\\\\Gyak10\\\\src\\\\main\\\\java\\\\hu\\\\unideb\\\\inf\\\\pk\\\\gyak10\\\\output.xml"));
        
        transformer.transform(source, result);
        
        //Fájlból adatok lekérése
        
        /*File inputFile = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Progtech\\Gyak10\\src\\main\\java\\hu\\unideb\\inf\\pk\\gyak10\\input.xml");
        Document doc = dBuilder.parse(inputFile);
        
        doc.normalize();
        
        System.out.println("Gyökérelem: "+doc.getDocumentElement().getNodeName());
        
        NodeList nodeList = doc.getElementsByTagName("hallgato");
        
        for(int i=0; i<nodeList.getLength(); i++) {
            
            Node node = nodeList.item(i);
            Element element = (Element) node;
            
            System.out.println("Neptunkód: "+element.getAttribute("neptunkod"));
            System.out.println("Vezetéknév: "+element.getElementsByTagName("vezeteknev").item(0).getTextContent());
            System.out.println("Keresztnév: "+element.getElementsByTagName("keresztnev").item(0).getTextContent());
            System.out.println("Átlag: "+element.getElementsByTagName("atlag").item(0).getTextContent());
            
        }*/
        
        }
        catch (Exception e){
          e.printStackTrace();
        }
        
    }
    
}
