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
package br.com.thiagomoreira.mercadobitcoin.service;

import br.com.thiagomoreira.mercadobitcoin.model.Orderbook;
import br.com.thiagomoreira.mercadobitcoin.model.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataService {

	@GET("/api/{coin}/orderbook/")
	Call<Orderbook> getOrderbook(@Path("coin") String coin);

	@GET("/api/{coin}/ticker/")
	Call<Response> getTicker(@Path("coin") String coin);

}
