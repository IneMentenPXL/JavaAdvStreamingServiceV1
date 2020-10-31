package be.pxl.ja.streamingservice.repository;

import be.pxl.ja.streamingservice.model.Account;

import java.util.HashMap;

public class AccountRepository {
    private HashMap<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getEmail(), account);
    }

    public Account findAccount(String email) {
        return accounts.get(email);
    }
}
