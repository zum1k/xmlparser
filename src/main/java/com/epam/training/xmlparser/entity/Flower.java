package com.epam.training.xmlparser.entity;

import java.util.Objects;

public class Flower {
    private String name;
    private Soil soilType;
    private Country originZone;

    private Color stemColor;
    private Color leafColor;
    private int averageSize;

    private int temperature;
    private int irrigationPerWeek;
    private boolean lightLoving;
    private Multiplying mtpType;

    public Flower(){

    }

    public Flower(String name, Soil soilType, Country originZone, Color stemColor, Color leafColor,
                  int averageSize, int temperature, int irrigationPerWeek, boolean lightLoving, Multiplying mtpType) {
        this.name = name;
        this.soilType = soilType;
        this.originZone = originZone;
        this.stemColor = stemColor;
        this.leafColor = leafColor;
        this.averageSize = averageSize;
        this.temperature = temperature;
        this.irrigationPerWeek = irrigationPerWeek;
        this.lightLoving = lightLoving;
        this.mtpType = mtpType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoilType() {
        return soilType;
    }

    public void setSoilType(Soil soilType) {
        this.soilType = soilType;
    }

    public Country getOriginZone() {
        return originZone;
    }

    public void setOriginZone(Country originZone) {
        this.originZone = originZone;
    }

    public Color getStemColor() {
        return stemColor;
    }

    public void setStemColor(Color stemColor) {
        this.stemColor = stemColor;
    }

    public Color getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(Color leafColor) {
        this.leafColor = leafColor;
    }

    public int getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(int averageSize) {
        this.averageSize = averageSize;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getIrrigationPerWeek() {
        return irrigationPerWeek;
    }

    public void setIrrigationPerWeek(int irrigationPerWeek) {
        this.irrigationPerWeek = irrigationPerWeek;
    }

    public boolean isLightLoving() {
        return lightLoving;
    }

    public void setLightLoving(boolean lightLoving) {
        this.lightLoving = lightLoving;
    }

    public Multiplying getMtpType() {
        return mtpType;
    }

    public void setMtpType(Multiplying mtpType) {
        this.mtpType = mtpType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flower flower = (Flower) o;
        return averageSize == flower.averageSize &&
                temperature == flower.temperature &&
                irrigationPerWeek == flower.irrigationPerWeek &&
                lightLoving == flower.lightLoving &&
                Objects.equals(name, flower.name) &&
                soilType == flower.soilType &&
                originZone == flower.originZone &&
                stemColor == flower.stemColor &&
                leafColor == flower.leafColor &&
                mtpType == flower.mtpType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, soilType, originZone, stemColor, leafColor, averageSize,
                temperature, irrigationPerWeek, lightLoving, mtpType);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Flower{" +
                "name='" + name + '\'' +
                ", soilType=" + soilType +
                ", originZone=" + originZone +
                ", stemColor=" + stemColor +
                ", leafColor=" + leafColor +
                ", averageSize=" + averageSize +
                ", temperature=" + temperature +
                ", irrigationPerWeek=" + irrigationPerWeek +
                ", lightLoving=" + lightLoving +
                ", mtpType=" + mtpType +
                '}').toString();
    }
}
