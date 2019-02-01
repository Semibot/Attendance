package attendanceautomation.gui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author DKE
 */
public class AttendanceController implements Initializable{
    
    @FXML
    private Button scoBtn;
    @FXML
    private Button sdeBtn;
    @FXML
    private Button itoBtn;
    @FXML
    private Button dbosBtn;
    
    @FXML
    private void openScoWindow(ActionEvent e) throws IOException{
        Stage scoWindow = new Stage();
        scoWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewScoWindow.fxml"));
        Parent root = loader.load();
        NewScoWindowController swc1 = loader.getController();
        swc1.setParentWindowController(this);
        Stage cSco = (Stage)scoBtn.getScene().getWindow();
        cSco.close();
        
        Scene scene = new Scene(root);
        scoWindow.setTitle("SCO Class list");
        scoWindow.setScene(scene);
        scoWindow.showAndWait();
    }
    
    @FXML
    private void openSdeWindow(ActionEvent e) throws IOException{
        Stage sdeWindow = new Stage();
        sdeWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewSdeWindow.fxml"));
        Parent root = loader.load();
        NewSdeWindowController swc2 = loader.getController();
        swc2.setParentWindowController(this);
        Stage cSde = (Stage)sdeBtn.getScene().getWindow();
        cSde.close();
        
        Scene scene = new Scene(root);
        sdeWindow.setTitle("SDE Class list");
        sdeWindow.setScene(scene);
        sdeWindow.showAndWait();
    }
    
    @FXML
    private void openItoWindow(ActionEvent e) throws IOException{
        Stage itoWindow = new Stage();
        itoWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewItoWindow.fxml"));
        Parent root = loader.load();
        NewItoWindowController iwc = loader.getController();
        iwc.setParentWindowController(this);
        Stage cIto = (Stage)itoBtn.getScene().getWindow();
        cIto.close();
        
        Scene scene = new Scene(root);
        itoWindow.setTitle("ITO Class list");
        itoWindow.setScene(scene);
        itoWindow.showAndWait();
    }
    
    @FXML
    private void openDbosWindow(ActionEvent e) throws IOException{
        Stage dbosWindow = new Stage();
        dbosWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewDbosWindow.fxml"));
        Parent root = loader.load();
        NewDbosWindowController dwc = loader.getController();
        dwc.setParentWindowController(this);
        Stage cDbos = (Stage)dbosBtn.getScene().getWindow();
        cDbos.close();
        
        Scene scene = new Scene(root);
        dbosWindow.setTitle("DBOS Class list");
        dbosWindow.setScene(scene);
        dbosWindow.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            Path dir = FileSystems.getDefault().getPath("./src/images/Sco.png");
            Image image = new Image(dir.toUri().toURL().toExternalForm());
            scoBtn.setGraphic(new ImageView(image));
            
            Path dir1 = FileSystems.getDefault().getPath("./src/images/Sde.png");
            Image image1 = new Image(dir1.toUri().toURL().toExternalForm());
            sdeBtn.setGraphic(new ImageView(image1));
            
            Path dir2 = FileSystems.getDefault().getPath("./src/images/Ito.png");
            Image image2 = new Image(dir2.toUri().toURL().toExternalForm());
            itoBtn.setGraphic(new ImageView(image2));
            
            Path dir3 = FileSystems.getDefault().getPath("./src/images/Dbos.png");
            Image image3 = new Image(dir3.toUri().toURL().toExternalForm());
            dbosBtn.setGraphic(new ImageView(image3));
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }
    }
}