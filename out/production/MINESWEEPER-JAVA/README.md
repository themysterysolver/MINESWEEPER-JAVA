# MINESWEEPER🎮

## HISTORY🏃‍♂️
- Minesweeper is a *logic puzzle video game* genre generally played on personal computers.
- The objective is to clear the board without detonating any mines, with help from clues about the number of neighboring mines in each field.
- Minesweeper has been incorporated as a minigame in other games, such as `RuneScape` and `Minecraft's` 2015 April Fools update.

## Why I did it?🗿

- when I was started `BFS` problems in `leetcode` to crack `OA` for intern and placement,I found this q [529.Mineweeper](https://leetcode.com/problems/minesweeper/description/),
  which made me understand how a `minesweeper` game works and intrested me.(*Bucket list project*)
  - *FUN FACT*:I used to randomly pick cells when I first got a computer in 6th std.😁
  - I had no clue how it works.Mostly everyone during that time don't know how to play and I bet many don't know how to play now too.😂
  
  ![image](https://github.com/user-attachments/assets/868a07b9-5eda-4fb7-a836-4cc45e235bd3)
  ![image](https://github.com/user-attachments/assets/aa48099f-c941-42b2-9bcd-90e54f85014f)

- To revise `JAVA` with `AWT` and `SWING`
- To develop a final prodduct and give it as a `JAR`,So I learnt how to do `JAR`.
- Ofc to have fun🕺

> If u want to learn how to develop this?
Then you can view my commits,it guides you to do the same work.

## GamePlay

- In the game, mines (that resemble naval mines in the classic theme) are scattered throughout a board, which is divided into cells.
- **Three states**: `unopened`, `opened` and `flagged`. An unopened cell is blank and clickable, while an opened cell is exposed.
-  Flagged cells are those marked by the player to indicate a potential mine location.
    - Players can also flag a cell, visualised by a flag being put on the location, to denote that they believe a mine to be in that place
-  A player selects a cell to open it. If a player opens a mined cell, the game ends. Otherwise,
- The opened cell displays either a *number*, indicating the number of mines vertically, horizontally or diagonally adjacent to it. or a `blank tile` (or "0"), and all adjacent non-mined cells will automatically be opened
- **WIN:** If we managed to open all the cells without exploding a mine,then we win!
- **LOOSE:** when u click a mine,u lost the game.

## Directory structure
```
MINESWEEPER-JAVA/
├── GameBoardGUI.java
├── GameLogic.java
├── Minesweeper.java
├── MineSweeperGUI.java
```
- `Minesweeper.java` is the main() function where program starts.
-  `GameLogic.java` handles the logic.
-  `MineSweeperGUI.java` first dispaly page .
-  `GameBoardGUI.java` game play and event handling.

## Features

- Different modes based on difficulty.
- Full working of the game with winning and loosing logic.
- Reset game and can quit game.
- Random mine planting.

### PICS
#### Homepage
![Homepage](https://github.com/user-attachments/assets/5f855c67-8a2c-4920-b022-30bc6fb0c882)

#### Game init
![9*9:EASY:MODE](https://github.com/user-attachments/assets/2ff113f8-1903-4fe3-a8ee-b01fcd9532ba)

#### Lost game
![lsot](https://github.com/user-attachments/assets/2c50c347-ae95-4fb3-98b9-7e1b99202002)

#### Won Game
![image](https://github.com/user-attachments/assets/9e721908-129a-40f7-b128-6068ec1adeb9)


## Upcoming Features
- Timer
- Flag count
- State management
- Making it similar to that of the Orginal game.
