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


## Routes

| Route                 | Method | Description                                   |
|-----------------------|--------|-----------------------------------------------|
| /albums               | GET    | Retrieves a list of albums.                   |
| /albums/create        | POST   | Creates a new album.                          |
| /albums/delete/{id}   | DELETE | Deletes an album by ID.                       |
| /albums/{id}          | GET    | Retrieves a specific album by ID.             |
| /capitalize/{word}    | GET    | Capitalizes a word and displays it.           |
| /error                | GET    | Displays an error page.                       |
| /hello                | GET    | Displays a greeting message.                  |
| /                     | GET    | Displays the root page (index).               |
| /num-fact/{number}    | GET    | Retrieves a number fact from an external API. |
| /add-song             | POST   | Adds a new song to an album.                  |
| /delete-song/{songId} | DELETE | Deletes a song by ID.                         |
| /songs                | GET    | Retrieves a list of songs.                    |


