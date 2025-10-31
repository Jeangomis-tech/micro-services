package com.jc_gomis.accounts.mapper;

import com.jc_gomis.accounts.dto.AccountsDto;
import com.jc_gomis.accounts.entities.Accounts;

public class AccountsMapper {

    /**
     * Méthode pour mettre à jour une entité existante à partir d'un DTO
     * @param accountsDto le DTO source contenant les nouvelles valeurs
     * @param accounts l'entité cible à mettre à jour
     */

    public static Accounts mapDtoToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }

    public static AccountsDto toAccountsDto(Accounts accounts, AccountsDto accountsDto) {
//        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

//    /**
//     * Méthode pour mettre à jour une entité existante à partir d'un DTO
//     * @param accountsDto le DTO source contenant les nouvelles valeurs
//     * @param accounts l'entité cible à mettre à jour
//     */
//    public static void mapDtoToAccounts(AccountsDto accountsDto, Accounts accounts) {
//        accounts.setAccountType(accountsDto.getAccountType());
//        accounts.setBranchAddress(accountsDto.getBranchAddress());
//        // Note: on ne met généralement PAS à jour l'accountNumber car c'est l'ID
//    }
}