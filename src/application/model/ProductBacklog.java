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
	
	
	public StringProperty ThemeId() {
		return themeId;
	}
	public void setThemeId(StringProperty themeId) {
		this.themeId = themeId;
	}
	public String getThemeId() {
		return themeId.get();
	}
	
	public StringProperty Theme() {
		return theme;
	}
	public void setTheme(StringProperty theme) {
		this.theme = theme;
	}
	public String getTheme() {
		return theme.get();
	}
	
	public StringProperty Sprint() {
		return sprint;
	}
	public void setSprint(StringProperty sprint) {
		this.sprint = sprint;
	}
	public String getSprint() {
		return sprint.get();
	}
	
	public StringProperty UserStory() {
		return userStory;
	}
	public void setUserStory(StringProperty userStory) {
		this.userStory = userStory;
	}
	public String getUserStory() {
		return userStory.get();
	}
	
	public StringProperty Status() {
		return status;
	}
	public void setStatus(StringProperty status) {
		this.status = status;
	}
	public String getStatus() {
		return status.get();
	}


}
