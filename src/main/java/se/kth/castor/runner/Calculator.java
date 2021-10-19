package se.kth.castor.runner;

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
        nitro.destroyEarth("now"); // some side effect
        return a + b;
    }

    public int getProduct(int a, int b) {
        crash.saveEarth("now");
        dingo.vacuum();
        return a * b;
    }

    public String plainOldMethod(String name) {
        return "Hello " + name;
    }

    public int getFancySum(int a, int b) {
        int c = dingo.setNumber();
        return a + b + c;
    }
}