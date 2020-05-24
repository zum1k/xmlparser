package com.epam.training.xmlparser.parser;

import com.epam.training.xmlparser.entity.Flower;
import com.epam.training.xmlparser.exception.ParserException;

import java.util.List;

public interface Parser {
    List<Flower> parse(String path) throws ParserException;
}
