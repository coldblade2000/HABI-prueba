-- Las fuentes de soda que no son frecuentadas Andres Camilo Restrepo.
SELECT *
FROM "table-TIENDA" as tienda
JOIN "table-VENDE" vende
     on tienda."codigo-tienda" = vende."codigo-tienda"
JOIN "table-BEBIDA" "t-B"
    ON "t-B"."codigo-bebida" = vende."codigo-bebida"
        AND LOWER("t-B"."nombre-bebida") LIKE 'soda'
LEFT OUTER JOIN "table-FRECUENTA" frec
    on tienda."codigo-tienda" = frec."codigo-tienda"
LEFT OUTER JOIN "table-BEBEDOR" bebedor
    on frec.cedula = bebedor.cedula
WHERE nombre IS NULL OR nombre NOT LIKE 'Andres Camilo Restrepo';