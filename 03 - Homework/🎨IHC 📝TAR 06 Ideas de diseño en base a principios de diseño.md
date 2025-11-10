---
tags:
  - 🎨IHC
  - 📝TAR
cssclasses:
  - center-titles
---

# Ideas de diseño en base a principios de diseño | Individual | 45 minutos

> [!success] Información Necesaria
> [[🎨IHC 📝NOT 04 Generación de Ideas|Guía de Generación de Ideas]]
> [[🎨IHC 🚀PRO SalesBot|Tomar Principios de Diseño]]

> [!warning] Completar
> 1. Revise los principios de diseño de su proyecto y, por cada principio, dibuje **al menos una idea** para resolver el problema que el principio propone.
> > [!example] Ejemplo:
> > Si el principio para una app de compras de muebles en línea es: "La solución permite al usuario determinar si un mueble es adecuado para su hogar", una forma de resolverlo puede ser permitir al usuario subir una foto de su hogar y visualizar el mueble dentro de esa imagen.
> 2. Con sus dibujos de ideas, complete su [Entrega Individual](https://docs.google.com/document/d/1WY_tnroAzA0SdrINvyPHbOImRQIjPFTZ/edit#heading=h.jsbv9aug20xa) en la sección.

> [!bug] Entregar
> - URL de su portafolio con su [Entrega Individual de la sección 8 - Ideación y Concepto Final](https://docs.google.com/document/d/1WY_tnroAzA0SdrINvyPHbOImRQIjPFTZ/edit#heading=h.jsbv9aug20xa) completa.

---

> [!example] Resolución
> 
> > [!note] **Principio 1:** La solución permite al usuario acceder a información crítica de ventas y cartera en menos de 30 segundos
> > **Idea 1:** Comando de voz o texto rápido para consultas predefinidas.
> > **Descripción idea 1:** Implementar un sistema de "atajos" conversacionales donde el usuario pueda usar comandos específicos de voz o texto (ej: "estado cuenta Cliente X", "cartera vencida junio") para obtener respuestas inmediatas, sin navegar por menús. El sistema prioriza el procesamiento de estos comandos para garantizar una respuesta ultrarrápida, cacheando datos frecuentes y usando plantillas de respuesta pregeneradas para las consultas más comunes.
> 
> > [!note] **Principio 2:** La solución permite visualizar tendencias financieras mediante gráficos consolidados en una sola vista
> > **Idea 2:** Dashboard personalizable con widgets gráficos arrastrables.
> > **Descripción idea 2:** Diseñar una pantalla de inicio principal que funcione como un "dashboard" o tablero de control. Este dashboard mostraría por defecto los gráficos clave (barras de recaudación anual comparada, pastel de cartera por edades, línea de proyección de ingresos). El usuario podrá personalizar esta vista arrastrando, añadiendo o eliminando "widgets" gráficos según sus necesidades de monitoreo específicas, teniendo siempre una visión unificada en una sola pantalla.
> 
> > [!note] **Principio 3:** La solución permite adaptar las respuestas y funcionalidades según el perfil y rol del usuario
> > **Idea 3:** Perfiles adaptativos con "Vistas Espejo".
> > **Descripción idea 3:** Al iniciar sesión, el sistema identifica automáticamente si el usuario es un "Cliente" o un "Tomador de Decisiones". Para un Cliente, el SalesBot y la interfaz visual solo mostrarán opciones y datos relacionados con su propia cuenta (ej: "Mis Facturas", "Mi Estado de Pago"). Para un Tomador de Decisiones, se desplegará toda la gama de funcionalidades administrativas y datos agregados de la empresa. Es como si el sistema se "reflejara" de forma distinta para cada perfil.
> 
> > [!note] **Principio 4:** La solución permite interactuar mediante lenguaje natural sin requerir conocimientos técnicos
> > **Idea 4:** Asistente con "Entrenador de Consultas".
> > **Descripción idea 4:** El SalesBot incluirá un módulo de ayuda que sugiere al usuario, en lenguaje sencillo, cómo formular sus preguntas para obtener mejores resultados (ej: "Puede preguntarme: '¿Cuánto se ha facturado este trimestre?' o 'Muéstrame los clientes con mora mayor a 90 días'"). Esto "entrena" al usuario para que interactúe de manera efectiva sin necesidad de conocer términos técnicos o estructuras de base de datos, haciendo la experiencia más intuitiva y reduciendo la frustración.
> 
> > [!note] **Principio 5:** La solución permite mantener la seguridad y privacidad de datos sin comprometer la experiencia de usuario
> > **Idea 5:** Autenticación contextual y de un solo toque (SSO) con confirmación transparente.
> > **Descripción idea 5:** Integrar un sistema de inicio de sesión único (Single Sign-On) que utilice las credenciales existentes del ERP de la empresa. Para operaciones sensibles (como visualizar datos de un cliente específico), el sistema realizará una "autenticación contextual" silenciosa en segundo plano, verificando los permisos del usuario sin interrumpir su flujo. Solo en casos de alto riesgo pediría una confirmación explícita, pero de forma clara y sencilla, sin capas de seguridad redundantes que entorpezcan la usabilidad diaria.
> 
> > [!note] **Principio 6:** La solución permite recibir alertas proactivas basadas en criterios predefinidos del negocio
> > **Idea 6:** Panel de "Reglas de Alerta" configurables por el usuario.
> > **Descripción idea 6:** Crear una sección dentro del sistema donde el administrador pueda definir y configurar fácilmente las condiciones para las alertas (ej: "Notificarme si la cartera vencida crece más de un 5% mensual", "Alertar si un cliente supera su línea de crédito"). El SalesBot enviaría entonces estas alertas de forma proactiva a través del canal preferido (WhatsApp, correo, notificación en el dashboard), sin que el usuario tenga que buscarlas activamente.
> 
> > [!note] **Principio 7:** La solución permite integrarse con canales existentes (WhatsApp, web) de forma transparente
> > **Idea 7:** Núcleo de IA unificado con "Conectores de Canal".
> > **Descripción idea 7:** Diseñar la arquitectura del SalesBot con un núcleo central de inteligencia artificial que procese todas las solicitudes. Este núcleo se conectaría a través de "conectores" o APIs específicas a diferentes canales (WhatsApp Business API, ventana de chat web, aplicación móvil). Para el usuario, la experiencia y las capacidades del bot serán idénticas sin importar el canal que use, garantizando una transición fluida entre ellos (ej: empezar una consulta en WhatsApp y terminarla en la web sin perder el contexto).
> 
> > [!note] **Principio 8:** La solución permite validar y refinar funcionalidades mediante pruebas iterativas con usuarios reales
> > **Idea 8:** Panel de "Feedback Iterativo" integrado en el SalesBot.
> > **Descripción idea 8:** Después de ciertas interacciones clave o de forma periódica, el SalesBot pedirá automáticamente una valoración simple (ej: "¿Esta respuesta fue útil? Sí/No" o una calificación de 1 a 5 estrellas). Incluirá también una opción de "Sugerir Mejora" que permita al usuario describir libremente su idea. Este feedback se recopilará en un panel para el equipo de diseño, permitiendo identificar puntos de fricción y oportunidades de mejora de forma continua y basada en datos reales de uso.