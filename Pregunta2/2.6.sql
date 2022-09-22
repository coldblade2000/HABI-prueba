-- Los bebedores que unicamente frecuentan las
-- tiendas que unicamente sirven alguna bebida que le gusta

SELECT bebedor.cedula, bebedor.nombre
FROM "table-BEBEDOR" bebedor
JOIN "table-FRECUENTA" frec1 on bebedor.cedula = frec1.cedula
JOIN "table-GUSTA" gusta1 on bebedor.cedula = gusta1.cedula
JOIN "table-VENDE" vende1 on frec1."codigo-tienda" = vende1."codigo-tienda"
    AND vende1."codigo-bebida" = gusta1."codigo-bebida"
WHERE 1 = (
    SELECT COUNT("codigo-bebida")
    FROM "table-VENDE" vende2
    WHERE vende2."codigo-tienda" = vende1."codigo-tienda"
)
AND 1 = (
    SELECT COUNT(frec2."codigo-tienda")
    FROM "table-FRECUENTA" frec2
    WHERE frec2.cedula = bebedor.cedula
)
