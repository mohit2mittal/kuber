use northwind


CREATE TABLE `sample_dataset26` (
  `date` datetime DEFAULT NULL,
  `ticker` text,  
  `open` decimal(10,4) DEFAULT NULL,
  `high` decimal(10,4) DEFAULT NULL,
  `low` decimal(10,4) DEFAULT NULL,
  `close` decimal(10,4) DEFAULT NULL,
  `vol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


LOAD DATA INFILE 'check.csv' 
INTO TABLE sample_dataset26 
FIELDS
	ENCLOSED BY '"'
	TERMINATED BY ',' 
LINES 
	TERMINATED BY '\n'
IGNORE 1 ROWS
(@var,ticker,open,high,low,close,vol)
SET date=STR_TO_DATE(@var,'%Y%c%d'); 

select * from sample_dataset26


