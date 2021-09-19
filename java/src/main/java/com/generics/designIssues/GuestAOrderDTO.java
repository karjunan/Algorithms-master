package com.generics.designIssues;

public class GuestAOrderDTO extends AorderDTO {

    private final String id;

    private final String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected GuestAOrderDTO(InitGuestBuilder<?> builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
    }

    public static GuestOrderBuilder guestBuilder() {
        return new GuestOrderBuilder();
    }

    //Abstract class
    public static abstract class InitGuestBuilder<T extends InitGuestBuilder<T>> extends AorderDTO.Init<T> {

        private String id;
        private String name;

        public T withId(String id) {
            this.id = id;
            return self();
        }

        public T withName(String name) {
            this.name = name;
            return self();
        }
        public GuestAOrderDTO build() {
            return new GuestAOrderDTO(this);
        }

    }

    public static class GuestOrderBuilder extends InitGuestBuilder<GuestOrderBuilder> {

        public GuestAOrderDTO build(){
            return new GuestAOrderDTO(this);
        }

        @Override
        protected GuestOrderBuilder self() {
            return this;
        }
    }
}
