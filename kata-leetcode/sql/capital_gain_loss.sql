SELECT s.stock_name, SUM(IF(operation = 'Sell', s.price, 0)) - SUM(IF(operation = 'Buy', s.price, 0)) as capital_gain_loss 
FROM Stocks s GROUP BY stock_name ;