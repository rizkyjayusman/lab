select p.product_name, oo.unit FROM (
select product_id, order_date, sum(unit) unit from Orders GROUP BY product_id,year(order_date), month(order_date) having year(order_date) = '2020' and month(order_date) = '02' 
) oo JOIN Products p ON oo.product_id = p.product_id WHERE oo.unit >= 100 ;