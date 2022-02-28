package se.kth.castor.runner;

public class DrNitro {
    String badness;

    DrNitro() {
        this.badness = "max";
    }

    public void destroyEarth(String when) {
        System.out.println("Destroying earth " + when);
    }

    public float getFloaty(int num) {
        return num * 1.5F;
    }
}
