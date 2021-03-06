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
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Orderbook implements Serializable
{

    @SerializedName("asks")
    @Expose
    private List<List<Double>> asks = new ArrayList<List<Double>>();
    @SerializedName("bids")
    @Expose
    private List<List<Double>> bids = new ArrayList<List<Double>>();
    private final static long serialVersionUID = 7492488246067148583L;

    public List<List<Double>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<Double>> asks) {
        this.asks = asks;
    }

    public List<List<Double>> getBids() {
        return bids;
    }

    public void setBids(List<List<Double>> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("asks", asks).append("bids", bids).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bids).append(asks).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Orderbook) == false) {
            return false;
        }
        Orderbook rhs = ((Orderbook) other);
        return new EqualsBuilder().append(bids, rhs.bids).append(asks, rhs.asks).isEquals();
    }

}
