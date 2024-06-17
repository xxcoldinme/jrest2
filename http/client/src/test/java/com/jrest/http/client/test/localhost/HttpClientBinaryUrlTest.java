package com.jrest.http.client.test.localhost;

import com.jrest.http.client.BinaryHttpClient;
import com.jrest.http.client.HttpClients;

public class HttpClientBinaryUrlTest {

    public static void main(String[] args) {
        BinaryHttpClient httpClient = HttpClients.createBinaryClient(
                HttpClients.createClient(),
                HttpClientBinaryUrlTest.class.getResourceAsStream("/employee.jrest"));

        httpClient.executeBinary("getEmployee")
                .ifPresent(httpResponse -> {

                    System.out.println(httpResponse.getProtocol());
                    //  HTTP/1.1
                    System.out.println(httpResponse.getHeaders().getFirst(null));
                    // HTTP/1.1 200 OK
                    System.out.println(httpResponse.getCode());
                    //  200 OK

                    System.out.println(httpResponse.getContent().getHyperText());
                    // {"id":567,"firstName":"Piter","lastName":"Harrison","jobInfo":{"company":"Microsoft Corporation","website":"https://www.microsoft.com/","profession":"Developer C#","salary":3500}}
                });
    }
}