## LAMBDA EXPRESSIONS

- Lambda expressions can be implemented for the interfaces annotated with ```@FunctionalInterfaces``` (i.e. Interfaces which have only one abstract method).
- The methods inside the functional interfaces implicitly returns the value types based on the type of parameter passed.
- If curly braces are used inside the lambda expressions, you have to explicitly return the values.
```aidl
(a, b) -> a + b, 10, 12; // Implicitly returns values as per the type of the parameters passed.
(a, b) -> {
    int c = a + b;
    return c;
}
```

## FUNCTIONAL INTERFACES

- Modern JDK have provided lots of in-built functional interfaces from ```java.util.function``` package.
- Some of the widely used functional interfaces are:
```aidl
Consumer - void accept(T t) //executes code without returning the data
Function<T, R> - R apply(T t) // returns a result of the operation
BiFunction<T, U, R> - R apply(T t, U u) // returns a result of the operation taking two arguments
Predicate - boolean test(T t) // test if a condition is true or false.
BiPredicate - boolean test(T t, U u) // takes two arguments to test a condition.
Supplier - T get() // return an instance of something without taking any parameters.
UnaryOperator<T> - T apply(T t) // returns the result of type same as argument.
BinaryOperator<T> - T apply(T t1, T t2) // returns the result of same type as arguments, but takes 2 arguments.
```

## METHOD REFERENCES

- Method references are used in place of lambda expressions. 
- Method references can be used in these scenarios:
- static method - ```(p1, p2) -> p1 + p2 - Integer::sum```
- Instance methods - ```p1 -> System.out.println(p1) - System.out::println```
- Instance methods of an arbitrary objects - ```(p1, p2) -> p1.concat(p2 - String::concat```
- Constructor - ```() -> new LPAStudent - LPAStudent::new```
