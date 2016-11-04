package ty.sprmvc.controller.product;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ty.sprmvc.domain.product.Employee;
import ty.sprmvc.domain.product.Product;

@org.springframework.stereotype.Controller
public class EmployeeController {
	
	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value="/input-employee.pro")
	public String inputEmployee(Model model) {
        model.addAttribute(new Employee());
		return "product/EmployeeForm";
	}

	@RequestMapping(value="/save-employee.pro")
	public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult,
			Model model) {
		// we don't need ProductForm anymore,l
		// Spring MVC can bind HTML forms to Java objects
		if (bindingResult.hasErrors()) {
			FieldError fieldError = bindingResult.getFieldError();
			logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
			return "product/EmployeeForm";
		}

		// save product here
	    model.addAttribute("employee", employee);
	    
		return "product/EmployeeDetails";
	}
	
	/*
	//增加number参数 input-employee.pro?number=2
	@ModelAttribute
	public Product addAccount(@RequestParam String number) {
		logger.info("addAccount called. number is " + number);
	    return new Product();
	}
	// Add multiple attributes
	@ModelAttribute
	public void populateModel(@RequestParam String number, Model model) {
	    logger.info("populateModel called. number is " + number);
	    model.addAttribute("blah");
	}
	*/
}
