-- with where in
SELECT v.customer_id, COUNT(*) as count_no_trans FROM Visits v 
WHERE v.visit_id NOT IN (SELECT DISTINCT s.visit_id FROM Transactions s)
GROUP BY v.customer_id ORDER BY count_no_trans ;

-- with left join
SELECT v.customer_id, count(*) as count_no_trans FROM Visits v 
LEFT JOIN Transactions t ON t.visit_id = v.visit_id 
WHERE t.visit_id IS NULL 
GROUP BY v.customer_id ORDER BY count_no_trans;