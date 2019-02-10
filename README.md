"# NyTimes"

# NewYorkTimesApplication
An app that fetches articles from NewYork times api

# Api Used
NewYork times api for science top stories
https://api.nytimes.com/svc/topstories/v2/science.json

# Architecture used
MVP : Model View Presenter

# Libraries Used (Most Important)
Retrofit : Calling the api
Glide : Converting url to a picture
Espresso : UI testing


# How is the application working
This is a fairly simple application
A MainActivity with a sing recyclerView (expandable).
An a adapter that maps the data retrieved from the webservice to the recycler view.
When an item is selected from the recyclerView, a layout will show below the item row showing it's details.

# GET request
@GET("svc/topstories/v2/science.json?api-key={api key}")


# Author
Bader Shaqra
Bader.Shaqra@gmail.com
