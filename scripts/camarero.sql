-- Table: public."Camarero"

-- DROP TABLE public."Camarero";

CREATE TABLE public."Camarero"
(
    idcamarero serial,
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    apellido1 character varying(50) COLLATE pg_catalog."default" NOT NULL,
    apellido2 character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Camarero_pkey" PRIMARY KEY (idcamarero)
);

ALTER TABLE public."Camarero"
    OWNER to postgres;
COMMENT ON TABLE public."Camarero"
    IS 'Tabla donde se almacena la información del camarero';