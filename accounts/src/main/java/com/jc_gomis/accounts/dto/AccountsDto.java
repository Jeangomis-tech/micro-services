package com.jc_gomis.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
    @NotEmpty(message = "Mobile number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = " Account Type can not be null or empty")
    private String accountType ;

    @NotEmpty(message = " Branch Adress can not be null or empty")
    private String branchAddress;
}
