package com.epam.training.xmlparser.factory;

        import com.epam.training.xmlparser.parser.Parser;
        import com.epam.training.xmlparser.parser.dom.DomParser;
        import com.epam.training.xmlparser.parser.sax.SaxParser;
        import com.epam.training.xmlparser.parser.stax.STaxParser;

public class ParserFactory {
    public Parser createParser(ParserType parserType) {
        switch (parserType) {
            case DOM:
                return new DomParser();
            case STAX:
                return new STaxParser();
            case SAX:
                return new SaxParser();
            default:
                throw new IllegalArgumentException("Illegal Parser Type");
        }
    }
}

