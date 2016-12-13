package mealOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * @author DishengDeng
 *
 */
public class OrderHandlerImp implements OrderHandler{
	/**
	 * This class is the core of the system, which handle the ordering.
	 * 
	 */
	private List<Restaurant> _restaurants;
	private List<Meal> _orderList;
	
	
	public OrderHandlerImp(List<Restaurant> restaurants, List<Meal> orderList) {

		this._restaurants = restaurants;
		this._orderList = orderList;
	}

	@Override
	public List<Order> genrateOrders() {
		sortRestaurantByRating(_restaurants);
		
		List<Order> orders = new ArrayList<Order>();
		if(checkRestaurantCapacity(_restaurants,_orderList))//if the restaurants are not able to serve, return empty order list
		{
			List<Restaurant> copyRestaurants = new ArrayList<>(_restaurants);//make a copy of _restaurants
			for(Restaurant restaurant:copyRestaurants)
			{
				final Order order = getOrder(restaurant);
				if(!order.isEmpty())
				{
					orders.add(order);
				}
			}
		}

		
		return orders;
	}

	@Override
	public void setOrderList(List<Meal> orderList) {
		
		_orderList = orderList;
	}

	@Override
	public List<Meal> getOrderList() {
		sortMealListByTypeId(_orderList);
		return _orderList;
	}

	@Override
	public List<Restaurant> getRestaurants() {
		sortRestaurantByRating(_restaurants);
		return _restaurants;
	}

	@Override
	public String generateOrderString(Order order) {
		
		String output = order.getRestaurantName();
		output += " (";
		for(Meal orderMeal:order.getOrderList())
		{
			if(order.getOrderList().indexOf(orderMeal) == order.getOrderList().size()-1)
			{
				output += String.valueOf(orderMeal.getAmount()) + " " + orderMeal.getType();
			}
			else
			{
				output += String.valueOf(orderMeal.getAmount()) + " " + orderMeal.getType() + " + ";
			}
			
		}
		output += ")";
		return output;
	}
	
	private void sortRestaurantByRating(List<Restaurant> restaurants)
	{
		if(restaurants.size() > 0)
		{
			Collections.sort(restaurants,new Comparator<Restaurant>(){

				@Override
				public int compare(Restaurant restaurant0, Restaurant restaurant1) {
					
					int i = Double.compare(restaurant1.getRating(), restaurant0.getRating());
					if(i == 0)//if the restaurants have the same rating, order by name(A-Z)
					{
						return restaurant0.getName().compareTo(restaurant1.getName());
					}
					else
					{
						return i;
					}
				}
				
			}
			);
		}
	}
	
	private void sortMealListByTypeId(List<Meal> MealList)
	{
		if(MealList.size() > 0)
		{
			Collections.sort(MealList,new Comparator<Meal>(){

				@Override
				public int compare(Meal o1, Meal o2) {
					
					return Integer.compare(o1.getType().getTypeId(), o2.getType().getTypeId());
				}
				
			});
		}
	}
	
	private boolean checkRestaurantCapacity(List<Restaurant> restaurants,List<Meal> orderList)
	{
		boolean result = true;
		for(Meal orderMeal:orderList)
		{
			int amount = 0;
			for(Restaurant r : restaurants)
			{
				final int index = r.getCapacity().indexOf(orderMeal);
				if(index > -1)
				{
					amount += r.getCapacity().get(index).getAmount();
				}
			}
			
			if(amount < orderMeal.getAmount())
			{
				result = false;
			}
		}
		return result;
	}
	
	private Order getOrder(Restaurant restaurant)
	{
		Order order = new Order();
		List<Meal> bill = new ArrayList<Meal>();
		List<Meal> copyOrderList = new ArrayList<Meal>(_orderList);//make a copy of _orderList
		for(Meal orderMeal:copyOrderList)
		{
			final int index = restaurant.getCapacity().indexOf(orderMeal);
			if(index > -1) //check whether restaurant offer the meal
			{
				final int restaurantMealAmount = restaurant.getCapacity().get(index).getAmount();
				if(restaurantMealAmount > 0)// if the amount = 0 in a restaurant meal list, it means sold out
				{
				
					order.setRestaurantName(restaurant.getName());
					if(restaurantMealAmount >= orderMeal.getAmount())
					{
						bill.add(new Meal(orderMeal.getType(),orderMeal.getAmount()));
						//reset the order list for the next restaurant to order
						_orderList.remove(orderMeal);//no need to order anymore
						
						//reset restaurant's capacity
						_restaurants.get(_restaurants.indexOf(restaurant)).getCapacity().get(index).setAmount(restaurantMealAmount - orderMeal.getAmount());
					}
					else
					{
						bill.add(new Meal(orderMeal.getType(),restaurantMealAmount));
						//reset the order list for the next restaurant to order
						_orderList.get(_orderList.indexOf(orderMeal)).setAmount(orderMeal.getAmount() - restaurantMealAmount);;//no need to order anymore
						
						//reset restaurant's capacity
						_restaurants.get(_restaurants.indexOf(restaurant)).getCapacity().get(index).setAmount(0);
					}
				}
			}
		}
		sortMealListByTypeId(bill);
		if(bill.size()>0)
		{
			order.setOrderList(bill);
		}
		return order;
	}

}
