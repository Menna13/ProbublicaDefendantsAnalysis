package propublica.datadesign;

import java.util.ArrayList;

public class FullData {
	ArrayList<DefendentsFactors> Data; 
	
public FullData (ArrayList<String[]> entries) {
	for(int i = 0; i < entries.size(); i++) {
	String [] entry = entries.get(i);
	DefendentsFactors current = new DefendentsFactors(entry[0],entry[1], entry [2], entry [3],
			entry [4], entry [5], entry [6], entry [7], entry [8], entry [9]);
	Data.add(current);
	
}
	
}

public DefendentsFactors getrow(int v) {
	return Data.get(v);
}

public void addrow (DefendentsFactors newrow) {
	Data.add(newrow);
}
	



}
