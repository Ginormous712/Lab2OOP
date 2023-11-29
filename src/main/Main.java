package main;

import main.Dance.*;
import main.Parcers.*

import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String filePath = "Resources/Dance.xml";

        // Using DOM parser
        List<Dance> dancesDOM = DanceDOMParser.parse(filePath);
        printDances("DOM Parser", dancesDOM);

        // Using SAX parser
        try {
            List<Dance> dancesSAX = DanceSAXParser.parse(filePath);
            printDances("SAX Parser", dancesSAX);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Using StAX parser
        List<Dance> dancesStAX = DanceStAXParser.parse(filePath);
        printDances("StAX Parser", dancesStAX);

        System.out.println("Unsorted Dances:");
        printDances(dancesStAX);

        Collections.sort(dancesStAX, new DanceComparator());

        System.out.println("\nSorted Dances:");
        printDances(dancesStAX);
    }

    private static void printDances(String parser, List<Dance> dances) {
        System.out.println(parser + " Result:");
        for (Dance dance : dances) {
            System.out.println(dance);
        }
        System.out.println();
    }

    private static void printDances(List<Dance> dances) {
        for (Dance dance : dances) {
            System.out.println(dance);
        }
    }
}