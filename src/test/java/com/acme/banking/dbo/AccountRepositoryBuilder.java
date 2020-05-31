package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class AccountRepositoryBuilder {


    public AccountRepositoryBuilder withAccount(UUID accountid, Client client, double amount) {
        Collection<SavingAccount> accounts = new ArrayList<>();
        accounts.add(new SavingAccount(accountid, client, amount));
        return this;
    }

    public AccountRepositoryBuilder withAccount(Client client, double amount) {
        withAccount(UUID.randomUUID(), client, amount);
        return this;
    }
}
