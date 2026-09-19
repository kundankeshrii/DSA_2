SELECT stock_name,
SUM(IF(operation='Buy',-price,price))as capital_gain_loss
from stocks
group by stock_name;

