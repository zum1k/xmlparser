package com.epam.training.xmlparser.parser.sax;

import com.epam.training.xmlparser.entity.Flower;
import com.epam.training.xmlparser.exception.ParserException;
import com.epam.training.xmlparser.parser.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {
    private FlowerHandler flowerHandler;
    private SAXParserFactory saxParserFactory;

    @Override
    public List<Flower> parse(String path) throws ParserException {
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(path, flowerHandler);
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            throw new ParserException(ex.getMessage(), ex);

        }
        return flowerHandler.getFlowers();
    }
}
