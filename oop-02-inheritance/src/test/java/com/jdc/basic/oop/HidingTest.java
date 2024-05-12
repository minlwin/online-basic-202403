package com.jdc.basic.oop;

import org.junit.jupiter.api.Test;

import com.jdc.basic.oop.hiding.Child;
import com.jdc.basic.oop.hiding.Super;

public class HidingTest {

	@Test
	public void test() {
		Super object = new Child();
		object.showData();
	}
}
