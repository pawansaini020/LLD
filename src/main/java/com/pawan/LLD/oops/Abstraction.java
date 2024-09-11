package com.pawan.LLD.oops;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pawan Saini
 * Created on 10/09/24.
 */
@Slf4j
public class Abstraction {

//    Abstraction is a process of hiding the implementation details and showing only functionality to the user.
//    Another way, it shows only essential things to the user and hides the internal details, for example, sending SMS where you type the text and send the message.
//    You don't know the internal processing about the message delivery.

//    There are two ways to achieve abstraction in java:
//    1.  Abstract class (0 to 100%)

    public abstract class Bike {
        public abstract void getModel();
    }

    class Honda4 extends Bike {

        @Override
        public void getModel() {
            log.info("My model is Honda4");
        }
    }

    //    2.  Interface (100%)
    public interface Bank {
        float rateOfInterest();
    }

    public class SBI implements Bank {
        public float rateOfInterest() {
            return 9.15f;
        }
    }

    public class PNB implements Bank {
        public float rateOfInterest() {
            return 9.7f;
        }
    }

    //    Multiple inheritance in Java by interface
    public interface Printable {
        void print();
    }

    public interface Showable {
        void show();
    }

    class A7 implements Printable, Showable {
        public void print() {
            System.out.println("Hello A7");
        }

        public void show() {
            System.out.println("Welcome");
        }
    }

    //    Multiple inheritance is not supported through class in java, but it is possible by an interface, why?
//    As we have explained in the inheritance chapter, multiple inheritance is not supported in the case of class because of ambiguity.
//    However, it is supported in case of an interface because there is no ambiguity. It is because its implementation is provided by the implementation class.
    interface Printable1 {
        void print();
    }

    interface Showable1 {
        void print();
    }

    class TestInterface4 implements Printable1, Showable1 {
        public void print() {
            System.out.println("Hello");
        }
    }

    //    Interface inheritance (extends)
    public interface Printable2 {
        void print();
    }

    public interface Showable2 extends Printable2 {
        void show();
    }

    class TestInterface3 implements Showable {
        public void print() {
            System.out.println("Hello");
        }

        public void show() {
            System.out.println("Welcome");
        }
    }
}
