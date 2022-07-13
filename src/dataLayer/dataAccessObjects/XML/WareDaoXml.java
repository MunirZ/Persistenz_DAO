package dataLayer.dataAccessObjects.XML;

import Kaufvertrag.businessObjects.IWare;
import dataLayer.dataAccessObjects.IWareDao;

import java.io.*;
import java.util.List;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;


public class WareDaoXml implements IWareDao {


    private final String dateipfad;

    public WareDaoXml(String dateipfad) {
        this.dateipfad = dateipfad;
    }

    @Override
    public IWare create() {
        return null;
    }

    @Override
    public IWare create(IWare ware) {

        Document dom;
        Element e;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{

            String DIE_ID_BEKOMME_ICH_VON_MUNIR = "1";

            //use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //create instance of DOM
            dom = db.newDocument();

            //create root element
            Element rootEle = dom.createElement("Ware");
            //rootEle.setAttribute("ID", "1");

            e = dom.createElement("ID");
            e.appendChild(dom.createTextNode(DIE_ID_BEKOMME_ICH_VON_MUNIR));
            rootEle.appendChild(e);

            //create data elements and place them under root
            e = dom.createElement("Beschreibung");
            e.appendChild(dom.createTextNode(ware.getBeschreibung()));
            rootEle.appendChild(e);

            e = dom.createElement("Bezeichnung");
            e.appendChild(dom.createTextNode(ware.getBezeichnung()));
            rootEle.appendChild(e);

            e = dom.createElement("Maengel");
            e.appendChild(dom.createTextNode(String.valueOf(ware.getMaengel())));
            rootEle.appendChild(e);

            e = dom.createElement("Preis");
            e.appendChild(dom.createTextNode(String.valueOf(ware.getPreis())));
            rootEle.appendChild(e);

            dom.appendChild(rootEle);

            try{
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                //send DOM to file
                tr.transform(new DOMSource(dom),
                new StreamResult(new FileOutputStream(dateipfad)));
            } catch (TransformerException | IOException te){
                System.out.println(te.getMessage());
            }
        } catch(ParserConfigurationException pce){
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }

        return ware;
    }

    @Override
    public List<IWare> read() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(dateipfad));

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("----------");

            NodeList list = doc.getElementsByTagName("Ware");

            for(int counter = 0; counter < list.getLength(); counter++){
                Node node = list.item(counter);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    String Childelement1 = element.getElementsByTagName("Beschreibung").item(0).getTextContent();
                    String Childelement2 = element.getElementsByTagName("Bezeichnung").item(0).getTextContent();
                    String Childelement3 = element.getElementsByTagName("Maengel").item(0).getTextContent();
                    String Childelement4 = element.getElementsByTagName("Preis").item(0).getTextContent();
                    String Childelement5 = element.getElementsByTagName("ID").item(0).getTextContent();

                    System.out.println("Current Element : " + node.getNodeName());
                    System.out.println("Id : " + Childelement5);
                    System.out.println("Beschreibung : " + Childelement1);
                    System.out.println("Bezeichnung : " + Childelement2);
                    System.out.println("Maengel : " + Childelement3);
                    System.out.println("Preis : " + Childelement4);

                }

            }

        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public IWare read(int id) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(dateipfad));

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("----------");

            NodeList list = doc.getElementsByTagName("Ware");

            for(int counter = 0; counter < list.getLength(); counter++){
                Node node = list.item(counter);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    String Childelement5 = element.getElementsByTagName("ID").item(0).getTextContent();

                    if(Childelement5.equals(String.valueOf(id))){
                        String Childelement1 = element.getElementsByTagName("Beschreibung").item(0).getTextContent();
                        String Childelement2 = element.getElementsByTagName("Bezeichnung").item(0).getTextContent();
                        String Childelement3 = element.getElementsByTagName("Maengel").item(0).getTextContent();
                        String Childelement4 = element.getElementsByTagName("Preis").item(0).getTextContent();

                        System.out.println("Current Element : " + node.getNodeName());
                        System.out.println("Id : " + Childelement5);
                        System.out.println("Beschreibung : " + Childelement1);
                        System.out.println("Bezeichnung : " + Childelement2);
                        System.out.println("Maengel : " + Childelement3);
                        System.out.println("Preis : " + Childelement4);
                    }
                }

            }

        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(IWare ware) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        String DIE_ID_BEKOMME_ICH_VON_MUNIR = "10";

        try(InputStream is = new FileInputStream(dateipfad)){
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(is);

            NodeList listOfStaff = doc.getElementsByTagName("staff");

            for(int i = 0; i < listOfStaff.getLength(); i++){
                Node staff = listOfStaff.item(i);
                if(staff.getNodeType() == Node.ELEMENT_NODE){
                    String id = staff.getAttributes().getNamedItem("id").getTextContent();
                    if(DIE_ID_BEKOMME_ICH_VON_MUNIR.equals(id.trim())){

                        NodeList childNodes = staff.getChildNodes();

                        for(int j = 0; j < childNodes.getLength(); j++){
                            Node item = childNodes.item(j);
                            if(item.getNodeType() == Node.ELEMENT_NODE){
                                if("Beschreibung".equalsIgnoreCase(item.getNodeName())){
                                    item.setTextContent(ware.getBeschreibung());
                                }
                                if("Bezeichnung".equalsIgnoreCase(item.getNodeName())){
                                    item.setTextContent(ware.getBezeichnung());
                                }
                                if("Maengel".equalsIgnoreCase(item.getNodeName())){
                                    item.setTextContent(String.valueOf(ware.getMaengel()));
                                }
                                if("Preis".equalsIgnoreCase(item.getNodeName())){
                                    item.setTextContent(Double.toString(ware.getPreis()));
                                }
                            }
                        }




                    }
                }
            }



            try (FileOutputStream output = new FileOutputStream(dateipfad)){   //Irgendein passender Pfad
                writeXml(doc, output);
            }
        } catch (ParserConfigurationException | SAXException | IOException| TransformerException e){
            e.printStackTrace();
        }
    }

    private static void writeXml(Document doc, OutputStream output) throws  TransformerException, UnsupportedEncodingException{
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File("src/datasets/Ware.xslt")));

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }

    @Override
    public void delete(int id) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new File(dateipfad));

        NodeList nodes = doc.getElementsByTagName("Ware");

        for (int i = 0; i< nodes.getLength(); i++){
            Element ware = (Element)nodes.item(i);

            Element xml_id = (Element)ware.getElementsByTagName("ID").item(0);
            String w_id = xml_id.getTextContent();
            if(w_id.equals(String.valueOf(id))){
                ware.getParentNode().removeChild(ware);
            }
        }
    }
}
