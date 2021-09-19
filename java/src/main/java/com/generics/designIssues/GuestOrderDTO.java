package com.generics.designIssues;

public class GuestOrderDTO extends  OrderDTO {

    private final String id;

    private final String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected GuestOrderDTO(GuestOrderBuilder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
    }

    public static GuestOrderBuilder<? extends OrderDTO.OrderBuilder> builder() {
        return new GuestOrderBuilder();
    }


    public static class GuestOrderBuilder<T extends GuestOrderBuilder<T>> extends OrderBuilder<T> {
        private String id;
        private String name;


        public T withId(String id) {
            this.id = id;
            return (T)this;
        }

        public T withName(String name) {
            this.name = name;
            return (T)this;
        }

        public GuestOrderDTO build() {
            return new GuestOrderDTO((T)this);
        }
    }
}
