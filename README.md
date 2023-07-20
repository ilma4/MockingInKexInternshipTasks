# Mocking in Kex

## Task 1.

It's possible to generate a class in runtime, load it and then use it. So we can make this class an
inherited from required to mock, override
interested methods and that's it.

Limitations:

1. Can't mock `final` classes and `final` members (methods, nested classes, fields)
    - Can't mock enums and records
2. Can't avoid executing constructors
    - Have to provide all dependencies (or their mocks)
3. `getClass` will return different result than on real objects. So mock object could be
   different from the original.
4. Can't directly mock `sealed` class/interface. Have to mock a derived class/realization instead.
5. Can't mock `static` methods

All that problems solved in mocking frameworks (at least in Mockito).

## Task 2.

### Methods

I think, main problem will not with fields but with methods. Because unknown method can cause
unknown side effects, up to finishing program.

I suppose more practical would be to suppose, that object would only change its own state and state
of arguments passed to methods.

Scenario when side effects affects global and system variables could be optional.

### Fields

Other problem is invariants. Some of them are explicit (in constructor) which is good for SE.
But I suppose more problems would cause implicit, especially which only can be found when analyzing
program from the beginning.

However, I suppose it is a good place for reusing previous results. Idea: committed changes, then
run SE. It found a bug in a method. I edit that method (and only it). After that SE can check only
that buggy method.

## Task 3

Tested class and interface are [here](src/main/java/org/example/Example.java)

[Test](/src/test/java/org/example/ExampleMutTest.java)