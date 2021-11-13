# LocationApp  

A simple repository to retrieve location data by curl request, save it and provide back the user with a simpler version of it.   
The project contains Backend written in Java/Spring Boot.   
For database, one in-memory database, H2, have been used.

## APIs
APIs in the project are as follows:  

### POST: api/addLocationToH2
Send post request with only one item
### POST: api/addLocationListToH2
Send post request with whole store list

### GET: api/getAllLocationFromH2Json
Returns list of stores' locations in JSON
### GET: api/getAllLocationFromH2CSV
Returns list of stores' locations in CSV

You can find the sample file (response of curl request) saved under *resources*
