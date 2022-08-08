import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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

    @FXML
    public void setText(File file) throws FileNotFoundException{ //sets text for text area

        if (file.exists()) {
            Scanner scan = new Scanner(file);
            scan.useDelimiter(System.getProperty("line.separator"));

            while(scan.hasNext()) {
                String str = scan.nextLine();
                txtdetail.appendText(str+"\n");

            }
            scan.close();
        }
    } 
    
    
}
