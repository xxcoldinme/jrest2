package com.jrest.test.http.server;

import com.jrest.http.server.HttpServer;
import com.jrest.test.http.server.type.HttpServerRepository;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpServerRepositoryStartTest {

    public static void main(String[] args) {
        HttpServer httpServer = HttpServer.builder()
                .socketAddress(new InetSocketAddress(8080))
                .executorService(Executors.newCachedThreadPool())
                .build();

        httpServer.registerRepository(new HttpServerRepository());
        httpServer.bind();

        System.out.println("HTTP Server started on port 8080");
    }
}
