package ty.sprmvc.service.product;

import ty.sprmvc.domain.product.Product;

public interface ProductService {
	Product add(Product product);
	Product get(String id);
}
