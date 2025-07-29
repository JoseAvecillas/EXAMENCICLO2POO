# 🏨 Sistema de Gestión de Reservas de Hotel

Este proyecto es una aplicación de escritorio en Java con Swing, diseñada para gestionar clientes, habitaciones y reservas en un hotel. Sigue el patrón MVC para organizar el código y facilitar el mantenimiento.

## 🛠 Tecnologías Usadas

- Java 8+
- Swing (Interfaz Gráfica)
- Archivos `.txt` como almacenamiento local
- Patrón de diseño MVC

## 🚀 Funcionalidades

### 👤 Login y Registro
- Login con verificación desde archivo (`usuarios.txt`)
- Login y Resgistro de usuarios con sus respectivas validaciones

### 👥 Gestión de Clientes
- Crear y guardar nuevos clientes
- Validación de campos obligatorios

### 🛏 Gestión de Habitaciones
- Registro de habitaciones con número y tipo (`SIMPLE`, `DOBLE`, `SUITE`)
- Almacenamiento persistente

### 📅 Gestión de Reservas
- Registro de reservas por cédula y número de habitación
- Validación de fechas y cliente/habitación existentes
- Verificación de superposición de fechas
- Guardado en archivo `reservas.txt`

## 🧠 Lógica Destacada

### 🔁 Verificación de Superposición
Antes de guardar una nueva reserva, se verifica que las fechas no interfieran con otras reservas previas en la misma habitación.

```java
if (!(nueva.getFechaSalida().isBefore(r.getFechaEntrada()) || 
      nueva.getFechaEntrada().isAfter(r.getFechaSalida())))
```
## 📁 Estructura del Proyecto
```
📦 proyecto
 ┣ 📂model
 ┃ ┣ 📜Cliente.java
 ┃ ┣ 📜Habitacion.java
 ┃ ┣ 📜Reserva.java
 ┃ ┣ 📜Usuario.java (y subclases)
 ┃ ┗ 📜TipoHabitacion.java
 ┣ 📂view
 ┃ ┣ 📜LoginVista.java
 ┃ ┣ 📜RegistroVista.java
 ┃ ┗ 📜MenuPrincipalVista.java
 ┣ 📂controller
 ┃ ┣ 📜ClienteController.java
 ┃ ┣ 📜HabitacionController.java
 ┃ ┗ 📜ReservaController.java
 ┣ 📜App.java
 ┗ 📜usuarios.txt / reservas.txt
```
Desarrollado por Joey Diaz y Jose Avecillas
