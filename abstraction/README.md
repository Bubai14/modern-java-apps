## Abstract class and Interfaces

- Removing an access modifier from a class member makes it implicitly private.
- Removing an access modifier from an interface makes it implicitly public.
- Access modifier protected cannot be used on Interface.
- Interfaces are generally implemented by multiple classes in production. Any addition of new methods causes disruption on the entire hierarchy chain. JDK 8 has provided a feature to add additional method to the interface without disrupting the chain by creating a concrete method in the interface with ```default``` access modifier on the method. These are called ```default``` methods.
- From JDK 8, Interfaces can implement static and public static methods.
- From JDK 9, Interfaces can implement private methods.
- Any variable declared in interface is always final and static.