The web application provides two services; the first service return the full list of film grouped by film name. the second service can be used to retrieve films by film name.
1.	Service 1
API: https://filmlocations.herokuapp.com/films

HTTP-Method: GET
Response-Type: application/json
Parameters: no parameters
Returns: FilmDto list

2.	Service 2
API: https://filmlocations.herokuapp.com/filmsByName?name=[string]
HTTP-Method: GET
Response-Type: application/json
Parameters:
1.	name: String
If empty a list of all films will be returned
Returns: FilmDto list

Example: https://filmlocations.herokuapp.com/filmsByName?name=car

Response (FilmDto list)
[
  {
    "title": "Broken-A Modern Love Story ",
    "locations": [
      "Ina Coolbrith Park (1700 Taylor Street)",
      "0-100 block Halleck Street"
    ]
  },
  {
    "title": "The Love Bug",
    "locations": [
      "Golden Gate Bridge",
      "100 Block of Lombard Street"
    ]
  },
  {
    "title": "Love & Taxes",
    "locations": [
      "The Marsh Theatre (1062 Valencia Street)",
      "20 Hill Street",
      "198 Gough Street"
    ]
  },
  {
    "title": "Nina Takes a Lover",
    "locations": [
      null
    ]
  },
  {
    "title": "When a Man Loves a Woman",
    "locations": [
      "Buena Vista Café (2765 Hyde Street)",
      "Victor's Restaurant, The Westin St. Francis Hotel (335\n\t\t\t\tPowell Street)",
      "Spring Valley School (1451 Jackson Street)",
      "International Studies Academy (993 Vermont Street, Potrero\n\t\t\t\tHill)",
      "Grant Street at Pacific Avenue",
      "Cybelle's Pizza (1000 Bush Street)",
      "766 Vallejo Street at Stockton Street (North Beach)\n\t\t\t",
      "1521 Masonic Avenue at Piedmont Street"
    ]
  }
]

3.	Service 3
API: https://filmlocations.herokuapp.com/buildings

HTTP-Method: GET
Response-Type: application/json
Parameters: no parameters
Returns: Buildings list

4.	Service 4
API: https://filmlocations.herokuapp.com/buildingsByName?name=building
HTTP-Method: GET
Response-Type: application/json
Parameters:
1.	name: String
If empty a list of all buildings will be returned
Returns: Buildings list

{
   "buildings":[
      {
         "department":"Building Inspection",
         "sourceType":"CNG",
         "co2Emission":11.79717391
      },
      {
         "department":"Building Inspection",
         "sourceType":"Gasoline",
         "co2Emission":22.317146247
      },
      {
         "department":"Building Inspection",
         "sourceType":"CNG",
         "co2Emission":12.31040348
      },
      {
         "department":"Building Inspection",
         "sourceType":"Gasoline",
         "co2Emission":21.74465868
      },
      {
         "department":"Building Inspection",
         "sourceType":"CNG",
         "co2Emission":12.78167243
      },
      {
         "department":"Building Inspection",
         "sourceType":"Gasoline",
         "co2Emission":24.839501533
      },
      {
         "department":"Building Inspection",
         "sourceType":"CNG",
         "co2Emission":13.15054268
      },
      {
         "department":"Building Inspection",
         "sourceType":"Gasoline",
         "co2Emission":25.05485738
      },
      {
         "department":"Building Inspection",
         "sourceType":"Natural Gas",
         "co2Emission":39.269074036
      },
      {
         "department":"Building Inspection",
         "sourceType":"Natural Gas",
         "co2Emission":25.506680782
      },
      {
         "department":"Building Inspection",
         "sourceType":"Natural Gas",
         "co2Emission":60.703103243
      },
      {
         "department":"Building Inspection",
         "sourceType":"Natural Gas",
         "co2Emission":53.179419977
      }
   ]
}

