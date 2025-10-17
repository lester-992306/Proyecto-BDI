-- 03_autor.sql
-- Autores

CREATE TABLE AUTOR (
  autor_id         NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nombres          VARCHAR2(120) NOT NULL,
  apellidos        VARCHAR2(120) NOT NULL,
  fecha_nacimiento DATE,
  nacionalidad     VARCHAR2(80)
);

COMMENT ON TABLE AUTOR IS 'Autores de obras/títulos.';
