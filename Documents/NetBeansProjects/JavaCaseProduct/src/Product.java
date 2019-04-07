/**
 *
 * @author Alessandro Carpanzano
 */
public class Product
//attributes
{
	private String name;
	private int stockLevel;
	private double price;

//methods
public Product(String nameIn, int stockLevelIn, double priceIn) 
{
	name = nameIn;
	stockLevel = stockLevelIn;
	price = priceIn;
}
// methods to read the attributes
public void reStock(int reStockAmount)
{
	stockLevel = stockLevel+reStockAmount; 	
}
public double sell(int itemSold) throws SellException
{
	if(itemSold<=stockLevel)
	{
		stockLevel = stockLevel-itemSold;
		
	}
	else
{
	throw new SellException("Couldn't sell the product because our stock level is:  "+ getStockLevel());
}
	return price*itemSold;
}
public void setPrice(double priceIn)
{
	price = priceIn;
}
public String getName()
{
	return name;
}
public int getStockLevel()
{
	return stockLevel;
}
public double getPrice()
{
	return price;
}
public void setName(String nameIn)
{
    name = nameIn;
}


}

