package com.jdc.pos.features;

public abstract class AbstractFeature {

	private int id;
	private String name;

	public AbstractFeature(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public abstract void doBusiness();
	
	public String getTitle() {
		return "%d. %s".formatted(id, name);
	}
	
	public int getId() {
		return id;
	}
	
}
