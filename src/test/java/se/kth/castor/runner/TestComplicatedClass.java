package se.kth.castor.runner;

import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestComplicatedClass {

    static XStream xStream = new XStream();

    @Test
    public void testRegular() {
        ComplicatedClass complicatedClass = new ComplicatedClass(new Bandicoot(), new DrNitro(), new ComplicatedClass2(6));
        assertEquals(8400, complicatedClass.performSomeCalculation(42, 42));
    }

    @InjectMocks
    ComplicatedClass complicatedClass;

    @Mock
    Bandicoot mockBandicoot;

    @Mock
    DingoDile dingoDile;

    @Mock
    DrNitro mockDrNitro;

    @BeforeAll
    public static void setxStream() {
        xStream.allowTypesByWildcard(new String[]{
                "**"
        });
    }

    @Mock
    ComplicatedClass2 mockComplicatedClass2;

    private <T> T deserializeObject(String serializedObjectString) {
        return (T) xStream.fromXML(serializedObjectString);
    }

    @BeforeEach
    public void setUpMockInjection() {
//        complicatedClass = new ComplicatedClass(mockBandicoot, mockDrNitro, mockComplicatedClass2);
        complicatedClass = new ComplicatedClass(mockBandicoot);
//        complicatedClass = new ComplicatedClass(mockBandicoot, something);
    }

    @Test
    public void testWithMock() {
        when(mockBandicoot.getNumberOfLivesLeft(10, 12)).thenReturn(50);
        assertEquals(5000, complicatedClass.performSomeCalculation(10, 12));
        verify(mockBandicoot).getNumberOfLivesLeft(10, 12);
    }

    @Test
    public void testParameterMethod() {
        complicatedClass.tryingParameterInvocation(dingoDile);
        verify(dingoDile, times(2)).setNumber(anyInt(), anyInt());
    }

    @Test
    public void testWithMockSetNumber_a3f5a1d3964f48ba8809526239964ae5() throws Exception {
        when(dingoDile.setNumber(5, 6)).thenReturn(32);
        String paramsObjectStr =
                "<object-array>" +
                        "  <se.kth.castor.runner.DingoDile/>" +
                        "</object-array>";
        Object[] paramObjects = deserializeObject(paramsObjectStr);
        se.kth.castor.runner.DingoDile paramObject1 = (se.kth.castor.runner.DingoDile) paramObjects[0];
        assertEquals(34, complicatedClass.tryingParameterInvocation(dingoDile));
        verify(dingoDile).setNumber(5, 6);
    }

}
