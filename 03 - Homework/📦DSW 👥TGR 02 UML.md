---
tags:
  - 📦DSW
  - 👥TGR
cssclasses:
  - center-titles
---

# Análisis de Requisitos para Sales-Bot

---

## 1. Contexto y Propósito

> [!info] Entrevista clave
> **Entrevistado:** Marco Jarrín - Gerente de Soluciones Integrales OMNISOFT (Empresa especializada en el desarrollo de soluciones informáticas totalmente basadas en la tecnología de Internet.)
> **Propósito:** Explorar procesos actuales y viabilidad de un Sales-Bot para gestión de ventas, facturación y cartera

> [!example] **Proyecto:** SalesBot.
> Administro el área de Ventas y llevo el control de toda la facturación y recaudación de la empresa.
> Nuestra área está enfocada en dar información precisa del estado de cuenta de un cliente, tener la cartera de la empresa por edades, el monto recaudado en un año comparado con el anterior, la tasa mensual de incremento o decremento de cartera vencida, los datos de facturación y pagos para hacer una proyección de ingresos en el siguiente periodo.
> Necesito una solución digital que nos permita tener esta información de forma rápida, eficaz, nos alerte con indicadores basados en criterios definidos previamente y me permita como área tener un seguimiento personalizado de los procesos que se llevan y son críticos

---

## 2. Hallazgos Principales

### 2.1 Procesos Actuales

> [!success] Integración existente
> - Sistema contable como núcleo central
> - Facturación electrónica obligatoria (SRI)
> - Desarrollo interno para seguridad y control
> - Nexo transaccional como requisito legal

### 2.2 Interés en Chatbots

| Tipo de Usuario | Necesidades Específicas | Canales Preferidos |
|-----------------|-------------------------|-------------------|
| **Clientes Finales** | Estado de cuenta, facturas, pagos | WhatsApp, Chatbot embebido |
| **Tomadores de Decisión** | Análisis, proyecciones, alertas | APIs Meta/Google, Dashboard |

> [!tip] Tecnología recomendada
> GitHub + APIs de IA (Gemini, ChatGPT, DeepSeek) para desarrollo

---

## 3. Diseño del Flujo del Chatbot

### 3.1 Identificación y Personalización

> [!info] Flujo de identificación
> - Identificación del usuario al inicio
> - Personalización de respuestas según perfil
> - Personalidad del bot: amigable y con género definido

> [!example] Ejemplos de Consultas Útiles
> **Clientes**:
> - "¿Cuál es mi saldo actual?"
> - "¿Puedo ver mis facturas pendientes?"
> 
> **Gerentes**:
> - "Comparativo facturación mes actual vs anterior"
> - "Estado de cartera vencida"
> - "Proyección de ingresos del trimestre"

---

## 4. Requisitos de Seguridad y Visualización

### 4.1 Seguridad de Datos

> [!warning] Consideraciones críticas
> - **Cifrado obligatorio** de datos
> - Prevención de ataques SQL e intermediario
> - Cumplimiento Ley de Protección de Datos
> - Perfiles de usuario bien definidos

### 4.2 Visualización e Indicadores

| Indicador Clave | Tipo de Visualización | Frecuencia |
|-----------------|----------------------|------------|
| Cartera vencida | Gráficos de barras | Tiempo real |
| Facturación comparativa | Gráficos históricos | Mensual |
| Medios de pago | Gráficos de pastel | Semanal |
| Proyección ingresos | Líneas de tendencia | Trimestral |

---

## 5. Customer Journey Map

### 5.1 Cliente Final

| Etapa | Acciones del Usuario | Objetivo | Experiencias Positivas ✅ | Puntos de Dolor ❌ | Oportunidades para IA |
|-------|---------------------|----------|-------------------------|-------------------|----------------------|
| **Revisión Financiera** | Revisar estado de cuentas pendientes | Conocer obligaciones financieras | Acceso rápido al saldo actual | Dificultad para entender estados de cuenta | Explicación clara de conceptos financieros |
| **Consulta Específica** | Buscar facturas específicas o detalles de transacciones | Encontrar información concreta | Búsqueda intuitiva por múltiples criterios | Tiempo perdido en buscar documentos | Búsqueda semántica y contextual |
| **Verificación de Pagos** | Confirmar aplicación de pagos realizados | Validar que pagos fueron aplicados | Confirmación inmediata de aplicación | Incertidumbre sobre procesamiento | Notificaciones automáticas de estado |
| **Solicitud de Soporte** | Plantear dudas o problemas con facturas | Resolver incidencias específicas | Respuestas personalizadas y útiles | Tiempo de espera en respuestas | Resolución inmediata de consultas comunes |
| **Planificación de Pagos** | Evaluar opciones y fechas de pago | Organizar calendario de pagos | Recomendaciones de fechas óptimas | Falta de claridad en consecuencias | Simulaciones de escenarios de pago |
| **Gestión Documental** | Descargar y organizar comprobantes | Tener documentos organizados | Descarga masiva y organizada | Dificultad para encontrar documentos antiguos | Organización automática por categorías |
| **Seguimiento Continuo** | Monitorear cambios en el estado de cuenta | Mantener control financiero | Alertas proactivas de cambios | Falta de notificaciones importantes | Alertas predictivas y personalizadas |

