package com.jc_gomis.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(
        name = "Response",
        description = "Schema to hold successfully response information"
)
@AllArgsConstructor
public class ResponseDto {
@Schema(
        description = "Status code in the response ", example = "200"
)
    private String statusCode;
@Schema(
        description = "Message in the response ", example = "Customer not found"
)
    private String message;
}
