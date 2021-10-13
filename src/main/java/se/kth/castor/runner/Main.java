package se.kth.castor.runner;

public class Main {
    public int someMainMethod() {
        System.out.println("hello from another method");
        return 56;
    }

    public static void main(String[] args) {
        System.out.println("Running calculator");
        Main main = new Main();
        main.someMainMethod();
        Calculator calculator = new Calculator();
        int sum = calculator.getSum(21, 21);
        System.out.println("The sum is " + sum);
    }
}
