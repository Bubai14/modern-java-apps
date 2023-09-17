## Immutables

- Shallow Copy - shallow copy creates a new object with same references to fields inside the objects.
- Deep Copy - Deep copy creates a fresh new copy of the objects with new references of the fields.

### Making Collections Immutable
- Some of the methods which make unmodifiable collections are:
```aidl
List.copyOf()
List.of()
Set.copyOf()
Set.of()
Map.copyOf()
Map.of()
Map.entry(K k, V v)
Map.ofEntries()
```
- The above methods will make a immutable copy of the collection passed. Any changes to the original collection after the copy has been made will not get reflected in the copy.
- You can even achieve the same using these methods
```aidl
Collections.unmodifiableList
Collections.unmodifiableSet
Collections.unmodifiableNavigableSet
Collections.unmodifiableSortedSet
Collections.unmodifiableMap
Collections.unmodifiableNavigableMap
Collections.unmodifiableSortableMap
```
- The above methods will reflect the changes of the original collect even after the copy was made.
### Record
- Records are implicitly final classes.
- The arguments passed in the record classes are implicitly final.
```aidl
public record Person(String name, String dob) {}
```
- Records support two types of constructors:
- Canonical constructor - Which is called after the arguments passed to the record are initialized.
- Constant constructor - Which is called before the arguments passed to the record are initialized. This constructor does not need any argument
```aidl
Person {
}
```

### Sealed Classes

- Sealed classed (from JDK 17) allows to lock the extensibility/inhertance of the classes/interfaces.
- The sealed classes has to be declared with keyword ```sealed```. The class/interface to be provided the names of subclasses or interfaces which will extend/implement it.
```aidl
public sealed abstract class SealedClass permits ChildFinalClass, ChildNonSealedClass
```
- The subclasses of the sealed class has to be declared with ```sealed, non-sealed or final``` keyword.
- sealed - Allows only permitted class to inherit it.
- non-sealed - Allows all type of class to inherit it. Use it to break the lock of sealed class for some of the sub class.
- final - Class which cannot be subclassed.