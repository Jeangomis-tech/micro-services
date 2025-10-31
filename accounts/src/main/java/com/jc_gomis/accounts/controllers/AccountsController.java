package com.jc_gomis.accounts.controllers;

import com.jc_gomis.accounts.constants.AccountConstants;
import com.jc_gomis.accounts.dto.CustomerDto;
import com.jc_gomis.accounts.dto.ResponseDto;
import com.jc_gomis.accounts.entities.Accounts;
import com.jc_gomis.accounts.services.AccountService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api")
public class AccountsController {

    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

        accountService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountsDetails(@RequestParam String mobileNumber) {

        CustomerDto customerDto = accountService.fetchAccount(mobileNumber);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(customerDto);
    }


}
