-- 02_usuario.sql
-- Usuarios con login simple (contraseña en texto plano)

CREATE TABLE USUARIO (
  usuario_id  NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nombre      VARCHAR2(120)  NOT NULL,
  email       VARCHAR2(160)  NOT NULL,
  contrasena  VARCHAR2(200)  NOT NULL,
  rol_id      NUMBER         NOT NULL,
  activo      CHAR(1)        DEFAULT 'S' CHECK (activo IN ('S','N')),
  fecha_alta  DATE           DEFAULT SYSDATE NOT NULL,
  CONSTRAINT uk_usuario_email UNIQUE (email),
  CONSTRAINT fk_usuario_rol FOREIGN KEY (rol_id) REFERENCES ROL(rol_id)
);

COMMENT ON TABLE USUARIO IS 'Usuarios de la aplicación (login simple).';
COMMENT ON COLUMN USUARIO.contrasena IS 'Texto plano solo por requerimiento (no recomendado).';

-- Índice para la FK (mejora de joins)
CREATE INDEX ix_usuario_rol ON USUARIO(rol_id);
