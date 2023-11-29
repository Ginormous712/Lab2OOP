package main.Parcers;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import main.Dance.*;
public class DanceStAXParser {

    public static List<Dance> parse(String filePath) {
        List<Dance> dances = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(new File(filePath))) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);

            Dance dance = null;
            DancerType dancer = null;
            List<DancerType> dancers = null;
            String content = null;

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        content = "";
                        if ("Dance".equals(reader.getLocalName())) {
                            dance = new Dance();
                        } else if ("Dancer".equals(reader.getLocalName())) {
                            if (dancers == null) {
                                dancers = new ArrayList<>();
                            }
                            dancer = new DancerType();
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        content = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if ("id".equals(reader.getLocalName())) {
                            dance.setId(content);
                        } else if ("Type".equals(reader.getLocalName())) {
                            dance.setType(DanceTypeEnum.fromValue(content));
                        } else if ("Scene".equals(reader.getLocalName())) {
                            dance.setScene(SceneTypeEnum.fromValue(content));
                        } else if ("NumberOfDancers".equals(reader.getLocalName())) {
                            dance.setNumberOfDancers(NumberOfDancersEnum.fromValue(content));
                        } else if ("Music".equals(reader.getLocalName())) {
                            dance.setMusic(MusicTypeEnum.fromValue(content));
                        } else if ("Number".equals(reader.getLocalName())) {
                            dance.setNumber(BigInteger.valueOf(Long.parseLong(content)));
                        } else if ("Dancers".equals(reader.getLocalName())) {
                            DancersType dancersType = new DancersType();
                            dancersType.setDancer(dancers);
                            dance.setDancers(dancersType);
                        } else if ("Dancer".equals(reader.getLocalName())) {
                            dancers.add(dancer);
                        } else if ("Name".equals(reader.getLocalName())) {
                            dancer.setName(content);
                        } else if ("Age".equals(reader.getLocalName())) {
                            dancer.setAge(Integer.parseInt(content));
                        } else if ("Dance".equals(reader.getLocalName())) {
                            dances.add(dance);
                        }
                        break;
                }
            }

        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dances;
    }
}
