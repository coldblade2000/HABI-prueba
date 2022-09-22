-- Para cada bebedor, las bebidas que no le gustan
SELECT DISTINCT bebedor.cedula, bebedor.nombre, bebida."codigo-bebida", "nombre-bebida"
FROM "table-BEBEDOR" bebedor
JOIN "table-GUSTA" gusta on bebedor.cedula = gusta.cedula
JOIN "table-BEBIDA" bebida on bebida."codigo-bebida" not in (
    SELECT gusta."codigo-bebida"
    FROM "table-GUSTA" gusta
    JOIN "table-BEBIDA" tb2 on tb2."codigo-bebida" = gusta."codigo-bebida"
    WHERE gusta.cedula = bebedor.cedula AND  gusta."codigo-bebida" = tb2."codigo-bebida"
    )