package com.jc_gomis.accounts.dto;

import com.jc_gomis.accounts.entities.Accounts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
   private String name;
   private String email;
   private String mobileNumber;
   //Pour la combinaison des deux dtos
   private AccountsDto accountsDto;

}
