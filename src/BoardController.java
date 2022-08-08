import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BoardController implements Initializable{

    //THINGS THAT WE ARE USING IN THE VIEW
   
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnnewGame;
    @FXML
    private Button btnquit;

    // PLAYER KEEPS TRACK OF MOVES
    //HAVING AN ARRAYLIST OF BUTTONS ALLOWS ME TO EAISLY CHANGE VALUES 
    //FOR A BUTTON WITHOUT HAVING TO MANUALLY CHANGE EACH BUTTON
    private int player;
    private ArrayList<Button> btns = new ArrayList (9);
    private String[][] board = new String [3][3];
    private Game g = new Game(player, board);
    private String winner;
    private File file = new File("summary.txt");
    
    
    
    //DEFAULT METHOD IN CONTROLLER
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Collections.addAll(btns, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9);
    }

    //CLOSES PROGRAM WHEN QUIT BUTTON IS CLICKED
    @FXML
    public void quit(ActionEvent event) throws FileNotFoundException {
        PrintWriter fileOut = new PrintWriter(file);
        fileOut.print("");
        fileOut.flush();
        Stage stage = (Stage) btnquit.getScene().getWindow();
        stage.close();
    }

    //RELOADS THE BOARD
    @FXML
    public void newGame(ActionEvent event) throws FileNotFoundException{

        for(int i = 0; i < btns.size(); i++){
            btns.get(i).setText("");
            btns.get(i).setDisable(false);
            btns.get(i).setStyle(null);
            updateArray();
        }
        PrintWriter fileOut = new PrintWriter(file);
        fileOut.print("");
        fileOut.flush();
        g.newGame();
    }


    //CHANGES THE BUTTON'S TEXT TO EITHER X OR O BASED ON WHOSE TURN IT IS
    //getSource() checks which button was clicked on the board
    //we then which button it was in our arraylist
    @FXML
    public void updateBoard(ActionEvent event) throws IOException{

        for(int i = 0; i< btns.size(); i++){
            btns.get(i).setFont(new Font(26));
            if(event.getSource() == btns.get(i)){
                if(player % 2 == 0){
                    btns.get(i).setText("X");
                    btns.get(i).setDisable(true);
                    btns.get(i).setStyle("-fx-background-color: #ff0000;");
                    
                }
                else{
                    btns.get(i).setText("O");
                    btns.get(i).setDisable(true);
                    btns.get(i).setStyle("-fx-background-color: #0066ff;");
                }
            }

        }
        player++;
        updateArray();
        summary(event);


        if(g.checkTie()){
            winner = "It's a Tie";
            newWindow(winner);
        }
            
        else if(g.checkWin()){
            Button button = (Button) event.getSource();
            if(button.getText().equals("X")){
                winner = "X Wins";
            }
            else if(button.getText().equals("O")){
                winner = "O Wins";
            }
            newWindow(winner);
        }
    }

    public void newWindow(String s){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Popup.fxml"));
            Parent root = (Parent) loader.load(); 
            PopupController controller = loader.getController();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Who Won?");
            stage.setScene(scene);
            stage.show();
            controller.setLabel(s);
            controller.setText(file);

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    private void updateArray(){
        for(int i = 0; i < btns.size(); i++){
            for(int j = 0; j < board.length; j++){
                for(int k = 0; k < board[0].length; k++){
                    if(btns.get(i) == btn1)
                        board[0][0] = btn1.getText();
                    else if(btns.get(i) == btn2)
                        board[0][1] = btn2.getText();
                    else if(btns.get(i) == btn3)
                        board[0][2] = btn3.getText();
                    else if(btns.get(i) == btn4)
                        board[1][0] = btn4.getText();
                    else if(btns.get(i) == btn5)
                        board[1][1] = btn5.getText();
                    else if(btns.get(i) == btn6)
                        board[1][2] = btn6.getText();
                    else if(btns.get(i) == btn7)
                        board[2][0] = btn7.getText();
                    else if(btns.get(i) == btn8)
                        board[2][1] = btn8.getText();
                    else if(btns.get(i) == btn9)
                        board[2][2] = btn9.getText();
                }
            }
        }
    }

    private void summary(ActionEvent event) throws IOException { //executes everytime a button is clicked.
        try {
            PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            Button button = (Button) event.getSource();
            char num = button.getId().charAt(3);
        
            if (player % 2 == 0) {
                fileOut.println("Move "+(player)+": Player 2 put an O on button "+num+"\n");
                fileOut.flush();
            }
            else {
                fileOut.println("Move "+(player)+": Player 1 put an X on button "+num+"\n");
                fileOut.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    
}
