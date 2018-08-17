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

