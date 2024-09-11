package com.pawan.LLD.oops;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class Polymorphism {

//    In programming language theory and type theory, polymorphism is the use of a single symbol to represent multiple different types.

//    Runtime polymorphism
    class A{}
    class B extends A{}
    A a=new B();//upcasting

//    Method Overloading:

    class Adder{
        static int add(int a,int b){return a+b;}
        static int add(int a,int b,int c){return a+b+c;}
    }
}
