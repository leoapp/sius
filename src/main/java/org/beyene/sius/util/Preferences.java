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
package org.beyene.sius.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Preferences {

	private static Properties p = new Properties();

	static {
		try {
			readConfiguration(Preferences.class.getClassLoader().getResourceAsStream("sius.config"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Preferences() {
		// private constructor to prevent instantiation
	}

	public static void readConfiguration(InputStream is) throws IOException {
		p.load(is);
	}

	public static int getInt(String key, int defaultValue) {
		String value = _load(key);
		if (value != null) {
			try {
				int i = Integer.parseInt(value);
				return i;
			} catch (NumberFormatException e) {
			}
		}
		return defaultValue;
	}

	private static String _load(String key) {
		return p.getProperty(key);
	}
}