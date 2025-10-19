---
fecha: 2025-10-17
tags:
  - 🎨IHC
  - 📝TAR
---

# 📋 Resumen de la Entrevista

**Entrevistado:** Marco Jarrín – Gerente de Soluciones en empresa de software con experiencia en desarrollo de sistemas integrados (contabilidad, ventas, inventario, académico).  
**Propósito de la entrevista:** Explorar procesos actuales, necesidades de automatización y viabilidad de un Sales-Bot para gestión de ventas, facturación y cartera.

---

## 🧩 Hallazgos Clave

### 1. **Procesos Actuales y Herramientas**

- Todo el sistema contable, de ventas e inventario está **integrado**.
- La **contabilidad es el núcleo** del sistema.
- El **SRI exige facturación electrónica** y el **nexo transaccional**, lo que obliga a las empresas a mantener sistemas actualizados.
- Desarrollan sus propias soluciones desde cero, sin terceros, para garantizar **seguridad y control de datos**.

### 2. **Interés en Chatbots / Asistentes Virtuales**

- Mostró interés en un chatbot con **dos tipos de usuarios**:
    - **Clientes finales**: consultas sobre estado de cuenta, facturas, pagos.
    - **Tomadores de decisiones** (gerentes, directores, tesorería): consultas analíticas y de gestión.
- **Canales sugeridos**: WhatsApp, chatbot embebido, APIs de Meta/Google.
- **Tecnología recomendada**: GitHub, APIs de IA (Gemini, ChatGPT, DeepSeek).

### 3. **Diseño del Flujo del Chatbot**

- **Identificación del usuario** al inicio para personalizar respuestas.
- **Ejemplos de consultas útiles**:
    - Estado de cuenta de un cliente.
    - Comparativo de facturación mes actual vs. anterior.
    - Identificación de activos/pasivos.
- **Personalidad del bot**: debe ser **amigable y con género definido**.
- **Pruebas con usuarios** para refinar el flujo y las funcionalidades.

### 4. **Indicadores Clave y Visualización**

- **Cartera vencida** es un **dolor frecuente**.
- Necesidad de **visualización gráfica** en tiempo real:
    - Gráficos de barras (facturación vs. años anteriores).
    - Gráficos de pastel (medios de pago, distribución de cartera).
- Información relevante:
    - Monto facturado.
    - Evolución de cartera.
    - Medios de pago utilizados.
    - Proyecciones de ingresos.

### 5. **Seguridad y Privacidad**

- **Cifrado de datos** es obligatorio (evitar ataques SQL, hombre en el medio).
- **Perfiles de usuario** bien definidos para restringir acceso.
- Cumplimiento de la **Ley de Protección de Datos**.
- Diferenciar entre:
    - Datos específicos de un cliente (ej: “Juan Pérez debe $1000”).
    - Información agregada para gerentes (ej: “1000 clientes en mora”).

---

## 🎯 Alineación con el Proyecto Sales-Bot

|Necesidad del Sales-Bot|Cómo se aborda según la entrevista|
|---|---|
|Información precisa del estado de cuenta|Chatbot identifica usuario y responde según perfil.|
|Control de cartera por edades|Gráficos comparativos y alertas de cartera vencida.|
|Montos recaudados vs. año anterior|Gráficos de barras comparativos.|
|Tasa de incremento/decremento de cartera|Indicadores visuales en dashboard.|
|Proyección de ingresos|Análisis de datos históricos y tendencias.|
|Alertas basadas en criterios|Reglas de negocio según perfil y datos en tiempo real.|
|Seguimiento personalizado|Flujos diferenciados para clientes y gerentes.|

---

## 💡 Recomendaciones para el Sales-Bot

1. **Definir dos flujos claros**:
    - **Cliente**: consultas simples (estado de cuenta, facturas).
    - **Gerente**: informes, proyecciones, alertas.
2. **Incluir gráficos en respuestas para gerentes**:
    - Usar APIs de generación de gráficos (ej: Chart.js, QuickChart).
3. **Implementar autenticación y roles**:
    - Asegurar que cada usuario solo acceda a lo permitido.
4. **Usar IA para respuestas naturales**:
    - Integrar con modelos como DeepSeek o GPT para mejorar interacción.
5. **Pruebas con usuarios reales** antes del lanzamiento.

---

## 🗂️ Posibles Próximos Pasos

- Diseñar el flujo de conversación para ambos perfiles.
- Prototipar interfaz de dashboard gerencial.
- Definir reglas de alertas (ej: “si cartera > 30 días, notificar”).
- Estudio de herramientas de cifrado y compliance con ley de datos.