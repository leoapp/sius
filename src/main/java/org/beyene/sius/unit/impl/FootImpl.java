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
package org.beyene.sius.unit.impl;

import org.beyene.sius.dimension.Length;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.length.Constants;
import org.beyene.sius.unit.length.Foot;
import org.beyene.sius.unit.length.Meter;

final class FootImpl implements Foot {

	private final double scalar;
	private static final UnitId<Length, Meter, Foot> unitId = UnitIdentifier.FOOT;
	
	public FootImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Length getDimension() {
		return Length.INSTANCE;
	}

	@Override
	public UnitId<Length, Meter, Foot> getIdentifier() {
		return unitId;
	}

	@Override
	public <OTHER extends Unit<Length, Meter, OTHER>> Foot convert(OTHER other) {
		Foot converted;
		if (other.getIdentifier().equals(unitId))
			converted = FactoryLength.foot(other.getValue());
		else if (other.getIdentifier().equals(UnitIdentifier.METER))
			converted = FactoryLength.foot(other.getValue() / Constants.METER_PER_FOOT);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public Meter toBaseUnit() {
		return FactoryLength.meter(scalar * Constants.METER_PER_FOOT);
	}

	@Override
	public Foot valueOf(double d) {
		return FactoryLength.foot(d);
	}

	@Override
	public double getValue() {
		return scalar;
	}

	@Override
	public String toString() {
		return "Foot [value=" + scalar + "]";
	}
}