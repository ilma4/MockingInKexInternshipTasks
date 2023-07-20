## Task 1.

It's possible to generate a class in runtime (in bytecode or in source and then compile), load it
and then use it. So we can make this class an inherited from required to mock, override
interested methods and that's it.

Limitations:

1. Can't mock `final` classes, `final` methods and `final` inner classes
    - Can't mock enums and records
2. Can't avoid executing constructors
    - Have to provide all dependencies (or their mocks)
3. `getClass` will return different result than on real objects. So mock object could be
   different from the original.
4. Can't directly mock `sealed` class/interface. Have to mock a derived class/realization instead.
5. Can't mock `static` methods

All that problems solved in mocking frameworks (at least in Mockito).

## Task 2.

I think, main problem will be invariants. They may be simple and explicit:

```java
record PositiveInt(int value) {

    PositiveInt {
        assert value > 0;
    }
}
```

```java
record PrimeInt(int value) {

    PrimeInt {
        assert isPrime(value);
    }
}
```


```java
record Example(int value){
    
    
}

```

