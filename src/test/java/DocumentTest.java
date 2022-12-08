import decorator.Document;
import decorator.SmartDocument;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DocumentTest {
    Document document = new SmartDocument("gs://oop-course/Geico-2021.png");

    @Test
    public void DocumentTest() {
        Assertions.assertNotNull(document.parse());
    }
}
