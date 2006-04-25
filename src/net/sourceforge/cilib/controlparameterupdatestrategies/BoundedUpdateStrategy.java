/*
 * BoundedUpdatedStrategy.java
 *
 * Created on March 18, 2004, 4:23 PM
 *
 *
 * Copyright (C) 2003 - 2006 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package net.sourceforge.cilib.controlparameterupdatestrategies;

import net.sourceforge.cilib.type.DomainParser;
import net.sourceforge.cilib.type.types.Real;
import net.sourceforge.cilib.type.types.Vector;

/**
 * 
 * @author Gary Pampara
 *
 */
public abstract class BoundedUpdateStrategy implements ControlParameterUpdateStrategy {
	
	protected Real parameter;
	protected String range = "";
	
	
	/**
	 * 
	 *
	 */
	public BoundedUpdateStrategy() {
		this.parameter = new Real();
	}
	
	
	/**
	 * 
	 * @param copy
	 */
	public BoundedUpdateStrategy(BoundedUpdateStrategy copy) {
		this.parameter = copy.parameter.clone();
		this.range = new String(copy.range);
	}
	
	
	/**
	 * 
	 */
	public abstract BoundedUpdateStrategy clone();

	
	/**
	 * Get the value of the represented parameter.
	 * @return The value of the represented parameter 
	 */
	public double getParameter() {
		return parameter.getReal();
	}
	
	
	public double getParameter(double min, double max) {
		throw new UnsupportedOperationException("");
	}

	
	/**
	 *  
	 */
	public void setParameter(double value) {
		this.parameter.setReal(value);
	}

	/**
	 * 
	 */
	public abstract void updateParameter();
	
	
	/**
	 * 
	 * @return
	 */
	public double getLowerBound() {
		return this.parameter.getLowerBound();
	}
	
	
	/**
	 * 
	 * @param lower
	 */
	public void setLowerBound(double lower) {
		this.parameter.setLowerBound(lower);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public double getUpperBound() {
		return this.parameter.getUpperBound();
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void setUpperBound(double value) {
		this.parameter.setUpperBound(value);
	}

	
	/**
	 * 
	 * @return
	 */
	public String getRange() {
		return range;
	}

	
	/**
	 * 
	 * @param range
	 */
	public void setRange(String range) {
		this.range = range;
		DomainParser parser = DomainParser.getInstance();
		parser.parse(this.range);
		Vector v = (Vector) parser.getBuiltRepresentation();
		
		if (v.getDimension() != 1) 
			throw new RuntimeException("Range incorrect in BoundedUpdateStrategy! Please correct");
		else
			this.parameter = (Real) v.get(0);
	}
	
}