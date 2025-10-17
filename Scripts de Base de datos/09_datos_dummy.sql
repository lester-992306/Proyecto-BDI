-- Usuario bibliotecario
INSERT INTO USUARIO(nombre, email, contrasena, rol_id, activo)
SELECT 'Admin Bib', 'admin@bib.gt', 'admin123', r.rol_id, 'S'
FROM ROL r WHERE r.nombre='BIBLIOTECARIO';

-- Usuario lector
INSERT INTO USUARIO(nombre, email, contrasena, rol_id, activo)
SELECT 'Juan Lector', 'juan@bib.gt', 'juan123', r.rol_id, 'S'
FROM ROL r WHERE r.nombre='LECTOR';

-- Un autor, un título, dos copias
INSERT INTO AUTOR(nombres, apellidos) VALUES ('Gabriel', 'García Márquez');
INSERT INTO TITULO(nombre, isbn, anio, editorial, categoria)
VALUES('Cien años de soledad','978-0-06-088328-7',1967,'Sudamericana','Novela');
INSERT INTO TITULO_AUTOR(titulo_id, autor_id)
SELECT t.titulo_id, a.autor_id FROM TITULO t, AUTOR a
 WHERE t.nombre='Cien años de soledad' AND a.apellidos='García Márquez';

INSERT INTO LIBRO(titulo_id, codigo_barra, ubicacion) 
SELECT titulo_id, 'CB-0001', 'Sala A' FROM TITULO WHERE nombre='Cien años de soledad';
INSERT INTO LIBRO(titulo_id, codigo_barra, ubicacion)
SELECT titulo_id, 'CB-0002', 'Sala A' FROM TITULO WHERE nombre='Cien años de soledad';

COMMIT;
