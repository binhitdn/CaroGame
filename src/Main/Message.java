package Main;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Model.User;

public class Message {
	private int id;
	private String nickname;
	private String content;
	File inputFile;
	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	Document doc;
	Element goc;
	User user;
	String name;
	public Message() {		
		try {
			 inputFile = new File("xml/tinnhan.xml");
			 dbFactory = DocumentBuilderFactory.newInstance();
	            dBuilder = dbFactory.newDocumentBuilder();
	            doc = dBuilder.parse(inputFile);
	            doc.getDocumentElement().normalize();       
	            goc = doc.getDocumentElement();   
        } catch (Exception e) {
            e.printStackTrace();
        }     
	}
	public Message(int id, String nickname, String content) {
		this.id = id;
		this.nickname = nickname;
		this.content = content;
		
		try {
			 inputFile = new File("xml/tinnhan.xml");
			 dbFactory = DocumentBuilderFactory.newInstance();
	            dBuilder = dbFactory.newDocumentBuilder();
	            doc = dBuilder.parse(inputFile);
	            doc.getDocumentElement().normalize();        
	            goc = doc.getDocumentElement();
           
           Element user = doc.createElement("message");
           goc.appendChild(user);
           Attr attr1 = doc.createAttribute("id");
           attr1.setValue(Integer.toString(id));
           user.setAttributeNode(attr1);
           
           Element date = doc.createElement("date");
           date.appendChild(doc.createTextNode((new Date()).time()));
           user.appendChild(date);
           
           Element firstname = doc.createElement("nickname");
           firstname.appendChild(doc.createTextNode(nickname));
           user.appendChild(firstname);
           
           Element lastname = doc.createElement("content");
           lastname.appendChild(doc.createTextNode(content));
           user.appendChild(lastname);

      
         

         
           TransformerFactory transformerFactory = 
                   TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           DOMSource source = new DOMSource(doc);
           StreamResult result = new StreamResult(
                   new File("xml/tinnhan.xml"));
           transformer.transform(source, result);
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String ReadMessage(User user) {
		this.user = user;
		String message ="";
		NodeList nodeListStudent = doc.getElementsByTagName("message");
		for (int i = 0; i < nodeListStudent.getLength(); i++) {
            
            Node nNode = nodeListStudent.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String name="";
                if(user.getID()==Integer.parseInt(eElement.getAttribute("id"))) name = "Tôi";
                else name = eElement.getElementsByTagName("nickname").item(0).getTextContent();
                	
                
                message += "("+eElement.getElementsByTagName("date").item(0).getTextContent()+")"+name+": "+eElement.getElementsByTagName("content").item(0).getTextContent()+"\n";
                
            }
        }
		
		return message;
		
	}
	public void EditName(int ID,String name) {
		this.id = ID;
		this.name = name;
		NodeList student1 = doc.getElementsByTagName("message");
		
		for (int i = 0; i < student1.getLength(); i++) {
			Node nNode = student1.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                
                if(this.id == Integer.parseInt(eElement.getAttribute("id"))) {
                	eElement.getElementsByTagName("nickname").item(0).setTextContent(name);
                	
    			}
            }
		}
		
        Transformer transformer;
		try {
			TransformerFactory transformerFactory = 
	                TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(
	                new File("xml/tinnhan.xml"));
	        transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
}
