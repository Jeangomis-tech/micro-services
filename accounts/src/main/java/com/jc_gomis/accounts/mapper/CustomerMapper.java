package com.jc_gomis.accounts.mapper;

import com.jc_gomis.accounts.dto.CustomerDto;
import com.jc_gomis.accounts.entities.Customer;

public class CustomerMapper {

    public static CustomerDto mapCustomerToDto(Customer customer, CustomerDto customerDto) {
//        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }
    public static Customer mapDtoToCustomer(CustomerDto customerDto, Customer customer) {
//        Customer customer = new Customer();
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
