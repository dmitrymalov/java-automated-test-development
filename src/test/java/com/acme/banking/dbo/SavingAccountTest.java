package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SavingAccountTest {
    private Client stubClient;

    @Before
    public void initsut() {
        stubClient = new Client(UUID.randomUUID(), "Test Name");
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

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
        exception.expect(IllegalArgumentException.class);
        new SavingAccount(stubId, stubClient, 1.0d);

        //endregion


        //region then

        //end region
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenAddNegativeAmount() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        exception.expect(IllegalArgumentException.class);
        new SavingAccount(stubId, stubClient, -1.0d);

        //endregion


        //region then

        //end region
    }

    @Test
    public void shouldAddAccounttoCientWhenAddAccount() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, 1.0d);


        //endregion


        //region then

        assertEquals(true, stubClient.getAccountIds().contains(stubId));

        //end region
    }


    @Test
    public void shouldNotAddAccounttoCientWhenAddAlreadyExistingAccount() {
        //region given
        UUID stubId = UUID.randomUUID();
        SavingAccount sut = new SavingAccount(stubId, stubClient, 1.0d);
        //endregion

        //region when
        exception.expect(IllegalArgumentException.class);
        SavingAccount sut1 = new SavingAccount(stubId, stubClient, 2.0d);
        //endregion


        //region then
        //end region
    }
}
