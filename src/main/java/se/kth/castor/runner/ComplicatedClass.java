package se.kth.castor.runner;

public class ComplicatedClass {
    private Bandicoot bandicoot;
    DrNitro nitroOne;
    ComplicatedClass complicatedClassField;
    private DrNitro nitroTwo = new DrNitro();
    ComplicatedClass2 complicatedClass2;

    // no default constructor
    ComplicatedClass(Bandicoot bandicoot, DrNitro nitroOne, ComplicatedClass2 complicatedClass2) {
        this.bandicoot = bandicoot;
        this.nitroOne = nitroOne;
        this.complicatedClass2 = complicatedClass2;
    }

    ComplicatedClass(Bandicoot bandicoot) {
        this.bandicoot = bandicoot;
    }

    public Bandicoot getBandicoot() {
        return bandicoot;
    }

    public int performSomeCalculation(int a, int b) {
        int lives = bandicoot.getNumberOfLivesLeft(a, b);
        return lives * 100;
    }

    public DrNitro returnNonPrimitiveStuff() {
        bandicoot.getNumberOfLivesLeft(4, 2);
        return new DrNitro();
    }

    public int tryingParameterInvocation(final DingoDile dingoDile) {
        bandicoot.saveEarth("now");
        bandicoot.getNumberOfLivesLeft(7, 9);
        int someNumber = dingoDile.setNumber(5, 6);
        dingoDile.setNumber(9, 9);
        return someNumber + 2;
    }

    public float sameInvocationSignatureOnMultipleFields() {
        float first = nitroOne.getFloaty(50);
        float second = nitroTwo.getFloaty(25);
        return first + second;
    }

    public long someLongMethod(long value) {
        return value + 42L;
    }

    // is method declaring type same as executable declaring type?
    public void something() {
        complicatedClassField.sameInvocationSignatureOnMultipleFields();
    }
}
