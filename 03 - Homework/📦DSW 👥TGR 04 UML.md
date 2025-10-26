---
tags:
  - 📦DSW
  - 👥TGR
cssclasses:
  - center-titles
---

# Taller Grupal #04
> [!info] Contexto
> Su tarea consiste en identificar el comportamiento de un sistema para una clínica que quiere un sistema interactivo para manejar interacciones entre sus pacientes y sus doctores.
> **Los requerimientos identificados hasta el momento son los siguientes:**
> - Un paciente puede solicitar una cita médica... 
> - ...y se le debe enviar un correo electrónico de confirmación con los datos de la cita.
> - Cuando el paciente asiste a la cita, debe esperar en una sala de espera hasta que la secretaria verifique que su cita aún está activa (al menos 10 minutos antes de la hora de la cita) y recibe el pago de la cita.
> - Luego, la secretaría lo deja pasar al consultorio del doctor cuando este se encuentre libre, es decir; sin otro paciente.
> - Cuando el paciente es atendido por el doctor, en caso de necesitar medicinas, la receta la imprime el doctor y además se envía al correo electrónico del paciente.
> - Por otro lado, el doctor puede añadir un plan nutricional en caso de que el paciente lo necesite.
> - El paciente después de ser atendido puede solicitar a la secretaria que le separe una nueva cita para otra fecha o los puede hacer por su propia cuenta.
> - Por otro lado, el paciente también puede suspender su cita hasta 2 horas antes de la misma.
> - El pago se puede realizar en efectivo, tarjeta de crédito/débito o PayPal.
> - Las consultas pueden ser a Medicina General con costo regular, o a un área específica (Endocrinología, Pediatría, Ginecología, Cardiología y Neurología) donde el costo de la consulta varia.
> - También se cuenta con un registro de pacientes por área en la que ha sido atendido con el respectivo médico, hora, fecha y diagnóstico.
> - Para poder acceder al sistema se debe estar registrado, cada usuario necesita un correo electrónico y contraseña, además de nombre, apellido, edad, historia clínica (Enfermedades, alergias, etc).
> - El doctor es quien puede registrar/eliminar a su secretaria,... 
> - ...también existe un administrador que es quien puede registrar a todos los usuarios y asignarles el rol correspondiente. 

> [!question] Actividad
> **Realice lo siguiente:**
> Elabore Diagrama de Casos de Uso utilizando una herramienta colaborativa como Visual Paradigm Online. Puede crear una cuenta gratuita utilizando su cuenta de FIEC y compartirlo con sus compañeros de grupo de forma simultánea. Desde el siguiente enlace puede ver 
> https://drive.google.com/file/d/1gO0RePlx6L21rDLVM2_CH9Shh6hp_mB2/view?usp=sharing
> Describa brevemente cada uno de los actores del sistema (principales y secundarios).
> Describa los casos de uso de “Solicitar cita” y “Ampliar tiempo de pago” en Word.
> Realice el Diagrama de Clases separando en 3 paquetes uno por cada capa de MVC, no olvide colocar relaciones, atributos y métodos importantes. Para las vistas y los controladores solo es necesario indicar los nombres de las clases, en los modelos si se debe detallar cada clase.
> Subir ambos archivos en un solo archivo ZIP o RAR a la plataforma Sidweb.

> [!tip] Casos de Uso del Paciente:
> 
> - [x] **Solicitar Cita Médica**
> - [x] **Suspender Cita**
> - [x] **Realizar Pago de Cita**
> - [x] **Recibir Correo de Confirmación de Cita** 
> - [x] **Recibir Receta Médica por Correo** 
> - [x] **Registrarse en el Sistema**
> - [x] **Iniciar Sesión**

> [!tip] Casos de Uso del Doctor:
> 
> - [x] **Imprimir Receta Médica**
> - [x] **Enviar Receta Médica por Correo**
> - [x] **Añadir Plan Nutricional**
> - [x] **Registrar Secretaria**
> - [x] **Eliminar Secretaria**
> - [x] **Registrar Diagnóstico y Detalles de Atención**
> - [x] **Iniciar Sesión**

> [!tip] Casos de Uso de la Secretaria:
> - [x] **Verificar Cita Activa**
> - [x] **Recibir Pago de Cita**
> - [x] **Permitir Acceso a Consultorio**
> - [x] **Separar Nueva Cita para Paciente**
> - [x] **Registrar Paciente**
> - [x] **Iniciar Sesión**

> [!tip] Casos de Uso del Administrador:
> - [x] **Registrar Usuario**
> - [x] **Asignar Rol de Usuario**
> - [x] **Iniciar Sesión**

> [!bug] Preview
> ![[📦DSW 👥TGR 04 UML Case Use.excalidraw|100%]]