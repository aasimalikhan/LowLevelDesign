package org.example.caseStudies.designSnakeAndLadder.models;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private Cell[][] cells;

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders)
    {
        initializeCells(boardSize);
        addSnakesAndLadders(numberOfSnakes, numberOfLadders);
    }
    private void initializeCells(int boardSize)
    {
        cells = new Cell[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
            {
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }

    private void addSnakesAndLadders(int numberOfSnakes, int numberOfLadders) {
        while(numberOfSnakes > 0)
        {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if(snakeTail >= snakeHead)
            {
                continue;
            }
            Jump snakeObj = new Jump();
            snakeObj.setStart(snakeHead);
            snakeObj.setEnd(snakeTail);

            Cell cell = getCell(snakeHead);
            cell.setJump(snakeObj);

            numberOfSnakes--;
        }

        while(numberOfLadders > 0)
        {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if(ladderStart >= ladderEnd)
            {
                continue;
            }
            Jump snakeObj = new Jump();
            snakeObj.setStart(ladderStart);
            snakeObj.setEnd(ladderEnd);

            Cell cell = getCell(ladderStart);
            cell.setJump(snakeObj);

            numberOfLadders--;
        }
    }

    public Cell getCell(int position)
    {
        int boardRow = position / cells.length;
        int boardCol = (position % cells.length);
        return cells[boardRow][boardCol];
    }
}
