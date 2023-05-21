package teluskoProductDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

	List<Product> products = new ArrayList<>();

	public void addProduct(Product p) {
		products.add(p);
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public List<Product> getProductWithText(String txt) {
		final String text = txt.toLowerCase();
		return products
				.stream().filter(p -> p.getName().toLowerCase().contains(text)
						|| p.getType().toLowerCase().contains(text) || p.getPlace().toLowerCase().contains(text))
				.collect(Collectors.toList());

	}

	public List<Product> getNonWarrantyProducts() {
		return products.stream().filter(p -> p.getWarranty() < 2023).collect(Collectors.toList());

	}

	public List<Product> getUnderWarrantyProducts() {
		return products.stream().filter(p -> p.getWarranty() > 2022).collect(Collectors.toList());
	}

}
