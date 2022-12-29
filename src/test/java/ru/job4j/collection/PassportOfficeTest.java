package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {

    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenPassportDuplicated() {
        Citizen citizenP = new Citizen("abc123", "P Sbk");
        Citizen citizenB = new Citizen("abc123", "B Sbk");
        PassportOffice office = new PassportOffice();
        office.add(citizenP);
        assertThat(office.add(citizenB)).isFalse();
    }
}
