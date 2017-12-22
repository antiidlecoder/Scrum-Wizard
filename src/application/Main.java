package application;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import application.model.ProductBacklog;
import application.model.BacklogListWrapper;
import application.model.SprintBacklog;
import application.view.BacklogEditViewController;
import application.view.BacklogOverviewController;
import application.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * @author Joel Frehner
 * @author Joël Schöni
 * @author Benni Lux
 * @author Lukas Järmann
 * 
 */
public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;


	/**
	 * The data as an observable list of Backlogs.
	 */
	private ObservableList<ProductBacklog> productBacklogData = FXCollections.observableArrayList();
	private ObservableList<SprintBacklog> sprintBacklogData = FXCollections.observableArrayList();

	/**
	 * Constructor
	 */
	public Main() {

	}


	/**
	 * Returns the data as an observable list of Backlogs. 
	 * @return
	 */
	public ObservableList<ProductBacklog> getProductBacklogData() {
		return productBacklogData;
	}

	public ObservableList<SprintBacklog> getSprintBacklogData() {
		return sprintBacklogData;
	}



	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Scrum Wizard LITE");

		initRootLayout();

		showBacklogOverview();
	}

	/**
	 * Initializes the root layout and tries to load the last opened
	 * backlog file.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMain(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Try to load last opened backlog file.
		File file = getBacklogFilePath();
		if (file != null) {
			loadBacklogDataFromFile(file);
		}
	}

	/**
	 * Shows the Backlog overview inside the root layout.
	 */
	public void showBacklogOverview() {
		try {
			// Load Backlog overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/BacklogOverview.fxml"));
			AnchorPane BacklogOverview = (AnchorPane) loader.load();

			// Set Backlog overview into the center of root layout.
			rootLayout.setCenter(BacklogOverview);

			// Give the controller access to the main app.
			BacklogOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens a dialog to edit details for the specified backlog. If the user
	 * clicks OK, the changes are saved into the provided backlog object and true
	 * is returned.
	 * 
	 * @param backlog the backlog object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showProductBacklogEditView(ProductBacklog productBacklog) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/ProductBacklogEditView.fxml"));
			BorderPane page = (BorderPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Backlog bearbeiten");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the backlog into the controller.
			BacklogEditViewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setBacklog(productBacklog);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Opens a dialog to edit details for the specified backlog. If the user
	 * clicks OK, the changes are saved into the provided backlog object and true
	 * is returned.
	 * 
	 * @param backlog the backlog object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showSprintBacklogEditView(SprintBacklog tempSl) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/SprintBacklogEditView.fxml"));
			BorderPane page = (BorderPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Sprint bearbeiten");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the backlog into the controller.
			BacklogEditViewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSprintBacklog(tempSl);
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isSprintOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}


	/**
	 * Returns the backlog file preference, i.e. the file that was last opened.
	 * The preference is read from the OS specific registry. If no such
	 * preference can be found, null is returned.
	 * 
	 * @return
	 */
	public File getBacklogFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(Main.class);
		String filePath = prefs.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	/**
	 * Sets the file path of the currently loaded file. The path is persisted in
	 * the OS specific registry.
	 * 
	 * @param file the file or null to remove the path
	 */
	public void setBacklogFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(Main.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update the stage title.
			primaryStage.setTitle("Scrum Wizard - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Update the stage title.
			primaryStage.setTitle("Scrum Wizard");
		}
	}



	/**
	 * Loads backlog data from the specified file. The current backlog data will
	 * be replaced.
	 * 
	 * @param file
	 */
	public void loadBacklogDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext
					.newInstance(BacklogListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			BacklogListWrapper wrapper = (BacklogListWrapper) um.unmarshal(file);

			productBacklogData.clear();
			sprintBacklogData.clear();
			productBacklogData.addAll(wrapper.getBacklogs());
			sprintBacklogData.addAll(wrapper.getSprintBacklogs());

			// Save the file path to the registry.
			setBacklogFilePath(file);

		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load data");
			alert.setContentText("Could not load data from file:\n" + file.getPath());

			alert.showAndWait();
		}
	}

	/**
	 * Saves the current backlog data to the specified file.
	 * 
	 * @param file
	 */
	public void saveBacklogDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext
					.newInstance(BacklogListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our backlog data.
			BacklogListWrapper wrapper = new BacklogListWrapper();
			wrapper.setBacklogs(productBacklogData);
			wrapper.setSprintBacklogs(sprintBacklogData);

			// Marshalling and saving XML to the file.
			m.marshal(wrapper, file);

			// Save the file path to the registry.
			setBacklogFilePath(file);
		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not save data");
			alert.setContentText("Could not save data to file:\n" + file.getPath());

			alert.showAndWait();
		}
	}
}