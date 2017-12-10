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

import br.com.thiagomoreira.mercadobitcoin.model.Orderbook;
import br.com.thiagomoreira.mercadobitcoin.model.Response;
import br.com.thiagomoreira.mercadobitcoin.model.Ticker;
import br.com.thiagomoreira.mercadobitcoin.model.UserInfo;
import br.com.thiagomoreira.mercadobitcoin.service.DataService;
import br.com.thiagomoreira.mercadobitcoin.service.TransactionService;
import br.com.thiagomoreira.mercadobitcoin.util.HmacUtil;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MercadoBitcoin {

	protected DataService dataService;
	protected TransactionService transactionService;

	public MercadoBitcoin() {
		this(false);
	}

	public MercadoBitcoin(boolean debug) {
		this("https://www.mercadobitcoin.net", debug);
	}

	public MercadoBitcoin(String baseUrl, boolean debug) {

		OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

		if (debug) {
			HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

			interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

			httpClientBuilder.addInterceptor(interceptor);
		}

		Retrofit.Builder builder = new Retrofit.Builder();
		Retrofit retrofit = builder.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClientBuilder.build()).build();

		dataService = retrofit.create(DataService.class);
		transactionService = retrofit.create(TransactionService.class);
	}

	public Orderbook getOrderbook(String coin) throws IOException {
		Call<Orderbook> call = dataService.getOrderbook(coin);

		retrofit2.Response<Orderbook> response = call.execute();
		Orderbook orderbook = response.body();

		if (response.isSuccessful()) {
			return orderbook;
		} else {
			throw new IOException("");
		}
	}

	public Ticker getTicker(String coin) throws IOException {
		Call<Response> call = dataService.getTicker(coin);

		retrofit2.Response<Response> response = call.execute();
		Response response2 = response.body();

		if (response.isSuccessful()) {
			return response2.getTicker();
		} else {
			throw new IOException("");
		}
	}

	public UserInfo getUserInfo(String clientId, String clientSecret)
			throws Exception {
		long nounce = System.currentTimeMillis();
		String method = "get_account_info";
		String path = "/tapi/v3/?tapi_method=" + method + "&tapi_nonce="
				+ nounce;

		String tapiMac = HmacUtil.calculateHMAC(path, clientSecret);
		Call<Response> call = transactionService.getUserInfo(clientId, tapiMac,
				method, nounce);

		retrofit2.Response<Response> response = call.execute();
		Response response2 = response.body();

		if (response.isSuccessful()) {
			return response2.getResponseData();
		} else {
			throw new IOException("");
		}
	}

}
