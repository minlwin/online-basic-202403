package com.jdc.pos.models;

public interface SaleModel {

	Sale checkOut(SaleItem[] items);

	Sale[] getHistory();

}
