# Integración Cotinua
La integración continua es la práctica de desarrollo de software en donde los integrantes de ese equipo de desarrollo, y como el nombre lo indica, continuamente integran su trabajo. Ésta integración puede suceder al menos una vez al día lo que da lugar a múltiples colaboraciones al día.
Las integraciones continuas incluyen ejecución de pruebas para detectar fallos tan rápido como sea posible. El no incluir pruebas de las integraciones continuas, puede dar lugar a errores en el código que pasan desapercibidas.
En caso de encontrar errores en el código, se tendrá que volver a construir la integración hasta lograr una libre de fallos.

## Entornos
Las integraciones continuas pueden realizarse en diferentes entonces, aquí se encuentra una lista de posibles entornos:
- **Entorno de Producción:** Es el entorno en el que se exploran las aplicaciones ejecutadas
- **Entorno de Pre-Producción:** Es el entorno con las mismas características de el de producción pero con la finalidad de realizar pruebas sobre las aplicaciones y poder ser mandadas a producción.
- **Entorno de Integración Continua:** Es el entorno donde se manejan y gestionan las ramas (branches) del código.
- **Entorno Local:** Es el entorno del desarrollador

## Requisitos Para la Integración Continua
Estos son los requisitos para mantener un flujo de integración continua:
- Mantener un único repositorio con un controlador de versiones, tales como GitHub, GitLab, SVN, etc.
- Automatizar la construcción
  - Toda integración se realiza en la rama de desarrollo dentro del entorno de integración
  - Cada construcción debe incluir la ejecución de pruebas inmediatas
  - Arreglar fallos inmediatamente
- Automatizar el despliegue
- Probar en un entorno de Pre-Producción
- Facilitar la obtención del último ejecutable
- Que todo el equipo pueda ver lo que está sucediendo

## Puebas Continuas (Continous Testing)
Las pruebas continuas se basan en la automatización de pruebas integradas, como parte de un proceso de implementación en el que el software se valida en entornos de pruebas realistas. La adición de la virtualización del servicio , permite a los equipos comenzar a comprobar la calidad del software más temprano en el ciclo de vida, simulando software y sistemas dependientes, pero no disponibles.
Las pruebas continuas permiten a un equipo de proyecto ejecutar pruebas cuando sea necesario, no cuando sea posible.

Algunos puntos importantes sobre las pruebas continuas:

- Las pruebas continuas proporcionan una visión instantánea sobre si un candidato de lanzamiento es demasiado arriesgado para proceder a través del pipeline de entrega.
- Las pruebas continuas establecen una red de seguridad que ayuda al equipo a proteger la experiencia del usuario en los procesos de desarrollo acelerados y a evitar los titulares de los fallos del software
- Las pruebas continuas esperan que las pruebas se integren en el proceso de desarrollo, no que se añadan al final.

# Ejemplo # - Nombre del ejemplo

## Objetivo

* Agregar los objetivos del ejemplo (Mínimo agregar 2 objetivos y Borrar está linea una vez se hay leido)

## Desarrollo

>**💡 Nota para experto(a)**
>
> Este es un ejemplo por si el experto necesita tener en cuenta un punto clave durante el ejemplo.
>Si no es necesario, puedes borrar esta nota.

Aquí se debe agregar el desarrollo del ejemplo



