# TicTacToe Java Application

This is a simple TicTacToe game implemented in Java. The game allows two players to take turns marking their chosen symbol ('X' or 'O') on a 3x3 grid until one player wins or the game ends in a draw.

### Installation
To run the TicTacToe Java application, follow these steps:

1. Clone the repository to your local machine or download the source code as a ZIP file.

2. Ensure that you have Java Development Kit (JDK) installed on your system. You can download the latest version of JDK from the official Oracle website.

3. Open a command prompt or terminal and navigate to the directory where you cloned or extracted the source code.

4. Compile the Java source files by running the following command: 
javac *.java

5. Once the compilation is successful, you can start the game by executing the following command:
java Main

### How to Play

1. The game starts by displaying an empty 3x3 grid.

2. Players take turns to make their moves. Player 1 is assigned the symbol 'X', and Player 2 is assigned the symbol 'O'.

3. To make a move, enter the row and column numbers of the cell where you want to place your symbol. Rows and columns are numbered from 0 to 2.

4. The game validates the move and updates the grid with the symbol. If the move is invalid (e.g., the chosen cell is already occupied), an error message will be displayed, and the player will be prompted to enter a valid move.

5. The game continues until one player wins or the game ends in a draw. A player wins if they have three of their symbols in a row (horizontally, vertically, or diagonally).

6. After the game ends, the final state of the grid is displayed along with the result (win, draw, or quit).

7. To play another round, simply start the game again by executing the java Main command.

### Game Rules

The game is played on a 3x3 grid.
Players take turns to mark their chosen symbol ('X' or 'O') on an empty cell.
A player wins if they have three of their symbols in a row (horizontally, vertically, or diagonally).
If all cells are filled and no player has won, the game ends in a draw.
Players cannot make a move on an already occupied cell.
The game can be quit at any time by entering 'q' or 'Q' when prompted for a move.
License
This TicTacToe Java application is open-source and released under the MIT License. Feel free to modify and distribute the code as per the terms of the license.