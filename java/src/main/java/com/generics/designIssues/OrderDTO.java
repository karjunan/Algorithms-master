package com.generics.designIssues;

public class OrderDTO {

    private final String orderId;

    public String getOrderId() {
        return orderId;
    }

    protected OrderDTO(OrderBuilder<?> builder) {
        this.orderId = builder.orderId;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }


    public static class OrderBuilder<T extends OrderBuilder<T>> {
        String orderId;

        public T withOrderId(String orderId) {
            this.orderId = orderId;
            return (T)this;
        }

        public OrderDTO build(){
            return new OrderDTO((T)this);
        }
    }

}
