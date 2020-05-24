package com.epam.training.xmlparser.parser.dom;

import com.epam.training.xmlparser.entity.Flower;
import com.epam.training.xmlparser.exception.ParserException;
import com.epam.training.xmlparser.parser.Parser;
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
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private FlowerBuilder flowerBuilder = new FlowerBuilder();

    @Override
    public List<Flower> parse(String path) throws ParserException {
        List<Flower> flowerList = new ArrayList<Flower>();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();
            addFlowerToList(root, flowerList);
        } catch (IOException | ParserConfigurationException | org.xml.sax.SAXException ex) {
            throw new ParserException(ex.getMessage(), ex);
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
