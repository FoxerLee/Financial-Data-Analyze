CREATE TABLE data_real_time(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE data_days(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE data_weeks(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE data_months(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE data_years(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

# warehouse
CREATE TABLE warehouse_data_real_time(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE warehouse_data_days(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	ma5 DOUBLE NOT NULL,
	ma10 DOUBLE NOT NULL,
	ma20 DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE warehouse_data_weeks(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	ma5 DOUBLE NOT NULL,
	ma10 DOUBLE NOT NULL,
	ma20 DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE warehouse_data_months(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	ma5 DOUBLE NOT NULL,
	ma10 DOUBLE NOT NULL,
	ma20 DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE warehouse_data_years(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	trading_day DATETIME NOT NULL,
	open_value DOUBLE NOT NULL,
	close_value DOUBLE NOT NULL,
	high_value DOUBLE NOT NULL,
	low_value DOUBLE NOT NULL,
	volume_value DOUBLE NOT NULL,
	ma5 DOUBLE NOT NULL,
	ma10 DOUBLE NOT NULL,
	ma20 DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE company_info(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NULL,
	name TEXT NULL,
	lead_underwriter TEXT NULL,
	profile TEXT NULL,
	en_name TEXT NULL,	
	total_name TEXT NULL,
	listing_date TEXT NULL,
	establish_date TEXT NULL,
	organization TEXT NULL,
	listing_price DOUBLE NULL,
	scope TEXT NULL,
	market TEXT NULL, 
	PRIMARY KEY (id)
);






