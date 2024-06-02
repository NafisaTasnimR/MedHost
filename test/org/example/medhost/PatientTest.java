package org.example.medhost;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDischareDate() {
        Patient patient = new Patient();
        LocalDate date = LocalDate.of(2024, Month.JUNE,2);
        String result = patient.getDischareDate(date);
        assertEquals("02/06/2024",result);

    }
}