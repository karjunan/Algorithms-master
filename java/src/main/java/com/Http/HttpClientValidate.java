//package com.Http;
//
//import jdk.incubator.http.HttpClient;
//import jdk.incubator.http.HttpRequest;
//import jdk.incubator.http.HttpResponse;
//
//import java.io.IOException;
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class HttpClientValidate {
//
//    static System.Logger logger = System.getLogger("HttpClientValidate.class");
//    public static void main(String[] args) throws IOException, InterruptedException {
//
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        HttpClient client = HttpClient.newBuilder()
//                .version(HttpClient.Version.HTTP_1_1)
//                .build();
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create("https://www.spiproject.com"))
//                .build();
//        CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture = client
//                .sendAsync(request, HttpResponse.BodyHandler.asString());
//        httpResponseCompletableFuture.thenAcceptAsync(response -> {
//            System.out.println(response.body() + "["+Thread.currentThread().getName()+"]");
//        },executor)
//        .join();
//        executor.shutdown();
////        System.out.println("Thread Name ::" + Thread.currentThread().getName());
//
//
//
//    }
//}
