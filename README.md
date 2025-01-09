# Sudoku

Sudoku is an interactive puzzle game built in Android Studio using Java. This app leverages backtracking to solve Sudoku puzzles and provides a seamless user experience through the use of Android fragments. The Sudoku grid is managed using an efficient 4D array structure to represent the entire 9x9 grid as 3x3 sub-grids as 3x3x3x3.

## Main Sections

- New Game: Start a fresh Sudoku puzzle.

- Continue Game: Resume your previous game where you left off.

- Backtracking Visualization: Visualize the solving process using multithreading for a smooth experience.

- Victory Page: Celebrate your success with a dedicated victory screen upon completing the puzzle.

## Additional Features
- Time Counter: Tracks the duration of the game.
- Hint System: Provides hints to help solve the puzzle.
- Remaining Digits Tracker: Shows how many numbers are left to complete the grid.
- Score Calculation: Keeps track of your performance based on time and accuracy.
- Penalty System: Adds penalties for incorrect moves.
- Difficulty Levels: Choose from Easy, Medium, or Hard levels to suit your skill.

## Technical Details

- Language: Java

- IDE: Android Studio

- Algorithm: Backtracking algorithm for solving Sudoku puzzles.

- UI: Utilizes fragments to create a dynamic and modular interface.

- Data Structure: Uses a 4D array (3x3x3x3) to efficiently manage the entire Sudoku grid.

## How It Works

### Backtracking Algorithm

The core of the Sudoku solver is a backtracking algorithm. It systematically searches for the correct numbers to place in each cell, ensuring that the Sudoku rules are followed:
- Each row must have numbers 1 to 9 without repetition.
- Each column must have numbers 1 to 9 without repetition.
- Each 3x3 sub-grid must have numbers 1 to 9 without repetition.

### Multithreading for Visualization

The app uses multithreading to display the backtracking process in real time. This feature provides users with a visual representation of how the algorithm solves the puzzle step-by-step.


