package com.generics.designIssues;

public class AorderDTO {

    private final String orderId;

    public String getOrderId() {
        return orderId;
    }

    protected AorderDTO(Init builder) {
        this.orderId = builder.orderId;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }


    //Abstract class
    public static abstract class Init<T extends Init<T>> {
        String orderId;


        public T withOrderId(String orderId) {
            this.orderId = orderId;
            return self();
        }

        protected abstract T self();

        public AorderDTO build() {
            return new AorderDTO(this);
        }

    }

    //Impl class
    public static class OrderBuilder extends Init<OrderBuilder>{

        public AorderDTO build(){
            return new AorderDTO(this);
        }

        @Override
        protected OrderBuilder self() {
            return this;
        }
    }

}
