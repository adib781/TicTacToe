
public class Game {
    int player1 = 0; //USED TO STORE NUMBER OF MOVES MADE BY PLAYER 1
    int player2 = 0; //USED TO STORE NUMBER OF MOVES MADE BY PLAYER 2
    boolean check = false; //STORES TRUE OR FALSE FOR METHODS CHECKING WHETHER WIN OR TIE

    String[][] board = new String[3][3]; //CREATES THE 3X3 GAME BOARD FOR PROCESSING DATA

    public Game() {} //DEFAULT GAME CONSTRUCTOR

    public Game(int player1, int player2, String[][] board) { //GAME CONSTRUCTOR
        this.player1 = player1; 
        this.player2 = player2;
        this.board = board;
    }

    public boolean checkWin(String[][] board) { //CHECKS IF ANY PLAYER HAS A WINNING COMBINATION
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) { //HORIZONTAL WIN
                check = true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) { //VERTICAL WIN
                check = true;
            }
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) { //DIAGONAL WIN
                check = true;
            }
        }
        return check;
    }

    public boolean checkTie(String[][] board) { //CHECKS IF THE GAME BOARD IS FULL
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == null) {
                    check = false;
                } else {
                    check = true;
                }
            }
        }
        return check;
    }
}
