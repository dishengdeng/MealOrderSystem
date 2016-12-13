package mealOrder;

import java.util.List;
/**
 * @author DishengDeng
 *
 */
public interface OrderHandler {
	/**
	 * This interface is to define the order handler methods that can enable system accessibility.
	 * 
	 */
	public List<Order> genrateOrders();
	public void setOrderList(List<Meal> orderList);
	public List<Meal> getOrderList();
	public List<Restaurant> getRestaurants();
	public String generateOrderString(Order order);	
	
}
