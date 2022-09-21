SELECT beb.cedula, beb.nombre
FROM "table-BEBEDOR" as "beb"
LEFT OUTER JOIN "table-GUSTA" AS "gusta"
    ON beb.cedula = "gusta".cedula
LEFT OUTER JOIN "table-BEBIDA" bebida
    ON gusta."codigo-bebida" = bebida."codigo-bebida"
WHERE bebida."nombre-bebida" IS NULL OR LOWER(bebida."nombre-bebida") NOT LIKE '%colombiana%'
