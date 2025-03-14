package org.example.caseStudies.designSnakeAndLadder;

import org.example.caseStudies.designSnakeAndLadder.models.Board;
import org.example.caseStudies.designSnakeAndLadder.models.Cell;
import org.example.caseStudies.designSnakeAndLadder.models.Dice;
import org.example.caseStudies.designSnakeAndLadder.models.Player;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Player winner;
    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    static int playerIdCounter = 101;

    public Game()
    {
        initializeGame();
    }
    public void initializeGame()
    {
        board = new Board(10, 5, 5);
        dice = new Dice(1);
        winner = null;
        addPlayer();
        addPlayer();
        addPlayer();
    }

    public void addPlayer()
    {
        String playerId = String.valueOf(playerIdCounter);
        Player player = new Player(playerId);
        playerIdCounter++;
        playerList.add(player);
    }

    public void startGame()
    {
        while(winner == null) {
            Player currentPlayer = findPlayerTurn();
            System.out.println("Player " + currentPlayer.getId() + "'s turn, current position: " + currentPlayer.getCurrentPosition());
            int rolledDiceValue = dice.rollDice();
            int currentPlayerPosition = currentPlayer.getCurrentPosition();
            int currentPlayerUpdatedPosition = currentPlayerPosition + rolledDiceValue;
            currentPlayerUpdatedPosition = jumpUpdated(currentPlayerUpdatedPosition);

            currentPlayer.setCurrentPosition(currentPlayerUpdatedPosition);
            System.out.println("Player " + currentPlayer.getId() + "'s turn, jumped to position: " + currentPlayer.getCurrentPosition());
            if (currentPlayerUpdatedPosition >= board.getCells().length * board.getCells().length - 1) {
                winner = currentPlayer;
            }
        }

        System.out.println("WINNER is : " + winner.getId());
    }
    public int jumpUpdated(int position)
    {
        if(position > board.getCells().length * board.getCells().length - 1)
        {
            return position;
        }
        Cell cell = board.getCell(position);
        if(cell.getJump() != null && cell.getJump().getStart() == position)
        {
            return cell.getJump().getEnd();
        }
        return position;
    }

    public Player findPlayerTurn()
    {
        Player player = playerList.removeFirst();
        playerList.addLast(player);
        return player;
    }
}
