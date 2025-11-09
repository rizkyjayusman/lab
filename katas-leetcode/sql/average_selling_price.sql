SELECT 
  p.product_id, 
  ROUND(SUM(p.price * s.units) / SUM(s.units),2) as average_price 
FROM Prices p
LEFT JOIN UnitsSold s ON 
  p.product_id = s.product_id AND 
  s.purchase_date BETWEEN p.start_date AND p.end_date 
GROUP BY p.product_id ;

-- or
SELECT 
    p.product_id,
    IFNULL(ROUND(SUM(p.price * s.units) / SUM(s.units),2), 0.00) as average_price
FROM Prices p, UnitsSold s
WHERE
  p.product_id = s.product_id AND 
  s.purchase_date BETWEEN p.start_date AND p.end_date 
GROUP BY p.product_id ;
