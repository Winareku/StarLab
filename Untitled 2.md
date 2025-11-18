# 🗃️ SBD - Procedimientos Esenciales para Exámenes

---

## 1. Procedimiento: Diseño del Modelo Conceptual (ER)

### 1.1 Identificar Entidades
- **Buscar sustantivos** en el enunciado que representen objetos del mundo real
- **Ejemplo**: "estudiante", "escuela", "concurso", "profesor", "premio"

### 1.2 Identificar Atributos
- **Para cada entidad**, listar sus características
- **Clasificar atributos**:
  - **Simple**: cédula, nombre, fecha
  - **Compuesto**: dirección (calle, ciudad)
  - **Multivalor**: teléfonos (varios números)
  - **Derivado**: edad (se calcula de fecha_nacimiento)

### 1.3 Definir Claves Primarias
- **Escoger atributo único** para cada entidad
- **Si no existe**, crear ID artificial
- **Ejemplo**: `Estudiante(cedula, nombres, apellidos, fecha_nacimiento)`

### 1.4 Identificar Relaciones
- **Buscar verbos** entre entidades
- **Determinar cardinalidad**:
  - **1:1**: Un empleado tiene un vehículo
  - **1:N**: Una escuela tiene muchos estudiantes  
  - **N:M**: Un estudiante participa en muchos concursos, un concurso tiene muchos estudiantes

### 1.5 Especialidades
- **Relaciones recursivas**: Empleado supervisa Empleado
- **Supertipo/Subtipo**: Cliente → Persona Natural, Empresa
- **Entidades débiles**: Dependiente no existe sin Empleado

---

## 2. Procedimiento: Transformación a Modelo Lógico

### 2.1 Conversión de Entidades
```
Regla: Cada entidad → Tabla
Atributos → Columnas
PK conceptual → PK lógica
```

**Ejemplo**:
```
ESTUDIANTE(
  cedula PK VARCHAR(10),
  nombres VARCHAR(50),
  apellidos VARCHAR(50),
  fecha_nacimiento DATE
)
```

### 2.2 Conversión de Relaciones

#### Relación 1:1
```sql
-- Opción 1: Fusionar tablas
EMPLEADO(id_empleado PK, nombre, matricula_vehiculo FK)

-- Opción 2: Clave foránea en una tabla
EMPLEADO(id_empleado PK, nombre, id_vehiculo FK)
VEHICULO(id_vehiculo PK, placa, modelo)
```

#### Relación 1:N
```sql
-- PK del lado "1" → FK del lado "N"
ESCUELA(id_escuela PK, nombre, direccion)
ESTUDIANTE(cedula PK, nombres, id_escuela FK)  -- FK a ESCUELA
```

#### Relación N:M
```sql
-- Crear tabla intermedia
ESTUDIANTE(cedula PK, nombres)
CONCURSO(id_concurso PK, nombre)
INSCRIPCION(cedula PK/FK, id_concurso PK/FK, fecha_inscripcion)
```

### 2.3 Casos Especiales

#### Atributos Multivalorados
```sql
-- Crear tabla separada
ESTUDIANTE(cedula PK, nombres)
TELEFONO(cedula PK/FK, telefono PK)
```

#### Relaciones Ternarias
```sql
EVALUACION(
  id_profesor PK/FK,
  cedula_estudiante PK/FK, 
  id_concurso PK/FK,
  calificacion,
  fecha
)
```

#### Supertipo/Subtipo
```sql
-- Opción {Obligatorio, Disjunto}
PERSONA(id_persona PK, tipo ENUM('Natural','Juridica'))
PERSONA_NATURAL(id_persona PK/FK, cedula)
EMPRESA(id_persona PK/FK, ruc)
```

---

## 3. Procedimiento: Normalización hasta 3FN

### 3.1 Identificar Dependencias Funcionales
- **Analizar**: ¿Qué atributos determinan a otros?
- **Ejemplo**: 
  - `cedula → nombre, fecha_nacimiento`
  - `(cedula, id_concurso) → fecha_inscripcion, calificacion`

### 3.2 Aplicar 1FN
**Condición**: Atributos atómicos, sin grupos repetitivos

```sql
-- ❌ NO 1FN
VENTA(id_venta, productos) -- productos = "Lapiz, Borrador, Regla"

-- ✅ 1FN
VENTA(id_venta)
DETALLE_VENTA(id_venta FK, producto, cantidad)
```

### 3.3 Aplicar 2FN
**Condición**: Para claves compuestas, dependencia completa

```sql
-- ❌ NO 2FN (LugarTrabajo depende solo de Empleado)
EMPLEADO_HABILIDAD(empleado PK, habilidad PK, LugarTrabajo)

-- ✅ 2FN
EMPLEADO(empleado PK, LugarTrabajo)
HABILIDAD_EMPLEADO(empleado PK/FK, habilidad PK)
```

### 3.4 Aplicar 3FN
**Condición**: Eliminar dependencias transitivas

```sql
-- ❌ NO 3FN (Ciudad → Departamento)
EMPLEADO(id_empleado, nombre, ciudad, departamento)

-- ✅ 3FN
EMPLEADO(id_empleado, nombre, ciudad)
CIUDAD(ciudad PK, departamento)
```

### 3.5 Proceso Completo de Ejemplo
**Tabla inicial**:
```sql
VENTA(vendedor_id PK, producto_id PK, fecha PK, 
      vendedor_nombre, producto_nombre, precio, cantidad)
```

**Dependencias**:
- `(vendedor_id, producto_id, fecha) → cantidad`
- `vendedor_id → vendedor_nombre`
- `producto_id → producto_nombre, precio`

**3FN resultante**:
```sql
VENDEDOR(vendedor_id PK, vendedor_nombre)
PRODUCTO(producto_id PK, producto_nombre, precio)
VENTA(vendedor_id PK/FK, producto_id PK/FK, fecha PK, cantidad)
```

---

## 4. Checklist para Exámenes

### ✅ Modelo Conceptual
- [ ] Todas las entidades identificadas
- [ ] Atributos correctamente clasificados
- [ ] PK definida para cada entidad
- [ ] Relaciones con cardinalidad correcta
- [ ] Reglas de negocio representadas

### ✅ Modelo Lógico
- [ ] Cada entidad → tabla
- [ ] Relaciones 1:N → FK en tabla "hijo"
- [ ] Relaciones N:M → tabla intermedia
- [ ] Atributos multivalor → tabla separada
- [ ] Tipos de datos apropiados

### ✅ Normalización
- [ ] 1FN: Atributos atómicos
- [ ] 2FN: Dependencia completa de clave compuesta
- [ ] 3FN: Sin dependencias transitivas
- [ ] Dependencias funcionales identificadas

---

> 💡 **Consejo para exámenes**: Comienza siempre leyendo cuidadosamente el enunciado, subrayando sustantivos (entidades) y verbos (relaciones). Sigue estos procedimientos paso a paso y verifica con el checklist final.