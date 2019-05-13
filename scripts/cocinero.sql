-- Table: public."Cocinero"

-- DROP TABLE public."Cocinero";

CREATE TABLE public."Cocinero"
(
    idcocinero serial,
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    apellido1 character varying(50) COLLATE pg_catalog."default" NOT NULL,
    apellido2 character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Cocinero_pkey" PRIMARY KEY (idcocinero)
);

ALTER TABLE public."Cocinero"
    OWNER to postgres;
COMMENT ON TABLE public."Cocinero"
    IS 'Tabla que hace referencia a la información del cocinero';