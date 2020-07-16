package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import grumsen.be.Project;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class CustomCellController extends ListCell<Project>{
    @FXML private HBox hbox;
    @FXML private Label projectNameLbl;
    @FXML private Pane pane;
    @FXML private Label timeLbl;
    @FXML private JFXButton playBtn;
    @FXML private JFXButton pauseBtn;
    @FXML private JFXButton stopBtn;
    private FXMLLoader fxmlLoader;
    
    public CustomCellController(){
        super();
        hbox.getChildren().addAll(projectNameLbl, pane, timeLbl, playBtn, pauseBtn, stopBtn);
        playBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                System.out.println("Timer running");
            }
        });
        pauseBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                System.out.println("Timer paused");
            }
        });
        stopBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                System.out.println("Timer stoped");
            }
        });
    }
    
    @Override
    public void updateItem(Project project, boolean empty){
        super.updateItem(project, empty);
        
        if(empty || project == null){
            setText(null);
            setGraphic(null);
        }else {
            if(fxmlLoader == null){
                fxmlLoader = new FXMLLoader(getClass().getResource("/grumsen/gui/view/CustomCell.fxml"));
                fxmlLoader.setController(this);
                try{
                    fxmlLoader.load();
                }catch (IOException ex){
                    Logger.getLogger(CustomCellController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            projectNameLbl.setText(project.getName());
            //timeLbl.setText(logHours.getTime());
            
            setText(null);
            setGraphic(hbox);
        }
    }
}