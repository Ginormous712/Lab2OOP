package main.Parcers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import main.Dance.*

public class DanceSAXParser {

    public static List<Dance> parse(String filePath) throws SAXException {
        List<Dance> dances = new ArrayList<>();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                Dance dance;
                DancerType dancer;
                List<DancerType> dancers;
                String content;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    content = "";
                    if ("Dance".equals(qName)) {
                        dance = new Dance();
                    } else if ("Dancer".equals(qName)) {
                        if (dancers == null) {
                            dancers = new ArrayList<>();
                        }
                        dancer = new DancerType();
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    content = new String(ch, start, length);
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    if ("id".equals(qName)) {
                        dance.setId(content);
                    } else if ("Type".equals(qName)) {
                        dance.setType(DanceTypeEnum.fromValue(content));
                    } else if ("Scene".equals(qName)) {
                        dance.setScene(SceneTypeEnum.fromValue(content));
                    } else if ("NumberOfDancers".equals(qName)) {
                        dance.setNumberOfDancers(NumberOfDancersEnum.fromValue(content));
                    } else if ("Music".equals(qName)) {
                        dance.setMusic(MusicTypeEnum.fromValue(content));
                    } else if ("Number".equals(qName)) {
                        dance.setNumber(BigInteger.valueOf(Long.parseLong(content)));
                    } else if ("Dancers".equals(qName)) {
                        DancersType dancersType = new DancersType();
                        dancersType.setDancer(dancers);
                        dance.setDancers(dancersType);
                    } else if ("Dancer".equals(qName)) {
                        dancers.add(dancer);
                    } else if ("Name".equals(qName)) {
                        dancer.setName(content);
                    } else if ("Age".equals(qName)) {
                        dancer.setAge(Integer.parseInt(content));
                    }
                }

                @Override
                public void endDocument() {
                    dances.add(dance);
                }
            };

            saxParser.parse(new File(filePath), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dances;
    }
}

