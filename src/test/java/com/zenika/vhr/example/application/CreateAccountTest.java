package com.zenika.vhr.example.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountTest {
    private final CreateAccount createAccount = new CreateAccount();
    @Test
    public void create_Account() throws Exception {

        assertThat(createAccount.create("test")).isEqualTo("test");
    }


}
