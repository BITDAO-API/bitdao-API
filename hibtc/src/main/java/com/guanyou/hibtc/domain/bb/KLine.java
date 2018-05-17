package com.guanyou.hibtc.domain.bb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/714:19
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KLine {
    /**
     *timestamp
     */
    @JsonProperty("timestamp")
    long timestamp;
    /**
     *open price
     */
    @JsonProperty("open_price")
    BigDecimal open_price;
    /**
     *high price
     */
    @JsonProperty("high_price")
    BigDecimal high_price;
    /**
     *low price
     */
    @JsonProperty("low_price")
    BigDecimal low_price;
    /**
     *close price
     */
    @JsonProperty("close_price")
    BigDecimal close_price;
    /**
     *volume
     */
    @JsonProperty("volume")
    BigDecimal volume;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getOpen_price() {
        return open_price;
    }

    public void setOpen_price(BigDecimal open_price) {
        this.open_price = open_price;
    }

    public BigDecimal getHigh_price() {
        return high_price;
    }

    public void setHigh_price(BigDecimal high_price) {
        this.high_price = high_price;
    }

    public BigDecimal getLow_price() {
        return low_price;
    }

    public void setLow_price(BigDecimal low_price) {
        this.low_price = low_price;
    }

    public BigDecimal getClose_price() {
        return close_price;
    }

    public void setClose_price(BigDecimal close_price) {
        this.close_price = close_price;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("time", timestamp)
                .append("open_price", open_price)
                .append("high_price", high_price)
                .append("low_price",low_price )
                .append("close_price",close_price )
                .append("volume",volume )
                .toString();
    }
}
