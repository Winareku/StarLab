# Continuación Modelo Lógico
El modelo lógico debe llevar tipo de datos en la tercera columna
|  |  |  |
|--|--|--|
| PK | C1 | type1
| FK | C2 | type2

## Hay varios tipos de datos:
### Int
Tinyint, smallint, etc.

### Date y Time
- DateTime
- Date
- Time
- TimeStamp (restas en tiempos)

### String
- char(#)
- varchar(#)
- ENUM

### JSON
Es como un diccionario en Python. Sirve para cuando las estructuras son variables, ejemplo: una tienda en línea tiene características de productos, una camiseta puede tener ciertas características y un valor por cada característica y no comparte estructura similar con otro productos.

## Normalización
Para eliminar redundancias.
### Dependencia Funcional
Un campo debe determinar de manera única a registros.
### Primera Forma Normal
### Segunda Forma Normal
### Tercera Forma Normal
