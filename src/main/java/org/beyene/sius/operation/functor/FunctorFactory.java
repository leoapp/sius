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
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;

public final class FunctorFactory {
	private FunctorFactory() {
		// private constructor to prevent instantiation
	}
	
	/**
	 * Creates adder.
	 * 
	 * @param targetId target unit id
	 * @return functor that performs addition
	 * 
	 * @param <D> dimension
	 * @param <B> base unit of dimension
	 * @param <TARGET_UNIT> target unit
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, TARGET_UNIT extends Unit<D, B, TARGET_UNIT>> Adder<D, B, TARGET_UNIT> sum(UnitId<D, B, TARGET_UNIT> targetId) {
		return new AdderImpl<D, B, TARGET_UNIT>(targetId);
	}
	
	/**
	 * Creates mean.
	 * 
	 * @param targetId conversion unit id
	 * @return functor that computes mean
	 * 
	 * @param <D> dimension
	 * @param <B> base unit of dimension
	 * @param <TARGET_UNIT> target unit
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, TARGET_UNIT extends Unit<D, B, TARGET_UNIT>> ArithmeticMean<D, B, TARGET_UNIT> mean(UnitId<D, B, TARGET_UNIT> targetId) {
		return new ArithmeticMeanImpl<D, B, TARGET_UNIT>(targetId);
	}
}