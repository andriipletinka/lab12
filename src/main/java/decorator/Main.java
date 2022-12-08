package decorator;

public class Main {
    public static void main(String[] args) {
//        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
//        System.out.println(document.parse());
//        System.out.println();
//        document = new TimedDocument(document);
//        System.out.println(document.parse());
//        System.out.println();
        SmartDocument document1 = new SmartDocument("gs://oop-course/Geico-2021.png");
        CashedDocument document2 = new CashedDocument(document1);
//        System.out.println(document2.parse());
        System.out.println(document2.find());
    }
}
