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

import org.beyene.sius.dimension.composition.Speed;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.speed.Constants;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.composition.speed.MilesPerHour;
import org.beyene.sius.unit.length.Mile;
import org.beyene.sius.unit.time.Hour;

public class MilesPerHourImpl implements MilesPerHour {

	private final double scalar;
	private final UnitId<Speed, MeterPerSecond, MilesPerHour> unitId = UnitIdentifier.MILES_PER_HOUR;

	public MilesPerHourImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Mile getComponentUnit1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hour getComponentUnit2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Speed getDimension() {
		return Speed.INSTANCE;
	}

	@Override
	public UnitId<Speed, MeterPerSecond, MilesPerHour> getIdentifier() {
		return unitId;
	}

	@Override
	public <OTHER extends Unit<Speed, MeterPerSecond, OTHER>> MilesPerHour convert(
			OTHER other) {
		MilesPerHour converted;
		if (other.getIdentifier().equals(unitId))
			converted = valueOf(other.getValue());
		else if (other.getIdentifier().equals(UnitIdentifier.METER_PER_SECOND))
			converted = valueOf(other.getValue() * Constants.MPS_PER_MPH);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public MeterPerSecond toBaseUnit() {
		return FactorySpeed.mps(scalar / Constants.MPS_PER_MPH);
	}

	@Override
	public MilesPerHour valueOf(double d) {
		return new MilesPerHourImpl(d);
	}

	@Override
	public double getValue() {
		return scalar;
	}

	@Override
	public String toString() {
		return "MilesPerHour [value=" + scalar + "]";
	}
}