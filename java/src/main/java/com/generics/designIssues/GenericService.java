package com.generics.designIssues;

public class GenericService {

    private static GuestOrderDTO guestOrderDTO;
    private static OrderDTO orderDTO;
    private static GuestOrderDTO guest;
    private static OrderDTO.OrderBuilder build;

    public static void main(String[] args) {
//        guestOrderDTO = GuestOrderDTO.builder().withOrderId("123").withId("123").withName("123").build();

        AorderDTO aorderDTO = AorderDTO.builder().withOrderId("1").build();
//        GuestAOrderDTO guestAOrderDTO = GuestAOrderDTO.builder().withOrderId("123").build();

        GuestAOrderDTO guestAOrderDTO = GuestAOrderDTO.guestBuilder().withName("Krishna").withOrderId("Hellow").withId("123").build();
        aorderDTO = GuestAOrderDTO.guestBuilder().withName("Krishna").withOrderId("Hellow").withId("123").build();
    }
}
