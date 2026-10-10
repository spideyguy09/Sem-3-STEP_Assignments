# Week 10 - Practice Problems

## Part B — Quiz Answers

1. **D. s1 == s2 is false, and s1.equals(s2) is true.**
   - `new String("hello")` creates two distinct objects in the heap memory. So their references are different (`s1 == s2` is false), but their content is the same (`s1.equals(s2)` is true).

2. **B. "baL avaJ"**
   - The StringBuilder appends "Java" and " Lab" to become "Java Lab". After calling `.reverse()`, it becomes "baL avaJ".

3. **B. public Student(String name)**
   - The expression `new Student("Ravi")` calls the constructor that accepts a single `String` parameter.

4. **D. w1 balance: 700, w2 balance: 700**
   - Both `w1` and `w2` reference the same `Wallet` object in memory. Updating the balance using `w2` affects the object that `w1` also points to.

5. **C. 3**
   - `count` is a static variable, meaning it is shared across all instances of the `Visitor` class. Creating 3 objects increments it 3 times.

6. **A. 45 78 92 60 85**
   - The standard `for` loop from `0` to `scores.length - 1` iterates over and prints each element of the array in order.

7. **B. 1 2 4 5**
   - When `i == 3`, the `continue` statement skips the print statement for that iteration and moves to the next iteration.

8. **A. 5**
   - Java uses pass-by-value. For primitive types like `int`, a copy of the value is passed to the method. The original variable `x` remains unchanged when `n` is modified inside `change()`.

9. **C. 83.33333333333333**
   - Since `count` is a `double` (3.0), the operation `total / count` becomes a floating-point division (250.0 / 3.0), resulting in `83.33333333333333`.

10. **B. Paid 510.0 by card**
    - The `amount` is 500, the `fee` is `500 * 0.02 = 10.0`. The total output prints `500 + 10.0 = 510.0`.

11. **B. The name object's value remains "java", and a new String object "JAVA" is created for upperName.**
    - Strings are immutable in Java. Calling methods like `toUpperCase()` creates and returns a new String object rather than modifying the original one.

12. **B. 2**
    - "hello" is created in the String pool (1 object). `s1` and `s2` point to it. `new String("hello")` creates a new object in the heap (the 2nd object).

13. **A. 6 / m**
    - The length of "Campus" is 6. `charAt(2)` returns the character at index 2 (0-indexed), which is 'm'.

14. **A. 4**
    - The character '@' is located at index 4 in "user@domain.com" (u:0, s:1, e:2, r:3, @:4).

15. **B. Title: Unknown, Price: 0.0**
    - The default constructor sets `title` to "Unknown" and `price` to 0.0.

16. **A. Title: Java Programming, Price: 450.0**
    - The parameterized constructor sets the `title` and `price` to the provided arguments.

17. **B. 2**
    - `w1` creates one object. `w2` points to the same object. `w3` creates a second object. Therefore, there are 2 objects in memory.

18. **C. w1 balance: 700 / w2 balance: 700**
    - `w1` and `w2` refer to the same object. Calling `add(200)` via `w2` updates the balance of the shared object.

19. **C. s1 name: Anu / s2 name: Ravi**
    - Changing the name of `s1` affects the object `s1` points to. `s2` remains unchanged.

20. **C. Total visitors: 3**
    - `visitorCount` is a static variable shared by all instances. Each time the constructor is called (3 times), it increments the count.

## Part C — Concept Questions Answers

**Question 1**
String immutability means that once a String object is created, its value cannot be changed. Any modification (like concatenation or substring) creates a new String object. This can lead to performance issues and high memory consumption when a String undergoes repeated modifications, as many intermediate objects are created and discarded. This performance impact can be mitigated by using mutable string classes like `StringBuilder` or `StringBuffer`, which modify the character sequence in place without creating new objects.

**Question 2**
When an instance variable and a constructor parameter share the same name, the parameter shadows the instance variable. The `this` keyword is used to explicitly refer to the instance variable of the current object, resolving the ambiguity.
Example:
```java
class Person {
    String name;
    public Person(String name) {
        this.name = name; // 'this.name' refers to instance variable, 'name' is the parameter
    }
}
```

**Question 3**
An object is an instance of a class that resides in heap memory and holds state and behavior. A reference variable is a pointer that holds the memory address of an object. When one reference variable is assigned to another (e.g., `ref2 = ref1`), both variables point to the exact same object in memory. Any modifications made to the object through `ref2` will be visible when accessed through `ref1`.

**Question 4**
Static variables belong to the class rather than any specific instance and are shared among all instances. Instance variables belong to specific objects and each object has its own copy. A static member would be preferred for a global property shared by all instances, like a `totalInstancesCount` or a constant like `Math.PI`. An instance member is suitable for attributes unique to each object, such as a `studentName` or `balance` in a bank account.

**Question 5**
- **for loop**: Used when the number of iterations is known in advance (e.g., iterating through an array or a fixed range).
- **while loop**: Used when the number of iterations is unknown and depends on a condition being true before each iteration (e.g., reading user input until they type 'quit').
- **do-while loop**: Similar to `while`, but the condition is checked after the loop body. Used when the code must execute at least once regardless of the condition (e.g., displaying a menu to a user at least one time before checking if they want to exit).

**Question 6**
Java is strictly pass-by-value. When a method receives a primitive data type, a copy of the primitive value is passed; modifying it inside the method does not affect the original variable. When a method receives an object reference, a copy of the reference is passed. While you cannot reassign the original reference to a new object, you can modify the internal state (mutating) of the object it points to, and these changes will be reflected outside the method.

**Question 7**
Integer division in Java truncates any fractional part and returns only the integer quotient (e.g., `5 / 2` yields `2`). To obtain a precise floating-point result, at least one of the operands must be a floating-point type. An explicit type cast (e.g., `(double) 5 / 2`) temporarily treats the integer as a floating-point number, forcing the operation to be performed as floating-point division, thus yielding `2.5`.

**Question 8**
Encapsulation is the bundling of data (variables) and methods that operate on the data into a single unit (class), while restricting direct access to some of the object's components. By making instance variables `private`, they cannot be accessed directly from outside the class. Instead, public getter and setter methods are provided, which allows the class to enforce validation rules, ensure data integrity, and control how its state is modified.

**Question 9**
The `==` operator checks for reference equality (whether two reference variables point to the exact same object in memory). The `equals()` method, by default, also checks for reference equality, but it is intended to be overridden by classes to check for logical equivalence (whether two different objects have the same state or value). For example, `String` overrides `equals()` to compare the characters inside the strings rather than their memory addresses.

**Question 10**
- **Method Overloading**: Defining multiple methods in the same class with the same name but different parameter lists. It is resolved at compile-time (static polymorphism). Example: `void print(int x)` and `void print(String s)`.
- **Method Overriding**: When a subclass provides a specific implementation for a method that is already defined in its superclass, with the exact same signature. It is resolved at run-time (dynamic polymorphism). Example: A `Dog` class overriding the `makeSound()` method of its `Animal` superclass.
