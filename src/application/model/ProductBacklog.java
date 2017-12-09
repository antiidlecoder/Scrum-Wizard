package application.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductBacklog {
	
	private StringProperty themeId;
	private StringProperty theme;
	private StringProperty sprint;
	private StringProperty userStory;
	private StringProperty status;

	
	
	public ProductBacklog() {
		this.themeId = new SimpleStringProperty("1");
		this.theme = new SimpleStringProperty("Front-End");
		this.sprint = new SimpleStringProperty("1");
		this.userStory = new SimpleStringProperty("As .. I want to.. So that a friend can see it.");
		this.status = new SimpleStringProperty("In progress");
	}
	
	
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
	
	
	public void setStatus(String status) {
		this.status.set(status);
	}
	public String getStatus() {
		return status.get();
	}
	public StringProperty Status() {
		return status;
	}


}
