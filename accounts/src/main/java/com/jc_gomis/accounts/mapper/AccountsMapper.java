package com.jc_gomis.accounts.mapper;

import com.jc_gomis.accounts.dto.AccountsDto;
import com.jc_gomis.accounts.entities.Accounts;

public class AccountsMapper {

    public  static Accounts toAccounts(AccountsDto accountsDto ) {
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());

        return accounts;
    }

    public static AccountsDto toAccountsDto(Accounts accounts ) {
        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }
}
