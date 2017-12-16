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
@XmlRootElement(name = "productBacklogs")
public class ProductBacklogListWrapper {

    private List<ProductBacklog> productBacklogs;

    @XmlElement(name = "productBacklog")
    public List<ProductBacklog> getProductBacklogs() {
        return productBacklogs;
    }

    public void setProductBacklogs(List<ProductBacklog> productBacklogs) {
        this.productBacklogs = productBacklogs;
    }
}