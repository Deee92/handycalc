package se.kth.castor.runner;

public class Calculator {
    String colour;
    DrNitro nitro;

    Calculator() {
        this.colour = "red";
        this.nitro = new DrNitro();
    }

    public int getSum(int a, int b) {
        nitro.destroyEarth("now"); // some side effect
        return a + b;
    }
}