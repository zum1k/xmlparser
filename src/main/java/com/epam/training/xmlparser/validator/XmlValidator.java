package com.epam.training.xmlparser.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    private static final Logger LOGGER = LogManager.getLogger(XmlValidator.class);

    public boolean isValid(String xsdPath, String xmlPath) {
        boolean result = false;
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemaLocation = new File(xsdPath);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
            result = true;
        } catch (IOException e) {
            LOGGER.error("I/O exception in file - " + xmlPath);
        } catch (SAXException e) {
            LOGGER.error("Exception while reading XML in file - " + xmlPath);
        }
        return result;
    }
}
