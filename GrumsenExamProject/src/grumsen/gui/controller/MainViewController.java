package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Project;
import grumsen.gui.model.GrumsenModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Daniel
 */
public class MainViewController implements Initializable{
    private final ObservableList listProject = FXCollections.observableArrayList();
    @FXML private JFXListView<Project> projectListview;
    @FXML private JFXTextField textField;
    @FXML private JFXButton addBtn;
    private GrumsenModel gm;
    
    public MainViewController(){
        projectListview = new JFXListView<>();
        gm = new GrumsenModel();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Add project
        String a = "Projects:";
        listProject.add(a);
        List<Project> listp = gm.getAllProjects();
        listProject.addAll(listp);
        projectListview.getItems().addAll(listProject);
    }
    
    @FXML
    private void handleProjectsBtnAction(ActionEvent e){
        
    }
    
    @FXML
    private void handleCustomersBtnAction(ActionEvent e){
        
    }
    
    @FXML
    private void handleStatisticsBtnAction(ActionEvent e){
        
    }
    
    @FXML
    private void handleAddBtnAction(ActionEvent e){
        String projectName = textField.getText();
        
        if(!projectName.isEmpty()){
            listProject.add(textField.getText());
            projectListview.setItems(listProject);
            textField.clear();
        }
    }
    
    /*public void addProject(Project p){
        try{
            Project project = gm.createProject(p);
            projectListview.getItems().clear();
            listProject.addAll(project);
            projectListview.getItems().addAll(listProject);
        }catch (SQLException ex){
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}