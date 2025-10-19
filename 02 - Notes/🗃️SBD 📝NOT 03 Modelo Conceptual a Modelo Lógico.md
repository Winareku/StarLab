---
tags:
  - 🗃️SBD
  - 📝NOT
---
---

# Tablas, Columnas, Filas y Campos
## Modelo Lógico
- El modelo lógico es el refinamiento del Modelo Conceptual.
- Aquí se reducen y/o aumnentan entidades y solo quedan aquellas que van a ser diseñadas como tablas de la Base de Datos.
## Transformación del MC al ML
- Se transforman en tablas todos los tipos de entidades, atributos, relaciones que aparecen en el modelo Conceptual.
- **Normalización:** Se normaliza el esquema resultante.
- Entidades se convierten en tablas y atributos en columnas.
- Un atributo multivaluado forma una nueva tabla.
- Una tabla tiene una clave primaria única y puede tener claves únicas adicionales llamadas claves candidatas.

---

# Definición de PK y FK
## Interidad Referencial - Foreign Key
- Una clave foránea es una referencia a una clave en otra tabla.
- No necesitan ser claves únicas 

---

# Conversión de Entidades del Modelo Conceptual


---

# Conversión de Relaciones
## Relaciones M:M 
- La relación de un modelo se transforma directamente en una tabla.
- Los campos de esta tabla son las claves primarias de todas las entidades que participen en la relación más todos aquellos atributos que pudiera tener la relación.
## Relaciones 1:1 
- Si una de las entidades que participa en la relación posee cardinalidad (0,1), mientras que en la otra es de (1,1), conviene propagar la clave de la entidad de cardinalidad (1,1) a la tabla resultante de la entidad de cardinalidades (0,1).
- Cuando las participaciones de una relación binaria es parcial, se decide cuál es la clase Padre e Hijo, y la PK se copia del Padre al Hijo.
- En caso de que ambas presenten cardinalidades (1,1), se puede unificar ambas entidades en un a sola tabla.
	- Se elije como PK a cualquiera de...
## Relaciones 1:M 

## Relaciones Ternarias

## Relaciones Recursivas
- Se genera una FK en la misma tabla en caso de 1:1 
- Se genera una tabla a parte en caso de 1:M 

---

# Conversión de Relaciones Especiales

## Supertipo - Subtipo

### 1. {Obligatorio, Sobrelapado}
- Se crean tablas para el supertipo y subtipos, y se añaden atributos para el supertipo (generalmente Booleans).
> [!warning] Todos los atributos de supertipo no pueden ser **False** a la vez.

### 2. {Obligatorio, Disjunto}
- Se crean tablas para el supertipo y subtipos, y se añaden un atributo en el supertipo que señale el subtipo.
> [!warning] No puede ser **nulo**.

> [!warning] Otra manera es crear dos tablas, siempre y cuando un subtipo no pueda convertirse a otro subtipo (Casos especiales porque puede causar duplicidad de datos).

### 3. {Opcional, Sobrelapado}
- Se crean tablas para el supertipo y subtipos, y se añaden atributos para el supertipo (generalmente Booleans).
> [!info] Todos los atributos del supertipo pueden ser **False** a la vez.

### 4. {Opcional, Disjunto}
- Se crean tablas para el supertipo y subtipos, y se añaden un atributo en el supertipo que señale el subtipo.
> [!info] Puede ser **nulo**.