package MostCommonMap;

import java.util.Comparator;

public class OneNameCountCompare implements Comparator<OneName>{
	@Override
	public int compare(OneName o1, OneName o2){
		if(o1.getCount() > o2.getCount())
			return 1;
		else if(o1.getCount() < o2.getCount())
			return -1;
		else return 0;
	}
}
