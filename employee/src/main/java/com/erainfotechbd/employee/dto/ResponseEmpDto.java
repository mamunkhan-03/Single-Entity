package com.erainfotechbd.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmpDto {

    private int responseCode;
    private String responseMessage;

}
