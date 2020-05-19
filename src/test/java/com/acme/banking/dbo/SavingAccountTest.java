package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class SavingAccountTest {
    private Client stubClient;

    @Before
    public void initsut() {
        stubClient = new Client(UUID.randomUUID(), "Test Name");
    }


    @Test
    public void ShouldSavePropertiesWhenCreated() {
        //region given
        UUID stubId = UUID.randomUUID();

        //endregion

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, 1.0d);
        //endregion


        //region then
        assertThat(sut.getId(), allOf(
                equalTo(stubId),
                notNullValue()));
        //end region
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenAddNullId() {
        //region given
        UUID stubId = null;
        //endregion

        //region when
        try {
            new SavingAccount(stubId, stubClient, 1.0d);
            fail();
        }
        //endregion


        //region then
        catch (IllegalArgumentException e) {
        }
        ;
        //end region
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenAddNegativeAmount() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        try {
            new SavingAccount(stubId, stubClient, -1.0d);
            fail();
        }
        //endregion


        //region then
        catch (IllegalArgumentException e) {
        }
        ;
        //end region
    }
}
