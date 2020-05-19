package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ClientTest {
    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client sut = new Client(stubId, "dummy client name");
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        //endregion
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenAddNullId() {
        //region given
        UUID stubId = null;
        //endregion

        //region when

        try {
            Client sut = new Client(stubId, "dummy client name");
            fail();
        }
        //endregion
        //region then
        catch (IllegalArgumentException e) {
        }
        ;
        //endregion
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenAddEmptyName() {
        //region given
        UUID stubId = UUID.randomUUID();
        String EmptyName = "";
        //endregion

        //region when

        try {
            Client sut = new Client(stubId, EmptyName);
            fail();
        }
        //endregion
        //region then
        catch (IllegalArgumentException e) {
        }
        ;
        //endregion
    }
}
