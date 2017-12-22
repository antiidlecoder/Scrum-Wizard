package application.view;


import application.model.ProductBacklog;
import application.model.SprintBacklog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class BacklogEditViewController {

	//Product backlog
    @FXML
    private TextField txtTheme;
    @FXML
    private TextField txtSprint;
    @FXML
    private TextArea taUserStory;
    @FXML
    private TextField txtPbStatus;
    
    //Sprint backlog
    @FXML
    private TextField txtTask;
    @FXML
    private TextField txtPriority;
    @FXML
    private TextArea taDescription;
    @FXML
    private TextField txtTimeS;
    @FXML
    private TextField txtTimeI;
    @FXML
    private TextField txtResp;
    @FXML
    private TextField txtSbStatus;
    

    private Stage dialogStage;
    private ProductBacklog productBacklog;
    private SprintBacklog sprintBacklog;
    private boolean okClicked = false;
    private boolean sprintOk = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the backlog to be edited in the dialog.
     * 
     * @param productBacklog
     */
    public void setBacklog(ProductBacklog productBacklog) {
        this.productBacklog = productBacklog;

        txtTheme.setText(productBacklog.getTheme());
        txtSprint.setText(productBacklog.getSprint());
        taUserStory.setText(productBacklog.getUserStory());
        txtPbStatus.setText(productBacklog.getPBStatus());
    }
    
    /**
     * Sets the backlog to be edited in the dialog.
     * 
     * @param tempSl
     */
    public void setSprintBacklog(SprintBacklog tempSl) {
        this.sprintBacklog = tempSl;
    	
    	txtTask.setText(tempSl.getTask());
    	taDescription.setText(tempSl.getDescription());
    	txtPriority.setText(tempSl.getPriority());
    	txtTimeS.setText(tempSl.getTimeS());
    	txtTimeI.setText(tempSl.getTimeI());
    	txtResp.setText(tempSl.getResponsible());
    	txtSbStatus.setText(tempSl.getSBStatus());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    public boolean isSprintOkClicked() {
    	return sprintOk;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
    
        if (isInputValid()) {
        	productBacklog.setTheme(txtTheme.getText());
        	productBacklog.setSprint(txtSprint.getText());
        	productBacklog.setUserStory(taUserStory.getText());
            productBacklog.setPBStatus(txtPbStatus.getText());
           
            okClicked = true;
            dialogStage.close();
            //System.out.println(backlog);
        } 
    }

    @FXML
    private void handleSprintOk() {
    	if (isInputValid()) {
        	sprintBacklog.setTask(txtTask.getText());
            sprintBacklog.setDescription(taDescription.getText());
            sprintBacklog.setPriority(txtPriority.getText());
            sprintBacklog.setResponsible(txtResp.getText());
            sprintBacklog.setTimeS(txtTimeS.getText());
            sprintBacklog.setTimeI(txtTimeI.getText());
            sprintBacklog.setSBStatus(txtSbStatus.getText());
            
            sprintOk = true;
            dialogStage.close();
            //System.out.println(sprintBacklog.getDescription());
    	}
    }
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleSprintCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    
    private boolean isInputValid() {
        String errorMessage = "";
        
        //validation if needed

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
    
}
