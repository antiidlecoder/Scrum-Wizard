package application.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Joel Frehner
 */
@XmlRootElement(name = "backlogs")
public class BacklogListWrapper {

    private List<ProductBacklog> productBacklogs;
    private List<SprintBacklog> sprintBacklogs;

    @XmlElement(name = "backlog")
    public List<ProductBacklog> getBacklogs() {
        return productBacklogs;
    }
    
    @XmlElement(name = "sprintBacklog")
    public List<SprintBacklog> getSprintBacklogs() {
        return sprintBacklogs;
    }

    public void setBacklogs(List<ProductBacklog> productBacklogs) {
        this.productBacklogs = productBacklogs;
    }
    
    public void setSprintBacklogs(List<SprintBacklog> sprintBacklogs) {
        this.sprintBacklogs = sprintBacklogs;
    }
}