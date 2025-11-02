package com.jc_gomis.accounts.dto;

import com.jc_gomis.accounts.entities.Accounts;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Custommer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "Jean Gomis"
    )
    @NotEmpty(message = "Name can not be empty")
    @Size(min = 2 ,max = 30, message = "The length of the customer name should be between 2 and 30 character")
   private String name;

    @Schema(
            description = "Email of the customer", example = "jean.gomis@gmail.com"
    )
    @NotEmpty(message = "Email adress can not be empty or null")
    @Email(message = " Email value shoul be valid ")
   private String email;

    @Schema(
            description = "Mobile number of the customer", example = "06 00 00 00 00"
    )
    @NotEmpty(message = "Mobile number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
   private String mobileNumber;

    @Schema(
            description = "Bank account"
    )
   //Pour la combinaison des deux dtos
   private AccountsDto accountsDto;

}
