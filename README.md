# Wobble API

A Spring Boot REST API project

# GET Requests

GET all green cars <br/>
/car/filter?color=green

GET all cars with value over 20000 euros <br/>
/car/filter?min_value=20000

GET all cars with top speed over 180 km/h <br/>
/car/filter?min_top_speed=180

GET all cars built before 2008 <br/>
/car/filter?max_build_date=2008

GET all cars with brand Audi <br/>
/car/filter?brand=audi

Request params can be chained:  <br/>
/car/filter?brand=audi&color=blue

GET specific car by licenseplate <br/>
/car/find?license_plate=11XXX1

# POST Requests

POST request for adding a new car - autofills properties <br/>
{ <br/>
    "licensePlate": "" <br/>
} <br/>

Post request for adding cars with foreign plates - custom properties <br/>
{ <br/>
    "licensePlate": "", <br/>
    "carBrand": "", <br/>
    "carModel": "", <br/>
    "carColor": "", <br/>
    "carTopSpeed": "", <br/>
    "carNewValue": "", <br/>
    "wltpRange": "", <br/>
    "carPower": "", <br/>
    "secondsTo100": "", <br/>
    "carType": "", <br/>
    "carEngine": "", <br/>
    "carBuildDate": "" <br/>
} 
