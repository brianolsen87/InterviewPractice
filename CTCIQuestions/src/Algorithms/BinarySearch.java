package Algorithms;

import java.util.List;

/**
 * BinarySearch algorithms that require that type T implements comparable.
 * 
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 * 
 * Assumptions: Input array is a distinct sorted list.
 * 
 * I want to make a few remarks on the "? super T" syntax. It's called a wild card and is used in conjunction with "super".
 * Super in Generics is the opposite of extends. Instead of saying the comparable's generic type has to be a subclass of T, 
 * it is saying it has to be a superclass of T.
 * A List<? super Integer>, for example, includes List<Integer>, List<Number>, and List<Object>.
 * @author Brian
 *
 * @param <T>
 */
public class BinarySearch<T extends Comparable<? super T>> {
	public int binarySearch(List<T> array, T key){
		if(array == null || array.size() == 0 || key == null){
			return -1;
		}
		
		int low = 0;
		int high = array.size();
		int mid;
		
		while(high >= low){
			mid = (high + low)/2;
			
			if(array.get(mid).compareTo(key) < 0){
				low = mid + 1;
			}else if(array.get(mid).compareTo(key) > 0){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		
		return -1;
	}
	
	public int binarySearchRecursive(List<T> array, T key){
		if(array == null || array.size() == 0 || key == null){
			return -1;
		}
		return binarySearch(array, key, 0, array.size());
	}
	
	private int binarySearch(List<T> array, T key, int low, int high){
		if(high < low){
			return -1;
		}
		int mid = (high + low)/2;
			
		if(array.get(mid).compareTo(key) < 0){
			return binarySearch(array, key, mid + 1, high);
		}else if(array.get(mid).compareTo(key) > 0){
			return binarySearch(array, key, low, mid - 1);
		}else{
			return mid;
		}
	}
}
