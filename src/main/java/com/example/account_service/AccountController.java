package com.example.account_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Account")
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;

    }

    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody Account account){
        accountService.createAccount( account) ;
        return ResponseEntity.status(HttpStatus.CREATED).body("Account is created succesfully");

    }

    @GetMapping("/fetchAllAccounts")
    public ResponseEntity<List<Account>> getAccounts() {

        List<Account> accounts = accountService.getAccounts();

        return ResponseEntity.ok(accounts);
    }
}
