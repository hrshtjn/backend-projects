package org.example.enum01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PizzaTest01 {

    private Pizza01 pizza;

    @BeforeEach
    public void setUp() {
        pizza = new Pizza01();
        pizza.setStatus(Pizza01.PizzaStatus.DELIVERED);
    }

    @Test
    public void test_isPizzaDelivered() {
        //assert(pizza.getStatus()==Pizza.PizzaStatus.DELIVERED);
        assertEquals(pizza.getStatus(), Pizza01.PizzaStatus.DELIVERED);
    }

    @Test
    public void test_getDeliveryTimeInDays() {
        assertEquals(pizza.getDeliveryTimeInDays(),0);
    }
}
