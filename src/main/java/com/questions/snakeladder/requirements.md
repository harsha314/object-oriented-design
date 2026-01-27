# Snake & Ladders Game

## Requirements

### Board Creation

- A Board should be created with a given set of snakes and ladders defined by start and end
- It's guaranteed that for a snake that start is less than end, similarily for ladder start is greater than end.
- It's guaranteed that a snake's start and ladder's start do not coincide.
- It's guaranteed that there is no snake at 100.
- Dice will have 6 faces with values from 1 to 6.
- Snakes and Ladders do not form an infinite loop.

### Gameplay

- All the players should start from zero meaning outside the board
- Each player rolls the dice when their turn comes
- Based on the dice value, the player moves that many cells forward
- If a player lands on a snake/ladder start on their turn, they are moved to the end of the snake/ladder
- If a players move causes their piece to move outside of the board, the piece doesn't move
- A player wins if it exactly reaches 100 and the game ends there
- After each move, the system should print 'player {player id} rolled {dice value} and moved from {initial position} to {final position}'
- After the end, the system should display 'player {player id} won the game'
