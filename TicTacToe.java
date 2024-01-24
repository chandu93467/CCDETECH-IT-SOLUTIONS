import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    private static char currentPlayer = 'X';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        playTicTacToe();
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    private static boolean checkWinner(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Check rows
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Check columns
            }
        }

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player); // Check diagonals
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // There is an empty cell
                }
            }
        }
        return true; // Board is full
    }

    private static boolean isValidMove(int row, int col) {
        return 0 <= row && row < 3 && 0 <= col && col < 3 && board[row][col] == ' ';
    }

    private static void makeMove() {
        int row, col;
        if (currentPlayer == 'X') {
            System.out.println("Player X's turn:");
            System.out.print("Enter the row (0, 1, or 2): ");
            row = scanner.nextInt();
            System.out.print("Enter the column (0, 1, or 2): ");
            col = scanner.nextInt();
        } else {
            System.out.println("Player O's turn:");
            int[] move = getComputerMove();
            row = move[0];
            col = move[1];
        }

        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
        } else {
            System.out.println("Invalid move. Try again.");
            makeMove();
        }
    }

    private static int[] getComputerMove() {
        int[] result = minimax();
        return new int[] { result[1], result[2] };
    }

    private static int[] minimax() {
        int[] bestMove = { -1, -1, Integer.MIN_VALUE };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int score = minimax(false, 0);
                    board[i][j] = ' ';

                    if (score > bestMove[2]) {
                        bestMove[0] = score;
                        bestMove[1] = i;
                        bestMove[2] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    private static int minimax(boolean isMaximizing, int depth) {
        if (checkWinner('X')) {
            return -1;
        }
        if (checkWinner('O')) {
            return 1;
        }
        if (isBoardFull()) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int score = minimax(false, depth + 1);
                        board[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax(true, depth + 1);
                        board[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static void playTicTacToe() {
        while (true) {
            printBoard();
            makeMove();

            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }
}
