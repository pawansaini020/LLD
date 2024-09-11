package com.pawan.LLD.oops;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class AccessModifiers {

//    There are four types of Java access modifiers:

//    Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
//    Default: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
//    Protected: The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package.
//    Public: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the package.

//save by A.java
//    package pack;
//        public class A{
//            protected void msg(){System.out.println("Hello");}
//        }
//    //save by B.java
//    package mypack;
//    import pack.*;
//
//    class B extends A{
//        public static void main(String args[]){
//            B obj = new B();
//            obj.msg();
//        }
//    }

//    in Private, Default - Compiler error
//    Protected and Public is successfully done
}
