package org.example;

import static org.mockito.Mockito.*;

public class Main {

    static class WTF {

        int foo() {
            return (int) System.currentTimeMillis();
        }

        static int bar() {
            return (int) System.currentTimeMillis();
        }
    }

    public static void main(String[] args) {
        WTF mock = mock(WTF.class);
        when(mock.foo()).thenReturn(42);

        assert mock.foo() == 42;

    }
}