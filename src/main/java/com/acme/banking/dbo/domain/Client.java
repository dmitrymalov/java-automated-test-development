package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;


    private Collection<UUID> accountIds = new ArrayList<>(); //TODO

    public Client(UUID id, String name) {
        if (id == null) throw new IllegalArgumentException();
        if ((name == null) || (name == "")) throw new IllegalArgumentException();

        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<UUID> getAccountIds() {
        return accountIds;
    }


    public void addAccount(SavingAccount savingAccount) {
        if (!savingAccount.getClient().getAccountIds().contains(savingAccount.getId()))
            accountIds.add(savingAccount.getId());
        else throw new IllegalArgumentException("This account already exists");

    }
}
