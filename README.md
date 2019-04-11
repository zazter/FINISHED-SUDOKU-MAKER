This will give return a finished 9x9 sudoku grid.
It is however, quite inefficient -
  Since it's randomly generated, it may accidentally generate an impossible row. The program will loop 1000 times to make sure every digit    is checked. After 1000 loops and no suitable numbers, the row will be reset.
