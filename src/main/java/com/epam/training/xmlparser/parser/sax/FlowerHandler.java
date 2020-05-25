package com.epam.training.xmlparser.parser.sax;

import com.epam.training.xmlparser.entity.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.jar.Attributes;

class FlowerHandler extends DefaultHandler {
    private List<Flower> flowerList;
    private Flower flower = null;
    private FlowerTag currentEnum = null;
    private EnumSet<FlowerTag> tagSet;

    public FlowerHandler() {
        flowerList = new ArrayList<>();
    }

    public List<Flower> getFlowers() {
        return flowerList;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        StringBuilder stringBuilder = new StringBuilder();

        if (qName.equals("flower")) {
            flower = new Flower();
            flower.setName((attributes.getValue("name")));

        } else {
            FlowerTag tag = FlowerTag.valueOf(localName.toUpperCase());
            if (tagSet.contains(tag)) {
                currentEnum = tag;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("flower".equals(localName)) {
            flowerList.add(flower);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    flower.setName(s);
                    break;
                case SOIL_TYPE:
                    flower.setSoilType(Soil.valueOf(s));
                    break;
                case ORIGIN_ZONE:
                    flower.setOriginZone(Country.valueOf(s));
                    break;
                case STEM_COLOR:
                    flower.setStemColor(Color.valueOf(s));
                    break;
                case LEAF_COLOR:
                    flower.setLeafColor(Color.valueOf(s));
                    break;
                case AVERAGE_SIZE:
                    flower.setAverageSize(Integer.parseInt(s));
                    break;
                case TEMPERATURE:
                    flower.setTemperature(Integer.parseInt(s));
                    break;
                case IRRIGATION_PER_WEEK:
                    flower.setIrrigationPerWeek(Integer.parseInt(s));
                    break;
                case LIGHT_LOVING:
                    flower.setLightLoving(Boolean.parseBoolean(s));
                    break;
                case MULTIPLYING_TYPE:
                    flower.setMultiplyingType(Multiplying.valueOf(s));
                    break;
                default:
            }
            throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
        }
    }

    public void warning(SAXParseException exception) {
    }

    public void error(SAXParseException exception) {
    }

    public void fatalError(SAXParseException exception) throws SAXException {
    }
}

