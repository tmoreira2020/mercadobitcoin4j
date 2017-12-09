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

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import br.com.thiagomoreira.mercadobitcoin.model.Orderbook;
import br.com.thiagomoreira.mercadobitcoin.model.Ticker;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.Buffer;

public class MercadoBitcoinTest {

	@Test
	public void getOrderbook() throws IOException {
		MercadoBitcoin mercadobitcoin = new MercadoBitcoin(
				setup("/get-orderbook.json"), true);

		Orderbook orderbook = mercadobitcoin.getOrderbook("BTC");

		Assert.assertNotNull(orderbook);
		Assert.assertNotNull(orderbook.getAsks());
		Assert.assertEquals(779, orderbook.getAsks().size());
		Assert.assertNotNull(orderbook.getBids());
		Assert.assertEquals(1000, orderbook.getBids().size());
	}

	@Test
	public void getTicker() throws IOException {
		MercadoBitcoin mercadobitcoin = new MercadoBitcoin(
				setup("/get-ticker.json"), true);

		Ticker ticker = mercadobitcoin.getTicker("BTC");

		double delta = 0.00000000;
		Assert.assertNotNull(ticker);
		Assert.assertEquals(53400.00000000, ticker.getLast(), delta);
		Assert.assertEquals(53500.00000000, ticker.getSell(), delta);
		Assert.assertEquals(1512829632, ticker.getDate());
	}

	protected String setup(String jsonPath) throws IOException {
		MockWebServer server = new MockWebServer();
		Buffer buffer = new Buffer();

		buffer.readFrom(getClass().getResourceAsStream(jsonPath));

		server.enqueue(new MockResponse().setBody(buffer));

		server.start();

		return server.url("/").toString();
	}

}
