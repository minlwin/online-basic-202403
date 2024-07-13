package com.jdc.collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class BalancedChecker {
	
	private Queue<Character> stack;

	public boolean isBalance(String value) {
		
		stack = Collections.asLifoQueue(new ArrayDeque<>());
		
		var chars = value.toCharArray();
		
		if(chars.length == 0) {
			return false;
		}
		
		for(var c : chars) {
			switch(c) {
			case '(', '[', '{' -> stack.offer(c);
			case ')', ']', '}' -> {
				var last = stack.poll();
				
				if(null == last) {
					return false;
				}
				
				if(!isMatch(last, c)) {
					return false;
				}
			}
			default -> throw new IllegalArgumentException();
			}
		}
		
		return stack.isEmpty();
	}

	private boolean isMatch(Character last, char current) {
		return (last == '(' && current == ')') 
				|| (last == '[' && current == ']') 
				|| (last == '{' && current == '}') ;
	}


}
