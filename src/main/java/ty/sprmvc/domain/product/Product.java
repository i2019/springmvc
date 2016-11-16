package ty.sprmvc.domain.product;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Size;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9152283832829370860L;
	
	private String id;
    
	//JSR 303 Validator
	@Size(min=1,max=10)
	private String name;
	
    private String description;
    private BigDecimal price;
    private LocalDate productionDate;
    private String productionDateFrom;
    
    public String getProductionDateFrom() {
		return productionDateFrom;
	}
	public void setProductionDateFrom(String productionDateFrom) {
		this.productionDateFrom = productionDateFrom;
	}
	public LocalDate getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
   
}