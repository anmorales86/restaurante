-- Table: public."Cliente"

-- DROP TABLE public."Cliente";

CREATE TABLE public."Cliente"
(
    idcliente serial,
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    apellido1 character varying(50) COLLATE pg_catalog."default" NOT NULL,
    apellido2 character varying(50) COLLATE pg_catalog."default",
    observaciones character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Cliente_pkey" PRIMARY KEY (idcliente)
);

ALTER TABLE public."Cliente"
    OWNER to postgres;
COMMENT ON TABLE public."Cliente"
    IS 'Tabla donde tiene la información del cliente';