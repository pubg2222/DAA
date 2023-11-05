import java.util.Arrays;
import java.util.Comparator;
class CompareItem implements Comparator<ItemValue>{
	public int compare(ItemValue a, ItemValue b){
		double first = (double)a.profit/a.weight;
		double second = (double)b.profit/b.weight;
		if(first<second) return 1;
		return -1;
	}
}
class ItemValue {
		int profit, weight, number;
		// Item value function
		public ItemValue(int num,int profit, int weight)
		{
			this.weight = weight;
			this.profit = profit;
            this.number = num;
		}
	}
// Greedy approach
public class FractionalKnapsack {
	// Function to get maximum value
	private static double getMaxValue(ItemValue[] arr, int capacity)
	{
		// Sorting items by profit/weight ratio;
		Arrays.sort(arr, new CompareItem());
        double totalValue = 0d;
		for (ItemValue i : arr) {
			if (capacity >= i.weight) {
				// This weight can be picked whole
				capacity -= i.weight;
				totalValue += i.profit;
                System.out.println("object " + i.number +" : included whole");
			}
			else {
				// Item cant be picked whole
				double fraction = (double)capacity/i.weight;
				totalValue += (i.profit * fraction);
				capacity = (int)(capacity - (i.weight * fraction));
                System.out.println("object " + i.number +" : included " + fraction*100+"%");
				break;
			}
		}
		return totalValue;
	}
	// Driver code
	public static void main(String[] args)
	{
		ItemValue[] arr = { new ItemValue(1, 100, 20),
			new ItemValue(2, 1000, 50),
			new ItemValue(3, 500, 25), };
		int capacity = 70;
		double maxValue = getMaxValue(arr, capacity);
		// Function call
		System.out.println("Maximum profit that can be achieved is "+maxValue);
	}
}
