package se.kth.castor.runner;

import java.util.ArrayList;
import java.util.List;

public class Bandicoot {
    boolean hasAkuAku;
    List<Gem> gems = new ArrayList<>();

    Bandicoot() {
        this.hasAkuAku = true;
    }

    public int getNumberOfLivesLeft(int a, int b) {
        return a + b;
    }

    public void saveEarth(String when) {
        System.out.println("Saving earth " + when);
    }

    // Hi there I am a comment
    public List<String> getNiceList(List<String> someStrings) {
        List<String> newList = new ArrayList<>();
        for (String s : someStrings) {
            newList.add("This is " + s);
        }
        return newList;
    }

    public String meetCrash() {
        return "Crash has "+ gems.size() + " gems";
    }

    public void collectGem(String colour) {
        gems.add(new Gem(colour));
    }
}
