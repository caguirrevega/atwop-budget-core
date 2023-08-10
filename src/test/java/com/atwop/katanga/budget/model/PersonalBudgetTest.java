package com.atwop.katanga.budget.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonalBudgetTest {

    @Test
    void givenAmountWhenAmountIsNullThenIsFalse() {
        PersonalBudget personalBudget = new PersonalBudget(null, null, null);

        assertThat(personalBudget.validate()).isEqualTo("amount is invalid");
    }

    @Test
    void givenAmountWhenAmountIsZeroThenIsFalse() {
        PersonalBudget personalBudget = new PersonalBudget(0F, null, null);

        assertThat(personalBudget.validate()).isEqualTo("amount is invalid");
    }

    @Test
    void givenUserIdWhenUserIdIsNullThenIsFalse() {
        PersonalBudget personalBudget = new PersonalBudget(200F, null, null);

        assertThat(personalBudget.validate()).isEqualTo("userId is invalid");
    }

    @Test
    void givenUserIdWhenUserIdIsEmptyThenIsFalse() {
        PersonalBudget personalBudget = new PersonalBudget(200F, "", null);

        assertThat(personalBudget.validate()).isEqualTo("userId is invalid");
    }

    @Test
    void givenAmountAndUserIdWhenAreValidsThenIsTrue() {
        PersonalBudget personalBudget = new PersonalBudget(200F, "FAKE-ID", null);

        assertThat(personalBudget.validate()).isNull();
    }
}
