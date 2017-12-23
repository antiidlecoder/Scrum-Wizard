package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SprintBacklog {
	
	private StringProperty sprint = new SimpleStringProperty();
	private StringProperty task  = new SimpleStringProperty();
	private StringProperty description  = new SimpleStringProperty();	
	private StringProperty priority  = new SimpleStringProperty();
	private StringProperty timeS  = new SimpleStringProperty();
	private StringProperty timeI  = new SimpleStringProperty();
	private StringProperty responsible  = new SimpleStringProperty();
	private StringProperty sbStatus  = new SimpleStringProperty();

	
	
	public SprintBacklog() {
			
	}
	
	
	public void setSBSprint(String sprint) {
		this.sprint.set(sprint);
	}
	public String getSBSprint() {
		return sprint.get();
	}
	public StringProperty SBSprint() {
		return sprint;
	}
	
	
	public void setTask(String task) {
		this.task.set(task);
	}
	public String getTask() {
		return task.get();
	}
	public StringProperty Task() {
		return task;
	}
	
	
	public void setDescription(String description) {
		this.description.set(description);;
	}
	public String getDescription() {
		return description.get();
	}
	public StringProperty Description() {
		return description;
	}
	
	
	public void setPriority(String priority) {
		this.priority.set(priority);
	}
	public String getPriority() {
		return priority.get();
	}
	public StringProperty Priority() {
		return priority;
	}
	
	
	public void setTimeS(String timeS) {
		this.timeS.set(timeS);;
	}
	public String getTimeS() {
		return timeS.get();
	}
	public StringProperty TimeS() {
		return timeS;
	}
	
	
	public void setTimeI(String timeI) {
		this.timeI.set(timeI);
	}
	public String getTimeI() {
		return timeI.get();
	}
	public StringProperty TimeI() {
		return timeI;
	}
	
	
	public void setResponsible(String responsible) {
		this.responsible.set(responsible);;
	}
	public String getResponsible() {
		return responsible.get();
	}
	public StringProperty Responsible() {
		return responsible;
	}
	
	
	public void setSBStatus(String status) {
		this.sbStatus.set(status);
	}
	public String getSBStatus() {
		return sbStatus.get();
	}
	public StringProperty SBStatus() {
		return sbStatus;
	}

	
}
