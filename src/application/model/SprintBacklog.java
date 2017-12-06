package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringProperty;

public class SprintBacklog {
	
	private StringProperty taskId;
	private StringProperty task;
	private StringProperty priority;
	private StringProperty timeS;
	private StringProperty timeI;
	private StringProperty status;
	
	public SprintBacklog() {
		this.taskId = new SimpleStringProperty("1");
		this.task = new SimpleStringProperty("Submit button stylen");
		this.priority = new SimpleStringProperty("1");
		this.timeS = new SimpleStringProperty("60");
		this.timeI = new SimpleStringProperty("90");
		this.status = new SimpleStringProperty("In progress");
	}
	
	
	public StringProperty TaskId() {
		return taskId;
	}
	public void setTaskId(StringProperty taskId) {
		this.taskId = taskId;
	}
	public String getTaskId() {
		return taskId.get();
	}
	
	public StringProperty Task() {
		return task;
	}
	public void setTask(StringProperty task) {
		this.task = task;
	}
	public String getTask() {
		return task.get();
	}
	
	public StringProperty Priority() {
		return priority;
	}
	public void setPriority(StringProperty priority) {
		this.priority = priority;
	}
	public String getPriority() {
		return priority.get();
	}
	
	public StringProperty TimeS() {
		return timeS;
	}
	public void setTimeS(StringProperty timeS) {
		this.timeS = timeS;
	}
	public String getTimeS() {
		return timeS.get();
	}
	
	public StringProperty TimeI() {
		return timeI;
	}
	public void setTimeI(StringProperty timeI) {
		this.timeI = timeI;
	}
	public String getTimeI() {
		return timeI.get();
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
