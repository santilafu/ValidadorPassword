# 🧩 Proyecto: ValidadorPassword

## 🧠 Introducción

Este proyecto forma parte de la **Unidad 3 del módulo de Desarrollo de Interfaces**, centrada en la creación de **componentes visuales reutilizables**.  
El objetivo ha sido diseñar un **campo de contraseña personalizado en Java Swing**, capaz de validar automáticamente el texto introducido según una serie de criterios de seguridad.

Durante la realización del proyecto me he apoyado en **ChatGPT (GPT-5)** para comprender mejor algunos conceptos técnicos sobre eventos, validación y encapsulación de la lógica, manteniendo un enfoque práctico y sencillo.

---

## 🎯 Objetivo principal

El propósito de esta actividad ha sido crear un **componente visual reutilizable** (`ValidadorC`) que extiende `JPasswordField` y que valida contraseñas en base a los siguientes criterios:

| Requisito | Descripción |
|:--|:--|
| Longitud mínima | Debe tener al menos 8 caracteres |
| Mayúsculas | Debe incluir al menos una letra mayúscula |
| Minúsculas | Debe incluir al menos una letra minúscula |
| Números | Debe incluir al menos un número |
| Carácter especial | Debe incluir al menos un símbolo especial (!@#$%^&*) |

---

## ⚙️ Funcionamiento general

El usuario introduce su contraseña en el campo y el componente la **valida automáticamente cuando pierde el foco**, cambiando el color de fondo para indicar el resultado:

- **Verde claro:** contraseña válida
- **Rojo claro:** contraseña incorrecta

Además, el campo muestra un **mensaje informativo  indicando qué requisitos faltan.  
También se añadió un **botón “Confirmar”** que permite comprobar manualmente si la contraseña cumple los requisitos, mostrando un mensaje distinto según el resultado.

| Estado | Descripción | Tipo de mensaje |
|:--|:--|:--|
| Vacío | El campo está sin rellenar | Advertencia |
| Correcto | Cumple todas las condiciones | Información |
| Incorrecto | Faltan uno o varios requisitos | Error |

---

## 🧩 Componentes creados

### 1. `ValidadorC`
Componente principal que hereda de `JPasswordField`.  
Contiene toda la lógica interna de validación y el cambio de color según los resultados.

**Características principales:**
- Valida automáticamente al perder el foco.
- Cambia de color según la validez.
- Muestra mensajes informativos.
- Incluye el método `esValida()` que devuelve un valor booleano (true o false).
- Es completamente reutilizable en cualquier interfaz Swing.

---

### 2. `TestValidador`
Clase encargada de probar el funcionamiento del componente `ValidadorC`.  
Muestra una interfaz simple con los siguientes elementos:

- Etiqueta de título.
- Campo de contraseña personalizado.
- Etiqueta con los requisitos visibles.
- Botón “Confirmar” para comprobar manualmente la contraseña.

---

## 🔍 Funcionamiento interno

El componente recorre carácter por carácter la contraseña y evalúa si cumple las condiciones establecidas.  
Se han utilizado los métodos estándar de Java `Character.isUpperCase()`, `Character.isLowerCase()` y `Character.isDigit()` para mantener la validación limpia y eficiente.

A diferencia de versiones iniciales, esta versión **no depende del color del campo para saber si la contraseña es válida**, sino de la lógica interna encapsulada en el método `esValida()`.  
Esto garantiza que el componente funcione correctamente incluso si se cambian los colores o estilos visuales.

---

## 📘 Resumen del aprendizaje

| Concepto | Qué se ha aprendido |
|:--|:--|
| Eventos de foco | Detectar cuándo un componente gana o pierde la atención del usuario |
| Componentes personalizados | Extender clases de Swing para crear elementos visuales propios |
| Validación de entradas | Aplicar reglas de comprobación en tiempo real |
| Encapsulación | Mantener la lógica dentro del componente, sin depender del exterior |
| Usabilidad | Diseñar interfaces claras, simples y con feedback visual |

---

## 🧩 Herramientas utilizadas

| Herramienta | Uso principal |
|:--|:--|
| **IntelliJ IDEA Ultimate** | Desarrollo completo del proyecto |
| **Java Swing / AWT** | Creación de la interfaz gráfica |
| **GitHub** | Control de versiones y publicación |
| **ChatGPT (GPT-5)** | Apoyo para la redacción técnica y explicación de conceptos |

---

## 👤 Autor y créditos

**Autor:** Santiago Lafuente Hernández  
**Proyecto:** ValidadorPassword  
**Ciclo:** Desarrollo de Aplicaciones Multiplataforma (2º DAM)  
**Centro:** Aula Campus Burjassot – Valencia  
**Colaboración técnica:** Asistencia puntual de ChatGPT (GPT-5), sobretodo en el desarrollo del Markdown y explicación de conceptos técnicos.
