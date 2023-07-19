package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExampleTest {

    I argument;
    Example testSubject;

    @BeforeEach
    void setup() {
        argument = mock(I.class);
        testSubject = new Example();
    }

    @Test
    void branchIsStable() {
        when(argument.nextValue()).thenReturn(1, 2, 3);
        when(argument.name()).thenReturn("I");
        assertEquals(3, testSubject.mut(argument));
    }

    @Test
    void branchIsUnstable() {
        when(argument.nextValue()).thenReturn(1, -2);
        when(argument.name()).thenReturn("I");
        assertThrows(IllegalStateException.class, () -> testSubject.mut(argument));
    }

    @Test
    void branchNegative() {
        when(argument.nextValue()).thenReturn(0, 1);
        when(argument.name()).thenReturn("negative");
        assertEquals(-1, testSubject.mut(argument));
    }


    @Test
    void branchUncovered() {
        when(argument.nextValue()).thenReturn(0);
        when(argument.name()).thenReturn("non-negative");
        assertThrows(IllegalArgumentException.class, () -> testSubject.mut(argument));
    }

}