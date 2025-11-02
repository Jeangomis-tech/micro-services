package com.jc_gomis.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Schema(
            description = "Schema to hold  Account number", example = "0104051245"
    )
    @NotEmpty(message = "Mobile number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Diagram for defining the account type", example = "Current"
    )
    @NotEmpty(message = " Account Type can not be null or empty")
    private String accountType ;
    @Schema(
            description = "Schema to hold  Branch address", example = "13 Rue Babeuf , Paris, FR"
    )
    @NotEmpty(message = " Branch Adress can not be null or empty")
    private String branchAddress;
}
