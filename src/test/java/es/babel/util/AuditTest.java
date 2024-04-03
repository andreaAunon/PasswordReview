package es.babel.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class AuditTest {

    @Mock
    private controllers sut;

    @BeforeEach
    public void setup() {
        sut = new controllers();
        // Para hacer un mock en caso de inyección de dependencias
        // Mockito.mock(.class)
    }

    @Test
    void test_shouldAuditPassword_whenOnlyHaveOneMinus() {
        // GIVEN
        String password = "a";
        String resultExpected = "Muy debil";
        // Notación when (sirve para dar comportamiento esperado):
        //when(sut.auditPassword(password)).thenReturn(resultExpected);
        // WHEN
        String result = sut.auditPassword(password);
        // THEN
        Assertions.assertEquals(resultExpected,result);
    }

    @Test
    void test_shouldAuditPassword_whenOnlyHaveOneMayus() {
        // GIVEN
        String password = "A";
        String resultExpected = "Muy debil";
        // WHEN
        String result = sut.auditPassword(password);
        // THEN
        Assertions.assertEquals(resultExpected,result);
    }

    @Test
    void test_shouldAuditPassword_whenMinusAndMayus() {
        // GIVEN
        String password = "Ab";
        String resultExpected = "Debil";
        // WHEN
        String result = sut.auditPassword(password);
        // THEN
        Assertions.assertEquals(resultExpected,result);
    }

    @Test
    void test_shouldAuditPassword_whenHaveAllAndLongFour() {
        // GIVEN
        String password = "Ab*1";
        String resultExpected = "Moderada";
        // WHEN
        String result = sut.auditPassword(password);
        // THEN
        Assertions.assertEquals(resultExpected,result);
    }

    @Test
    void test_shouldAuditPassword_whenEmpty() {
        // GIVEN
        String password = "";
        String resultExpected = "Hay alguna contraseña no valida";
        // WHEN
        String result = sut.auditPassword(password);
        // THEN
        Assertions.assertEquals(resultExpected,result);
    }
}