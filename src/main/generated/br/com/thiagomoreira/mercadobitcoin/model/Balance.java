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

public class Balance implements Serializable
{

    @SerializedName("brl")
    @Expose
    private Brl brl;
    @SerializedName("btc")
    @Expose
    private Btc btc;
    @SerializedName("ltc")
    @Expose
    private Ltc ltc;
    @SerializedName("bch")
    @Expose
    private Bch bch;
    @SerializedName("btg")
    @Expose
    private Btg btg;
    private final static long serialVersionUID = 6852316087505137290L;

    public Brl getBrl() {
        return brl;
    }

    public void setBrl(Brl brl) {
        this.brl = brl;
    }

    public Btc getBtc() {
        return btc;
    }

    public void setBtc(Btc btc) {
        this.btc = btc;
    }

    public Ltc getLtc() {
        return ltc;
    }

    public void setLtc(Ltc ltc) {
        this.ltc = ltc;
    }

    public Bch getBch() {
        return bch;
    }

    public void setBch(Bch bch) {
        this.bch = bch;
    }

    public Btg getBtg() {
        return btg;
    }

    public void setBtg(Btg btg) {
        this.btg = btg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("brl", brl).append("btc", btc).append("ltc", ltc).append("bch", bch).append("btg", btg).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(btc).append(ltc).append(btg).append(brl).append(bch).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Balance) == false) {
            return false;
        }
        Balance rhs = ((Balance) other);
        return new EqualsBuilder().append(btc, rhs.btc).append(ltc, rhs.ltc).append(btg, rhs.btg).append(brl, rhs.brl).append(bch, rhs.bch).isEquals();
    }

}
