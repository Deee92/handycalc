package se.kth.castor.runner;

import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestCalculatorPanktiGenGoal {
    static XStream xStream = new XStream();

    @Mock
    se.kth.castor.runner.DrNitro mockNitro;

    @Mock
    private Bandicoot mockCrash;

    @Mock
    DingoDile mockDingo;

    @InjectMocks
    Calculator calculator = new Calculator();

    @BeforeAll
    public static void setxStream() {
        xStream.allowTypesByWildcard(new String[]{
                "**"
        });
    }


    private <T> T deserializeObject(String serializedObjectString) {
        return (T) xStream.fromXML(serializedObjectString);
    }

    private <T> T deserializeObject(File serializedObjectFile) throws Exception {
        Scanner scanner = new Scanner(serializedObjectFile);
        String serializedObjectString = scanner.useDelimiter("\\A").next();
        return (T) xStream.fromXML(serializedObjectString);
    }

    @Test
    public void testGetSum1() throws Exception {
        String receivingObjectStr =
                "<se.kth.castor.runner.Calculator>" +
                        "  <colour>red</colour>" +
                        "  <nitro>" +
                        "    <badness>max</badness>" +
                        "  </nitro>" +
                        "</se.kth.castor.runner.Calculator>";
        Calculator receivingObject = deserializeObject(receivingObjectStr);
        assertEquals(42, receivingObject.getSum(21, 21));
    }

    @Test
    public void testGetSumWithMock() throws Exception {
        int returnedObject = calculator.getSum(21, 21);
        verify(mockNitro, times(1)).destroyEarth(anyString());
        assertEquals(42, returnedObject);
    }

    @Test
    public void testGetProductWithMock() throws Exception {
        int returnedObject = calculator.getProduct(21, 2);
        verify(mockCrash, times(1)).saveEarth(anyString());
        verify(mockDingo, times(1)).vacuum();
        assertEquals(42, returnedObject);
    }

    @Test
    public void testPlainOldMethod1() throws Exception {
        String receivingObjectStr =
                "<se.kth.castor.runner.Calculator>" +
                        "  <colour>red</colour>" +
                        "  <nitro>" +
                        "    <badness>max</badness>" +
                        "  </nitro>" +
                        "  <crash>" +
                        "    <hasAkuAku>true</hasAkuAku>" +
                        "  </crash>" +
                        "  <dingo/>" +
                        "</se.kth.castor.runner.Calculator>";
        se.kth.castor.runner.Calculator receivingObject = deserializeObject(receivingObjectStr);
        String returnedObjectStr =
                "<string>Hello Coco</string>";
        java.lang.String expectedObject = deserializeObject(returnedObjectStr);
        String paramsObjectStr =
                "<object-array>" +
                        "  <string>Coco</string>" +
                        "</object-array>";
        Object[] paramObjects = deserializeObject(paramsObjectStr);
        java.lang.String paramObject1 = (java.lang.String) paramObjects[0];
        assertEquals(expectedObject, receivingObject.plainOldMethod(paramObject1));
    }
}