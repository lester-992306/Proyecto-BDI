-- 08_vw_stock_titulo.sql
-- Vista de stock por TÍTULO (total, prestado, disponible)

CREATE OR REPLACE VIEW VW_STOCK_TITULO AS
SELECT
  t.titulo_id,
  t.nombre AS titulo,
  t.isbn,
  COUNT(l.libro_id) AS stock_total,
  SUM(
    CASE
      WHEN EXISTS (
        SELECT 1
        FROM PRESTAMO p
        WHERE p.libro_id = l.libro_id
          AND p.fecha_devolucion IS NULL
      ) THEN 1 ELSE 0
    END
  ) AS stock_prestado,
  (COUNT(l.libro_id) -
   SUM(
     CASE
       WHEN EXISTS (
         SELECT 1
         FROM PRESTAMO p
         WHERE p.libro_id = l.libro_id
           AND p.fecha_devolucion IS NULL
       ) THEN 1 ELSE 0
     END
   )) AS stock_disponible
FROM TITULO t
LEFT JOIN LIBRO l
  ON l.titulo_id = t.titulo_id
GROUP BY t.titulo_id, t.nombre, t.isbn;
