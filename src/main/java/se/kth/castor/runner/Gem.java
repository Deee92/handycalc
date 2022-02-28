package se.kth.castor.runner;

public class Gem {
    String colour;

    Gem(String colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return "This is a " + colour + "-coloured gem.";
    }
}
