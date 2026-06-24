package com.example.account_service;

import org.springframework.stereotype.Service;

import java.util.Date;
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
        System.out.println("generateNumber Hit");

        BranchCode branchCode =
                branchCodeRepo.findByBranchName(branchName).orElseThrow(() ->
                new RuntimeException("Branch not found"));
        int randomNumber =
                1000000 + new Random().nextInt(9000000);
        System.out.println("generateNumber Hit last line");
        return BANK_CODE +
                branchCode.getBranchCode() +
                String.valueOf(randomNumber);
    }


    public void createAccount(Account account) {
        System.out.println(" service  Hit--------------------");
        Long seq = Long.valueOf(generateNumber(account.getBranchName()));
        account.setAccount_number(String.valueOf(seq));
        account.setCreatedDate(new Date());
        account.setUpdateddate(new Date());
        System.out.println("account id going to save Hit id is ");
        this.accountRepository.save(account);
        System.out.println("account  saved Hit");
    }

    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }
}
