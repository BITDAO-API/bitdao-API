package com.guanyou.hibtc.domain.bb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @date 2018/5/423:15
 * @Modified by:
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {
    /**
     * The first (highest)price to buy in order books.
     */
    @JsonProperty("buy")
    private BigDecimal buy;

    /**
     * Highest price in the last 24 hours.
     */
    @JsonProperty("high")
    private BigDecimal high;

    /**
     * Last trade price in this pair.
     */
    @JsonProperty("last")
    private BigDecimal last;

    /**
     * Lowest price in the last 24 hours.
     */
    @JsonProperty("low")
    private BigDecimal low;

    /**
     * The first (lowest)price to sell in order books.
     */
    @JsonProperty("sell")
    private BigDecimal sell;

    /**
     * Timestamp
     */
    @JsonProperty("timestamp")
    private long timestamp;

    /**
     * The volume of transactions in the last 24 hours.
     */
    @JsonProperty("vol")
    private BigDecimal vol;

    /**
     * Recent 24 hour price changes.
     */
    @JsonProperty("dchange")
    private BigDecimal dchange;

    /**
     * % price change in the last 24 hours.
     */
    @JsonProperty("dchange_pec")
    private BigDecimal dchange_pec;

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    public BigDecimal getDchange() {
        return dchange;
    }

    public void setDchange(BigDecimal dchange) {
        this.dchange = dchange;
    }

    public BigDecimal getDchange_pec() {
        return dchange_pec;
    }

    public void setDchange_pec(BigDecimal dchange_pec) {
        this.dchange_pec = dchange_pec;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("buy", buy)
                .append("high", high)
                .append("last", last)
                .append("low", low)
                .append("sell", sell)
                .append("timestamp", timestamp)
                .append("vol", vol)
                .append("dchange", dchange)
                .append("dchange_pec", dchange_pec)
                .toString();
    }
}
