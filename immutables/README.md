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