---
tags:
  - 📦DSW
  - 📝TAR
cssclasses:
  - center-titles
---

# Tarea Grupal #01

> [!info] Contexto
> **Sistema de alquiler de hospedaje HomeStay**
> - El sistema de alquiler de hospedaje HomeStay facilita la búsqueda, reserva y gestión de alojamientos temporales en diferentes ubicaciones a nivel del país.
> - Cada propiedad en el sistema puede tener múltiples unidades disponibles para alquiler, las cuales pueden variar en tipo (habitaciones privadas, departamentos completos, o casas).
> - Una unidad puede estar en uno de los siguientes estados: disponible, reservada, ocupada, en mantenimiento, o fuera de servicio.
> - Los usuarios pueden buscar propiedades según criterios como ubicación, precio, tipo de alojamiento, y servicios ofrecidos.
> - Una vez encontrada una opción adecuada, los usuarios pueden reservar la unidad por un período específico, sujeto a la disponibilidad y a las políticas de cancelación establecidas por el anfitrión.
> - Además, el sistema debe gestionar el cobro automático de depósitos de seguridad y tarifas adicionales, según corresponda.
> - Los anfitriones pueden establecer reglas específicas para sus propiedades, como horarios de check-in/check-out y restricciones de uso.
> - Las reseñas de los huéspedes son gestionadas de forma transparente, permitiendo que tanto anfitriones como huéspedes puedan calificar su experiencia.
> - El sistema también ofrece la opción de enviar notificaciones a través de distintos canales, como correo electrónico, SMS o aplicaciones de mensajería, para mantener a los usuarios informados sobre el estado de sus reservas o eventos importantes relacionados con su estancia.
> - Nuevos métodos de notificación pueden añadirse al sistema sin causar alteraciones significativas.
> - Para asegurar la calidad del servicio, el sistema debe manejar incidentes reportados por los huéspedes, los cuales son atendidos primero por el anfitrión; si no se resuelven, son escalados a un moderador de la plataforma, y finalmente al equipo de soporte legal para una resolución definitiva en casos críticos.
---

