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

import org.beyene.sius.unit.temperature.Celsius;
import org.beyene.sius.unit.temperature.Fahrenheit;
import org.beyene.sius.unit.temperature.Kelvin;

public final class FactoryTemperature {
	private FactoryTemperature() {
		// private constructor to prevent instantiation
	}
	
	public static Kelvin kelvin(double value) {
		return new KelvinImpl(value);
	}
	
	public static Celsius celsius(double value) {
		return new CelsiusImpl(value);
	}
	
	public static Fahrenheit fahrenheit(double value) {
		return new FahrenheitImpl(value);
	}
}