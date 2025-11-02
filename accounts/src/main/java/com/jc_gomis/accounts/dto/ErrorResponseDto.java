package com.jc_gomis.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Schema(
        name = "ErrorResponse",
        description = "Error handler for request and response"
)
@AllArgsConstructor
public class ErrorResponseDto {
    @Schema(
            description = " Api path  invoked by client"
    )
    private String apiPath;
    @Schema(
            description = "Schema to hold error code ", example = "500"
    )
    private HttpStatus errorCode;
    @Schema(
            description = " Schema to hold error message" ,example = "INTERNAL SERVER ERROR"
    )
    private String errorMessage;
    @Schema(
            description = "Schema to hold time error  "
    )
    private LocalDateTime errorTime;
}
