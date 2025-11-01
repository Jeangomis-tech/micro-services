package com.jc_gomis.accounts.controllers;

import com.jc_gomis.accounts.constants.AccountConstants;
import com.jc_gomis.accounts.dto.CustomerDto;
import com.jc_gomis.accounts.dto.ResponseDto;
import com.jc_gomis.accounts.entities.Accounts;
import com.jc_gomis.accounts.services.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api")
@Validated
public class AccountsController {

    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {

        accountService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountsDetails(@RequestParam
                                                                @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
                                                                String mobileNumber) {

        CustomerDto customerDto = accountService.fetchAccount(mobileNumber);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(customerDto);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountService.updateAccount(customerDto);
        if(isUpdated) {
            return  ResponseEntity.status(HttpStatus.OK )
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
                                                         String mobileNumber) {
        boolean isDeleted = accountService.deleteAccount(mobileNumber);
        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        }else{
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }



}
