package org.example.enum01;

public class Pizza01 {
    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }


    private PizzaStatus status;

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }


    public boolean isDelivered() {
        return getStatus() == PizzaStatus.DELIVERED;
    }

    public int getDeliveryTimeInDays() {
        switch (status) {
            case ORDERED: return 5;
            case READY: return 2;
            case DELIVERED: return 0;
        }
        return 0;
    }
}
