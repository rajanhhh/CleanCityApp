# Clean City

## Demo Page 
Url: http://localhost:9080/fetch/demo?pin=12345
Check demo page to render image from database.


##Fetch All Report By Pin
http://localhost:9080/fetch/data?pin=12345

##Reporting Page
http://localhost:9080/reportBoard


+--------------+------------------+------+-----+-------------------+----------------+
| Field        | Type             | Null | Key | Default           | Extra          |
+--------------+------------------+------+-----+-------------------+----------------+
| id           | int(10) unsigned | NO   | PRI | NULL              | auto_increment |
| name         | varchar(150)     | NO   |     | NULL              |                |
| address      | varchar(150)     | NO   |     | NULL              |                |
| pin          | varchar(150)     | NO   |     | NULL              |                |
| phone_number | varchar(150)     | NO   |     | NULL              |                |
| photo        | longblob         | YES  |     | NULL              |                |
| report_time  | datetime         | NO   |     | CURRENT_TIMESTAMP |                |
+--------------+------------------+------+-----+-------------------+----------------+