## Diagramas UML
> [!bug] Diagrama de Casos de Uso
> > [!person] Identificar Actores y Casos de Uso
> > 
> > - **Actor: Huésped**
> > Buscar propiedades
> > Reservar unidad
> > Calificar experiencia
> > Reportar incidente
> > 
> > - **Actor: Anfitrión**
> > Establecer políticas de cancelación
> > Establecer reglas de propiedad
> > Calificar experiencia
> > Atender incidente
> > 
> > - **Actor: Moderador**
> > Gestionar incidente escalado
> > 
> > - **Actor: Equipo de soporte legal**
> > Resolver incidente crítico
>
> > [!question] Identificar Refinamientos (Include/Extend)
> > Reservar unidad "include" Gestionar cobro automático
> > Reservar unidad "include" Enviar notificación
> > Reportar incidente "include" Enviar notificación
> > Atender incidente "include" Enviar notificación
> > Gestionar incidente escalado (Moderador) "extend" Atender incidente (Anfitrión)
> > Resolver incidente crítico (Equipo de soporte legal) "extend" Gestionar incidente escalado (Moderador)
> > Enviar notificación por correo "extend" Enviar notificación
> > Enviar notificación por SMS "extend" Enviar notificación
> > Enviar notificación por app de mensajería "extend" Enviar notificación
>
> ![[📦DSW 📝TAR 01 G1 - Image 01.excalidraw|100%]]
> 
> > [!info] Elegir 4 Casos de Uso Principales
> > 
> > - **Buscar Propiedades**
> > ***Actores involucrados:*** Huésped (Actor principal), Sistema.
> > ***Precondiciones:*** El Huésped debe tener acceso a la plataforma HomeStay (web o app).
> > ***Flujo principal de eventos:***
> > El Huésped introduce los criterios de búsqueda (ubicación, precio, tipo de alojamiento, servicios).
> > El Huésped inicia la acción de búsqueda.
> > El Sistema consulta la base de datos de propiedades y unidades.
> > El Sistema filtra los resultados basándose en los criterios del Huésped y en la disponibilidad (excluyendo las que están "fuera de servicio").
> > El Sistema presenta al Huésped una lista de las propiedades/unidades que coinciden con la búsqueda.
> > ***Flujos alternativos:***
> > A1: No se encuentran resultados. Si ningún alojamiento coincide con los criterios, el Sistema informa al Huésped que no hay resultados disponibles.
> > ***Postcondiciones:***
> > Éxito: Se muestra al Huésped la lista de propiedades coincidentes.
> > Fallo (A1): Se muestra al Huésped un mensaje indicando que no se encontraron propiedades.
> > 
> > - **Reservar Unidad**
> > ***Actores involucrados:*** Huésped (Actor principal), Sistema, Anfitrión (Actor secundario, recibe la notificación).
> > ***Precondiciones:***
> > El Huésped ha seleccionado una unidad específica y un rango de fechas.
> > La unidad debe estar en estado "disponible" para esas fechas.
> > El Huésped debe estar autenticado en el sistema (implícito para gestionar un pago).
> > El Huésped debe tener un método de pago válido asociado (implícito por "cobro automático").
> > ***Flujo principal de eventos:***
> > El Huésped selecciona la opción de reservar la unidad.
> > El Sistema verifica la disponibilidad final de la unidad y calcula el coste total (incluyendo depósitos de seguridad y tarifas adicionales).
> > El Sistema presenta el resumen del coste y solicita confirmación al Huésped.
> > El Huésped confirma la reserva.
> > El Sistema invoca el caso de uso "include" Gestionar cobro automático para procesar el depósito/pago.
> > El Sistema actualiza el estado de la unidad a "reservada" para las fechas seleccionadas.
> > El Sistema invoca el caso de uso "include" Enviar notificación para informar al Huésped (confirmación) y al Anfitrión (nueva reserva).
> > El Sistema muestra un mensaje de éxito de la reserva al Huésped.
> > ***Flujos alternativos:***
> > A1: Unidad deja de estar disponible. Si entre la búsqueda y la confirmación (paso 4) la unidad es reservada por otro usuario, el Sistema informa al Huésped y cancela el proceso.
> > A2: Falla el cobro automático. Si "include" Gestionar cobro automático falla (p.ej., fondos insuficientes), el Sistema informa al Huésped, la reserva no se crea y la unidad sigue "disponible".
> > A3: El Huésped no confirma. En el paso 4, el Huésped decide cancelar el proceso. El flujo termina sin crear la reserva.
> > Postcondiciones:
> > Éxito: Se crea la reserva, se procesa el cobro, el estado de la unidad se actualiza a "reservada" y se envían las notificaciones.
> > Fallo (A1, A2, A3): No se crea la reserva, no se realiza ningún cobro y el estado de la unidad permanece "disponible".
> > 
> > - **Calificar Experiencia**
> > ***Actores involucrados:*** Huésped o Anfitrión (Actor principal).
> > ***Precondiciones:***
> > Debe existir una reserva cuyo estado haya sido "ocupada" y ya haya finalizado (la estancia concluyó).
> > El actor (Huésped o Anfitrión) debe estar autenticado.
> > El período habilitado para dejar reseñas debe estar activo.
> > Flujo principal de eventos:
> > El actor (Huésped o Anfitrión) accede a la sección de reseñas de sus estancias pasadas.
> > El actor selecciona la estancia que desea calificar.
> > El actor proporciona una calificación (p.ej., puntuación) y/o un comentario sobre su experiencia.
> > El actor envía la calificación.
> > El Sistema valida y guarda la calificación en la base de datos, asociándola a la estancia, al anfitrión y al huésped.
> > El Sistema informa al actor que su calificación ha sido registrada.
> > ***Flujos alternativos:***
> > A1: Período de calificación expirado. Si el actor intenta calificar fuera del tiempo permitido, el Sistema informa que ya no es posible dejar una reseña.
> > ***Postcondiciones:***
> > Éxito: La calificación es registrada y almacenada "de forma transparente" por el sistema (lista para ser mostrada según las reglas de negocio).
> > Fallo (A1): No se registra ninguna calificación.
> > 
> > - **Reportar Incidente**
> > ***Actores involucrados:*** Huésped (Actor principal), Sistema, Anfitrión (Actor secundario, receptor inicial).
> > ***Precondiciones:***
> > El Huésped debe tener una reserva activa ("ocupada") o recién finalizada.
> > El Huésped debe estar autenticado.
> > ***Flujo principal de eventos:***
> > El Huésped selecciona la opción "Reportar incidente" asociada a su reserva.
> > El Huésped rellena un formulario detallando el incidente (descripción, tipo de problema, etc.).
> > El Huésped envía el reporte.
> > El Sistema registra el incidente en la plataforma.
> > El Sistema asigna el incidente al Anfitrión de la propiedad para su atención inicial.
> > El Sistema invoca el caso de uso "include" Enviar notificación para alertar al Anfitrión sobre el nuevo incidente y para confirmar la recepción al Huésped.
> > ***Flujos alternativos:***
> > A1: Reporte incompleto. Si el Huésped intenta enviar el formulario sin la información mínima requerida, el Sistema le solicita que complete los campos faltantes.
> > ***Postcondiciones:***
> > Éxito: Se crea un nuevo registro de incidente, se notifica al Anfitrión y al Huésped, y el incidente queda pendiente de la acción del Anfitrión (lo que inicia el caso de uso "Atender incidente").
> > Fallo (A1): No se crea el incidente.

> [!bug] Diagrama de Clases
> No hacer mucho caso a este boceto...
>
> ![[📦DSW 📝TAR 01 G1 - Image 02.excalidraw|100%]]

## Asunciones del Proyecto
// En el Doc
## Descripción de Casos de Uso
// ...
## Justificación de los principios SOLID
// ...