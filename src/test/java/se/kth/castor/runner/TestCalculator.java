package se.kth.castor.runner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestCalculator {
    @Mock
    DrNitro mockDrNitro;

    @InjectMocks
    Calculator calculator = new Calculator();

    @Test
    public void testCalculatorAddition() {
        int sum = calculator.getSum(21, 21);
        verify(mockDrNitro, times(1)).destroyEarth(anyString());
        assertEquals(42, sum);
    }
}
