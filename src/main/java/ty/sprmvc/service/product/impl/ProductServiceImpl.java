package ty.sprmvc.service.product.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import ty.sprmvc.domain.product.Product;
import ty.sprmvc.service.product.ProductService;
import ty.sprmvc.util.Utils;

@Service
public class ProductServiceImpl implements ProductService {

	 private Map<String, Product> products = new HashMap<String, Product>();
	    private AtomicLong generator = new AtomicLong();

	    public ProductServiceImpl() {
	        Product product = new Product();
	        product.setName("JX1 Power Drill");
	        product.setDescription("Powerful hand drill, made to perfection");
	        product.setPrice(new BigDecimal(129.99));
	        add(product);
	    }

	    @Override
	    public Product add(Product product) {
	        String newId = generator.incrementAndGet()+"";
	        product.setId(newId);
	        products.put(newId, product);
	        return product;
	    }

	    @Override
	    public Product get(String id) {
	        return products.get(id);
	    }
	    
	/*
	@Override
	public Product add(Product product) {
		if(null!=product&&product.getId()==null){
			product.setId(Utils.getGenerateKey());
		}
		return product;
	}

	@Override
	public Product get(String id) {
		Product p=new Product();
		return p;
	}
	*/
}
