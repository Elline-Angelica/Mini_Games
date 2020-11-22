package BrainGames.TicTacToe;

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    
    public static void main(String[] args){

        char[][] introGameBoard =
                        {{'1', '|', '2', '|', '3' },
                        {'-', '+', '-', '+', '-' },
                        {'4', '|', '5', '|', '6' },
                        {'-', '+', '-', '+', '-' },
                        {'7', '|', '8', '|', '9' }};

        char[][] gameBoard =
                {{' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' }};

        System.out.println("\nWelcome to TicTacToe! \nThe objective of the game is to place your character into positions that will eventually form a row of three. \nGoodluck! You will be playing against the CPU. \n");
        printGameBoard(introGameBoard);
        System.out.println("Choose your character!");
        System.out.println("\nYou're up first! Enter your placement for X (1-9):");


        while(true) {
            Scanner scan = new Scanner(System.in);
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos)  || cpuPositions.contains(playerPositions)){
                System.out.println("\nposition taken, enter a correct position");
                playerPos = scan.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");

            String result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                printGameBoard(gameBoard);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos)  || cpuPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                printGameBoard(gameBoard);
                break;
            }
        }
    }

    public static void printGameBoard(char [][] gameBoard){

        for(char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char [][] gameBoard, int pos, String user){

        char symbol = 'X';

        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos);
        } else if(user.equals("cpu")){
            cpuPositions.add(pos);
            symbol = 'O';
        }

        switch (pos) {
            case 1: gameBoard[0][0] = symbol; break;
            case 2: gameBoard[0][2] = symbol; break;
            case 3: gameBoard[0][4] = symbol; break;
            case 4: gameBoard[2][0] = symbol; break;
            case 5: gameBoard[2][2] = symbol; break;
            case 6: gameBoard[2][4] = symbol; break;
            case 7: gameBoard[4][0] = symbol; break;
            case 8: gameBoard[4][2] = symbol; break;
            case 9: gameBoard[4][4] = symbol; break;
        }
    }

    public static String checkWinner(){

        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);

        List leftColumn = Arrays.asList(1,4,7);
        List centerColumn = Arrays.asList(2,5,8);
        List rightColumn = Arrays.asList(3,6,9);

        List topDownDiagonal = Arrays.asList(1,5,9);
        List downTopDiagonal = Arrays.asList(7,5,3);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftColumn);
        winningConditions.add(centerColumn);
        winningConditions.add(rightColumn);
        winningConditions.add(topDownDiagonal);
        winningConditions.add(downTopDiagonal);

        for(List l : winningConditions){
            if(playerPositions.containsAll(l)){
                return "\nCongratualtions! You won!";
            } else if (cpuPositions.containsAll(l)){
                return "\nCPU wins! Sorry :(";
            } else if (playerPositions.size()+ cpuPositions.size() == 9) {
                return "\nIt's a tie!";
            }
        }
        return "";
    }


}
