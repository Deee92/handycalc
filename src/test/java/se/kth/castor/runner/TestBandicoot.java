package se.kth.castor.runner;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class TestBandicoot {
    Bandicoot bandicoot = new Bandicoot();

    @Test
    public void testTryMockingList() {
        List mockList = Mockito.mock(List.class);
        bandicoot.gems = mockList;
        when(mockList.size()).thenReturn(2);
        assertEquals("Crash has 2 gems", bandicoot.meetCrash());
    }

    @Test
    public void testTryMockingList1() {
        List mockList = Mockito.mock(List.class);
        bandicoot.gems = mockList;
        assertNotEquals("Crash has 2 gems", bandicoot.meetCrash());
    }

    @Test
    public void testMockListAgain() {
        List mockList = Mockito.mock(List.class);
        bandicoot.gems = mockList;
        when(mockList.size()).thenReturn(3);
        bandicoot.collectGem("red");
        verify(mockList, atLeastOnce()).add(any(Gem.class));
    }
}
