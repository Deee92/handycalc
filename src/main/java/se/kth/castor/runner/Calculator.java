package se.kth.castor.runner;

import java.util.List;

public class Calculator {
    String colour;
    DrNitro nitro;
    Bandicoot crash;
    DingoDile dingo;

    Calculator() {
        this.colour = "red";
        this.nitro = new DrNitro();
        this.crash = new Bandicoot();
        this.dingo = new DingoDile();
    }

    public int getSum(int a, int b) {
        crash.getNumberOfLivesLeft(56, 78);
        nitro.destroyEarth("now"); // some side effect
        return a + b;
    }

    public int getProduct(int a, int b) {
        crash.saveEarth("now");
        dingo.vacuum();
        for (int i = 0; i < 5; i++)
            dingo.vacuum();
        return a * b;
    }

    public String plainOldMethod(String name) {
        return "Hello " + name;
    }

    public int getFancySum(int a, int b) {
        int c = dingo.setNumber(2, 5);
        return a + b + c;
    }

    public String funnyStrings() {
        String concatenated = "";
        List<String> elements = crash.getNiceList(List.of("Hydrogen", "Helium", "Lithium", "Beryllium"));
        for (String e : elements) {
            concatenated += e + ". ";
        }
        return concatenated;
    }
}