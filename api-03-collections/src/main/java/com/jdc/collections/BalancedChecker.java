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
			if(isOpen(c)) {
				stack.offer(c);
			} else {
				
			}
		}
		
		return false;
	}

	private boolean isOpen(char c) {
		return c == '(' || c == '[' || c == '{';
	}

}
