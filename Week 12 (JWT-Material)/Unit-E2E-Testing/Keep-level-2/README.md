# Angular Assignment - Keep	Level 2
	
## Objective  
	
The Objective of this application is to understand Angular Forms, Authentication & Security, Routing & Guards  

## Prerequisites

1. Fork this boilerplate repository  
2. Clone the boilerplate repository and cd into it  
3. Install dependencies `npm install`  
4. Run the backend `npm run serve`  which shall run on port:3000  
5. Run the frontend `npm run start` which shall run on port:4200  

## Know your server  

On running `npm run serve`, following apis would be available for your use -  
1. To authenticate user - POST - http://localhost:3000/auth/v1 - expecting data - { username, password }  
2. To check if user is authenticated - POST - http://localhost:3000/auth/v1/isAuthenticated - expecting header - { 'Authorization', `Bearer ${token}` }  
3. To get notes - GET - http://localhost:3000/api/v1/notes - expecting header - { 'Authorization', `Bearer ${token}` }  
4. To add a note - POST - http://localhost:3000/api/v1/notes - expecting header - { 'Authorization', `Bearer ${token}` } and data - { note }  
	
## Assignment:	
	
1.  Keep should use Material Design for it's UI	 
2.  User shall be shown a login form  
3.  After authentication, user is able to see all the notes on the page loaded from server as [Cards](https://material.angular.io/components/card/overview)  
4.  User is be able to create and persist notes on server  

## Instructions:

1. You are expected to use `Note` class for Note model  
2. `AppModule` shall be the root module  
3. Application to have two routes -  
	a. `dashboard` mapped to `DashboardComponent`  
	b. `login` mapped to `LoginComponent`  
	`dashboard` being the default route  
4. `AppComponent` as the bootstrapping component - which displays the `HeaderComponent` and one other component based on the requested route  
5. `HeaderComponent` to use Material Toolbar with text content `Keep`  
6. `LoginComponent`  
	6.1. is expected to use Angular Reactive Forms with two form controls `username` and `password` with classes `username` and `password` respectively and a button with text `Submit` to submit the form   
	6.2. is expected to have an element with class name `error-message` to display any server error messages  
	6.3. to have a `loginSubmit()` method called when form is submitted which shall validate the user credentials with server, if validation is successful, user is redirected to `dashboard` and his token is saved in local storage  
7. `DashboardComponent` to contain the same Expansion Panel and the Notes Collection from `AppComponent` implemented in `Keep Level 1`  
8. `CanActivateRouteGuard` to protect dashboard route, redirect unauthenticated users to login route and return the authenticated status as true or false for the user from `canActivate` method  
9. `AuthenticationService` talks to the server for user authentication and shall include methods -  
	9.1 `authenticateUser()` to get the user authenticated - accepts { username, password } and returns server response  
	9.2 `setBearerToken()` to save user token in local storage with key `bearerToken` - accepts the token string  
	9.3 `getBearerToken()` to fetch user token from local storage  
	9.4 `isUserAuthenticated()` to validate authenticity of a user - accepts the token string and returns Promise of authenticated status of user  
10. `NotesService` talks to the server to fetch/persist data and shall include methods -  
	10.1 `getNotes()` to fetch the notes collection  
	10.2 `addNote()` to persist a note to server  
11. `RouterService` to navigate user to available routes -  
	11.1 `routeToDashboard()` to navigate to dashboard route  
	11.2 `routeToLogin()` to navigate to login route  
12. Ensure following commands succeed in your local machine before submitting your code for Preliminary automated review as described next -  
`npm install
npm run build
npm run lint
`
13. Ensure unit test cases pass -  
`npm run test
`
14. Ensure e2e test cases pass -  
`npm run serve` (backend shall be running before executing e2e test cases)  
`npm run e2e`


## Submitting your solution for preliminary automated review  
1. Open `https://hobbes-cts.stackroute.in/#/` and login into the platform  
2. Under `Assignment repository` select `angular-keep-level-2-assignment`, and branch `master`  
3. Under `Your solution repository` select your own repository and branch
4. Press `Submit`  
5. Press `click here` for the feedback  
6. Evaluation will take around 5 mins to complete after which you need to refresh your browser and get the updated status  
7. Watch out for your total score and detailed status on each test and eslint errors in the coloured blocks on the screen  
8. Fix failing test cases as well as eslint errors and re-submit your solution (you may skip any eslint errors reported in the provided spec files)  


## MENTORS TO BEGIN REVIEW YOUR WORK ONLY AFTER ->

- You add the respective Mentor as a Reporter/Master into your Assignment Repository

- You have checked your Assignment on the Automated Evaluation Tool - Hobbes (Check for necessary steps in your Boilerplate - README.md file. ) and got the required score - Check with your mentor about the Score you must achieve before it is accepted for Manual Submission.

- Intimate your Mentor on Slack and/or Send an Email to learner.support@stackroute.in - with your Git URL - Once you are done working and are ready for final submission.