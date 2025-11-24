# Aplicación de Registro de Medidores

Aplicación móvil nativa para Android desarrollada con Kotlin y Jetpack Compose. Permite a los usuarios registrar, almacenar y visualizar el historial de lecturas de medidores de servicios básicos (Agua, Luz y Gas) de manera local y persistente.

Examen final para el ramo de **Programación II**.

## Características

* Registro de Mediciones: Formulario intuitivo para ingresar tipo de servicio, valor y fecha.
* Persistencia de Datos: Almacenamiento local utilizando ROOM Database (SQLite).
* Listado Histórico: Visualización eficiente de registros mediante `LazyColumn`.
* Selector de Fecha: Implementación de `DatePicker` nativo para asegurar el formato correcto.
* Navegación: Flujo fluido entre pantallas usando `Navigation Component`.
* Internacionalización: Soporte completo para Español e Inglés.

## Tecnologías Utilizadas

* Lenguaje: Kotlin
* UI Toolkit: Jetpack Compose (Material 3)
* Arquitectura: MVVM (Model-View-ViewModel)
* Base de Datos: Android Room



## Cómo ejecutar el proyecto

1.  Clona este repositorio:
    ```bash
    git clone [https://github.com/diegodonoso4-design/medidores.git](https://github.com/diegodonoso4-design/medidores.git)
    ```
2.  Abre el proyecto en Android Studio (Ladybug o superior recomendado).
3.  Espera a que Gradle sincronice las dependencias.
4.  Selecciona un dispositivo emulador o físico.
5.  Presiona el botón Run.
