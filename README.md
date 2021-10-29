# OOP TicTacToe

This repo serves as an example of how to convert largely procedural code into a more idiomatic OOP design. The `master` branch is the starting point, and the `oop` branch contains a more idiomatic OOP design.

> This repo is **not** a great example of how to do git commits. It exists
> only to save the starting and ending state. Ideally you would commit as
> you go at natural points in the refactoring.

There's also a number of other OOP improvements you could make, including rewriting `Board` into an interface and removing the `.set` and `.get` methods in favor of a more general interface. My suggestion would be something along the lines of `char[] Board.getAllLegalMoves()` and `void Board.makeMove(char c)` to abstract away the grid nature of the board. Other implementations of board would then have the capability to use nonsquare boards or even boards with gaps in them, all while allowing our current code to continue to work!
