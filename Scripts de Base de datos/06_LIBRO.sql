-- 06_libro.sql
-- Copias físicas inventariables

CREATE TABLE LIBRO (
  libro_id     NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  titulo_id    NUMBER NOT NULL,
  codigo_barra VARCHAR2(64) NOT NULL,
  ubicacion    VARCHAR2(160),
  estado       VARCHAR2(20) DEFAULT 'BUENO',
  CONSTRAINT uk_libro_cb UNIQUE (codigo_barra),
  CONSTRAINT fk_libro_titulo FOREIGN KEY (titulo_id) REFERENCES TITULO(titulo_id)
);

COMMENT ON TABLE LIBRO IS 'Ejemplar/copia física asociada a un TÍTULO.';

-- Índice para la FK
CREATE INDEX ix_libro_titulo ON LIBRO(titulo_id);
