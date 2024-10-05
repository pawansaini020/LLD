package com.pawan.LLD.solidprinciple;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class DependencyInversionPrinciple {

    interface Keyboard {

    }
    class WiredKeyboard implements Keyboard {

    }
    class BluetoothKeyboard implements Keyboard {

    }

    interface Mouse {

    }
    class WiredMouse implements Mouse {

    }
    class BluetoothMouse implements Mouse {

    }
//  traditional method
    class MacBook {

        private final WiredKeyboard keyboard;
        private final WiredMouse mouse;

        public MacBook() {
            this.keyboard = new WiredKeyboard();
            this.mouse = new WiredMouse();
        }
    }

//    Dependency Inversion Principle
    class MacBook1 {

        private final Keyboard keyboard;
        private final Mouse mouse;

        public MacBook1(Keyboard keyboard, Mouse mouse) {
            this.keyboard = keyboard;
            this.mouse = mouse;
        }
    }

    MacBook1 macBook1 = new MacBook1(new WiredKeyboard(), new WiredMouse());
    MacBook1 macBook2 = new MacBook1(new BluetoothKeyboard(), new BluetoothMouse());
}
