package com.pawan.LLD.soldprinciple;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class InterfaceSegregationPrinciple {


    public interface Conversion {
        void intToDouble();
        void intToChar();
        void charToString();
    }


//  Segregation
    public interface ConvertIntToDouble {
        void intToDouble();
    }

    public interface ConvertIntToChar {
        void intToChar();
    }

    public interface ConvertCharToString {
        void charToString();
    }

    public class DataTypeConversion implements ConvertIntToDouble, ConvertCharToString
    {
        public void intToDouble()
        {
            //conversion logic
        }
        public void charToString()
        {
            //conversion logic
        }
    }
}
