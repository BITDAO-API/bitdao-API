package com.guanyou.hibtc.domain.bb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/7 17:58
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    /**
     * order ID
     */
    @JsonProperty("order_id")
    long order_id;
    /**
     *pair
     */
    @JsonProperty("pair")
    String pair;
    /**
     *time of trade
     */
    @JsonProperty("timestamp")
    Long timestamp;
    /**
     *trade volume
     */
    @JsonProperty("volume")
    BigDecimal volume;
    /**
     *amount of order place
     */
    @JsonProperty("amount")
    BigDecimal amount;
    /**
     *price of place,  the price is  positive means bids and a negative number indicates asks.
     */
    @JsonProperty("place_price")
    BigDecimal place_price;
    /**
     * price of trade
     */
    @JsonProperty("trade_price")
    BigDecimal trade_price;
    /**
     * order type
     */
    @JsonProperty("order_type")
    String order_type;
    /**
     * associated orders, 0 means no associated orders
     */
    @JsonProperty("associated_order")
    int associated_order;
    /**
     * order status,1-Initiating  2-Dealt Partial  3-Dealt 4-Canceled
     */
    @JsonProperty("order_status")
    int order_status;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPlace_price() {
        return place_price;
    }

    public void setPlace_price(BigDecimal place_price) {
        this.place_price = place_price;
    }

    public BigDecimal getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(BigDecimal trade_price) {
        this.trade_price = trade_price;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public int getAssociated_order() {
        return associated_order;
    }

    public void setAssociated_order(int associated_order) {
        this.associated_order = associated_order;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("order_id", order_id)
                .append("pair", pair)
                .append("timestamp", timestamp)
                .append("volume", volume)
                .append("amount", amount)
                .append("place_price", place_price)
                .append("trade_price", trade_price)
                .append("order_type", order_type)
                .append("associated_order", associated_order)
                .append("order_status", order_status)
                .toString();
    }
}
