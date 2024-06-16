package com.jrest.http.server.test.server.type;

import com.jrest.http.server.test.employee.Employee;
import com.jrest.http.server.test.employee.EmployeeJob;
import com.jrest.mvc.model.*;
import com.jrest.mvc.persistence.*;

import java.util.Optional;

@HttpServer
public class HttpServerRepository {

    @HttpBeforeExecution
    public void before(HttpRequest httpRequest) {
        Headers headers = httpRequest.getHeaders()
                .set(Headers.Def.CONTENT_TYPE, ContentType.APPLICATION_JSON)
                .set(Headers.Def.USER_AGENT, "Mikhail Sterkhov");

        httpRequest.setHeaders(headers);
    }

    @HttpGet("/employee")
    public HttpResponse doGet(HttpRequest request) {
        Attributes attributes = request.getAttributes();
        Optional<Integer> attributeIdOptional = attributes.getInteger("id");

        if (!attributeIdOptional.isPresent()) {
            return HttpResponse.badRequest();
        }
        return HttpResponse.ok(Content.fromEntity(
                Employee.builder()
                        .id(attributeIdOptional.get())
                        .jobInfo(EmployeeJob.builder()
                                .company("Microsoft Corporation")
                                .website("https://www.microsoft.com/")
                                .profession("Developer C#")
                                .salary(3500)
                                .build())
                        .firstName("Piter")
                        .lastName("Harrison")
                        .build()));
    }
}
