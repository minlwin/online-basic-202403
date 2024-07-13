package com.jdc.collections;

import java.util.List;

public class RemoveIfOddNumber {

	public List<Integer> removeIfOdd(List<Integer> list) {
		
		var iterator = list.iterator();
		
		while(iterator.hasNext()) {
			var item = iterator.next();
			if(item % 2 != 0) {
				iterator.remove();
			}
		}
		
		return list;
	}
}
