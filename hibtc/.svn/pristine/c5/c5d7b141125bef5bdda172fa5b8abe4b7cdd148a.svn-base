package com.guanyou.hibtc.domain.bb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/714:35
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade {
    /**
     * trade ID
     */
    @JsonProperty("trade_id")
    long trade_id;
    /**
     * price
     */
    @JsonProperty("price")
    BigDecimal price;
    /**
     * the volume is  positive means bids and a negative number indicates asks
     */
    @JsonProperty("volume")
    BigDecimal volume;
    /**
     * timestamp
     */
    @JsonProperty("timestamp")
    long timestamp;
    /**
     * isbid
     */
    @JsonProperty("isbid")
    boolean isbid;

    public long getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(long trade_id) {
        this.trade_id = trade_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isIsbid() {
        return isbid;
    }

    public void setIsbid(boolean isbid) {
        this.isbid = isbid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("trade_id", trade_id)
                .append("price", price)
                .append("volume", volume)
                .append("timestamp", timestamp)
                .append("isbid", isbid)
                .toString();
    }
}
