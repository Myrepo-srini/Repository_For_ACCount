package com.example.account_service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {



    private static final String BANK_CODE = "101";

    private final AccountRepository accountRepository;
    private final BranchCodeRepo branchCodeRepo;

    public AccountService(AccountRepository accountRepository ,BranchCodeRepo branchCodeRepo){
        this.accountRepository =accountRepository;
        this.branchCodeRepo =branchCodeRepo;

    }

    private String generateNumber(String branchName){


        BranchCode branchCode =
                branchCodeRepo.findByBranchName(branchName).orElseThrow(() ->
                new RuntimeException("Branch not found"));
        int randomNumber =
                1000000 + new Random().nextInt(9000000);

        return BANK_CODE +
                branchCode.getBranchCode() +
                randomNumber;
    }


    public void createAccount(Account account) {

        Long seq = Long.valueOf(generateNumber(account.getBranchName()));
        account.setAccount_number(String.valueOf(seq));

        this.accountRepository.save(account);
    }

    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }
}
