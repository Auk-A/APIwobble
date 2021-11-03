# Wobble API


GET REQUESTS

EXAMPLES:

GET all green cars
/car/filter?color=green

GET all cars with value over 20000 euros
/car/filter?min_value=20000

GET all cars with top speed over 180 km/h
/car/filter?min_top_speed=180

GET all cars built before 2008
/car/filter?max_build_date=2008

GET all cars with brand Audi
/car/filter?brand=audi

Request params can be chained: 
/car/filter?brand=audi&color=blue

GET specific car by licenseplate
/car/find?license_plate=11XXX1

POST request for adding a new car - autofills properties
{
    "licensePlate": ""
}

Post request for adding cars with foreign plates - custom properties
{
    "licensePlate": "",
    "carBrand": "",
    "carModel": "",
    "carColor": "",
    "carTopSpeed": "",
    "carNewValue": "",
    "wltpRange": "",
    "carPower": "",
    "secondsTo100": "",
    "carType": "",
    "carEngine": "",
    "carBuildDate": ""
}
