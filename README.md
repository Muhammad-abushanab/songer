# Songer Web App

## Requirements
- postgresql
- inteliJ ide

### Steps to run the app
- clone this repo
- create a database called `songer`
- go to [Application.properties](./src/main/resources/application.properties)
- update the username and password based on your postgres credit
- run the application.
- go to your browser and type `localhost:8080`
- that's it everything shall be good.


Endpoints
- `/` root endpoint that displays the home page
- `/hello?name=YourName` a route that welcomes you to the application by default it's guest
- `/capitalize/{word}` a route that capitalize the word by default the word is world
- `/albums` displays a album for some singers.
- `/num-fact/{number}` a route to see a fact about a certain number by default 50

