package com.northface_clone.orderservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponseDTO {
    private Integer businessErrorCode;
    private String businessErrorDescription;
    private String error;
    private Map<String, String> validationErrors;
    private Map<String, String> errors;
}
