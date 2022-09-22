-- Los bebedores que frecuentan solo las tiendas que frecuenta Luiz Perez
SELECT DISTINCT bebedor.cedula, nombre
FROM "table-BEBEDOR" bebedor
JOIN "table-FRECUENTA" frec on bebedor.cedula = frec.cedula
    AND frec."codigo-tienda" in (
        SELECT tienda."codigo-tienda"
        FROM "table-TIENDA" tienda
        JOIN "table-FRECUENTA" frec2 on tienda."codigo-tienda" = frec2."codigo-tienda"
        JOIN "table-BEBEDOR" bebedor2 ON bebedor2.cedula = frec2.cedula
        WHERE bebedor2.nombre LIKE 'Luiz Perez'
        )
WHERE bebedor.nombre NOT LIKE 'Luiz Perez'