---
tags:
  - 🎨IHC
  - 📝TAR
cssclasses:
  - center-titles
---

# Apuntes de la Entrevista

---

> [!note] Contexto
> - Se realizó la entrevista a un administrador del área de ventas de la empresa OMNISOFT para conocer los procesos que se realizan para administrar la información y ofrecer una solución digital (posiblemente basada en IA) que permita acelerar estos procesos o hacerlos más eficaces.
> - No se pretende llegar a completar e implementar la solución, simplemente llegar a un esquema final sin producir código realmente.

> [!example] Proyecto: SalesBot.
> - Administro el área de Ventas y llevo el control de toda la facturación y recaudación de la empresa.
> - Nuestra área está enfocada en dar información precisa del estado de cuenta de un cliente, tener la cartera de la empresa por edades, el monto recaudado en un año comparado con el anterior, la tasa mensual de incremento o decremento de cartera vencida, los datos de facturación y pagos para hacer una proyección de ingresos en el siguiente periodo.
> - Necesito una solución digital que nos permita tener esta información de forma rápida, eficaz, nos alerte con indicadores basados en criterios definidos previamente y me permita como área tener un seguimiento personalizado de los procesos que se llevan y son críticos

> [!info] Datos de la Entrevista
> **Entrevistado:** Marco Jarrín - Gerente de Soluciones Integrales OMNISOFT (Empresa especializada en el desarrollo de soluciones informáticas totalmente basadas en la tecnología de Internet.)
> **Propósito:** Explorar procesos actuales y viabilidad de un Sales-Bot para gestión de ventas, facturación y cartera
---

> [!bug] Herramientas y Procesos que utilizan
> - Todos los módulos de ventas, inventario, bancos, etc. están integrados a la parte contable.
> - El resto de módulos vienen a ser auxiliares del ERP.
> - La empresa usa servicios propios, no requieren elementos de terceros para garantizar que tienen la seguridad de proteger los datos de sus clientes.
> - Están interesados en utilizar agentes de IA para que los usuarios puedan administrar.

> [!tip] Proceso para crear ChatBot
> - El entrevistado nos enseñó una serie de pasos para la implementación de un ChatBot.
> 
> 1. **Definir objetivos**: Establecer la función principal del ChatBot. Lo que nos interesa es manejo y gestión de ventas y cobranzas con dos tipos de usuarios: Clientes de la empresa y Gente que toma decisiones (gerentes, director de ventas, tesorería, etc.). Deben tener diferentes preguntas por parte de la IA.
> 
> 2. **Elegir los canales**: Web, WhatsApp, Redes Sociales, Embebido, etc. Están interesados que sea parte de su sistema o por WhatsApp.
> 
> 3. **Seleccionar la tecnología**: (Nos ofreció como recomendación GitHub) + APIs de IA.
> 
> 4. **Diseñar el flujo**: Lo primordial es identificar quién es el usuario para identificar su perfil (cliente o tomador de decisiones). Luego presentar una serie de opciones que el usuario pueda ingresar o, mediante lenguaje natural, solicitar consultas específicas.
> 
> 5. **Definir la personalidad**: Cómo va a tratar al usuario, si va a tener género, cómo se comunica (texto o voz).
> 
> 6. **Añadir la IA**: IA como Gemini, ChatGPT, DeepSeek, etc.
> 
> 7. **Pruebas y Ajustes**: Realizar una prueba con los usuarios para tener una retroalimentación y añadir elementos que no fueron incluidos. Añadir preguntas de satisfacción de uso.

> [!quote] Parte Gráfica
> - En una sola pantalla, alguien que toma decisiones debería poder ver cómo va evolucionando la cartera y otros datos con gráficos de barras o pasteles.
> - Esto ayudaría a ver rápidamente si se están incrementando o reduciendo las ventas, cartera, etc.
> - Es fundamental que la herramienta implemente gráficos.
> - Puede resultar conveniente conocer por qué canal los clientes realizan pagos.

> [!warning] Seguridad
> - Tienen cifrada toda la información que viaja con un algoritmo.
> - Prevención de ataques SQL Injection e intermediario.
> - Cumplimiento Ley de Protección de Datos.
> - Perfiles de usuario bien definidos.
> - Los clientes solo deben ser capaces de ver sus propios datos.

***