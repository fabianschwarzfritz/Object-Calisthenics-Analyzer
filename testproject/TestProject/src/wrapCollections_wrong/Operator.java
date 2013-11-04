package wrapCollections_wrong;

import java.util.ArrayList;
import java.util.List;

public class Operator {

	public void main() {
		WrapCollection wrapCollection = new WrapCollection();
		wrapCollection.getCollection().add(new Integer(3));

		List<Integer> ar = new ArrayList<Integer>();
	}
}
