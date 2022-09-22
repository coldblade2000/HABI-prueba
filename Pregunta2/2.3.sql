-- Las fuentes de soda que no son frecuentadas Andres Camilo Restrepo.
SELECT bebedor.cedula, nombre
FROM "table-BEBEDOR" bebedor
JOIN "table-GUSTA" gusta on bebedor.cedula = gusta.cedula
JOIN "table-FRECUENTA" "t-F" on bebedor.cedula = "t-F".cedula