import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class PopupController implements Initializable {

    @FXML
    private Label lbl1;
    @FXML
    private TextArea txtdetail;

    // @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML 
    public void setLabel(String s){
        lbl1.setText(s);
    }

   /*  @FXML
     public void setText(File file){ //not finished, just trying to see what works
        txtdetail.setText(file); 
    } */
    
    
}
