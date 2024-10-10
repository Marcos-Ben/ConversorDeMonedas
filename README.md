                                                                CONVERSOR DE MONEDAS
![image](https://github.com/user-attachments/assets/5d094902-52c5-443b-91c5-a112d3b93f2d)

## Descripción

Este proyecto es un **Convertidor de Monedas** para el desafio de Alura que permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio actualizadas. Los resultados de las conversiones se guardan en un archivo JSON para referencia futura.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación utilizado para desarrollar la aplicación.
- **Gson**: Biblioteca para la manipulación de JSON en Java, utilizada para deserializar la respuesta de la API y para serializar las conversiones a un archivo JSON.
- **Java HTTP Client**: Usado para realizar solicitudes HTTP a la API de tasas de cambio.
- **API de tasas de cambio**: Se utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio actuales.

## Instalación

Para ejecutar el proyecto, sigue estos pasos:

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git
   ```
   
2. **Navegar a la carpeta del proyecto**:
   ```bash
   cd nombre_del_repositorio
   ```

3. **Agregar la biblioteca Gson**:
   - Si usas un proyecto de Maven, añade la siguiente dependencia a tu archivo `pom.xml`:
     ```xml
     <dependency>
         <groupId>com.google.code.gson</groupId>
         <artifactId>gson</artifactId>
         <version>2.8.8</version>
     </dependency>
     ```
   - Para otros métodos de gestión de dependencias, consulta la documentación de Gson.

4. **Ejecutar el programa**:
   - Asegúrate de tener Java JDK instalado (versión 11 o superior).
   - Ejecuta el siguiente comando en tu terminal:
     ```bash
     java -cp . nombre_del_paquete.Principal
     ```

## Uso de la Aplicación

### Paso 1: Ejecutar el Programa

Cuando ejecutes el programa, se te solicitará que elijas la **moneda de origen** y la **moneda de destino** para la conversión, además del **monto** que deseas convertir.

### Paso 2: Selección de la Moneda de Origen

Una vez que el programa inicie, mostrará una lista de todas las monedas disponibles para la conversión. Ejemplo:

```text
Monedas disponibles:
USD, EUR, GBP, ARS, MXN, JPY, ...
```

El sistema aceptará tanto minúsculas como mayúsculas para los códigos de moneda, por ejemplo:

```text
Ingrese el código de la moneda de origen (por ejemplo, USD, ARS, MXN): usd
```

El código **USD** se interpreta como "dólar estadounidense".

### Paso 3: Selección de la Moneda de Destino

Después de seleccionar la moneda de origen, el programa te pedirá que elijas la moneda de destino, donde deseas convertir la cantidad:

```text
Ingrese el código de la moneda a la que desea convertir (por ejemplo, EUR, MXN): ars
```

El código **ARS** se interpreta como "peso argentino".

### Paso 4: Ingreso del Monto a Convertir

Ahora se te pedirá que ingreses el monto que deseas convertir. Por ejemplo, si deseas convertir 100 USD a ARS:

```text
Ingrese la cantidad en USD que desea convertir: 100
```

### Paso 5: Resultado de la Conversión

El programa realizará la conversión y mostrará el resultado en la consola:

```text
Tasa de cambio: 1 USD = 350.50 ARS
100 USD equivale a 35050.00 ARS
```

### Paso 6: Guardado Automático de la Conversión

Cada conversión se guarda automáticamente en un archivo `conversiones.json`. El archivo tiene un formato legible con todas las conversiones realizadas durante la ejecución del programa:

```json
[
  {
    "fromCurrency": "USD",
    "toCurrency": "ARS",
    "originalAmount": 100.0,
    "convertedAmount": 35050.0,
    "conversionRate": 350.50
  },
  {
    "fromCurrency": "EUR",
    "toCurrency": "MXN",
    "originalAmount": 50.0,
    "convertedAmount": 1050.0,
    "conversionRate": 21.0
  }
]
```

## Ejemplo de Uso

Aquí tienes un ejemplo de cómo usar la aplicación para convertir **100 USD** a **ARS**:

1. **Moneda de origen**: USD
2. **Moneda de destino**: ARS
3. **Cantidad**: 100

El resultado podría ser algo como:

```text
Tasa de cambio: 1 USD = 350.50 ARS
100 USD equivale a 35050.00 ARS
```

Además, esta conversión se añadirá al archivo `conversiones.json` para que puedas consultarlo más tarde.
---
