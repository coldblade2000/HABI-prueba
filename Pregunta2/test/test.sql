SELECT *
FROM "table-TIENDA" tienda
JOIN "table-FRECUENTA" frec2 on tienda."codigo-tienda" = frec2."codigo-tienda"
JOIN "table-BEBEDOR" bebedor2 ON bebedor2.cedula = frec2.cedula
WHERE bebedor2.nombre LIKE 'Luiz Perez'