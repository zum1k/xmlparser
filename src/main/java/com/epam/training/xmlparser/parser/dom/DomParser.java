package com.epam.training.xmlparser.parser.dom;

import com.epam.training.xmlparser.entity.Flower;
import com.epam.training.xmlparser.exception.ParserException;
import com.epam.training.xmlparser.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private FlowerBuilder flowerBuilder = new FlowerBuilder();

    @Override
    public List<Flower> parse(String xmlPath) throws ParserException {
        List<Flower> flowerList = new ArrayList<Flower>();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlPath);
            Element root = document.getDocumentElement();
            addFlowerToList(root, flowerList);
        } catch (IOException e) {
            LOGGER.error("I/O exception in file - " +xmlPath);
        }
        catch (ParserConfigurationException e) {
            LOGGER.error("Wrong configuration exception - "+xmlPath);
        }
        catch (org.xml.sax.SAXException e) {
           LOGGER.error("SAX exception - " +xmlPath);
        }
        return flowerList;
    }

    private void addFlowerToList(Element root, List<Flower> flowers) {
        NodeList flowerList = root.getElementsByTagName("flower");
        for (int i = 0; i < flowerList.getLength(); ++i) {
            Element flowerElement = (Element) flowerList.item(i);
            Flower flower = flowerBuilder.buildFlower(flowerElement);
            flowers.add(flower);
        }
    }
}
