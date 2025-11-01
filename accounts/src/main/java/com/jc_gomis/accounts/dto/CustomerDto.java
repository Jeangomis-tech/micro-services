package com.jc_gomis.accounts.dto;

import com.jc_gomis.accounts.entities.Accounts;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 2 ,max = 30, message = "The length of the customer name should be between 2 and 30 character")
   private String name;

    @NotEmpty(message = "Email adress can not be empty or null")
    @Email(message = " Email value shoul be valid ")
   private String email;

    @NotEmpty(message = "Mobile number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
   private String mobileNumber;

   //Pour la combinaison des deux dtos
   private AccountsDto accountsDto;

}
