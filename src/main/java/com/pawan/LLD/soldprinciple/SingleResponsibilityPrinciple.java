package com.pawan.LLD.soldprinciple;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
@Slf4j
public class SingleResponsibilityPrinciple {

    public class Student
    {
        public void printDetails()
        {
            log.info("functionality of the method");
        }
        public void calculatePercentage()
        {
            log.info("functionality of the method");
        }
        public void addStudent()
        {
            log.info("functionality of the method");
        }
    }

    public class Student1
    {
        public void printDetails()
        {
            log.info("functionality of the method");
        }
    }

    public class PrintStudentDetails {
        public void calculatePercentage()
        {
            log.info("functionality of the method");
        }
    }

    public class Percentage {
        public void addStudent()
        {
            log.info("functionality of the method");
        }
    }
}
