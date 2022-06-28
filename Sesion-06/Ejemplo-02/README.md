# Ejemplo 2 - La premisa del principio de transformación

## :dart: Objetivo

- Analizar qué es esta técnica de programación guiada por pruebas, sus orígenes y la lógica detrás de su funcionamiento.
- Aplicar el ciclo rojo, verde, refactorización.

## ⚙ Requisitos

- IntelliJ IDEA
- Java
- Gradle
- JUnit
- Code with me
- Una cuenta de GitHub

## Desarrollo

Continuando con nuestro desarrollo, ahora necesitamos probar el caso en que recibimos dos elementos pero en desorden.

```java
    @Test
    public void twoElements2(){
        int[] arr = new int[] {2,1};
        assertArrayEquals(new int[]{1,2}, Sorter.sort(arr));
    }

```

¿Cuál podría ser el código minimo y más simple que podríamos implementar para pasar este caso?

Probablemente podrías estar considerando comenzar con las iteraciones, sin embargo no sería el código más "sencillo".

Lo que podemos ver en este caso es que cuando tenemos dos números y uno es mayor que el otro necesitamos
intercambiarlos.

```java
    public static int[] sort (int[] unsorted){
        int[] sorted = new int[] {};
        if(unsorted.length <= 1) return unsorted;

        if (unsorted[0] > unsorted[1]) {
            int temp = unsorted[0];
            unsorted[0] = unsorted[1];
            unsorted[1] = temp;
        } 

        return unsorted;
    }
```

¿Te parece un sin sentido implementar dicho código porque solo funcionara con estos casos de prueba?

Planteemos el siguiente escenario, imagina un día típico donde estás trabajando con código "desconocido", los primeros
pasos seguramente serán pequeños, algún print por ahi, tal vez ir directamente por el debugger, probar diferentes
entradas para ver que salidas obtienes, etc. Todo esto con el propósito de ir ganando familiaridad con el código. Cuando
por fin te sientes con la confianza necesaria para comenzar con modificaciones los primeros pasos que daras serán
pequeños, iras verificando que todo funcione en cada paso. Cuando tu confianza aumente haras cambios más grandes sin
detenerte, inesperadamente algo no estará funcionando y decidirás seguir cambiando, el código hasta que te encuentres en
un punto de no retorno. Donde o solucionas el error o deshaces todos los cambios. TDD busca evitar esto, creando ciclos
de desarrollo cortos donde siempre puedes volver a un estado anterior.

Nuestro siguiente caso será un arreglo con dos elementos iguales

```java
package Sort;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SorterTest {
    @Test
    public void SortEmptyList_ShouldReturnEmptyList(){
        int[] arr = new int[] {};
        assertArrayEquals(new int[]{}, Sorter.sort(arr));
    }

    @Test
    public void oneElement(){
        int[] arr = new int[] {1};
        assertArrayEquals(new int[]{1}, Sorter.sort(arr));
    }

    @Test
    public void twoElements(){
        int[] arr = new int[] {1,2};
        assertArrayEquals(new int[]{1,2}, Sorter.sort(arr));
    }

    @Test
    public void twoElements2(){
        int[] arr = new int[] {2,1};
        assertArrayEquals(new int[]{1,2}, Sorter.sort(arr));
    }

    @Test
    public void twoElements3(){
        int[] arr = new int[] {2,2};
        assertArrayEquals(new int[]{2,2}, Sorter.sort(arr));
    }
}

```

Nuestro siguiente caso será un arreglo con tres elementos iguales

```java
package Sort;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SorterTest {
    @Test
    public void SortEmptyList_ShouldReturnEmptyList(){
        int[] arr = new int[] {};
        assertArrayEquals(new int[]{}, Sorter.sort(arr));
    }

    @Test
    public void oneElement(){
        int[] arr = new int[] {1};
        assertArrayEquals(new int[]{1}, Sorter.sort(arr));
    }

    @Test
    public void twoElements(){
        int[] arr = new int[] {1,2};
        assertArrayEquals(new int[]{1,2}, Sorter.sort(arr));
    }

    @Test
    public void twoElements2(){
        int[] arr = new int[] {2,1};
        assertArrayEquals(new int[]{1,2}, Sorter.sort(arr));
    }

    @Test
    public void twoElements3(){
        int[] arr = new int[] {2,2};
        assertArrayEquals(new int[]{2,2}, Sorter.sort(arr));
    }

    @Test
    public void threeElements(){
        int[] arr = new int[] {1,2,3};
        assertArrayEquals(new int[]{1,2,3}, Sorter.sort(arr));
    }
}

```

