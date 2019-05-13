-- SEQUENCE: public.factura_idfactura_seq

-- DROP SEQUENCE public.factura_idfactura_seq;

CREATE SEQUENCE public.factura_idfactura_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.factura_idfactura_seq
    OWNER TO postgres;