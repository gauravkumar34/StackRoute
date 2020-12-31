# Movie Cruiser Assignment

## Objective

The Objective of this assignment is to work with ReST API's , understand asynchronous programming and build interactive web pages using Javascript.  

## Prerequisites

1. Fork this boilerplate repository  
2. Clone the boilerplate repository and cd into it  
3. Install dependencies. The idea here is to use json-server to serve static pages and data for movies.  

```
  npm install
  npm run start or json-server db.json -s ./public
```

## Coding Guidelines

1. All your HTML code resides in public/index.html  
2. All your JavaScript code resides in the public/js folder  
3. All your CSS code resides in the public/css folder  
4. All your images resides in the public/images folder  
5. HTML, Javascript, CSS code should be well indented and commented  
6. You shall use Bootstrap to style your pages and elements  
7. The Assignment should be pushed to gitlab on completion and submitted for Preliminary Automated Review as described below.  

## Assignment

1. Populate data for ***Movies*** collection in db.json while another ***Favourites*** collection could be left empty initially.  
2. Create Two Sections/List ***Movies*** and ***Favourites*** in your HTML page.  
3. ***Movies*** and the ***Favourites*** section of the page should populate all the movies and favourites from the db.json using AJAX calls.  
4. Every ***Movie*** item should have a ***Add to Favourites*** button.  
5. On click of the ***Add to Favourites*** button the copy of the movie item should be moved to the ***Favourites*** list/section. The movie added to ***Favourites*** section should also be added to the ***Favourites*** collection of db.json using AJAX calls.  

## Instructions 

 1. Each movie item in db.json to have atleast  `id`, `title`, `posterPath` 
 2. It is mandatory to use Fetch API and Promises for all the HTTP calls   
 3. `public/js/script.js` is expected to have three functions -  
 	a. `getMovies()` - to fetch movies from `http://localhost:3000/movies`, populate them in DOM under `<ul id="moviesList">` and returns a promise with the JSON response from API  
	b. `getFavourites()` - to fetch favourites from `http://localhost:3000/favourites`, populate them in DOM under `<ul id="favouritesList">` and returns a promise with the JSON response from API  
	c. `addFavourite()` - as the click event handler for the button `Add to Favourites` corresponding to each movie listed under `Movies` on page, this shall take `id` of a movie as input, copy the respective movie to `Favourites` section, post the movie to db.json via `http://localhost:3000/favourites` and returns a promise with the complete list of favourites been loaded on the page  
 4. `public/index.html` - Movies list to be populated under `<ul id="moviesList">`
 	and Favourites list to be populated under `<ul id="favouritesList">`, `getMovies()` and `getFavourites()` to be invoked as shown in the file  
 5. Test cases for the assignment shall be found in `./test` directory which validates the solution and you shall ensure that all of them pass locally before you submit your code for an automated review (steps shared below)  
	To run test cases locally, you shall execute -  
	`npm install` (if not done already)  
	`npm run test`  
 6. You shall also fix any eslint errors if present in code. To run eslint check locally, you shall execute `npm run eslint`  
 7. Once you have fixed all test cases and eslint errors locally, you shall submit your solution for the automated review as described below.  

## Submitting your solution for preliminary automated review  

 1. Open https://hobbes.stackroute.in/#/ and login into the platform  
 2. Under Assignment repository select `javascript-movie-cruiser-assignment`, and branch master  
 3. Under Your solution repository select your own repository and branch  
 4. Press Submit  
 5. Press click here for the feedback  
 6. Evaluation will take around 2 mins to complete after which you need to refresh your browser and get the updated status  
 7. Watch out for your total score and detailed status on each test and eslint errors in the coloured blocks on the screen  
 8. Fix failing test cases as well as eslint errors and re-submit your solution until you get 100%  
 
## MENTORS TO BEGIN REVIEW YOUR WORK ONLY AFTER ->

- You add the respective Mentor as a Reporter/Master into your Assignment Repository

- You have checked your Assignment on the Automated Evaluation Tool - Hobbes (Check for necessary steps in your Boilerplate - README.md file. ) and got the required score - Check with your mentor about the Score you must achieve before it is accepted for Manual Submission.

- Intimate your Mentor on Slack and/or Send an Email to learner.support@stackroute.in - with your Git URL - Once you are done working and are ready for final submission.
 
