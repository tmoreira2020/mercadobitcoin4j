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

public class Btg implements Serializable
{

    @SerializedName("available")
    @Expose
    private double available;
    @SerializedName("total")
    @Expose
    private double total;
    @SerializedName("amount_open_orders")
    @Expose
    private int amountOpenOrders;
    private final static long serialVersionUID = 8736593133663593110L;

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getAmountOpenOrders() {
        return amountOpenOrders;
    }

    public void setAmountOpenOrders(int amountOpenOrders) {
        this.amountOpenOrders = amountOpenOrders;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("available", available).append("total", total).append("amountOpenOrders", amountOpenOrders).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(available).append(amountOpenOrders).append(total).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Btg) == false) {
            return false;
        }
        Btg rhs = ((Btg) other);
        return new EqualsBuilder().append(available, rhs.available).append(amountOpenOrders, rhs.amountOpenOrders).append(total, rhs.total).isEquals();
    }

}
