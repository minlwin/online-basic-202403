package com.jdc.demo.usage;

public enum TarrotCard implements Card{
	CardA, CardB, CardC {
		@Override
		public int value() {
			return 99;
		}
	};
	
	@Override
	public int value() {
		return ordinal() + 1;
	}
}
