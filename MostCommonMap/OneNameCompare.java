package MostCommonMap;

import java.util.*;

public class OneNameCompare implements Comparator<OneName>{
	@Override
	public int compare (OneName o1, OneName o2){
		return o1.getName().compareTo(o2.getName());
	}
}
