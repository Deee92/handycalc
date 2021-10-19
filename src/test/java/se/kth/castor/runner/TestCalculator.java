package se.kth.castor.runner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestCalculator {
    @Mock
    DrNitro mockDrNitro;

    @Mock
    DingoDile mockDingoDile;

    @InjectMocks
    Calculator calculator = new Calculator();

    @Test
    public void testCalculatorAddition() {
        int sum = calculator.getSum(21, 21);
        verify(mockDrNitro, times(1)).destroyEarth(anyString());
        assertEquals(42, sum);
    }

    @Test
    public void testWithStub() {
        when(mockDingoDile.setNumber()).thenReturn(9);
        assertEquals(22, calculator.getFancySum(6, 7));
        verify(mockDingoDile, times(1)).setNumber();
    }
}
