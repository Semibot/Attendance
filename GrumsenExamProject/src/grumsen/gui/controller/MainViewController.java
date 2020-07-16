package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Project;
import grumsen.be.RegularUser;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Daniel
 */
public class MainViewController implements Initializable{
    private final ObservableList listProject;
    @FXML private JFXListView<Project> projectListview;
    @FXML private JFXTextField textField;
    private Stage myStage;
    private GrumsenModel gm;
    
    public MainViewController(){
        listProject = FXCollections.observableArrayList();
        gm = new GrumsenModel();
    }
    
    @FXML
    private void handleAddBtnAction(ActionEvent e) throws SQLException{
        String projectName = textField.getText();
        
        if(!textField.getText().isEmpty()){
            Project p = new Project(0, projectName,
                    false, 0, 0, 0);
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
        ProjectViewController pvc = loader.getController();
        pvc.setParentWindowController(this);
        
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
    private void handleCreateUserBtn(ActionEvent e) throws IOException{
        Stage createUserWindow = new Stage();
        createUserWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/grumsen/gui/view/UserView.fxml"));
        Parent root = loader.load();
        UserViewController uvc = loader.getController();
        uvc.setParentWindowController(this);
        
        Scene scene = new Scene(root);
        createUserWindow.setTitle("Create User View");
        createUserWindow.setScene(scene);
        createUserWindow.showAndWait();
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
    
    public void addRegularUser(RegularUser ru){
        try{
            RegularUser regUser = gm.createRegularUser(ru);
            projectListview.getItems().clear();
            listProject.addAll(regUser);
            projectListview.getItems().addAll(listProject);
        }catch (SQLException ex){
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Add project
        //String a = "Projects:";
        //listProject.add(a);
        List<Project> listp = gm.getAllProjects();
        listProject.addAll(listp);
        projectListview.getItems().addAll(listProject);
        
        projectListview.setItems(listProject);
        projectListview.setCellFactory(param -> new CustomCell());
        
        StackPane pane = new StackPane();
        pane.getChildren().add(projectListview);
        Scene scene = new Scene(pane);
        //Stage stage = (Stage) textField.getScene().getWindow();
        //stage.setScene(scene);
        setStage(myStage);
    }
    
    static class CustomCell extends ListCell<Project>{
        @FXML private HBox hbox;
        @FXML private Label projectNameLbl;
        @FXML private Pane pane;
        @FXML private Label timeLbl;
        @FXML private JFXButton playBtn;
        @FXML private JFXButton pauseBtn;
        @FXML private JFXButton stopBtn;
        private FXMLLoader fxmlLoader;
        
        public CustomCell(){
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
                        Logger.getLogger(CustomCell.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                projectNameLbl.setText(project.getName());
                //timeLbl.setText(logHours.getTime());
                
                setText(null);
                setGraphic(hbox);
            }
        }
    }
    
    public void setStage(Stage stage){
        myStage = stage;
    }
}