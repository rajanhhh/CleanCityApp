# Clean City

## Demo Page 
Url: http://localhost:9080/fetch/demo?pin=12345
Check demo page to render image from database.


##Fetch All Report By Pin
http://localhost:9080/fetch/data?pin=12345

##Reporting Page
http://localhost:9080/reportBoard


##DB Query

CREATE TABLE `cleancity_records` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(150) NOT NULL,
  `address` varchar(150) NOT NULL,
  `pin` varchar(150) NOT NULL,
  `phone_number` varchar(150) NOT NULL,
  `photo` longblob,
  `longitude` varchar(45) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

