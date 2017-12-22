package application.view;



import application.Main;
import application.model.ProductBacklog;
import application.model.SprintBacklog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BacklogOverviewController {
	@FXML
	private TableView<ProductBacklog> projectBacklogTable;
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
	private TableColumn<SprintBacklog, String> sbTask;
	@FXML
	private TableColumn<SprintBacklog, String> sbDescription;
	@FXML
	private TableColumn<SprintBacklog, String> sbPriority;
	@FXML
	private TableColumn<SprintBacklog, String> sbTimeS;
	@FXML
	private TableColumn<SprintBacklog, String> sbTimeI;
	@FXML
	private TableColumn<SprintBacklog, String> sbResponsible;
	@FXML
	private TableColumn<SprintBacklog, String> sbStatus;

	@FXML
	private TabPane tabPane;

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
				cellData -> cellData.getValue().PBStatus());


		sbTask.setCellValueFactory(
				cellData -> cellData.getValue().Task());
		sbDescription.setCellValueFactory(
				cellData -> cellData.getValue().Description());
		sbPriority.setCellValueFactory(
				cellData -> cellData.getValue().Priority());
		sbTimeS.setCellValueFactory(
				cellData -> cellData.getValue().TimeS());
		sbTimeI.setCellValueFactory(
				cellData -> cellData.getValue().TimeI());
		sbResponsible.setCellValueFactory(
				cellData -> cellData.getValue().Responsible());
		sbStatus.setCellValueFactory(
				cellData -> cellData.getValue().SBStatus());


		// Clear Backlog details.
		showProductBacklogDetails(null);
		showSprintBacklogDetails(null);

		// Listen for selection changes and show the Backlog details when changed.
		productBacklogTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showProductBacklogDetails(newValue));
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
	 * @param ProductBacklog the Backlog or null
	 * 
	 * for upcoming detail-view
	 */
	private void showProductBacklogDetails(ProductBacklog ProductBacklog) {
		if (ProductBacklog != null) {

		} else {

		}
	}

	/**
	 * Fills all text fields to show details about the Backlog.
	 * If the specified Backlog is null, all text fields are cleared.
	 * 
	 * @param Backlog the Backlog or null
	 * 
	 * for upcoming detail-view
	 */
	private void showSprintBacklogDetails(SprintBacklog Backlog) {
		if (Backlog != null) {

		} else {

		}
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
			alert.setHeaderText("No Backlog Selected");
			alert.setContentText("Please select a backlog in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new backlog.
	 */
	@FXML
	private void handleNewBacklogEntry() {

		//SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
		int tab = tabPane.getSelectionModel().getSelectedIndex();
		if (tab == 1) {
			SprintBacklog tempSl = new SprintBacklog();
			boolean sprintOk = mainApp.showSprintBacklogEditView(tempSl);
			if (sprintOk) {
				mainApp.getSprintBacklogData().add(tempSl);
			}
		} else if (tab == 0) {
			ProductBacklog tempBl = new ProductBacklog();
			boolean okClicked = mainApp.showProductBacklogEditView(tempBl);
			if (okClicked) {
				mainApp.getProductBacklogData().add(tempBl);
			}
		} 

	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected backlog.
	 */
	@FXML
	private void handleEditBacklog() {
		ProductBacklog selectedProductBacklog = productBacklogTable.getSelectionModel().getSelectedItem();
		SprintBacklog selectedSprintBacklog = sprintBacklogTable.getSelectionModel().getSelectedItem();

		int tab = tabPane.getSelectionModel().getSelectedIndex();
		if (tab == 1) {
			if (selectedSprintBacklog != null) {
				boolean sprintOk = mainApp.showSprintBacklogEditView(selectedSprintBacklog);
				if (sprintOk) {
					showSprintBacklogDetails(selectedSprintBacklog);
				}
			} else {
				// Nothing selected.
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("No Selection");
				alert.setHeaderText("No Backlog Selected");
				alert.setContentText("Please select a task in the table.");

				alert.showAndWait();
			}
		} else if (tab == 0) {
			if (selectedProductBacklog != null) {
				boolean okClicked = mainApp.showProductBacklogEditView(selectedProductBacklog);
				if (okClicked) {
					showProductBacklogDetails(selectedProductBacklog);
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
}
