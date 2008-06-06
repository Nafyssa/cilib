/*
 * Copyright (C) 2003 - 2008
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
 */
package net.sourceforge.cilib.functions;

import net.sourceforge.cilib.type.types.Type;
import net.sourceforge.cilib.type.types.container.Vector;

/**
 * @author Edwin Peer
 * @author Olusegun Olorunda
 */
public abstract class ContinuousFunction extends Function {
	
	/**
	 * Create an instance of {@linkplain ContinuousFunction}.
	 */
	public ContinuousFunction() {
		// constraint.add(new ContentValidator(new TypeValidator(Real.class)));
	}

	/**
	 * Copy constructor. Create a copy of the provided instance.
	 * @param copy The instance to copy.
	 */
	public ContinuousFunction(ContinuousFunction copy) {
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract ContinuousFunction getClone();

	/**
	 * {@inheritDoc}
	 */
	public Object getMinimum() {
		return new Double(-Double.MAX_VALUE);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getMaximum() {
		return new Double(Double.MAX_VALUE);
	}

	/**
	 * {@inheritDoc}
	 */
	public Double evaluate(Type x) {
		Double d = null;
		try {
			d = new Double(evaluate((Vector) x));
		}
		catch (ClassCastException c) {
			c.printStackTrace();
		}

		return d;
	}

	/**
	 * Evaluate the function with the given {@linkplain Vector} as input.
	 * @param x The input {@linkplain Vector}.
	 * @return The value of the evaluation.
	 */
	public abstract double evaluate(Vector x);

}
