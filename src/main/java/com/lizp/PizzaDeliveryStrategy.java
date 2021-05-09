package com.lizp;

/**
 * 策略模式
 */
public enum PizzaDeliveryStrategy {
    /**
     *
     */
    EXPIRES {
        @Override
        void deliver(String pz) {
            System.out.println("Pizza will be delivered in express mode");
        }
    };

    abstract void deliver(String pz);
}
