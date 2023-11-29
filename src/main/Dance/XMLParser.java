package main.Dance;

import main.Dance.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLParser {

    public static Dance parseXML(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Dance.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (Dance) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}

