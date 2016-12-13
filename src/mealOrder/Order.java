package mealOrder;

import java.util.List;
/**
 * @author DishengDeng
 *
 */
public class Order {
	/**
	 * This class is to output the order for the team.
	 * 
	 */
	private String _restaurantName;
	private List<Meal> _orderList;
	
	public Order() {		


	}

	public String getRestaurantName() {
		return _restaurantName;
	}

	public void setRestaurantName(String _Name) {
		this._restaurantName = _Name;
	}

	public List<Meal> getOrderList() {
		return _orderList;
	}

	public void setOrderList(List<Meal> _orderList) {
		this._orderList = _orderList;
	}
	
	public boolean isEmpty()
	{
		if(_restaurantName == null && _orderList ==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

	
}
