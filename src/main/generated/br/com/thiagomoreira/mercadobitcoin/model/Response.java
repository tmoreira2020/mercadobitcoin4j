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

package br.com.thiagomoreira.mercadobitcoin.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Response implements Serializable
{

    @SerializedName("ticker")
    @Expose
    private Ticker ticker;
    @SerializedName("response_data")
    @Expose
    private UserInfo userInfo;
    @SerializedName("status_code")
    @Expose
    private int statusCode;
    @SerializedName("server_unix_timestamp")
    @Expose
    private String serverUnixTimestamp;
    private final static long serialVersionUID = 2394082432118372888L;

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public UserInfo getResponseData() {
        return userInfo;
    }

    public void setResponseData(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getServerUnixTimestamp() {
        return serverUnixTimestamp;
    }

    public void setServerUnixTimestamp(String serverUnixTimestamp) {
        this.serverUnixTimestamp = serverUnixTimestamp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ticker", ticker).append("userInfo", userInfo).append("statusCode", statusCode).append("serverUnixTimestamp", serverUnixTimestamp).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(userInfo).append(ticker).append(serverUnixTimestamp).append(statusCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Response) == false) {
            return false;
        }
        Response rhs = ((Response) other);
        return new EqualsBuilder().append(userInfo, rhs.userInfo).append(ticker, rhs.ticker).append(serverUnixTimestamp, rhs.serverUnixTimestamp).append(statusCode, rhs.statusCode).isEquals();
    }

}
