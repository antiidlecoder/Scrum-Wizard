package application;

import java.io.IOException;

import application.model.Backlog;
import application.model.ProductBacklog;
import application.model.SprintBacklog;
import application.view.BacklogEditViewController;
import application.view.BacklogOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * @author Joel
 * @author Jo�l
 *
 */
public class Main extends Application {
	// salami + 2
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    
    /**
     * The data as an observable list of Backlogs.
     */
    private ObservableList<Backlog> backlogData = FXCollections.observableArrayList();
    private ObservableList<ProductBacklog> productBacklogData = FXCollections.observableArrayList();
    private ObservableList<SprintBacklog> sprintBacklogData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    
    public Main() {
        // Add some sample data
        productBacklogData.add(new ProductBacklog());
        sprintBacklogData.add(new SprintBacklog());
        /*
        backlogData.add(new Backlog(2, "Mueller"));
        backlogData.add(new Backlog(3, "Kurz"));
        backlogData.add(new Backlog(4, "Meier"));
        backlogData.add(new Backlog(5, "Meyer"));
        backlogData.add(new Backlog(6, "Kunz"));
        backlogData.add(new Backlog(7, "Best"));
        backlogData.add(new Backlog(8, "Meier"));
        backlogData.add(new Backlog(9, "Mueller"));
    	*/
    }
    
	
    /**
     * Returns the data as an observable list of Backlogs. 
     * @return
     */
    
    public ObservableList<Backlog> getBacklogData() {
        return backlogData;
    }
    
    
    public ObservableList<ProductBacklog> getProductBacklogData() {
        return productBacklogData;
    }
    
    public ObservableList<SprintBacklog> getSprintBacklogData() {
        return sprintBacklogData;
    }
    
    
    
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("S.C.R.U.M Wizard");

        initRootLayout();

        showBacklogOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
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
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showProductBacklogEditView(ProductBacklog backlog) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EditView.fxml"));
            BorderPane page = (BorderPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Backlog bearbeiten");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            BacklogEditViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setBacklog(backlog);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
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
}