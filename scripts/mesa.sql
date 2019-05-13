-- Table: public."Mesa"

-- DROP TABLE public."Mesa";

CREATE TABLE public."Mesa"
(
    idmesa serial,
    nummaxcomensa integer NOT NULL,
    ubicacion character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Mesa_pkey" PRIMARY KEY (idmesa)
);

ALTER TABLE public."Mesa"
    OWNER to postgres;
COMMENT ON TABLE public."Mesa"
    IS 'Tabla con la información de la mesa';