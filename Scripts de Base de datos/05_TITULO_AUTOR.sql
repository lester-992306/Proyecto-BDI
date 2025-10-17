-- 05_titulo_autor.sql
-- Relación N:M entre TÍTULO y AUTOR

CREATE TABLE TITULO_AUTOR (
  titulo_id NUMBER NOT NULL,
  autor_id  NUMBER NOT NULL,
  CONSTRAINT pk_titulo_autor PRIMARY KEY (titulo_id, autor_id),
  CONSTRAINT fk_tituloautor_titulo FOREIGN KEY (titulo_id) REFERENCES TITULO(titulo_id),
  CONSTRAINT fk_tituloautor_autor  FOREIGN KEY (autor_id)  REFERENCES AUTOR(autor_id)
);

-- Índices para FKs
CREATE INDEX ix_tituloautor_titulo ON TITULO_AUTOR(titulo_id);
CREATE INDEX ix_tituloautor_autor  ON TITULO_AUTOR(autor_id);
