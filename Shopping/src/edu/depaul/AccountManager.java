package edu.depaul;

import java.util.HashMap;
import java.util.Map;

class AccountManager {
    private static Map<String, Account> accountMap = new HashMap<>();

    public static void addAccount(String accountName, Account account) {
        accountMap.put(accountName, account);
    }

    public static Account getAccount(String accountName) {
        return accountMap.get(accountName);
    }

    public static void removeAccount(String accountName) {
        accountMap.remove(accountName);
    }
}