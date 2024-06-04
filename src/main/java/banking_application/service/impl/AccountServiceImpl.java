package banking_application.service.impl;

import banking_application.dto.AccountDto;
import banking_application.entity.Account;
import banking_application.mapper.AccountMapper;
import banking_application.repository.AccountRepository;
import banking_application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
       Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account account = accountRepository
               .findById(id)
               .orElseThrow(() -> new RuntimeException("Account dose not exist"));
        return AccountMapper.mapToAccountDto(account);
    }
}
