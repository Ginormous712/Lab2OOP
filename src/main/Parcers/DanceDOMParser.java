package main.Parcers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import main.Dance.*;

public class DanceDOMParser {

    public static List<Dance> parse(String filePath) {
        List<Dance> dances = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            NodeList danceNodes = document.getElementsByTagName("Dance");

            for (int i = 0; i < danceNodes.getLength(); i++) {
                Node danceNode = danceNodes.item(i);

                if (danceNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element danceElement = (Element) danceNode;
                    Dance dance = new Dance();

                    dance.setId(danceElement.getElementsByTagName("id").item(0).getTextContent());
                    dance.setType(DanceTypeEnum.fromValue(danceElement.getElementsByTagName("Type").item(0).getTextContent()));
                    dance.setScene(SceneTypeEnum.fromValue(danceElement.getElementsByTagName("Scene").item(0).getTextContent()));
                    dance.setNumberOfDancers(NumberOfDancersEnum.fromValue(danceElement.getElementsByTagName("NumberOfDancers").item(0).getTextContent()));
                    dance.setMusic(MusicTypeEnum.fromValue(danceElement.getElementsByTagName("Music").item(0).getTextContent()));
                    dance.setNumber(BigInteger.valueOf(Long.parseLong(danceElement.getElementsByTagName("Number").item(0).getTextContent())));

                    NodeList dancerNodes = danceElement.getElementsByTagName("Dancer");
                    DancersType dancersType = new DancersType();
                    List<DancerType> dancers = new ArrayList<>();

                    for (int j = 0; j < dancerNodes.getLength(); j++) {
                        Node dancerNode = dancerNodes.item(j);

                        if (dancerNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element dancerElement = (Element) dancerNode;
                            DancerType dancer = new DancerType();
                            dancer.setName(dancerElement.getElementsByTagName("Name").item(0).getTextContent());
                            dancer.setAge(Integer.parseInt(dancerElement.getElementsByTagName("Age").item(0).getTextContent()));
                            dancers.add(dancer);
                        }
                    }

                    dancersType.setDancer(dancers);
                    dance.setDancers(dancersType);

                    dances.add(dance);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dances;
    }
}
