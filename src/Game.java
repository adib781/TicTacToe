
public class Game {
    private int player = 0; //USED TO STORE NUMBER OF MOVES MADE BY PLAYERs
    private boolean check = false; //STORES TRUE OR FALSE FOR METHODS CHECKING WHETHER WIN OR TIE

    private String[][] board = new String[3][3]; //CREATES THE 3X3 GAME BOARD FOR PROCESSING DATA

    public Game() {} //DEFAULT GAME CONSTRUCTOR

    public Game(int player, String[][] board) { //GAME CONSTRUCTOR
        this.player = player;
        this.board = board;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        if (player != (int)player) {
            throw new IllegalArgumentException("Player must be an integer.");
        }
        this.player = player;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        if (check != (boolean)check) {
            throw new IllegalArgumentException("Check must be a boolean value.");
        }
        this.check = check;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public boolean checkWin() { //CHECKS IF ANY PLAYER HAS A WINNING COMBINATION
        for (int i = 0; i < board.length; i++) {
            if(!board[i][0].isEmpty()){
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) { //HORIZONTAL WIN
                    check = true;
                }
            }
            if(!board[0][i].isEmpty()){
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) { //VERTICAL WIN
                    check = true;
                }
            }
        }

        if(!board[0][0].isEmpty()){
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) { //DIAGONAL WIN
                check = true;
            }
        }
        if(!board[0][2].isEmpty()){ 
            if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
                check = true;
            }
        }

        return check;
    }

    public boolean checkTie() { //CHECKS IF THE GAME BOARD IS FULL
        if(!checkWin()){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == "") {
                        return false;
                    }
                }
            }
            setCheck(true);
        }
        else{
            setCheck(false);
        }

        return check;
    }

    public void newGame(){
        setCheck(false);
        setPlayer(0);
    }
}
