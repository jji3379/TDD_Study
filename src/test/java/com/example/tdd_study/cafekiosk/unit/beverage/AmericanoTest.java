package com.example.tdd_study.cafekiosk.unit.beverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AmericanoTest {

    @DisplayName("")
    @Test
    void getName() {
        // given
        Americano americano = new Americano();

        // when

        // then
        assertThat(americano.getName()).isEqualTo("아메리카노");
    }

}