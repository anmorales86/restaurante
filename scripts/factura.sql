-- Table: public."Factura"

-- DROP TABLE public."Factura";

CREATE TABLE public."Factura"
(
    idfactura integer NOT NULL,
    idcliente integer NOT NULL,
    idcamarero integer NOT NULL,
    idmesa integer NOT NULL,
    fechafactura date NOT NULL DEFAULT now(),
    CONSTRAINT "Factura_pkey" PRIMARY KEY (idfactura),
    CONSTRAINT idcamarero_fk FOREIGN KEY (idcamarero)
        REFERENCES public."Camarero" (idcamarero) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT idcliente_fk FOREIGN KEY (idcliente)
        REFERENCES public."Cliente" (idcliente) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT idmesa_fk FOREIGN KEY (idmesa)
        REFERENCES public."Mesa" (idmesa) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE public."Factura"
    OWNER to postgres;
COMMENT ON TABLE public."Factura"
    IS 'Tabla para almacenar la información de la factura';

COMMENT ON CONSTRAINT idcamarero_fk ON public."Factura"
    IS 'Llave foranea de la PK de la tabla Camarero(idcamarero)';
COMMENT ON CONSTRAINT idcliente_fk ON public."Factura"
    IS 'Llave foranea de la PK de la tabla Cliente(idcliente)';
COMMENT ON CONSTRAINT idmesa_fk ON public."Factura"
    IS 'Llave foranea de la PK de la tabla Mesa(idmesa)';