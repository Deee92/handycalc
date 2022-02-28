package se.kth.castor.runner;

import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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
    public void testRandom() {
        long[] someLongArray = deserializeObject(
                "<long-array>" +
                        "  <long>0</long>" +
                        "  <long>108</long>" +
                        "  <long>108</long>" +
                        "</long-array>");
        for (long a : someLongArray) {
            System.out.println(a);
        }
    }

    @Test
    public void testGetSum1() throws Exception {
        String receivingObjectStr =
                "<se.kth.castor.runner.Calculator invocation-count=\"0\">" +
                        "  <colour>red</colour>" +
                        "  <nitro>" +
                        "    <badness>max</badness>" +
                        "  </nitro>" +
                        "  <crash/>" +
                        "</se.kth.castor.runner.Calculator>";
        Calculator receivingObject = deserializeObject(receivingObjectStr);
        DrNitro mockNitro = Mockito.mock(DrNitro.class);
        receivingObject.nitro = mockNitro;
        assertEquals(42, receivingObject.getSum(21, 21));
        verify(mockNitro, times(1)).destroyEarth(anyString());
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
        verify(mockDingo, times(6)).vacuum();
        assertEquals(42, returnedObject);
    }

    @Test
    public void testWithMockGetNumberOfLivesLeft() throws Exception {
        when(mockCrash.getNumberOfLivesLeft(anyInt(), anyInt())).thenReturn(21);
        assertEquals(42, calculator.getSum(21, 21));
        verify(mockCrash).getNumberOfLivesLeft(anyInt(), anyInt());
    }

    @Test
    public void testPlainOldMethod1() throws Exception {
        String receivingObjectStr =
                "<se.kth.castor.runner.Calculator invocation-count=\"0\">" +
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

    @Test
    public void testWithMockSetNumber() throws Exception {
        Mockito.when(mockDingo.setNumber(2, 5)).thenReturn(12);
        assertEquals(21, calculator.getFancySum(5, 4));
        Mockito.verify(mockDingo).setNumber(anyInt(), anyInt());
    }

    @Test
    public void testWithMockDestroyEarth() throws Exception {
        assertEquals(42, calculator.getSum(21, 21));
        Mockito.verify(mockNitro).destroyEarth("now");
    }

    @Test
    public void testVerifyMethodSeq_calculator588e04d9d6844d5cb023449af5f0843f() throws Exception {
        assertEquals(42, calculator.getProduct(21, 2));
        Mockito.verify(mockCrash, times(1)).saveEarth(anyString());
        Mockito.verify(mockDingo, times(6)).vacuum();
    }
}
