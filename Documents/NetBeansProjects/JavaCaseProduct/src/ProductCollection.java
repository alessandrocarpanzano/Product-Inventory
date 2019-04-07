/**
 *
 * @author Alessandro Carpanzano
 */
import java.util.*;
public class ProductCollection {
    private ArrayList<Product> productsArrayList;
    
public ProductCollection(){
productsArrayList = new ArrayList<Product>();
}
public void addProduct(Product newProduct) {
		productsArrayList.add(newProduct);
	}
public void removeProduct(int removeProduct) {
		productsArrayList.remove(removeProduct);
	}
public Product getProduct(int productIndex) {
		return productsArrayList.get(productIndex);
	}

}