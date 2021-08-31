# Ejemplo #2 - Tipos de Pruebas de Software

## Objetivo

* Conocer los diferentes tipos de pruebas

## Desarrollo

Existen diferentes tipos de pruebas de software, en este documento se presentan los tipos según el SUT:
- Aceptación
- Sistema
- Integración
- Componente
- Unitaria

## Aceptación
Se prueba el sistema completo, desde la interfaz hasta la base de datos o de al menos alguna parte del sistema que sea funcional. El objetivo es validar los requireimientos iniciales como son los casos de uso, historias de usuario, etc. Quienes realizan estas pruebas usualmente son los usuarios finales que no formaron parte del desarrollo.

## Sistema
Se prueba el sistema completo, desde la interfaz hasta la base de datos o de al menos alguna parte del sistema que sea funcional. El objetivo es validar los requireimientos iniciales como son los casos de uso, historias de usuario, etc. Quienes realizan estas pruebas son personas dedicadas a las pruebas que pueden involucrar al usuario, pero no formaron parte del desarrollo.

## Integración
Se prueban componentes del sistema o subsistemas. El objetivo es verificar la comunicación entre los componentes del sistema o sus subsistemas. Quienes realizan estas pruebas son los desarrolladores incolucrando al usuario.

## Componente
Se prueban grupos o partes del sistema que en conjunto hacen funcionar un componente o servicio. El objetivo es verificar el funcionamiento correto e independiente de los componentes. Quienes realizan estas pruebas son los desarrolladores incolucrando al usuario.

## Unitaria
Se prueba una sola clase, objeto, o método. El objetivo es verificar las condiciones del diseño y documentar su comportamiento. Quienes realizan estas pruebas son los desarrolladores incolucrando al usuario.


## Probar el flujo para obtener la información de un entrevistador

`InterviewerTest.java`
```java
package com.test.interviewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class InterviewerTest {
    static String existingInterviewerName = "First";
    static String existingInterviewerLastName = "User";
    static String existingInterviewerEmail =  "first@email.com";

    @BeforeEach
    public void setUp() throws Exception {
        Interviewer.data = new ArrayList<>();

        // We insert a user for testing delete and save
        Interviewer.data.add(new Interviewer(
                existingInterviewerName,
                existingInterviewerLastName,
                existingInterviewerEmail,
                true
        ));
    }

    @Test
    public void add() {
        Interviewer interviewer = new Interviewer(
                "Test",
                "User",
                "any@email.com",
                true
        );

        interviewer.add();

        int expectedId = Interviewer.data.size();
        assertEquals(
                expectedId,
                interviewer.id,
                "Interviewer ID should be the new List's size"
        );
    }


    @Test
    public void getByEmail() {
        Interviewer result = Interviewer.getByEmail(existingInterviewerEmail);

        assertNotNull(result, "Interviewer should be found");
        assertEquals(
                existingInterviewerName,
                result.name,
                "Unexpected Interviewer Name"
        );
        assertEquals(
                existingInterviewerLastName,
                result.lastName,
                "Unexpected Interviewer Last Name"
        );
    }

    @Test
    public void getByNonExistingEmail() {
        String nonExistingEmail = "nonexisting@email.com";

        Interviewer result = Interviewer.getByEmail(nonExistingEmail);

        assertNull(result, "Interviewer should not be found");
    }
}
```

