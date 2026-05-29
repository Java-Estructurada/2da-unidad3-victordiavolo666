[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=24036401&assignment_repo_type=AssignmentRepo)
# 🚀 Examen - Unidad 3: Control de Clima Automatizado en Invernaderos de Berries 🍓🌡️

**Objetivo:** 🎯 Dominar la implementación de estructuras de control de flujo en Java utilizando **ciclos aninados (`for`, `while` o `do-while`)**, **estructuras selectivas múltiples y anidadas**, lógica de banderas (flags), contadores, acumuladores y validación estricta de entradas por consola.

**Contexto:** 🚜 Agricultura de precisión y automatización en el Sur de Jalisco (Ciudad Guzmán).

---

## 📖 Contexto del Problema 🌾

Las berries (arándanos, frambuesas y zarzamoras) cultivadas en los invernaderos inteligentes de **Ciudad Guzmán** son extremadamente sensibles a los cambios térmicos 🌡️. Para garantizar la calidad de exportación, cada invernadero cuenta con múltiples sensores que reportan la temperatura en tiempo real.

Necesitas desarrollar un prototipo de software que simule el **sistema central de auditoría climática** 🖥️. El programa debe permitir procesar la información de múltiples invernaderos, validar que las lecturas de los sensores sean correctas, clasificar el estado térmico de cada lectura y emitir un reporte de alerta global al finalizar la jornada.

---

## 📥 Requerimientos del Sistema y Reglas de Negocio ⚙️

El programa debe estructurarse de forma estrictamente secuencial e iterativa bajo las siguientes pautas:

### 1. 🔍 Validación de Invernaderos (Ciclo Externo)

* 🏢 El programa debe preguntar al inicio: **"¿Cuántos invernaderos se van a auditar hoy?"**.

* 🛑 **Validación de entrada:** El usuario no puede ingresar un número menor o igual a `0`. Si lo hace, el sistema debe mostrar un mensaje de error y volver a solicitar el número de invernaderos de forma indefinida hasta que ingrese un valor válido (uso de bucle de validación).

### 2. 🌡️ Captura de Lecturas con Centinela (Ciclo Interno)

* 📈 Para cada invernadero, el operador ingresará de forma continua las lecturas térmicas de los sensores en grados Celsius ($^\circ\text{C}$).

* 🎯 **Centinela de parada:** Dado que cada invernadero puede tener una cantidad diferente de sensores activos, la captura de lecturas terminará inmediatamente cuando el operador ingrese el valor de interrupción: **`-99`**.

### 3. 🚨 Validación de Rango de Temperatura

* ⚠️ Cada temperatura capturada debe ser realista. El rango permitido para un sensor es de **$-10.0^\circ\text{C}$ a $50.0^\circ\text{C}$**.

* 🚫 Si la lectura está fuera de ese rango (y no es el centinela `-99`), el sistema debe notificar: `"[ERROR] Lectura fuera de rango físico. Intente de nuevo."` y **no debe contabilizarla** para los promedios ni las alertas, permitiendo continuar con la siguiente lectura.

### 4. 🎚️ Clasificación Térmica y Alertas

Por cada lectura válida procesada, el sistema debe evaluar y clasificar la temperatura con base en las siguientes reglas:

* ❄️ **Menor a $12.0^\circ\text{C}$:** Estado **"FRÍO"**. (Acción: Encender calefactores automáticos).

* ✅ **Entre $12.0^\circ\text{C}$ y $28.0^\circ\text{C}$ (inclusive):** Estado **"ÓPTIMO"**. (Acción: Mantener ventilación pasiva).

* 🚨 **Mayor a $28.0^\circ\text{C}$:** Estado **"CRÍTICO"**. (Acción: Activar extractores de aire y riego de emergencia).

---

## 📊 Métricas a Calcular (Salidas Esperadas)

El sistema debe procesar las variables en tiempo real para mostrar dos reportes:

