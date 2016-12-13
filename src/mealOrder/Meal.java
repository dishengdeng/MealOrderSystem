package mealOrder;
/**
 * @author DishengDeng
 *
 */
public class Meal {
	/**
	 * This class is to store the order meal data from team and the restaurant's capacity
	 * 
	 */
	private MealType _type;
	private int _amount;
	
	public Meal(MealType type, int amount) {
		
		this._type = type;
		this._amount = amount;
	}

	public MealType getType() {
		return _type;
	}

	public void setType(MealType _type) {
		this._type = _type;
	}

	public int getAmount() {
		return _amount;
	}

	public void setAmount(int _amount) {
		this._amount = _amount;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Meal.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
		
	    final Meal otherMeal = (Meal)obj;
		
	    if(this._type == otherMeal._type)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	
	
	
}
