---
tags:
  - 🎨IHC
  - 📝TAR
cssclasses:
  - center-titles
---

# Proyecto de Sales-Bot

---
## 0. Detalles de la Entrevista
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
## 1. Journey Map
> [!success] 1. Solicitud de Reporte
> El ERP realiza correctamente las solicitudes.

> [!failure] 2. Extracción de Datos Contables
> 

> [!success] 3. Validación y Supervisión de Datos

> [!failure] 4. Envío de Datos

> [!success] 5. Cálculo de Indicadores

> [!failure] 6. Detección de Criticidad en Cartera

> [!failure] 7. Creación de Gráfica e Informe

> [!success] 8. Envío y Presentación de Documentos

> [!tip] Redefinición del Problema
> Hemos notado que el área de ventas necesita acceder de forma rápida y eficaz a información precisa sobre estados de cuenta, cartera, comparación de recaudación anual, y proyección de ingresos, con alertas automáticas y seguimiento de procesos críticos, pero actualmente carecen de una herramienta digital que entregue esos datos de manera inmediata, y los procesos existentes, como el ERP, no permiten una visualización unificada ni respuestas ágiles a consultas específicas. Si esto continúa, el administrador de ventas no podrá tomar decisiones oportunas basadas en datos actualizados y se dificultará la proyección precisa de ingresos, afectando tanto la eficiencia operativa del área como la capacidad de la empresa y optimizar su flujo. ¿Cómo podemos diseñar una solución digital centrada en experiencia de usuario que integre gráficas, un asistente conversacional con IA y alertas automatizadas, manteniendo los estándares de seguridad y segmentación de perfiles?

***

## 2. Diagrama de Afinidad

> [!example] Perfil del Usuario y Contexto Operativo
> 
> - Marco Jarrín es Gerente de Soluciones Integrales con 25 años de experiencia.
>     
> - La empresa desarrolla y utiliza un ERP propio con módulos integrados.
>     
> - Operan en un entorno de alta seguridad con sistemas cifrados.
>     
> - Evitan depender de servicios de terceros para proteger datos sensibles.
>     
> - Interactúan con clientes y tomadores de decisiones internos.
>     
> - Valoran la seguridad, el control interno y el cumplimiento legal (SRI, Ley de Datos).
>     

> [!example] Necesidades y Dolor Principal
> 
> - La información está centralizada, pero no es rápida de acceder ni en tiempo real.
>     
> - No todos los usuarios tienen acceso inmediato e intuitivo a indicadores.
>     
> - Falta una herramienta ágil para consultas rápidas de ventas y cartera.
>     
> - Dificultad para personalizar el seguimiento de procesos críticos.
>     
> - Los procesos de facturación y recaudación son lentos y poco visuales.
>     
> - Preocupación por la dependencia de procesos manuales para reportes.
>     

> [!example] Objetivos y Metas de IA
> 
> - Implementar un chatbot con IA para acelerar consultas de ventas y cartera.
>     
> - Reducir el tiempo de respuesta a menos de 30 segundos en consultas clave.
>     
> - Lograr que el 50% de las consultas se realicen por WhatsApp/IA en 6 meses.
>     
> - Mantener una tasa de éxito del 80% sin necesidad de escalamiento.
>     
> - Agilizar decisiones financieras con datos visuales en tiempo real.
>     
> - Ofrecer servicios más automatizados y modernos a instituciones educativas.
>     

> [!example] Características Deseadas en la Solución
> 
> - Chatbot con lenguaje natural, sin menús complejos.
>     
> - Integración con WhatsApp como canal principal.
>     
> - Segmentación de usuarios para respuestas personalizadas.
>     
> - Gráficos consolidados en una sola pantalla (barras, pasteles).
>     
> - Alertas automáticas basadas en criterios predefinidos.
>     
> - Reconocimiento de voz y reportes automáticos.
>     

> [!example] Requisitos de Seguridad y Personalización
> 
> - La IA debe adaptarse al perfil y rol del usuario.
>     
> - Los clientes solo pueden ver sus propios datos.
>     
> - Cumplimiento estricto de la Ley de Protección de Datos.
>     
> - Perfiles de usuario bien definidos y acceso segmentado.
>     
> - Prevención de ataques (SQL Injection, intermediario).
>     
> - Chatbot con personalidad profesional y adaptable.
>     

> [!example] Proceso de Implementación y Validación
> 
> - Realizar pruebas con usuarios para refinar herramientas.
>     
> - Definir procesos paso a paso para implementar chatbots.
>     
> - Validar flujo y usabilidad con prototipos.
>     
> - Añadir preguntas de satisfacción de uso post-implementación.
>     
> - Fase actual: exploración de IA, sin implementación real.
>     
> - Interés en probar el chatbot con usuarios antes de la implementación final.


***

## 3. Hallazgos y Principios de Diseño

### Hallazgos
> [!warning] Hallazgos Críticos
> - Acceso ineficiente a datos: La información está centralizada pero no es rápida ni intuitiva de acceder
> - Falta de visualización unificada: No existe una vista consolidada en tiempo real de indicadores clave
> - Procesos manuales lentos: La facturación y recaudación dependen de procesos manuales que consumen tiempo
> - Segmentación insuficiente: No hay personalización basada en perfiles de usuario (clientes vs tomadores de decisiones)
> - Barreras de usabilidad: La seguridad robusta dificulta la accesibilidad para algunos usuarios
> - Falta de automatización: No hay alertas automáticas ni proyecciones inteligentes

### Concepto de Diseño
> [!success] Concepto Central: "SalesBot Intelligence"
> **Visión**: Un asistente conversacional inteligente que democratiza el acceso a datos financieros críticos mediante interfaces naturales y seguras, transformando datos complejos en insights accionables para todos los perfiles de usuario.
> 
> Elementos clave del concepto:
> - Interacción natural: Chatbot con lenguaje natural que elimina barreras técnicas
> - Visualización unificada: Dashboard consolidado con gráficos claros y en tiempo real
> - Segmentación inteligente: Respuestas y vistas adaptadas al perfil del usuario
> - Seguridad transparente: Protección robusta sin comprometer la usabilidad
> - Multiplataforma: Acceso through canales familiares (WhatsApp, web, APIs)

### Principios de Diseño
> [!example] Principios de Diseño para SalesBot
> 
> - La solución permite al usuario acceder a información crítica de ventas y cartera en menos de 30 segundos
> - La solución permite visualizar tendencias financieras mediante gráficos consolidados en una sola vista
> - La solución permite adaptar las respuestas y funcionalidades según el perfil y rol del usuario
> - La solución permite interactuar mediante lenguaje natural sin requerir conocimientos técnicos
> - La solución permite mantener la seguridad y privacidad de datos sin comprometer la experiencia de usuario
> - La solución permite recibir alertas proactivas basadas en criterios predefinidos del negocio
> - La solución permite integrarse con canales existentes (WhatsApp, web) de forma transparente
> - La solución permite validar y refinar funcionalidades mediante pruebas iterativas con usuarios reales