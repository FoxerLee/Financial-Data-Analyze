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
	his_volume_value DOUBLE NOT NULL,
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
	his_volume_value DOUBLE NOT NULL,
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
	his_volume_value DOUBLE NOT NULL,
	PRIMARY KEY (id)
);

-- CREATE TABLE data_years(
-- 	id INT NOT NULL AUTO_INCREMENT,
-- 	code VARCHAR(6) NOT NULL,
-- 	trading_day DATETIME NOT NULL,
-- 	open_value DOUBLE NOT NULL,
-- 	close_value DOUBLE NOT NULL,
-- 	high_value DOUBLE NOT NULL,
-- 	low_value DOUBLE NOT NULL,
-- 	volume_value DOUBLE NOT NULL,
-- 	PRIMARY KEY (id)
-- );

-- warehouse
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

-- CREATE TABLE warehouse_data_years(
-- 	id INT NOT NULL AUTO_INCREMENT,
-- 	code VARCHAR(6) NOT NULL,
-- 	trading_day DATETIME NOT NULL,
-- 	open_value DOUBLE NOT NULL,
-- 	close_value DOUBLE NOT NULL,
-- 	high_value DOUBLE NOT NULL,
-- 	low_value DOUBLE NOT NULL,
-- 	volume_value DOUBLE NOT NULL,
-- 	ma5 DOUBLE NOT NULL,
-- 	ma10 DOUBLE NOT NULL,
-- 	ma20 DOUBLE NOT NULL,
-- 	PRIMARY KEY (id)
-- );

CREATE TABLE company_info(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NULL,
	name TEXT NULL,
	lead_underwriter TEXT NULL,
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

CREATE TABLE connect(
	code VARCHAR(6) NOT NULL,
	name VARCHAR(50) NOT NULL,
	c_name VARCHAR(50) NULL,
	PRIMARY KEY (code)
);

CREATE TABLE profile_data(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	name VARCHAR(50) NOT NULL,
	roe DOUBLE NULL,
	net_profit_ratio DOUBLE NULL,
	gross_profit_ratio DOUBLE NULL,
	net_profits DOUBLE NULL,
	eps DOUBLE NULL,
	business_income DOUBLE NULL,
	bips DOUBLE NULL,
	PRIMARY KEY (id)
);

CREATE TABLE operation_data(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	name VARCHAR(50) NOT NULL,
	arturnover DOUBLE NULL,
	arturndays DOUBLE NULL,
	inventory_turnover DOUBLE NULL,
	inventory_days DOUBLE NULL,
	currentasset_turnover DOUBLE NULL,
	currentasset_days DOUBLE NULL,
	PRIMARY KEY (id)
);

CREATE TABLE growth_data(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	name VARCHAR(50) NOT NULL,
	mbrg DOUBLE NULL,
	nprg DOUBLE NULL,
	nav DOUBLE NULL,
	targ DOUBLE NULL,
	epsg DOUBLE NULL,
	seg DOUBLE NULL,
	PRIMARY KEY (id)
);

CREATE TABLE debtpaying_data(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	name VARCHAR(50) NOT NULL,
	currentratio DOUBLE NULL,
	quickratio DOUBLE NULL,
	cashratio DOUBLE NULL,
	icratio DOUBLE NULL,
	sheqratio DOUBLE NULL,
	adratio DOUBLE NULL,
	PRIMARY KEY (id)
);

CREATE TABLE cashflow_data(
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	name VARCHAR(50) NOT NULL,
	cf_sales DOUBLE NULL,
	rateofreturn DOUBLE NULL,
	cf_nm DOUBLE NULL,
	cf_liabilities DOUBLE NULL,
	cashflowratio DOUBLE NULL,
	PRIMARY KEY (id)
);

CREATE TABLE user_info(
	user_id INT NOT NULL AUTO_INCREMENT,
	password VARCHAR(20) NOT NULL,
	name VARCHAR(100) NOT NULL,	
	PRIMARY KEY (user_id)
);

CREATE TABLE self_stocking(
	user_id INT NOT NULL,
	code VARCHAR(6) NOT NULL,
	PRIMARY KEY (user_id, code)
);				







