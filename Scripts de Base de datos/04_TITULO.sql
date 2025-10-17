-- 04_titulo.sql
-- Título/obra (no es la copia física)

CREATE TABLE TITULO (
  titulo_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nombre    VARCHAR2(300) NOT NULL,
  isbn      VARCHAR2(20),
  anio      NUMBER(4),
  editorial VARCHAR2(160),
  categoria VARCHAR2(120),
  CONSTRAINT uk_titulo_isbn UNIQUE (isbn)
);

COMMENT ON TABLE TITULO IS 'Obra o edición; no es la copia física.';
COMMENT ON COLUMN TITULO.isbn IS 'Único si se registra.';
