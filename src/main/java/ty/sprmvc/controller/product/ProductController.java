package ty.sprmvc.controller.product;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ty.sprmvc.domain.product.Product;
import ty.sprmvc.domain.product.ProductForm;
import ty.sprmvc.service.product.ProductService;

@org.springframework.stereotype.Controller
public class ProductController{

    private static final Log logger = LogFactory.getLog(ProductController.class);
  
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value={"/input-product.pro"},method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView inputProduct(HttpServletRequest request,HttpServletResponse response) 
    		throws Exception {
        logger.info("InputProductController called");
        //return new ModelAndView("/WEB-INF/pages/product/ProductForm.jsp");
        return new ModelAndView("product/ProductForm");
    }
    
    @RequestMapping(value={"/save-product.pro"},method={RequestMethod.POST,RequestMethod.GET})
   /*
    public ModelAndView saveProduct(HttpServletRequest request
    		,HttpServletResponse response
    		,RedirectAttributes redirectAttributes
    		) throws Exception {
    */	
    public String saveProduct(HttpServletRequest request
    		,HttpServletResponse response
    		,RedirectAttributes redirectAttributes
    		) throws Exception {
        ProductForm productForm = new ProductForm();
        // populate action properties
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));
        
        // create model
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(new BigDecimal(productForm.getPrice()));
        } catch (NumberFormatException e) {
        	logger.info("NumberFormatException"+e.getMessage());
        }
        product=productService.add(product);
        
        //FlashAttribute 重定向传的值
        redirectAttributes.addFlashAttribute("message", "The product was successfully added.");
        //重定向到其他页面，防止重复提交
        return "redirect:/view-product.do/" + product.getId();
        
        // insert code to save Product
        //return new ModelAndView("/WEB-INF/pages/product/ProductDetails.jsp", "product",product);
        //return new ModelAndView("product/ProductDetails", "product",product);
    
    }
    @RequestMapping(value = "/view-product.pro/{id}")
    public String viewProduct(@PathVariable String id, Model model) {
        Product product = productService.get(id);
        
        product.setName(id);
        product.setDescription("test");
        
        model.addAttribute("product", product);
        return "product/ProductView";
    }
}
