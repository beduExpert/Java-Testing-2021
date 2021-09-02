# Reto 1 - Migrar pruebas de JUnit 4 a Junit5 


## Desarrollo

Dado el siguiente código de una calculadora básica con pruebas en JUnit 4 migrar las pruebas a JUnit 5.

`Calculator.java`
```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result += add(result,a);
        }
        return result;
    }
}
```

`CalculatorTest.java`
```java
public class CalculatorTest {
    private int a,b;
    
    
    @Before
    public void setUp(){
        a = ThreadLocalRandom.current().nextInt();
        b = ThreadLocalRandom.current().nextInt();
    }

    @Test
    public void testAdd() {       
        int result = calculator.add(a, b);

        assertEquals("Resultado incorrecto de la suma", a + b, result);
    }

    @Test(expected = Exception.class)
    public void testAddThrowsExceptionWhenIsCalledWithInvalidParams() {
        String c = "hello";
        int result = calculator.add(a, c);

        assertEquals("Resultado incorrecto de la suma", a + b, result);
    }

    @Test
    public void testMultiply() {
        int additionResult = calculator.add(a, b);

        assumeNotNull(additionResult);

        int multiplicationResult = calculator.multiply(a, b);

        Assertions.assertEquals("Resultado incorrecto de la multiplicación",a * b, multiplicationResult);
    }
}
```

<details>
  <summary>Solución</summary>

`CalculatorTest.java`
```java

```

</details>