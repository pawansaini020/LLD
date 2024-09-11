package com.pawan.LLD.oops;

/**
 * @author Pawan Saini
 * Created on 10/09/24.
 */
public class Encapsulation {

//    Encapsulation in Java is a process of wrapping code and data together into a single unit

    public class Student{
        //private data member
        private String name;

        //getter method for name
        public String getName(){
            return name;
        }

        //setter method for name
        public void setName(String name){
            this.name=name;
        }
    }

    public class StudentReadOnly{
        //private data member
        private String name;

        //getter method for name
        public String getName(){
            return name;
        }
    }

    public class StudentWriteOnly{
        //private data member
        private String name;

        //setter method for name
        public void setName(String name){
            this.name=name;
        }
    }
}
