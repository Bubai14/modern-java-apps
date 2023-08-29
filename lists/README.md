## ArrayLists, LinkedLists, AutoBoxing and Enum

 - Its always beneficial to use iterator for collection traversal as it can help to modify the collection without getting collection modifiable exceptions.
 - With iterator, it acts as a database cursor pointing to spaces between the items.

### Autoboxing
 - Now boxing and unboxing is automatically done by Java. We need not call factory methods like Integer.valueOf() or .intValue();
```
Integer autoBoxed = 5;
int unboxed = autoBoxed;
```