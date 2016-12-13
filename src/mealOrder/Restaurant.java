package mealOrder;

import java.util.List;
/**
 * @author DishengDeng
 *
 */
public class Restaurant {
	/**
	 * This class is to store the restaurant data.
	 * 
	 */
	
	private String _name;
	private List<Meal> _capacity;
	private final double _baseRate = 5;
	private double _rate;
	public Restaurant(String name,double rate, List<Meal> capacity) {

		this._name = name;
		this._rate = rate;
		this._capacity = capacity;
		
	}
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	public List<Meal> getCapacity() {
		return _capacity;
	}
	public void setCapacity(List<Meal> _capacity) {
		this._capacity = _capacity;
	}

	public void setRate(double _rate) {
		this._rate = _rate;
	}
	
	public double getRating()
	{
		return _rate/_baseRate;
	}
	
	

}
