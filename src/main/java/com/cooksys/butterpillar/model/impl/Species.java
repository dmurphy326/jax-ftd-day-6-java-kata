package com.cooksys.butterpillar.model.impl;

import com.cooksys.butterpillar.model.IButterpillar;
import com.cooksys.butterpillar.model.ICatterfly;
import com.cooksys.butterpillar.model.IGrowthModel;
import com.cooksys.butterpillar.model.ISpecies;

public class Species implements ISpecies {

	private String name;
	private IGrowthModel growthModel = new GrowthModel();
	//private ICatterfly
	
	public Species()
	{
		super();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public IGrowthModel getGrowthModel() {
		return growthModel;
	}

	@Override
	public void setGrowthModel(IGrowthModel growthModel) {
		this.growthModel = growthModel;

	}

	@Override
	public ICatterfly createCatterfly(double wingspan, double weight) {		
		return new Catterfly(wingspan, weight);
	}

	@Override
	public IButterpillar createButterpillar(double length, double leavesEaten) {
		return new Butterpillar(length, leavesEaten);
	}

	@Override
	public ICatterfly[] convert(IButterpillar[] butterpillars) {
		ICatterfly[] catterArray = null;
		
		int i = 0;
		
		for(IButterpillar b: butterpillars)
		{
			catterArray[i++] = growthModel.butterpillarToCatterfly(b);
		}
		
		return catterArray;
	}

	@Override
	public IButterpillar[] convert(ICatterfly[] catterflies) {
		IButterpillar[] butterArray = null;
		
		int i = 0;
		
		for(ICatterfly c: catterflies)
		{
			butterArray[i++] = growthModel.catterflyToButterpillar(c);
		}
		
		return butterArray;

	}

}
