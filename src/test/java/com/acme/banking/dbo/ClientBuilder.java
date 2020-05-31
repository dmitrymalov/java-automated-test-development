package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;

import java.util.UUID;

public class ClientBuilder {


    //  when(new ClientBuilder().withName(anyString())).    thenReturn( new Client());

    public Client withName(String name) {
        UUID id = UUID.randomUUID();
        return new Client(id, name);
    }


}
