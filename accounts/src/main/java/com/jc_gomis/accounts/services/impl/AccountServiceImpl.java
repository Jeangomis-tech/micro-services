package com.jc_gomis.accounts.services.impl;

import com.jc_gomis.accounts.constants.AccountConstants;
import com.jc_gomis.accounts.dto.AccountsDto;
import com.jc_gomis.accounts.dto.CustomerDto;
import com.jc_gomis.accounts.entities.Accounts;
import com.jc_gomis.accounts.entities.Customer;
import com.jc_gomis.accounts.exception.CustomerAlreadyExistException;
import com.jc_gomis.accounts.exception.ResourceNotFoundException;
import com.jc_gomis.accounts.mapper.AccountsMapper;
import com.jc_gomis.accounts.mapper.CustomerMapper;
import com.jc_gomis.accounts.repositories.AccountsRepository;
import com.jc_gomis.accounts.repositories.CustomerRepository;
import com.jc_gomis.accounts.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountsRepository accountsRepository;
    @Autowired
    CustomerRepository customerRepository;

    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
       Customer customer = CustomerMapper.mapDtoToCustomer(customerDto);
        Optional<Customer> optinalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optinalCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer already exist with given number"+customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccounts(savedCustomer));

    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()
                ->  new ResourceNotFoundException("customer", "with mobileNumber", mobileNumber + "Not found!")
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()
                -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapCustomerToDto(customer);
        customerDto.setAccountsDto(AccountsMapper.toAccountsDto(accounts));
        return customerDto;
    }


    private  Accounts createNewAccounts(Customer  customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber= 10000000000L+ new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;

    }

}
