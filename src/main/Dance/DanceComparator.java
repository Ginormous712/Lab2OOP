package main.Dance;

import java.util.Comparator;

public class DanceComparator implements Comparator<Dance> {

    @Override
    public int compare(Dance dance1, Dance dance2) {
        // Compare by Type field
        int typeComparison = dance1.getType().compareTo(dance2.getType());
        if (typeComparison != 0) {
            return typeComparison;
        }

        // If Type is the same, compare by the Scene field
        int sceneComparison = dance1.getScene().compareTo(dance2.getScene());
        if (sceneComparison != 0) {
            return sceneComparison;
        }

        // If Type and Scene are the same, compare by the Number field
        return dance1.getNumber().compareTo(dance2.getNumber());
    }
}
