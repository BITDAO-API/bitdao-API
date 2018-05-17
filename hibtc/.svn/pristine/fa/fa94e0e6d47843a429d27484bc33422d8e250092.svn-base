package com.guanyou.hibtc.domain.bb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/811:43
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthTrade {
    /**
     * trade ID
     */
    long trade_id;
    /**
     * pair
     */
    String pair;
    /**
     * timestamp
     */
    long timestamp;
    /**
     * price of order
     */
    BigDecimal price;
    /**
     * amount of trade
     */
    BigDecimal volume;

    /**
     * price of trade
     */
    BigDecimal trade_price;
    /**
     *  amount of trade
     */
    BigDecimal trade_amount;

    /**
     * order type
     */
    String order_type;
    /**
     * price of you specify
     */
    BigDecimal place_price;
    /**
     * fees
     */
    BigDecimal fee;

    public long getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(long trade_id) {
        this.trade_id = trade_id;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
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

    public BigDecimal getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(BigDecimal trade_price) {
        this.trade_price = trade_price;
    }

    public BigDecimal getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(BigDecimal trade_amount) {
        this.trade_amount = trade_amount;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public BigDecimal getPlace_price() {
        return place_price;
    }

    public void setPlace_price(BigDecimal place_price) {
        this.place_price = place_price;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("trade_id", trade_id)
                .append("pair", pair)
                .append("timestamp", timestamp)
                .append("price", price)
                .append("volume", volume)
                .append("trade_price", trade_price)
                .append("trade_amount", trade_amount)
                .append("order_type", order_type)
                .append("place_price", place_price)
                .append("fee", fee)
                .toString();
    }
}
