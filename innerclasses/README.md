## INNER CLASSES

- Inner classes can be static class or non-static class.
- Inner classes can access all the variables of the outer class, even the private variables.
- To instantiate a static inner class from any external class.
```
var innerClassInstance = new OuterClass.InnerClass()
```
- To instantiate the non-static inner class from any external class.
```aidl
var outerclassInstance = new OuterClass();
var innerclassInstance = outerclassInstance.new InnerClass()
```

## LOCAL CLASSES

- Local classes are declared and defined within a method body.
- They do not have any access modifiers.
- The scope of the local classes are limitted only within the method body.
- All types of variables of the local classes are directly accessible from the enclosing method body.
- The variables of the local class are final or effectively final.
- Final variables should be assigned value on declaration and cannot be changed any further.
- Effectively final variables do not need to assigned a value on declaration, but once a value is assigned it cannot be changed.

## ANONYMOUS CLASSES

- Anonymous classes are implementation of the interfaces within a method body.
```aidl
var anonymousClassInstance = new Comparable<Employees>(){
    public int compareTo(Employee e) {
        return name.equalIgnoreCase(e.name);
    }
};
```
- The entire definition of the anonymous class can be passed as method argument.