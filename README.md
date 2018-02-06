# BeerWineRecom

BeerWineRecom is a service which combines two recommendation services, one for beer and one for wine.

## User

### Register User [GET]

Register a new user to the service

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/register?username=cane&password=cane&email=cane@cane.it
    
    

+ Response 200 (application/json)


    + Body
    
            true
    

### Login [GET]

Sign in to the service 

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/login?username=cane&password=cane

+ Response 200 (application/json)


    + Body
    
            {
                "username": "cane"
                "password": "cane"
                "email": "cane@cane.it
            }

## Wine

### Search Wine [GET]

Return a list of wines, with specific proprieties, from Snooth db.

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/wine/cane/search

+ Response 200 (application/json)


    + Body
    
    
            [
            {
                "name": "Hitching Post Generation",
                "code": "hitching-post-generation-2005",
                "region": "USA > California > Santa Barbara",
                "winery": "Hitching Post",
                "varietal": "Cabernet Franc; Merlot; Syrah",
                "price": 15.99,
                "vintage": 2005,
                "type": "Red Wine",
                "link": "http://www.snooth.com/wine/hitching-post-generation-2005/",
                "image": "https://ei.isnooth.com/multimedia/a/e/1/image_319467_square.jpeg",
                "rating": 0,
                "review": null,
                "alcohol": null,
                "reviews": null
            },
            {
                "name": "Villa Farnia di Farnese Montepulciano d'Abruzzo",
                "code": "villa-farnia-di-farnese-montepulciano-dabruzzo-2008-1",
                "region": "Italy > Abruzzi > Montepulciano d'Abruzzo",
                "winery": "Farnese Vini",
            "varietal": "Montepulciano",
            "price": 20.75,
            "vintage": 2008,
            "type": "Red Wine",
            "link": "http://www.snooth.com/wine/villa-farnia-di-farnese-montepulciano-dabruzzo-2008-1/",
            "image": "https://ei.isnooth.com/multimedia/d/5/c/image_749147_square.jpeg",
            "rating": 0,
            "review": null,
            "alcohol": null,
            "reviews": null
        }
        .
        .
        .
        .
        .
    ]   


### Get Wine Details [GET]

Get the details of a specific wine. 
 

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/wine/cane/details

+ Response 200 (application/json)


    + Body
        
            {
                "name": "Hitching Post Generation",
                "code": "hitching-post-generation-2005",
                "region": "USA > California > Santa Barbara",
                "winery": "Hitching Post",
                "varietal": "Cabernet Franc; Merlot; Syrah",
                "price": 15.99,
                "vintage": 2005,
                "type": "Red Wine",
                "link": "http://www.snooth.com/wine/hitching-post-generation-2005/",
                "image": "https://ei.isnooth.com/multimedia/a/e/1/image_319467_square.jpeg",
                "rating": 0,
                "review": null,
                "alcohol": "0.0",
                "reviews": []
            }


## Beer    
  

### List All Beers [GET]

Return list of all beers in db.

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/beer/cane/seachall

+ Response 200 (application/json)

    + Body

        
        
            [
                {
                    "idBeer": "1",
                    "name": "Surama",
                    "type": "Saison",
                    "taste": "Dolce",
                    "color": "Chiara"
                }
                
                {
                    "idBeer": "2",
                    "name": "Obice",
                    "type": "Pale Ale",
                    "taste": "Amara",
                    "color": "Ambrata"
                }
                
                {
                    "idBeer": "3",
                    "name": "Bibock",
                    "type": "Pils",
                    "taste": "Amara",
                    "color": "Ambrata"
                }
                .
                .
                .
            ]
        
### Search Beer [GET] 

Get a specific beer from db. 
 
+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/beer/cane/seach/Surama

+ Response 201 (application/json)

   
    + Body
            
            {
                "idBeer": "1",
                "name": "Surama",
                "type": "Saison",
                "taste": "Dolce",
                "color": "Chiara"
                "rating": "3"
            }
            
            
            

## User-Wine Interaction

### User-Wine

#### Add to Wishlist and Rate [GET]

Add a rating from a specific user to a wine, and can either add it to its wishlist or not.

+ Request (application/json) 

      https://orchestrator-sde.herokuapp.com/rest/orch/wine/cane/rate?rating=3.5&code=hitching-post-generation-2005&review=good&iswish=1
    
    + Body
    
            { 
                "username": "cane", 
                "password": "cane", 
                "email": "cane@cane.it 
            }
        
        
+ Response 200 (application/json)

   + Body
   
           {
                "name": "cane",
                "rating": "4.5",
                "body": "I like the flavuor",
                "date": 1517930390033,
                "lang": null
            }
       

#### Get Wishlist [GET]

Return the wishlist of wines for a user.

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/wine/cane/mywine
    

