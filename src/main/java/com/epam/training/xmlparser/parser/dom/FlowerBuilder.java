package com.epam.training.xmlparser.parser.dom;

import com.epam.training.xmlparser.entity.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class FlowerBuilder {

    Flower buildFlower(Element element) {
        Flower flower = new Flower();
        String name = element.getAttribute("name");
        flower.setName(name);

        String soilTypeStr = getElementText(element, "soilType");
        String soilTypeUpper = soilTypeStr.toUpperCase();
        Soil soilType = Soil.valueOf(soilTypeUpper);
        flower.setSoilType(soilType);

        String originStr = getElementText(element, "origin");
        String originUpper = originStr.toUpperCase();
        Country originZone = Country.valueOf(originUpper);
        flower.setOriginZone(originZone);

        String stemColorStr = getElementText(element, "stemColor");
        String stemColorUpper = stemColorStr.toUpperCase();
        Color stemColor = Color.valueOf(stemColorUpper);
        flower.setStemColor(stemColor);

        String leafColorStr = getElementText(element, "leafColor");
        String leafColorUpper = leafColorStr.toUpperCase();
        Color leafColor = Color.valueOf(leafColorUpper);
        flower.setLeafColor(leafColor);

        String averageSizerStr = getElementText(element, "averageSize");
        int averageSize = Integer.parseInt(averageSizerStr);
        flower.setAverageSize(averageSize);

        String temperatureStr = getElementText(element, "temperature");
        int temperature = Integer.parseInt(temperatureStr);
        flower.setTemperature(temperature);

        String irrigationPerWeekStr = getElementText(element, "irrigationPerWeek");
        int irrigationPerWeek = Integer.parseInt(irrigationPerWeekStr);
        flower.setIrrigationPerWeek(irrigationPerWeek);

        String lightLovingStr = getElementText(element, "lightLoving");
        boolean lightLoving = Boolean.parseBoolean(lightLovingStr);
        flower.setLightLoving(lightLoving);

        String multiplyingTypeStr = getElementText(element, "multiplyingType");
        String multiplyingTypeUpper = multiplyingTypeStr.toUpperCase();
        Multiplying multiplyingType = Multiplying.valueOf(multiplyingTypeUpper);
        flower.setMultiplyingType(multiplyingType);
        return flower;
    }

    private String getElementText(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
