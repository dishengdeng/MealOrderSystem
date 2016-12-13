package mealOrder;
/**
 * @author DishengDeng
 *
 */
public enum MealType {
	/**
	 * This class is to define the meal type, which can be also convenient for sorting.
	 * 
	 */
	vegetarian(0),
	gluten_free(1),
	nut_free(2),
	fish_free(3),
	others(4);
	
	private final int _typeId;
	
	private MealType(final int typeId)
	{
		_typeId = typeId;
	}
	
	public int getTypeId()
	{
		return _typeId;
	}
}
