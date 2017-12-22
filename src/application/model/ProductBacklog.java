package application.model;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class ProductBacklog {
	
	//Product backlog entities
	private StringProperty themeId = new SimpleStringProperty();
	private StringProperty theme = new SimpleStringProperty();
	private StringProperty sprint = new SimpleStringProperty();
	private StringProperty userStory = new SimpleStringProperty();
	private StringProperty pbStatus = new SimpleStringProperty();
	
 
	//Constructor
    public ProductBacklog() {
        
    }
    
    
    /**
     * 
     * GETTERS AND SETTERS
     *
     */
    
    public void setThemeId(StringProperty themeId) {
		this.themeId = themeId;
	}
	public String getThemeId() {
		return themeId.get();
	}
	public StringProperty ThemeId() {
		return themeId;
	}
	

	public void setTheme(String theme) {
		this.theme.set(theme);
	}
	public String getTheme() {
		return theme.get();
	}
	public StringProperty Theme() {
		return theme;
	}
	
	
	public void setSprint(String sprint) {
		this.sprint.set(sprint);
	}
	public String getSprint() {
		return sprint.get();
	}
	public StringProperty Sprint() {
		return sprint;
	}
	

	public void setUserStory(String userStory) {
		this.userStory.set(userStory);
	}
	public String getUserStory() {
		return userStory.get();
	}
	public StringProperty UserStory() {
		return userStory;
	}
	
	
	public void setPBStatus(String status) {
		this.pbStatus.set(status);
	}
	public String getPBStatus() {
		return pbStatus.get();
	}
	public StringProperty PBStatus() {
		return pbStatus;
	}
     
}
