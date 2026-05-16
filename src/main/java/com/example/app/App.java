package com.example.app;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static class Order {
        private String orderId = UUID.randomUUID().toString().substring(0, 8);
        private double orderTotal;
        private String shippingCountry;
        private int itemQuantity;

        public Order(double orderTotal, String shippingCountry, int itemQuantity) {
            this.orderTotal = orderTotal;
            this.shippingCountry = shippingCountry;
            this.itemQuantity = itemQuantity;
        }
        public String getOrderId() { return orderId; }
        public double getOrderTotal() { return orderTotal; }
        public String getShippingCountry() { return shippingCountry; }
        public int getItemQuantity() { return itemQuantity; }
    }

    public boolean processOrder(Order order) {
        logger.info("Processing Order ID: #{}", order.getOrderId());
        if (order.getOrderTotal() > 5000.0 || order.getItemQuantity() > 50 || "SanctionedRegion".equalsIgnoreCase(order.getShippingCountry())) {
            logger.warn("ALERT [FRAUD/RISK]: Order #{} rejected.", order.getOrderId());
            return false;
        }
        logger.info("SUCCESS: Order #{} passed security rules.", order.getOrderId());
        return true;
    }

    public static void main(String[] args) {
        App engine = new App();
        engine.processOrder(new Order(250.00, "IN", 3));
        engine.processOrder(new Order(9999.00, "US", 1));
    }
}
