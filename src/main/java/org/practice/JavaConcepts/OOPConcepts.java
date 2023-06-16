package org.practice.JavaConcepts;

public class OOPConcepts {
    /**
     * Object-Oriented Design Goals: robustness, adaptability, and reusability.
     * Robustness:
         * program produces the right output for all the anticipated inputs in the program’s
         * application. In addition, we want software to be robust, that is, capable of handling
         * unexpected inputs that are not explicitly defined for its application
     * Adaptability:
         * Related to this concept is portability, which is the ability of software to run with minimal change on
         * different hardware and operating system platforms. An advantage of writing software in Java is the portability
         * provided by the language itself.
     * Reusability:
         * same code should be usable as a component of different systems in various
         * applications

     * Object-Oriented Design Principles: Abstraction, Encapsulation, Modularity
     * Abstraction:
         * The notion of abstraction is to distill a complicated system down to its most fundamental
         * parts. In Java, an ADT can be expressed by an interface, which is simply a list of method declarations
     * Encapsulation:
         * different components of a software system should not reveal the internal details of their
         * respective implementations. One of the main advantages of encapsulation is that it
         * gives one programmer freedom to implement the details of a component
         *The only constraint on the programmer of a component
         * is to maintain the public interface for the component, as other programmers will
         * be writing code that depends on that interface.
     * Modularity:
         * Modularity refers to an organizing principle in which different components
         * of a software system are divided into separate functional units. Robustness is
         * greatly increased because it is easier to test and debug separate components before
         * they are integrated into a larger software system
     */
    /**
     * Liskov Substitution Principle,
     * which states that a variable (or parameter) with a declared type can be assigned
     * an instance from any direct or indirect subclass of that type.
     */

    /**
     * design patterns we discuss include the following:
     * • Recursion (Chapter 5)
     * • Amortization (Sections 7.2.3, 11.4.4, and 14.7.3)
     * • Divide-and-conquer (Section 12.1.1)
     * • Prune-and-search, also known as decrease-and-conquer (Section 12.5.1)
     * • Brute force (Section 13.2.1)
     * • The greedy method (Sections 13.4.2, 14.6.2, and 14.7)
     * • Dynamic programming (Section 13.5)
     * Likewise, some of the software engineering design patterns we discuss include:
     * • Template method (Sections 2.3.3, 10.5.1, and 11.2.1)
     * • Composition (Sections 2.5.2, 2.6, and 9.2.1)
     * • Adapter (Section 6.1.3)
     * • Position (Sections 7.3, 8.1.2, and 14.7.3)
     * • Iterator (Section 7.4)
     * • Factory Method (Sections 8.3.1 and 11.2.1)
     * • Comparator (Sections 9.2.2, 10.3, and Chapter 12)
     * • Locator (Section 9.5.1)
     */

    /**
     * The ability of extending from more than one type is known as multiple inheritance.
     * In Java, multiple inheritance is allowed for interfaces but not for classes. The reason
     * for this rule is that interfaces do not define fields or method bodies, yet classes
     * typically do. Thus, if Java were to allow multiple inheritance for classes, there
     * could be a confusion if a class tried to extend from two classes that contained fields
     * with the same name or methods with the same signatures. Since there is no such
     * confusion for interfaces, and there are times when multiple inheritance of interfaces
     * is useful, Java allows interfaces to use multiple inheritance.
     */

    /**
     * The Throwable hierarchy is divided into two subclasses: Error and Exception.
     * Errors are typically thrown only by the Java Virtual Machine and designate the most serious situations that are
     * unlikely to be recoverable, such as when the virtual machine is asked to execute
     * a corrupt class file, or when the system runs out of memory. In contrast, exceptions
     * designate situations in which a running program might reasonably be able to
     * recover, for example, when unable to open a data file.
     */
}
