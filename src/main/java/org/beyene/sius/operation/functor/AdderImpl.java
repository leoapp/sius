/*
 * Copyright 2014 Mikael Beyene
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.beyene.sius.operation.functor;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitFactory;
import org.beyene.sius.unit.UnitId;

final class AdderImpl<D extends Dimension<D>, B extends Unit<D, B, B>, CU extends Unit<D, B, CU>> extends AbstractFunctor<D, B, CU, Adder<D, B, CU>> implements Adder<D, B, CU> {
	
	private CU cachedResult;
	
	public AdderImpl(UnitId<D, B, CU> cunitId) {
		super(cunitId);
	}

	@Override
	public CU apply() {
		if (operands.isEmpty())
			return UnitFactory.valueOf(0, cunitId);

		if (cachedResult != null)
			return cachedResult;
		
		double res = 0d;
		for (Unit<D, B, ?> op : operands)
			res += op.toBaseUnit().getValue();

		B base = UnitFactory.valueOf(res, operands.get(0).toBaseUnit().getIdentifier());
		
		cachedResult = Operation.convert(base, cunitId);
		return cachedResult;
	}

	@Override
	protected Adder<D, B, CU> self() {
		return this;
	}

	@Override
	protected void resetCache() {
		cachedResult = null;
	}
	
	@Override
	public String toString() {
		return String.format("Adder [cunitId=%s, operands=%s]", cunitId, operands);
	}
}