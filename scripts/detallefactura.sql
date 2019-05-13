-- Table: public."DetalleFactura"

-- DROP TABLE public."DetalleFactura";

CREATE TABLE public."DetalleFactura"
(
    iddetallefactura serial,
    idfactura integer NOT NULL,
    idcocinero integer NOT NULL,
    plato character varying(200) COLLATE pg_catalog."default" NOT NULL,
    importe integer NOT NULL,
    CONSTRAINT "DetalleFactura_pkey" PRIMARY KEY (iddetallefactura),
    CONSTRAINT idcocinero_fk FOREIGN KEY (idcocinero)
        REFERENCES public."Cocinero" (idcocinero) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT idfactura_fk FOREIGN KEY (idfactura)
        REFERENCES public."Factura" (idfactura) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE public."DetalleFactura"
    OWNER to postgres;
COMMENT ON TABLE public."DetalleFactura"
    IS 'Tabla que hace referencia al detalle de la factura generada';

COMMENT ON CONSTRAINT idcocinero_fk ON public."DetalleFactura"
    IS 'Llave foranea a la tabla PK de cocinero(idcocinero)';
COMMENT ON CONSTRAINT idfactura_fk ON public."DetalleFactura"
    IS 'Llave foranea de la PK de la tabla Factura(idfactura)';