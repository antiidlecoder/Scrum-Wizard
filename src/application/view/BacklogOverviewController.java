package application.view;

import application.Main;
import application.model.Backlog;
import application.model.ProductBacklog;
import application.model.SprintBacklog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BacklogOverviewController {
	@FXML
	private TableView<Backlog> projectBacklogTable;
	@FXML
	private TableView<SprintBacklog> sprintBacklogTable;
	@FXML
	private TableView<ProductBacklog> productBacklogTable;
	@FXML
	private TableColumn<ProductBacklog, String> pbId;
	@FXML
	private TableColumn<ProductBacklog, String> pbTheme;
	@FXML
	private TableColumn<ProductBacklog, String> pbUserStory;
	@FXML
	private TableColumn<ProductBacklog, String> pbSprint;
	@FXML
	private TableColumn<ProductBacklog, String> pbStatus;
	@FXML
	private TableColumn<SprintBacklog, String> sbId;
	@FXML
	private TableColumn<SprintBacklog, String> sbTask;
	@FXML
	private TableColumn<SprintBacklog, String> sbPriority;
	@FXML
	private TableColumn<SprintBacklog, String> sbTimeS;
	@FXML
	private TableColumn<SprintBacklog, String> sbTimeI;
	@FXML
	private TableColumn<SprintBacklog, String> sbStatus;

	@FXML
	private Label backlogIdLabel;
	@FXML
	private Label backlogThemeLabel;
	@FXML
	private Label backlogSprintLabel;
	@FXML
	private Label backlogUserStoryLabel;
	@FXML
	private Label backlogTasksLabel;
	@FXML
	private Label backlogNotesLabel;
	@FXML
	private Label backlogPriorityLabel;
	@FXML
	private Label backlogStatusLabel;
	
	@FXML
	private Button deleteButton;
	
	
	

	// Reference to the main application.
	private Main mainApp;

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public BacklogOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the Backlog table with the two columns.
		pbId.setCellValueFactory(
				cellData -> cellData.getValue().ThemeId());
		pbUserStory.setCellValueFactory(
				cellData -> cellData.getValue().UserStory());
		pbTheme.setCellValueFactory(
				cellData -> cellData.getValue().Theme());
		pbSprint.setCellValueFactory(
				cellData -> cellData.getValue().Sprint());
		pbStatus.setCellValueFactory(
				cellData -> cellData.getValue().Status());

		
		sbId.setCellValueFactory(
				cellData -> cellData.getValue().TaskId());
		sbTask.setCellValueFactory(
				cellData -> cellData.getValue().Task());
		sbPriority.setCellValueFactory(
				cellData -> cellData.getValue().Priority());
		sbTimeS.setCellValueFactory(
				cellData -> cellData.getValue().TimeS());
		sbTimeI.setCellValueFactory(
				cellData -> cellData.getValue().TimeI());
		sbStatus.setCellValueFactory(
				cellData -> cellData.getValue().Status());
		
		
		
		
		// Clear Backlog details.
		showBacklogDetails(null);

		// Listen for selection changes and show the Backlog details when changed.
		productBacklogTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showBacklogDetails(newValue));
		sprintBacklogTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showSprintBacklogDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		productBacklogTable.setItems(mainApp.getProductBacklogData());
		sprintBacklogTable.setItems(mainApp.getSprintBacklogData());
	}

	/**
	 * Fills all text fields to show details about the Backlog.
	 * If the specified Backlog is null, all text fields are cleared.
	 * 
	 * @param Backlog the Backlog or null
	 */
	private void showBacklogDetails(ProductBacklog Backlog) {
		if (Backlog != null) {
			// Fill the labels with info from the Backlog object
			//sprintColumn.setCellValueFactory(
			//		cellData -> cellData.getValue().BacklogSprintProperty());
/*
			backlogIdLabel.setText(Integer.toString(Backlog.getBacklogId()));
			backlogThemeLabel.setText(Backlog.getBacklogTheme());
			backlogSprintLabel.setText(Backlog.getBacklogSprint());
			backlogUserStoryLabel.setText(Backlog.getBacklogUserStory());
			//backlogTasksLabel.setText(Backlog.getBacklogTask());
			backlogNotesLabel.setText(Backlog.getBacklogNotes());
			backlogPriorityLabel.setText(Integer.toString(Backlog.getBacklogPriority()));
			backlogStatusLabel.setText(Backlog.getBacklogStatus());
			*/
		} else {
			/*
			// Backlog is null, remove all the text.
			backlogIdLabel.setText("");
			backlogThemeLabel.setText("");
			backlogSprintLabel.setText("");
			backlogUserStoryLabel.setText("");
			//backlogTasksLabel.setText("");
			backlogNotesLabel.setText("");
			backlogPriorityLabel.setText("");
			backlogStatusLabel.setText("");
			*/
		}
	}
	private void showSprintBacklogDetails(SprintBacklog sprintBacklog) {
		
	}
	
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void deleteBacklogEntry() {
		int selectedIndex = productBacklogTable.getSelectionModel().getSelectedIndex();
		int sprintIndex = sprintBacklogTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	    	productBacklogTable.getItems().remove(selectedIndex);
	    } else if (sprintIndex >= 0) {
	    	sprintBacklogTable.getItems().remove(sprintIndex);
	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");

	        alert.showAndWait();
	    }
	}
		
	    
	    /**
	     * Called when the user clicks the new button. Opens a dialog to edit
	     * details for a new person.
	     */
	    @FXML
	    private void handleNewProductBlEntry() {
	        ProductBacklog tempBl = new ProductBacklog();
	        boolean okClicked = mainApp.showProductBacklogEditView(tempBl);
	        if (okClicked) {
	            mainApp.getProductBacklogData().add(tempBl);
	        }
	    }

	    /**
	     * Called when the user clicks the edit button. Opens a dialog to edit
	     * details for the selected person.
	     */
	    @FXML
	    private void handleEditProductBl() {
	        ProductBacklog selectedBacklog = productBacklogTable.getSelectionModel().getSelectedItem();
	        if (selectedBacklog != null) {
	            boolean okClicked = mainApp.showProductBacklogEditView(selectedBacklog);
	            if (okClicked) {
	                showBacklogDetails(selectedBacklog);
	            }

	        } else {
	            // Nothing selected.
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainApp.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Backlog Selected");
	            alert.setContentText("Please select a backlog in the table.");

	            alert.showAndWait();
	        }
	    }
		
	   
}
