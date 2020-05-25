package grumsen.gui.controller;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Project;
import grumsen.be.User;
import grumsen.gui.model.GrumsenModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Daniel
 */
public class MainViewController implements Initializable{
    private final ObservableList listProject = FXCollections.observableArrayList();
    @FXML private JFXListView<Project> projectListview;
    @FXML private JFXTextField textField;
    private GrumsenModel gm;
    private ProjectViewController pvc;
    
    public MainViewController(){
        gm = new GrumsenModel();
        pvc = new ProjectViewController();
    }
    
    @FXML
    private void handleAddBtnAction(ActionEvent e) throws SQLException{
        String projectName = textField.getText();
        
        if(!textField.getText().isEmpty()){
            Project p = new Project(0, projectName,
                    "True", "0", "", 375, 0, 0);
            addProject(p);
            projectListview.setItems(listProject);
            textField.clear();
        }
    }
    
    public void addProject(Project p){
        try{
            Project project = gm.createProject(p);
            projectListview.getItems().clear();
            listProject.addAll(project);
            projectListview.getItems().addAll(listProject);
        }catch (SQLException ex){
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleCreateProjectBtn(ActionEvent e) throws IOException{
        Stage createProjectWindow = new Stage();
        createProjectWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/grumsen/gui/view/ProjectView.fxml"));
        Parent root = loader.load();
        ProjectViewController prvc = loader.getController();
        prvc.setParentWindowController(this);
        
        Scene scene = new Scene(root);
        createProjectWindow.setTitle("Create Project View");
        createProjectWindow.setScene(scene);
        createProjectWindow.showAndWait();
    }
    
    @FXML
    private void handleCreateCustomerBtn(ActionEvent e) throws IOException{
        Stage createCustomerWindow = new Stage();
        createCustomerWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/grumsen/gui/view/CustomerView.fxml"));
        Parent root = loader.load();
        CustomerViewController cvc = loader.getController();
        cvc.setParentWindowController(this);
        
        Scene scene =new Scene(root);
        createCustomerWindow.setTitle("Create Customer View");
        createCustomerWindow.setScene(scene);
        createCustomerWindow.showAndWait();
    }
    
    public void addCustomer(Customer c){
        try{
            Customer customer = gm.createCustomer(c);
            projectListview.getItems().clear();
            listProject.addAll(customer);
            projectListview.getItems().addAll(listProject);
        }catch (SQLException ex){
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleCreatePersonBtn(ActionEvent e) throws IOException{
        Stage createPersonWindow = new Stage();
        createPersonWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/grumsen/gui/view/PersonView.fxml"));
        Parent root = loader.load();
        PersonViewController pevc = loader.getController();
        pevc.setParentWindowController(this);
        
        Scene scene = new Scene(root);
        createPersonWindow.setTitle("Create Person View");
        createPersonWindow.setScene(scene);
        createPersonWindow.showAndWait();
    }
    
    public void addAdmin(Admin a){
        try{
            Admin admin = gm.createAdmin(a);
            projectListview.getItems().clear();
            listProject.addAll(admin);
            projectListview.getItems().addAll(listProject);
        }catch (SQLException ex){
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addUser(User u){
        try{
            User user = gm.createUser(u);
            projectListview.getItems().clear();
            listProject.addAll(user);
            projectListview.getItems().addAll(listProject);
        }catch (SQLException ex){
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}