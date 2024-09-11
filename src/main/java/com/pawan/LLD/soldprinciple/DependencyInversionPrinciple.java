package com.pawan.LLD.soldprinciple;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class DependencyInversionPrinciple {

    public class WindowsMachine
    {
        //functionality
    }

    public class Monitor {

    }
    public class Keyboard {

    }

    public class WindowsMachine1
    {
        public final Keyboard keyboard;
        public final Monitor monitor;

        public WindowsMachine1() {
            this.monitor = new Monitor();  //instance of monitor class
            this.keyboard = new Keyboard(); //instance of keyboard class
        }
    }

    // Dependency Inversion
//    we decouple the WindowsMachine from the keyboard by using the Keyboard interface and this keyword.
    public class WindowsMachine2
    {
        private final Keyboard keyboard;
        private final Monitor monitor;
        public WindowsMachine2(Keyboard keyboard, Monitor monitor)
        {
            this.keyboard = keyboard;
            this.monitor = monitor;
        }
    }
}
