package com.pawan.LLD.solidprinciple;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class InterfaceSegregationPrinciple {

    //  traditional method
    public  interface RestaurantEmployee {
        void washDishes();
        void serveFood();
        void cookFood();
    }

    class Waiter implements RestaurantEmployee {

        @Override
        public void washDishes() {
            System.out.println("This is not my job.");
        }

        @Override
        public void serveFood() {
            System.out.println("Serving food the customer.");
        }

        @Override
        public void cookFood() {
            System.out.println("This is not my job.");
        }
    }

    // Interface for washing dishes
    public interface DishWasherInterface {
        void washDishes();
    }

    // Interface for serving food
    public interface WaiterInterface {
        void serveFood();
        void takeOrder();
    }

    // Interface for cooking food
    public interface ChefInterface {
        void cookFood();
        void decideMenu();
    }

    class Waiter1 implements WaiterInterface {

        @Override
        public void serveFood() {
            System.out.println("Serving food the customer.");
        }

        @Override
        public void takeOrder() {
            System.out.println("Taking order from customer.");
        }
    }
}
