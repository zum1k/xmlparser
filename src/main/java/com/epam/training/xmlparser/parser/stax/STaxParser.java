package com.epam.training.xmlparser.parser.stax;

import com.epam.training.xmlparser.entity.*;
import com.epam.training.xmlparser.exception.ParserException;
import com.epam.training.xmlparser.parser.Parser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class STaxParser implements Parser {
    @Override
    public List<Flower> parse(String xmlPath) throws ParserException {
        List<Flower> flowerList = new ArrayList<Flower>();
        Flower flower = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlPath));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "Flower":
                            flower = new Flower();
                            Attribute nameAttribute = startElement.getAttributeByName(new QName("name"));
                            flower.setName(nameAttribute.getValue());
                            break;

                        case "soilType":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setSoilType(Soil.valueOf(xmlEvent.asCharacters().getData()));
                            }
                            break;

                        case "originZone":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setOriginZone(Country.valueOf(xmlEvent.asCharacters().getData()));
                            }
                            break;

                        case "stemColor":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setStemColor(Color.valueOf(xmlEvent.asCharacters().getData()));
                            }
                            break;

                        case "leafColor":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setLeafColor(Color.valueOf(xmlEvent.asCharacters().getData()));
                            }
                            break;

                        case "averageSize":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setAverageSize(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            }
                            break;

                        case "temperature":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setTemperature(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            }
                            break;

                        case "irrigationPerWeek":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setIrrigationPerWeek(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            }
                            break;

                        case "lightLoving":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setLightLoving(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            }
                            break;

                        case "multiplyingType":
                            xmlEvent = reader.nextEvent();
                            if (flower != null) {
                                flower.setMultiplyingType(Multiplying.valueOf((xmlEvent.asCharacters().getData())));
                            }
                            break;
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Flower")) {
                        flowerList.add(flower);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }
        return flowerList;
    }
}


