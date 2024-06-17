package com.jrest.http.client.test.https;

import com.jrest.http.client.BinaryHttpClient;
import com.jrest.http.client.HttpClient;
import com.jrest.http.client.HttpClients;

public class HttpClientBinaryUrlTest {

    public static void main(String[] args) {
        BinaryHttpClient httpClient = HttpClients.createBinaryClient(
                HttpClients.createClient(),
                HttpClientBinaryUrlTest.class.getResourceAsStream("/catfacts.jrest"));

        httpClient.executeBinary("getFact")
                .ifPresent(httpResponse -> {

                    System.out.println(httpResponse.getProtocol());
                    System.out.println(httpResponse.getHeaders().getFirst(null));
                    //  HTTP/1.1 200 OK
                    System.out.println(httpResponse.getCode());
                    //  200 OK

                    System.out.println(httpResponse.getContent().getHyperText());
                    // {"fact":"A cat usually has about 12 whiskers on each side of its face.","length":61}
                });
    }
}