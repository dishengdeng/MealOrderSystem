package mealOrder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestOrderHandler {

	@Test
	public void TestCaseOne() {
		/*Test whether the order handler can process the order list by the highest rating restaurant first
		 * Restaurant A is 5
		 * Restaurant B is 3
		 * */
		//restaurant data
		List<Meal> _capacityA= new ArrayList<Meal>();
		_capacityA.add(new Meal(MealType.vegetarian,4));
		_capacityA.add(new Meal(MealType.others,36));
		
		Restaurant resturantA= new Restaurant("Restaurant A",5,_capacityA);
		
		List<Meal> _capacityB= new ArrayList<Meal>();
		_capacityB.add(new Meal(MealType.vegetarian,20));
		_capacityB.add(new Meal(MealType.gluten_free,20));
		_capacityB.add(new Meal(MealType.others,60));
		
		Restaurant resturantB= new Restaurant("Restaurant B",3,_capacityB);
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();			
		restaurants.add(resturantA);
		restaurants.add(resturantB);
		
		
		//team order list data

		
		List<Meal> orderList= new ArrayList<Meal>();
		orderList.add(new Meal(MealType.vegetarian,5));
		orderList.add(new Meal(MealType.gluten_free,7));
		orderList.add(new Meal(MealType.others,38));
		
		OrderHandler orderHandler= new OrderHandlerImp(restaurants,orderList);		

		
		List<Order> orders = orderHandler.genrateOrders();
		assertEquals(2, orders.size());
		assertEquals("Restaurant A (4 vegetarian + 36 others)", orderHandler.generateOrderString(orders.get(0)));
		assertEquals("Restaurant B (1 vegetarian + 7 gluten_free + 2 others)", orderHandler.generateOrderString(orders.get(1)));
	}

	@Test
	public void TestCaseTwo() {
		/*Test whether the order handler can process the order list by the highest rating restaurant first
		 * Restaurant A is 3
		 * Restaurant B is 5
		 * */
		//restaurant data
		List<Meal> _capacityA= new ArrayList<Meal>();
		_capacityA.add(new Meal(MealType.vegetarian,4));
		_capacityA.add(new Meal(MealType.others,36));
		
		Restaurant resturantA= new Restaurant("Restaurant A",3,_capacityA);
		
		List<Meal> _capacityB= new ArrayList<Meal>();
		_capacityB.add(new Meal(MealType.vegetarian,20));
		_capacityB.add(new Meal(MealType.gluten_free,20));
		_capacityB.add(new Meal(MealType.others,60));
		
		Restaurant resturantB= new Restaurant("Restaurant B",5,_capacityB);
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();			
		restaurants.add(resturantA);
		restaurants.add(resturantB);
		
		
		//team order list data

		
		List<Meal> orderList= new ArrayList<Meal>();
		orderList.add(new Meal(MealType.vegetarian,5));
		orderList.add(new Meal(MealType.gluten_free,7));
		orderList.add(new Meal(MealType.others,38));
		
		OrderHandler orderHandler= new OrderHandlerImp(restaurants,orderList);		

		
		List<Order> orders = orderHandler.genrateOrders();
		assertEquals(1, orders.size());
		assertEquals("Restaurant B (5 vegetarian + 7 gluten_free + 38 others)", orderHandler.generateOrderString(orders.get(0)));

	}
	
	@Test
	public void TestCaseThree() {
		/*Test whether the order handler can process the order list by restaurant names's order(A-Z) if the restaurants have the same rating.
		 * Restaurant A is 5
		 * Restaurant B is 5
		 * */
		//restaurant data
		List<Meal> _capacityA= new ArrayList<Meal>();
		_capacityA.add(new Meal(MealType.vegetarian,4));
		_capacityA.add(new Meal(MealType.others,36));
		
		Restaurant resturantA= new Restaurant("Restaurant A",5,_capacityA);
		
		List<Meal> _capacityB= new ArrayList<Meal>();
		_capacityB.add(new Meal(MealType.vegetarian,20));
		_capacityB.add(new Meal(MealType.gluten_free,20));
		_capacityB.add(new Meal(MealType.others,60));
		
		Restaurant resturantB= new Restaurant("Restaurant B",5,_capacityB);
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		restaurants.add(resturantB);//add resturantB first
		restaurants.add(resturantA);
		
		
		
		//team order list data

		
		List<Meal> orderList= new ArrayList<Meal>();
		orderList.add(new Meal(MealType.vegetarian,5));
		orderList.add(new Meal(MealType.gluten_free,7));
		orderList.add(new Meal(MealType.others,38));
		
		OrderHandler orderHandler= new OrderHandlerImp(restaurants,orderList);		

		
		List<Order> orders = orderHandler.genrateOrders();
		assertEquals(2, orders.size());
		assertEquals("Restaurant A (4 vegetarian + 36 others)", orderHandler.generateOrderString(orders.get(0)));
		assertEquals("Restaurant B (1 vegetarian + 7 gluten_free + 2 others)", orderHandler.generateOrderString(orders.get(1)));

	}
	
	
	@Test
	public void TestCaseFour() {
		/*Test whether the order handler can process the order list if the restaurants have the same rating and capacity.
		 * Restaurant A is 5
		 * Restaurant B is 5
		 * */
		//restaurant data
		List<Meal> _capacityA= new ArrayList<Meal>();
		_capacityA.add(new Meal(MealType.vegetarian,20));
		_capacityA.add(new Meal(MealType.gluten_free,20));
		_capacityA.add(new Meal(MealType.others,60));
		
		Restaurant resturantA= new Restaurant("Restaurant A",5,_capacityA);
		
		List<Meal> _capacityB= new ArrayList<Meal>();
		_capacityB.add(new Meal(MealType.vegetarian,20));
		_capacityB.add(new Meal(MealType.gluten_free,20));
		_capacityB.add(new Meal(MealType.others,60));
		
		Restaurant resturantB= new Restaurant("Restaurant B",5,_capacityB);
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		restaurants.add(resturantB);//add resturantB first
		restaurants.add(resturantA);
		
		
		
		//team order list data

		
		List<Meal> orderList= new ArrayList<Meal>();
		orderList.add(new Meal(MealType.vegetarian,5));
		orderList.add(new Meal(MealType.gluten_free,7));
		orderList.add(new Meal(MealType.others,38));
		
		OrderHandler orderHandler= new OrderHandlerImp(restaurants,orderList);		

		
		List<Order> orders = orderHandler.genrateOrders();
		assertEquals(1, orders.size());
		assertEquals("Restaurant A (5 vegetarian + 7 gluten_free + 38 others)", orderHandler.generateOrderString(orders.get(0)));


	}
	
	@Test
	public void TestCaseFive() {
		/*Test whether the order handler can process multiple times order in a day
		 * Restaurant A is 5
		 * Restaurant B is 3
		 * */
		//restaurant data
		List<Meal> _capacityA= new ArrayList<Meal>();
		_capacityA.add(new Meal(MealType.vegetarian,4));
		_capacityA.add(new Meal(MealType.others,36));
		
		Restaurant resturantA= new Restaurant("Restaurant A",5,_capacityA);
		
		List<Meal> _capacityB= new ArrayList<Meal>();
		_capacityB.add(new Meal(MealType.vegetarian,20));
		_capacityB.add(new Meal(MealType.gluten_free,20));
		_capacityB.add(new Meal(MealType.others,60));
		
		Restaurant resturantB= new Restaurant("Restaurant B",3,_capacityB);
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();			
		restaurants.add(resturantA);
		restaurants.add(resturantB);
		
		
		//team first order list data

		
		List<Meal> orderList= new ArrayList<Meal>();
		orderList.add(new Meal(MealType.vegetarian,5));
		orderList.add(new Meal(MealType.gluten_free,7));
		orderList.add(new Meal(MealType.others,38));
		
		OrderHandler orderHandler= new OrderHandlerImp(restaurants,orderList);		

		
		List<Order> orders = orderHandler.genrateOrders();
		assertEquals(2, orders.size());
		assertEquals("Restaurant A (4 vegetarian + 36 others)", orderHandler.generateOrderString(orders.get(0)));
		assertEquals("Restaurant B (1 vegetarian + 7 gluten_free + 2 others)", orderHandler.generateOrderString(orders.get(1)));
		
		
		
		//team second order list data
		List<Meal> orderList1= new ArrayList<Meal>();
		orderList1.add(new Meal(MealType.vegetarian,5));
		orderList1.add(new Meal(MealType.gluten_free,7));
		orderList1.add(new Meal(MealType.others,38));
		
		orderHandler.setOrderList(orderList1);
		
		List<Order> orders1 = orderHandler.genrateOrders();
		
		assertEquals(1, orders1.size());//restaurantA has sold out everything by the first team order
		assertEquals("Restaurant B (5 vegetarian + 7 gluten_free + 38 others)", orderHandler.generateOrderString(orders1.get(0)));
	}
	
	@Test
	public void TestCaseSix() {
		/*Test whether the order handler can return empty order list if the restaurants are not able to serve
		 * Restaurant A is 5
		 * Restaurant B is 3
		 * */
		//restaurant data
		List<Meal> _capacityA= new ArrayList<Meal>();
		_capacityA.add(new Meal(MealType.vegetarian,4));
		_capacityA.add(new Meal(MealType.others,36));
		
		Restaurant resturantA= new Restaurant("Restaurant A",5,_capacityA);
		
		List<Meal> _capacityB= new ArrayList<Meal>();
		_capacityB.add(new Meal(MealType.vegetarian,20));
		_capacityB.add(new Meal(MealType.gluten_free,20));
		_capacityB.add(new Meal(MealType.others,60));
		
		Restaurant resturantB= new Restaurant("Restaurant B",3,_capacityB);
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();			
		restaurants.add(resturantA);
		restaurants.add(resturantB);
		
		
		//team order list data

		
		List<Meal> orderList= new ArrayList<Meal>();
		orderList.add(new Meal(MealType.vegetarian,5));
		orderList.add(new Meal(MealType.gluten_free,21));//increase to 21
		orderList.add(new Meal(MealType.others,38));
		
		OrderHandler orderHandler= new OrderHandlerImp(restaurants,orderList);		

		
		List<Order> orders = orderHandler.genrateOrders();
		assertEquals(0, orders.size());

	}
}
