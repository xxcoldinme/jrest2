package com.jrest.test.http.server.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Employee {

    private final int id;

    private final String firstName;
    private final String lastName;

    private final EmployeeJob jobInfo;
}
