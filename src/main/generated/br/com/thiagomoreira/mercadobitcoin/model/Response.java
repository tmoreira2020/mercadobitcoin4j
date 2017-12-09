
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
    private final static long serialVersionUID = 142334241911024493L;

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ticker", ticker).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ticker).toHashCode();
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
        return new EqualsBuilder().append(ticker, rhs.ticker).isEquals();
    }

}
