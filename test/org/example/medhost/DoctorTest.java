package org.example.medhost;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSpecialization() {
        Doctor doctor = new Doctor("abc","34","ab34","Medicine","12ac");

        String result = doctor.getSpecialization();
        assertEquals("Medicine",result);
    }

}