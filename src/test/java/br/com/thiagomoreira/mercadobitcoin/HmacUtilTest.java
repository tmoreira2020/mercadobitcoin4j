/**
 * Copyright © 2017 Thiago Moreira (tmoreira2020@gmail.com)
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
 */
package br.com.thiagomoreira.mercadobitcoin;

import org.junit.Assert;
import org.junit.Test;

import br.com.thiagomoreira.mercadobitcoin.util.HmacUtil;

public class HmacUtilTest {

	@Test
	public void calculateHMAC() throws Exception {
		long nonce = 1512945833673L;
		String method = "get_account_info";
		String path = "/tapi/v3/?tapi_method=" + method + "&tapi_nonce="
				+ nonce;

		String actual = HmacUtil
				.calculateHMAC(path,
						"6bcaed80fb8d0e9f8ba356cfab7415ca8fafc19038c1ee8237874c7d25dfc7c9");
		String expected = "43c59f3cc4e56fc795ff65c2f06318e80690ca79b8482709d986080094a5554b56ed62389943516f4f9d5cbb210e12f04b46bca32987e54dce9fe49d1074c995";

		Assert.assertEquals(expected, actual);
	}
}
