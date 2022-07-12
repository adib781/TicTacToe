import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    int player;
    private ArrayList<Button> btns = new ArrayList (9);
    
    
    //DEFAULT METHOD IN CONTROLLER
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Collections.addAll(btns, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9);
    }

    //CLOSES PROGRAM WHEN QUIT BUTTON IS CLICKED
    @FXML
    public void quit(ActionEvent event) {
        Stage stage = (Stage) btnquit.getScene().getWindow();
        stage.close();
    }

    //RELOADS THE BOARD
    @FXML
    public void newGame(ActionEvent event){
        for(int i = 0; i < btns.size(); i++){
            btns.get(i).setText("");
            btns.get(i).setDisable(false);
            btns.get(i).setStyle(null);
        }
        player = 0;
    }


    //CHANGES THE BUTTON'S TEXT TO EITHER X OR O BASED ON WHOSE TURN IT IS
    //getSource() checks which button was clicked on the board
    //we then which button it was in our arraylist
    @FXML
    public void updateBoard(ActionEvent event){

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

    }

    
}
