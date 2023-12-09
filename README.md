
# Stick Hero Game - AP project

For the AP course project, we needed to implement a game inspired by Stick Hero using JavaFX and object-oriented programming (OOP) concepts. The game should emulate the core mechanics of Stick Hero while adding our own creative twist.

## Group 30

- Guneet Pal Singh (2022190)
- Harsh Nangia (2022199)
## Main file
- The main file of the game is `StickHero.java`

## Github Repo link
- https://github.com/hn-iiitd/StickHero

## How to compile
- Open terminal in the folder containing the project [StickHero]
- Run **mvn clean**
- Run **mvn package**
- Run **mvn clean javafx:run**

## How to Play
- Register as a new user if not already registered (For testing purpose use Userid - admin and password - 1234)
- Login via the userId and Password
- Click on Play button
- Click on new game
- A new game window will be opened
- Press and hold the left mouse button to increase the length of the Stick
- Release the mouse button to trigger the animation of falling of the stick and moving the player forward
- While the player is moving you can click the left mouse button to make the player go upside down to collect the cherries.
- `CAUTION`: Do not click the mouse more than once while stick is rotating.


## Game Features
- The game allows players to control a character named stick-hero who moves between platforms. The character can stretch out a stick to bridge gaps between pillars.
- The game includes multiple pillars of different widths
-  The game includes a reviving feature, which allows the player to be revived once using a certain amount(3) of blue cherries which can be collected during the game
- Failing to land the stick on a platform results in the character falling into the abyss and ending the game.
-  The character can collect rewards, such as cherries. We implemented 2 type of cherries ,red cherry and blue cherry. The red cherry helps in increasing the score and blue cherry helps in reviving the player.
-   The game includes the option for players to save their progress (last score, highest score till the point, total cherries).
-  The game have graphics, sound effects, and animations to enhance the overall gaming experience.

## Some features we added for making it more fun (BONUS)
- Made a login signup system.
- Implented two cherries which serve different purpose
- Player can change the character and use the character which he likes.
- We created a leaderboard displaying the top 5 highscorers.
- Implemented threads to change the background of the game after regular intervals of time (6 sec).

## Java concepts covered
- OOPS principles such as inheritance, abstraction, interfaces, design patterns, threading, exception handling, serialisation and deserialisation, JUnit, and many more.
- Design patterns 
  - **Singleton** - We used Singleton design pattern in the character object so that only one object of Char class is made.
  - **Flyweight** - We used Flyweight design pattern in login system so that no two people have same UserID.
- JUnit (StickHeroTest.java)
    -  We have Implemented JUnit tests to test the sorting of the arraylist of the players using the comparator interface based on their scores.
    - We have impleted JUnit tests to check if the new user is not able to  register with an already existing ID.



# StickHero Game - GamePlayController

The `GamePlayController` class is a part of the StickHero game application, responsible for handling the gameplay logic, user input, and controlling the game elements such as the player character, cherries, and platforms.

## Class Overview

The `GamePlayController` class is the class which majorly runs the game components like increasing the stick,platform generator and many more.


## Class Structure

The class includes the following major components:

- **Instance Variables:**
  - `isManDown`: Tracks whether the player character is in a down position.
  - `Cherries_ON`: Indicates whether cherries are present in the game.
  - `player_walking`: Tracks the player's movement status.
  - `mediaPlayer`: Manages the background music during gameplay.
  - `death`: Handles the sound effect for the player's death.

- **FXML Components:**
  - `ap`: AnchorPane for the game interface.
  - `current_score`: Label displaying the current score.
  - `RedCherryCount` and `BlueCherryCount`: Labels displaying counts of red and blue cherries.

- **Methods:**
  - `initialize`: Initializes the game settings and starts the background music.
  - `make_image_list`: Populates the image list for background slideshow.
  - `showNextImage`: Displays the next image in the background slideshow.

## Key Functions

1. `handleMousePressed`: Manages the actions when the mouse is pressed, including stick creation and player rotation.
2. `increaseStickHeight`: Increases the height of the stick during gameplay.
3. `handleMouseReleased`: Handles actions when the mouse is released, such as stopping the stick growth and initiating player movement.
4. `player_fall`: Initiates the player falling animation when conditions are met.
5. `game_over`: Displays the game over screen and redirects to the revival screen.
6. `platform_gen`: Generates new platforms and adjusts the game elements accordingly.

