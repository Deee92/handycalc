package se.kth.castor.runner;

public class Main {
    public int someMainMethod() {
        System.out.println("hello from another method");
        return 56;
    }

//    public void testingRegex() {
//        List<String> xmls = new ArrayList<>();
//        String xml1 = "" +
//                "<object-array>\n" +
//                "  <org.apache.pdfbox.cos.COSName>\n" +
//                "    <direct>false</direct>\n" +
//                "    <name>Encrypt</name>\n" +
//                "    <hashCode>57395781</hashCode>\n" +
//                "  </org.apache.pdfbox.cos.COSName>\n" +
//                "</object-array>";
//
//        String xml2 = "<null/>";
//        String xml3 = "<object-array/>";
//        String xml4 = "<some.cos.array/>";
//        String xml5 = "" +
//                "<object-array>\n" +
//                "  <org.apache.pdfbox.cos.COSName/>\n" +
//                "    <direct>false</direct>\n" +
//                "    <name>Encrypt</name>\n" +
//                "    <hashCode>57395781</hashCode>\n" +
//                "  </org.apache.pdfbox.cos.COSName>\n" +
//                "</object-array>";
//        xmls.add(xml1);
//        xmls.add(xml2);
//        xmls.add(xml3);
//        xmls.add(xml4);
//        xmls.add(xml5);
//        for (String xml : xmls) {
//            System.out.println(xml.indexOf('>'));
//            System.out.println((xml.indexOf('>')) - 1);
//            if (xml.charAt(xml.indexOf('>') - 1) != '/') {
//                xml = xml.replaceFirst(">", " count=\"1\">");
//                System.out.println(xml);
//            }
//        }
//    }

    public static void main(String[] args) throws Exception {
        System.out.println("Running calculator");
        Main main = new Main();
//        main.testingRegex();
        main.someMainMethod();
        Calculator calculator = new Calculator();
        System.out.println(calculator.plainOldMethod("Coco"));
        int sum = calculator.getSum(21, 21);
        int product = calculator.getProduct(21, 2);
        System.out.println(calculator.funnyStrings());
        System.out.println("The sum is " + sum);
        System.out.println("The product is " + product);
        System.out.println("The fancy sum is " + calculator.getFancySum(5, 4));
        Bandicoot crash = new Bandicoot();
        System.out.println("Collecting new gem");
        crash.collectGem("silver");
        System.out.println("Meet crash: " + crash.meetCrash());
        System.out.println("Number of lives left: " + crash.getNumberOfLivesLeft(12, 34));

        ComplicatedClass complicatedClass = new ComplicatedClass(crash, new DrNitro(), new ComplicatedClass2(Integer.valueOf(6)));
        System.out.println("result from complicated class: " + complicatedClass.performSomeCalculation(42, 42));
        System.out.println("Dingo parameter: " + complicatedClass.tryingParameterInvocation(calculator.dingo));
        System.out.println("Long values: " + complicatedClass.someLongMethod(42L));
        System.out.println(complicatedClass.returnNonPrimitiveStuff());
        System.out.println("multiple fields: " + complicatedClass.sameInvocationSignatureOnMultipleFields());
    }
}
