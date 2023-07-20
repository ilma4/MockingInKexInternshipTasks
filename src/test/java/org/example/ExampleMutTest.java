package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ExampleMutTest {

    I argument;
    Example example;

    @BeforeEach
    void setup() {
        argument = Mockito.mock(I.class);
        example = new Example();
    }

    @Test
    void branchIsStable() {
        Mockito.when(argument.nextValue()).thenReturn(1, 2, 3);
        Mockito.when(argument.name()).thenReturn("I");

        assertEquals(3, example.mut(argument));
    }

    @Test
    void branchIsUnstable() {
        Mockito.when(argument.nextValue()).thenReturn(1, -2);
        Mockito.when(argument.name()).thenReturn("I");

        assertThrows(IllegalStateException.class, () -> example.mut(argument));
    }

    @Test
    void branchNegative() {
        Mockito.when(argument.nextValue()).thenReturn(0, 1);
        Mockito.when(argument.name()).thenReturn("negative");

        assertEquals(-1, example.mut(argument));
    }


    @Test
    void branchUncovered() {
        Mockito.when(argument.nextValue()).thenReturn(0);
        Mockito.when(argument.name()).thenReturn("non-negative");

        assertThrows(IllegalArgumentException.class, () -> example.mut(argument));
    }
}