A continuación agregaremos una prueba con 3 elementos desordenados

```java
package Sort;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SorterTest {
    @Test
    public void SortEmptyList_ShouldReturnEmptyList(){
        int[] arr = new int[] {};
        assertArrayEquals(new int[]{}, Sorter.sort(arr));
    }

    @Test
    public void oneElement(){
        int[] arr = new int[] {1};
        assertArrayEquals(new int[]{1}, Sorter.sort(arr));
    }

    @Test
    public void twoElements(){
        int[] arr = new int[] {1,2};
        assertArrayEquals(new int[]{1,2}, Sorter.sort(arr));
    }

    @Test
    public void twoElements2(){
        int[] arr = new int[] {2,1};
        assertArrayEquals(new int[]{1,2}, Sorter.sort(arr));
    }

    @Test
    public void twoElements3(){
        int[] arr = new int[] {2,2};
        assertArrayEquals(new int[]{2,2}, Sorter.sort(arr));
    }

    @Test
    public void threeElements(){
        int[] arr = new int[] {1,2,3};
        assertArrayEquals(new int[]{1,2,3}, Sorter.sort(arr));
    }

    @Test
    public void threeElements2(){
        int[] arr = new int[] {2,1,3};
        assertArrayEquals(new int[]{1,2,3}, Sorter.sort(arr));
    }
}

```

Continuando con este patron ahora podemos verificar el caso para la longitud de tres

```java
    public static int[] sort (int[] unsorted){
        int[] sorted = new int[] {};
        if(unsorted.length <= 1) return unsorted;

        if (unsorted.length == 2) {
            if (unsorted[0] > unsorted[1]) {
            int temp = unsorted[0];
            unsorted[0] = unsorted[1];
            unsorted[1] = temp;
            } 

            return unsorted;
        }

        if (unsorted.length == 3) {
            if (unsorted[0] > unsorted[1]) {
            int temp = unsorted[0];
            unsorted[0] = unsorted[1];
            unsorted[1] = temp;
            } 

            return unsorted;
        }
        
        return unsorted
    }
```

Si miramos con atención podremos notar que un patron ha comenzado a emerger. Son casos similares, con la principal
diferencia radicando en el número de elementos.

Podríamos continuar con un comportamiento similar para distintas longitudes, sin embargo hay que recordar una regla de
mayor orden:

_"Mientras las pruebas se vuelven más especificas, el código se vuelve más genérico."_

Entonces seguir el camino del código específico no resistirá muchos cambios. Por lo tanto veamos la premisa del
principio de transformación, para comenzar a generalizar nuestro código.

### La premisa del principio de transformación

Esta premisa podría parecer bastante radical. Sugiere que las refactorizaciones tienen contrapartes llamadas
transformaciones. Las refactorizaciones son operaciones simples que cambian la estructura del código sin cambiar su
comportamiento. Las transformaciones son operaciones simples que cambian el comportamiento del código. Las
transformaciones se pueden utilizar como el único medio para pasar la prueba que actualmente falla en el ciclo
rojo/verde de refactorización. Las transformaciones tienen una prioridad, o un orden preferido, que si se mantiene,
mediante el orden de las pruebas, evitará estancamientos o interrupciones prolongadas en el ciclo rojo/verde.

    ({}–>nil) ningún código en absoluto que pasa a código que emplea null
    (nil->constant)
    (constant->constant+) una constante simple con una constante mas compleja
    (constant->scalar) remplazando con una constante con una variable o un argumento
    (statement->statements) añadiendo masdeclaraciones no condicionales
    (unconditional->if) dividiendo el camino de ejecución
    (scalar->array)
    (array->container)
    (statement->recursion)
    (if->while)
    (expression->function) remplazando una expresióncon una función o un algoritmo
    (variable->assignment) remplazando el valor de una variable 
