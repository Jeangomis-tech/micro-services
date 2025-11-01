package com.jc_gomis.accounts.services;

import com.jc_gomis.accounts.dto.CustomerDto;
import com.jc_gomis.accounts.entities.Customer;

import java.util.Optional;

public interface AccountService {
   /*
    * @param customerDto-CustomerDto Object
    */
    void createAccount( CustomerDto customerDto );

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
