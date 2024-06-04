package banking_application.service;

import banking_application.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id , double amount);
    AccountDto withdraw(Long id ,double amount);
}
