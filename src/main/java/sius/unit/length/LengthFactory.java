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
package sius.unit.length;

public final class LengthFactory {
	private LengthFactory() {
		// private constructor to prevent instantiation
	}

	public static Meter meter(double value) {
		return new MeterImpl(value);
	}

	public static Mile mile(double value) {
		return new MileImpl(value);
	}
	
	public static Yard yard(double value) {
		return new YardImpl(value);
	}
	
	public static Inch inch(double value) {
		return new InchImpl(value);
	}
	
	public static Foot foot(double value) {
		return new FootImpl(value);
	}
}