### A. Al finalizar la captura de cada invernadero individual:

1. 🧮 El **promedio de temperatura** de ese invernadero (solo de lecturas válidas).

2. 🚨 La **cantidad total de alertas críticas** detectadas (temperaturas $> 28.0^\circ\text{C}$).

3. 📢 Un diagnóstico final del invernadero:

   * Si el promedio de temperatura fue mayor a $28.0^\circ\text{C}$, mostrar: `[ESTADO DEL SECTOR: PELIGRO POR SOBRECALENTAMIENTO]`.

   * De lo contrario, mostrar: `[ESTADO DEL SECTOR: ESTABLE / SEGURO]`.

### B. Al finalizar la auditoría completa (Reporte Global):

1. 📊 Total de invernaderos analizados con éxito.

2. 🏆 La **temperatura máxima histórica** registrada en toda la instalación y a qué invernadero perteneció.

---

## ⚠️ Restricciones Técnicas

* ⛔ **Sin métodos complejos:** Todo el control de flujos debe programarse dentro del método `main` para evaluar la destreza del alumno en la anidación de bucles (`for` que contiene a un `while`, que a su vez contiene sentencias `if-else`).

* 🔢 **Precisión de decimales:** El promedio y la temperatura máxima deben utilizar variables de tipo `double`.

* 🛡️ **Evitar divisiones entre cero:** Si un invernadero se cierra con el centinela `-99` sin haber registrado ninguna lectura válida, el sistema debe controlarlo para evitar calcular un promedio indefinido (NaN).

---

## 📤 Ejemplo de Salida Esperada en Consola ✨

```text
=====================================================
 🚜 SISTEMA DE AUDITORÍA CLIMÁTICA - BERRYSMART 🍓
=====================================================
¿Cuántos invernaderos se van a auditar hoy?: -2
[ERROR] La cantidad debe ser mayor a cero.

¿Cuántos invernaderos se van a auditar hoy?: 2

-----------------------------------------------------
🏠 AUDITANDO INVERNADERO #1
-----------------------------------------------------
-> Ingrese lectura del sensor (o -99 para finalizar): 10.5
   [❄️ FRÍO] -> Calefactores encendidos.
-> Ingrese lectura del sensor (o -99 para finalizar): 22.4
   [✅ ÓPTIMO] -> Estado estable.
-> Ingrese lectura del sensor (o -99 para finalizar): 55.0
   [ERROR] Lectura fuera de rango físico. Intente de nuevo.
-> Ingrese lectura del sensor (o -99 para finalizar): 31.2
   [🚨 CRÍTICO] -> ¡Extractores activados!
-> Ingrese lectura del sensor (o -99 para finalizar): -99

📊 RESUMEN INVERNADERO #1:
+ Promedio de temperatura: 21.37°C
+ Alertas críticas detectadas: 1
+ Diagnóstico: [ESTADO DEL SECTOR: ESTABLE / SEGURO]

-----------------------------------------------------
🏠 AUDITANDO INVERNADERO #2
-----------------------------------------------------
-> Ingrese lectura del sensor (o -99 para finalizar): 29.5
   [🚨 CRÍTICO] -> ¡Extractores activados!
-> Ingrese lectura del sensor (o -99 para finalizar): 32.0
   [🚨 CRÍTICO] -> ¡Extractores activados!
-> Ingrese lectura del sensor (o -99 para finalizar): -99

📊 RESUMEN INVERNADERO #2:
+ Promedio de temperatura: 30.75°C
+ Alertas críticas detectadas: 2
+ Diagnóstico: [ESTADO DEL SECTOR: PELIGRO POR SOBRECALENTAMIENTO]

=====================================================
 📈 REPORTE GLOBAL DE LA JORNADA
=====================================================
+ Total de invernaderos auditados: 2
+ Pico de temperatura más alto detectado: 32.00°C (Invernadero #2)
=====================================================
Monitoreo finalizado. Registros guardados en la base de datos local.
```
