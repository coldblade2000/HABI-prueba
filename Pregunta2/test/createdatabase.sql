CREATE TABLE "table-TIENDA"
(
    "codigo-tienda" INT NOT NULL,
    "nombre-tienda" VARCHAR,
    PRIMARY KEY ("codigo-tienda")
);

CREATE TABLE "table-BEBIDA"
(
    "codigo-bebida" INT NOT NULL,
    "nombre-bebida" VARCHAR,
    PRIMARY KEY ("codigo-bebida")
);

CREATE TABLE "table-BEBEDOR"
(
    "cedula" BIGINT NOT NULL,
    "nombre" VARCHAR,
    PRIMARY KEY ("cedula")
);

CREATE TABLE "table-GUSTA"
(
    "cedula"        BIGINT NOT NULL,
    "codigo-bebida" INT    NOT NULL,
    PRIMARY KEY ("cedula"),
    CONSTRAINT fk_bebida
        FOREIGN KEY ("codigo-bebida")
            REFERENCES "table-BEBIDA" ("codigo-bebida")
);

CREATE TABLE "table-VENDE"
(
    "codigo-tienda" INT NOT NULL,
    "codigo-bebida" INT NOT NULL,
    CONSTRAINT fk_bebida
        FOREIGN KEY ("codigo-bebida")
            REFERENCES "table-BEBIDA" ("codigo-bebida"),
    CONSTRAINT fk_tienda
        FOREIGN KEY ("codigo-tienda")
            REFERENCES "table-TIENDA" ("codigo-tienda")
);

CREATE TABLE "table-FRECUENTA"
(
    "cedula"        BIGINT NOT NULL,
    "codigo-tienda" INT    NOT NULL,
    PRIMARY KEY ("cedula"),
    CONSTRAINT fk_tienda
        FOREIGN KEY ("codigo-tienda")
            REFERENCES "table-TIENDA" ("codigo-tienda")
);