package com.example.app;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testStandardOrderSuccess() {
        App engine = new App();
        assertTrue(engine.processOrder(new App.Order(150.00, "IN", 2)));
    }
    @Test
    public void testHighValueFraudBlock() {
        App engine = new App();
        assertFalse(engine.processOrder(new App.Order(6500.00, "US", 1)));
    }
}
