# Postwork

[Ver en Google docs](https://docs.google.com/document/d/1RnxO-wmpxGFD5JSZtCvUKKRhEInfIMh4aCppziQWbMY/edit?usp=sharing)




## 🎯 OBJETIVOS

Desarrollar funcionalidad adicional a nuestro programa.
Añadir pruebas unitarias adicionales para probar su funcionalidad.
Aplicar técnicas de diseño de pruebas.
Familiarizarse con la herramienta JUNIT.

## 🚀 DESARROLLO

Durante nuestro work, desarrollamos las primeras funcionalidades de nuestro software de entrevistas  y nos comenzamos a familiarizar con el uso de JUnit. Ahora en este post work continuaremos con el desarrollo del software de entrevistas y exploraremos algunas funcionalidades de JUnit realizando el siguiente ejercicio.

El project manager ha definido como objetivo para este sprint añadir las siguientes características a nuestro sistema actual:
La información de los entrevistadores se puede modificar desde terminal.
La definición de hecho (Definition of Done) establece que todo el código generado debe contar con pruebas unitarias.

1. Añade la opción número 3 al menú, con el texto: "3. Modificar un entrevistador" 

1. Dentro de nuestro switch generar el case con valor 3 y llamar a la función modifyInterviewer que crearemos a continuación

1. Crear la función modifyInterviewer solicitar el email del entrevistador y en caso de no encontrarlo imprimir el mensaje:  "Entrevistador no encontrado"


1. Solo se debe continuar en este flujo si el entrevistador fue encontrado. Solicitar a continuación el nuevo nombre, apellido y email, mencionando que se debe apretar Enter para mantener el valor actual. Preguntar si el entrevistador se encuentra activo.
                    

1. Guardar los datos del entrevistador llamando a la función save de nuestro objeto interviewer.

1. Añadir las pruebas unitarias correspondientes para validar el correcto funcionamiento de la funcionalidad de editar entrevistadores.


## Indicaciones generales

Una vez que hayas terminado  la actividad responde las siguientes preguntas:

¿Cómo estás creando la prueba para validar que se guardan correctamente los archivos?
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
¿Decidiste probar directamente en los métodos de la clase interviewer o estás probando en el menú? ¿?
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________

¿Crees que existe diferencia entre las pruebas hechas directamente a la clase interviewer y las realizadas al menú? ¿Por qué?
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________

¡Mucho éxito y reta tu potencial!



## ✅ Checklist 

Asegúrate que tu postwork contenga todo lo siguiente, ya que esto se evaluará al término del módulo.

- [ ] El usuario desde terminal puede seleccionar una opción que le permita editar la información de un entrevistador.




- [ ] El usuario podrá seleccionar el entrevistador a editar ingresando su id o su email.




- [ ] El usuario podrá editar todos los campos de un entrevistador.




- [ ] Test que valide que la información contenida en los archivos, después de la edición, sea la correcta.








<details>
  <summary>Solución</summary>

`Menu.java`
```java
package com.test.interviewer;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
        Interviewer.data = new ArrayList<Interviewer>();
        Interviewer.loadDataFromFile();

        showMainMenu();
    }

    public void showMainMenu() {
        int option = 0;

        while (option != 4 ) {
            System.out.println("Seleccione la operacion a realizar:");
            System.out.println("1. Dar de alta un entrevistador");
            System.out.println("2. Consultar un entrevistador");
            System.out.println("3. Modificar un entrevistador");
            System.out.println("4. Salir");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    addInterviewer();
                    break;
                case 2:
                    searchInterviewer();
                    break;
                case 3:
                    modifyInterviewer();
                    break;
            }
        };

        System.out.println("Programa terminado");
    }

    public void addInterviewer() {
        System.out.println("Ingrese el nombre del entrevistador: ");
        String name = sc.nextLine();
        System.out.println("Ingrese el apellido del entrevistador: ");
        String lastName = sc.nextLine();
        System.out.println("Ingrese el email del entrevistador: ");
        String email = sc.nextLine();
        System.out.println("El entrevistador se encuentra activo? (1=Si/2=No)");
        Boolean isActive = sc.nextInt() == 1;
        sc.nextLine();

        Interviewer interviewer = new Interviewer(name, lastName, email, isActive);
        interviewer.add();

        System.out.println(interviewer.toString());
    }

    public void searchInterviewer() {
        System.out.println("Ingrese el email del entrevistador a consultar:");
        String email = sc.nextLine();

        Interviewer interviewer = Interviewer.getByEmail(email);

        if (interviewer != null) {
            System.out.println("Entrevistador encontrado:");
            System.out.println(interviewer.toString());
        } else {
            System.out.println("Entrevistador no encontrado");
        }
    }

    public void modifyInterviewer() {
        System.out.println("Ingrese el email del entrevistador a modificar:");
        String email = sc.nextLine();

        Interviewer interviewer = Interviewer.getByEmail(email);

        if (interviewer != null) {
            System.out.println("Entrevistador encontrado:");
            System.out.println(interviewer.toString());

            System.out.println("Ingrese el nuevo nombre del entrevistador: (Enter para mantener actual)");
            String name = sc.nextLine();
            System.out.println("Ingrese el nuevo apellido del entrevistador: (Enter para mantener actual)");
            String lastName = sc.nextLine();
            System.out.println("Ingrese el nuevo email del entrevistador: (Enter para mantener actual)");
            String newEmail = sc.nextLine();
            System.out.println("El entrevistador se encuentra activo? (1=Si/2=No)");
            Boolean isActive = sc.nextInt() == 1;
            sc.nextLine();

            interviewer.save(name, lastName, newEmail, isActive);

        } else {
            System.out.println("Entrevistador no encontrado");
        }
    }

    public static void main(String[] args) {
        new Menu();
    }
}

```
`MenuTest.java`
```java
package com.test.interviewer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private final String exitCommand = "4 \n";

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }


    @Test
    public void addNewInterviewer() {
        final String interviewerName = "Interviewer Name";
        final String interviewerLastName = "Interviewer Lastname";
        final String interviewerEmail = "Interviewer Email";
        final String addNewInterviewerCommand = "1 \n " + interviewerName + " \n " + interviewerLastName + " \n " + interviewerEmail + " \n 1 \n" + exitCommand;
        provideInput(addNewInterviewerCommand);

        Menu.main(new String[0]);
        final String output = getOutput();

        assertTrue(output.contains(interviewerName));
        assertTrue(output.contains(interviewerLastName));
        assertTrue(output.contains(interviewerEmail));
    }

    @Test
    public void getInterviewer() {
        final String interviewerName = "Interviewer Name";
        final String interviewerLastName = "Interviewer Lastname";
        final String interviewerEmail = "interviewer@mail.com";
        final String addNewInterviewerCommand = "1 \n " + interviewerName + " \n " + interviewerLastName + " \n " + interviewerEmail + " \n 1 \n";
        final String getInterviewerCommand = "2 \n " + interviewerEmail + "\n ";
        provideInput(addNewInterviewerCommand + getInterviewerCommand + exitCommand);

        Menu.main(new String[0]);
        final String output = getOutput();

        assertTrue(output.contains(interviewerName));
        assertTrue(output.contains(interviewerLastName));
        assertTrue(output.contains(interviewerEmail));
    }


}

```
</details>
