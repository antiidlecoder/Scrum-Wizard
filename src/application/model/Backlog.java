package application.model;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Backlog {
	
	private StringProperty projectName;
	private IntegerProperty backlogId;
	private StringProperty backlogTheme;
	private StringProperty backlogSprint;
	private StringProperty backlogUserStory;
	private StringProperty backlogTasks;
	private StringProperty backlogNotes;
	private IntegerProperty backlogPriority;
	private StringProperty backlogStatus;
	

    
    /**
     * Constructor with some initial data.
     * 
     * @param backlogId
     * @param backlogTheme
     */
    public Backlog(int backlogId, String backlogTheme) {
    	this.projectName = new SimpleStringProperty("ProjektX");
    	
        this.backlogId = new SimpleIntegerProperty(backlogId);
        this.backlogTheme = new SimpleStringProperty(backlogTheme);
        
        this.backlogSprint = new SimpleStringProperty("1");
        this.backlogUserStory = new SimpleStringProperty("Test Story");
        this.backlogTasks = new SimpleStringProperty("Test Task");
        this.backlogNotes = new SimpleStringProperty("-");
        this.backlogPriority = new SimpleIntegerProperty(1);
        this.backlogStatus = new SimpleStringProperty("In progress");
        
    }
    
    
    public String getProjectName() {
        return projectName.get();
    }

    public void setProjectName(String projectName) {
        this.projectName.set(projectName);
    }

	public StringProperty ProjectNameProperty() {
		return projectName;
	}
	
	
    public int getBacklogId() {
        return backlogId.get();
    }

    public void setBacklogId(int backlogId) {
        this.backlogId.set(backlogId);
    }

	public IntegerProperty BacklogIdProperty() {
		return backlogId;
	}
		
    public String getBacklogTheme() {
        return backlogTheme.get();
    }

    public void setBacklogTheme(String backlogTheme) {
        this.backlogTheme.set(backlogTheme);
    }

	public StringProperty BacklogThemeProperty() {
		return backlogTheme;
	}	
	
    public String getBacklogSprint() {
        return backlogSprint.get();
    }

    public void setBacklogSprint(String backlogSprint) {
        this.backlogSprint.set(backlogSprint);
    }

	public StringProperty BacklogSprintProperty() {
		return backlogSprint;
	}

    public String getBacklogUserStory() {
        return backlogUserStory.get();
    }

    public void setBacklogUserStory(String backlogUserStory) {
        this.backlogUserStory.set(backlogUserStory);
    }
	
	public StringProperty BacklogUserStoryProperty() {
		return backlogUserStory;
	}
	
    public String getBacklogTask() {
        return backlogTasks.get();
    }

    public void setBacklogTask(String backlogTasks) {
        this.backlogTasks.set(backlogTasks);
    }

	public StringProperty BacklogTaskProperty() {
		return backlogTasks;
	}

    public String getBacklogNotes() {
        return backlogNotes.get();
    }

    public void setBacklogNotes(String backlogNotes) {
        this.backlogNotes.set(backlogNotes);
    }
    
	public StringProperty BacklogNotesProperty() {
		return backlogNotes;
	}
	
    public int getBacklogPriority() {
        return backlogPriority.get();
    }

    public void setBacklogPriority(int backlogPriority) {
        this.backlogPriority.set(backlogPriority);
    }

	public IntegerProperty BacklogPriorityProperty() {
		return backlogPriority;
	}

    public String getBacklogStatus() {
        return backlogStatus.get();
    }

    public void setBacklogStatus(String backlogStatus) {
        this.backlogStatus.set(backlogStatus);
    }
    
	
	public StringProperty BacklogStatusProperty() {
		return backlogStatus;
	}
	
	
	
    
    

}
