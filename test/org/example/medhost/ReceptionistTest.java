package org.example.medhost;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceptionistTest {

    @Test
    void getUid() {
        Receptionist receptionist = new Receptionist();
        receptionist.setUid("weq123");
        String result = receptionist.getUid();
        assertEquals("weq123",result);
    }
}