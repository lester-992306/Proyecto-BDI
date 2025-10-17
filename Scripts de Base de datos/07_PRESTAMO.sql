-- 07_prestamo.sql
-- Préstamos por copia física

CREATE TABLE PRESTAMO (
  prestamo_id       NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  usuario_id        NUMBER NOT NULL,
  libro_id          NUMBER NOT NULL,
  fecha_prestamo    DATE   DEFAULT SYSDATE NOT NULL,
  fecha_vencimiento DATE   NOT NULL,
  fecha_devolucion  DATE, -- NULL => préstamo abierto
  observaciones     VARCHAR2(4000),
  CONSTRAINT fk_prestamo_usuario FOREIGN KEY (usuario_id) REFERENCES USUARIO(usuario_id),
  CONSTRAINT fk_prestamo_libro   FOREIGN KEY (libro_id)   REFERENCES LIBRO(libro_id),
  CONSTRAINT ck_fechas_prestamo CHECK (fecha_vencimiento >= TRUNC(fecha_prestamo))
);

COMMENT ON TABLE PRESTAMO IS 'Registro de préstamos de copias físicas.';

-- Índices para FKs
CREATE INDEX ix_prestamo_usuario ON PRESTAMO(usuario_id);
CREATE INDEX ix_prestamo_libro   ON PRESTAMO(libro_id);

-- Regla: impedir dos préstamos abiertos del mismo ejemplar simultáneamente.
CREATE UNIQUE INDEX ux_prestamo_libro_abierto
  ON PRESTAMO (CASE WHEN fecha_devolucion IS NULL THEN libro_id END);
