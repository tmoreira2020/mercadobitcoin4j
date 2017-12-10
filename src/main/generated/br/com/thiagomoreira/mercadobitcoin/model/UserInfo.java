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

public class UserInfo implements Serializable
{

    @SerializedName("balance")
    @Expose
    private Balance balance;
    @SerializedName("withdrawal_limits")
    @Expose
    private WithdrawalLimits withdrawalLimits;
    private final static long serialVersionUID = 8235025622565064898L;

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public WithdrawalLimits getWithdrawalLimits() {
        return withdrawalLimits;
    }

    public void setWithdrawalLimits(WithdrawalLimits withdrawalLimits) {
        this.withdrawalLimits = withdrawalLimits;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("balance", balance).append("withdrawalLimits", withdrawalLimits).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(balance).append(withdrawalLimits).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserInfo) == false) {
            return false;
        }
        UserInfo rhs = ((UserInfo) other);
        return new EqualsBuilder().append(balance, rhs.balance).append(withdrawalLimits, rhs.withdrawalLimits).isEquals();
    }

}