+ Response 200 (application/json)

   + Body
   
            [
              {
                  "name": "Hitching Post Generation",
                  "code": "hitching-post-generation-2005",
                  "region": "USA > California > Santa Barbara",
                  "winery": "Hitching Post",
                  "varietal": "Cabernet Franc; Merlot; Syrah",
                  "price": 15.99,
                  "vintage": 2005,
                  "type": "Red Wine",
                  "link": "http://www.snooth.com/wine/hitching-post-generation-2005/",
                  "image": "https://ei.isnooth.com/multimedia/a/e/1/image_319467_square.jpeg",
                  "rating": 0,
                  "review": null,
                  "alcohol": null,
                  "reviews": null
              },
              {
                  "name": "Villa Farnia di Farnese Montepulciano d'Abruzzo",
                  "code": "villa-farnia-di-farnese-montepulciano-dabruzzo-2008-1",
                  "region": "Italy > Abruzzi > Montepulciano d'Abruzzo",
                  "winery": "Farnese Vini",
                  "varietal": "Montepulciano",
                  "price": 20.75,
                  "vintage": 2008,
                  "type": "Red Wine",
                  "link": "http://www.snooth.com/wine/villa-farnia-di-farnese-montepulciano-dabruzzo-2008-1/",
                  "image": "https://ei.isnooth.com/multimedia/d/5/c/image_749147_square.jpeg",
                  "rating": 0,
                  "review": null,
                  "alcohol": null,
                  "reviews": null
                } 
                .
                .
                .
                .
                .
            ]
   

### User-Beer


#### Get Wishlist [GET]

Return the wishlist of beers for a user.

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/beer/cane/wl

+ Response 200 (application/json)

   + Body
   
     + Body

            [
                {
                    "idBeer": "1",
                    "name": "Surama",
                    "type": "Saison",
                    "taste": "Dolce",
                    "color": "Chiara"
                }
                            
                {
                    "idBeer": "2",
                    "name": "Obice",
                    "type": "Pale Ale",
                    "taste": "Amara",
                    "color": "Ambrata"
                }
                .
                .
                .
            ]
            
   
#### Add to Wishlist [GET]

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/beer/cane/wl

+ Response 200 (application/json)

   + Body
   
            [
                {
                    "idBeer": "1",
                    "name": "Surama",
                    "type": "Saison",
                    "taste": "Dolce",
                    "color": "Chiara"
                }
                            
                {
                    "idBeer": "2",
                    "name": "Obice",
                    "type": "Pale Ale",
                    "taste": "Amara",
                    "color": "Ambrata"
                }
                .
                .
                .
            ]
        

#### Remove from Wishlist [GET]

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/beer/cane/removewl/1

+ Response 200 (application/json)

   + Body
   
            1

#### Add Rating [GET]

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/beer/cane/beer/rate/1

+ Response 200 (application/json)

   + Body
   
            true
  
  
#### Get Rating

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/beer/cane/getrate/1

+ Response 200 (application/json)

   + Body
   
            3.0




   


## Recommendation

### Wine Recommendation [GET]

Return a specific number of wine recommendations for a user.

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/wine/cane/recom
    

+ Response 200 (application/json)

   + Body
   
            [
              {
                  "name": "Hitching Post Generation",
                  "code": "hitching-post-generation-2005",
                  "region": "USA > California > Santa Barbara",
                  "winery": "Hitching Post",
                  "varietal": "Cabernet Franc; Merlot; Syrah",
                  "price": 15.99,
                  "vintage": 2005,
                  "type": "Red Wine",
                  "link": "http://www.snooth.com/wine/hitching-post-generation-2005/",
                  "image": "https://ei.isnooth.com/multimedia/a/e/1/image_319467_square.jpeg",
                  "rating": 0,
                  "review": null,
                  "alcohol": null,
                  "reviews": null
              },
              {
                  "name": "Villa Farnia di Farnese Montepulciano d'Abruzzo",
                  "code": "villa-farnia-di-farnese-montepulciano-dabruzzo-2008-1",
                  "region": "Italy > Abruzzi > Montepulciano d'Abruzzo",
                  "winery": "Farnese Vini",
                  "varietal": "Montepulciano",
                  "price": 20.75,
                  "vintage": 2008,
                  "type": "Red Wine",
                  "link": "http://www.snooth.com/wine/villa-farnia-di-farnese-montepulciano-dabruzzo-2008-1/",
                  "image": "https://ei.isnooth.com/multimedia/d/5/c/image_749147_square.jpeg",
                  "rating": 0,
                  "review": null,
                  "alcohol": null,
                  "reviews": null
                } 
                .
                .
                .
                .
                .
            ]
   

### Beer Recommendation [GET]

Return a specific number of beer recommendations for a user.

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/beer/cane/recom

+ Response 200 (application/json)

   + Body
   

            [
                {
                    "idBeer": "1",
                    "name": "Surama",
                    "type": "Saison",
                    "taste": "Dolce",
                    "color": "Chiara"
                }
                            
                {
                    "idBeer": "2",
                    "name": "Obice",
                    "type": "Pale Ale",
                    "taste": "Amara",
                    "color": "Ambrata"
                }
                .
                .
            ]
   

## Quote

### Get Drinking Quote [GET]
 
+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/quotesDrink

+ Response 200 (application/json)

   + Body
   
            {
                "quote": "{quote}"
                "author": "{author}"
            }
  

### Get Student Quote [GET]

+ Request (application/json)

      https://orchestrator-sde.herokuapp.com/rest/orch/quotesStud

+ Response 200 (application/json)

   + Body
        
            {
                "quote": "{quote}"
                "author": "{author}"
            }
  