### 5.2 Tomador de Decisión (Gerente/Director)

| Etapa | Acciones del Usuario | Objetivo | Experiencias Positivas ✅ | Puntos de Dolor ❌ | Oportunidades para IA |
|-------|---------------------|----------|-------------------------|-------------------|----------------------|
| **Monitoreo Diario** | Revisar indicadores clave de rendimiento | Mantener control operativo | Dashboard con métricas en tiempo real | Datos desactualizados o inconsistentes | Consolidación automática de fuentes múltiples |
| **Análisis de Tendencia** | Evaluar patrones y tendencias del negocio | Identificar oportunidades y riesgos | Visualizaciones claras de tendencias | Dificultad para identificar patrones | Detección automática de anomalías y patrones |
| **Evaluación de Cartera** | Analizar estado de cuentas por cobrar | Optimizar gestión de cobranza | Segmentación clara por antigüedad | Falta de alertas tempranas de mora | Alertas predictivas de riesgo de cartera |
| **Proyección Financiera** | Estimar flujos futuros de ingresos | Planificar recursos y presupuestos | Proyecciones basadas en datos históricos | Incertidumbre en proyecciones | Modelos predictivos con múltiples escenarios |
| **Toma de Decisiones** | Evaluar alternativas y consecuencias | Tomar decisiones informadas | Análisis de impacto de decisiones | Falta de datos para evaluar opciones | Simulaciones de impacto de decisiones |
| **Gestión de Excepciones** | Revisar y resolver casos especiales | Manejar situaciones atípicas | Identificación automática de excepciones | Tiempo perdido en casos menores | Priorización inteligente de excepciones |
| **Reporteo Ejecutivo** | Generar reportes para stakeholders | Comunicar resultados y planes | Generación automática de reportes | Tiempo excesivo en preparación de reportes | Reportes adaptativos según audiencia |

---

## 6. Oportunidades de Valor Agregado con IA

### 6.1 Para Clientes Finales

> [!tip] Funcionalidades inteligentes
> - **Reconocimiento de voz** para consultas naturales
> - **Recordatorios contextuales** de pagos basados en historial
> - **Recomendaciones personalizadas** de planes de pago
> - **Detección proactiva** de errores en facturas

### 6.2 Para Tomadores de Decisión

> [!success] Capacidades avanzadas
> - **Análisis predictivo** de comportamiento de clientes
> - **Alertas tempranas** de tendencias negativas
> - **Recomendaciones estratégicas** basadas en datos históricos
> - **Automatización** de reportes recurrentes

---

## 7. Recomendaciones de Implementación

> [!success] Roadmap de desarrollo
> 1. **Fase 1:** Funcionalidades básicas de consulta para clientes
> 2. **Fase 2:** Dashboard básico para gerentes con métricas clave
> 3. **Fase 3:** Integración de IA para recomendaciones simples
> 4. **Fase 4:** Capacidades predictivas y analíticas avanzadas
> 5. **Fase 5:** Optimización continua basada en feedback de usuarios

### 7.1 Métricas de Éxito por Etapa

| Etapa | Métrica Cliente | Métrica Gerente | Objetivo |
|-------|----------------|-----------------|----------|
| **Inicial** | Tiempo de respuesta < 2 min | Acceso a 5 KPIs básicos | 80% satisfacción |
| **Intermedia** | 50% reducción consultas manuales | 30% mejora en detección temprana | 85% satisfacción |
| **Avanzada** | 70% autoservicio exitoso | 50% mejora en precisión predictiva | 90% satisfacción |

> [!warning] Consideraciones críticas
> - **Privacidad de datos** como prioridad absoluta
> - **Escalabilidad** para crecimiento de usuarios
> - **Experiencia de usuario** intuitiva y accesible
> - **Integración fluida** con sistemas existentes

---

> [!success] Próximos Pasos Inmediatos
> 1. Priorizar las 3 principales oportunidades de IA identificadas
> 2. Diseñar prototipos para las etapas de mayor valor
> 3. Establecer métricas específicas para cada etapa del journey
> 4. Desarrollar plan de pruebas con usuarios reales
> 5. Crear roadmap detallado de implementación por fases

> [!info] Validación continua
> El customer journey map debe ser un documento vivo que se actualice regularmente basado en el feedback real de los usuarios y el desempeño de la IA implementada.
> 
> ![[🎨IHC 📝TAR 03 CustomerJourneyMap.excalidraw|100%]]

