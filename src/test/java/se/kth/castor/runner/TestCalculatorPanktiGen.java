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
public class TestCalculatorPanktiGen {
    static XStream xStream = new XStream();

    @Mock
    DrNitro mockNitro;

    @InjectMocks
    Calculator calculator = new Calculator();

    @BeforeAll
    public static void setxStream() {
        xStream.allowTypesByWildcard(new String[] {
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
}