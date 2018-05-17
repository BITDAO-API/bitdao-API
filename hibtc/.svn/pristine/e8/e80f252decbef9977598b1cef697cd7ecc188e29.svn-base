package com.guanyou.hibtc.domain.bb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/1119:59
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListTrade {
    /**
     * trade ID
     */
    @JsonProperty("trade_id")
    long trade_id;
    /**
     * pair
     */
    @JsonProperty("pair")
    String pair;
    /**
     * time of trade
     */
    @JsonProperty("timestamp")
    long timestamp;
    /**
     *  price of trade, when the price is  positive means bids and a negative number indicates asks..
     */
    @JsonProperty("trade_price")
    BigDecimal trade_price;
    /**
     *  price of order place
     */
    @JsonProperty("price")
    BigDecimal price;
    /**
     * trade amount
     */
    @JsonProperty("trade_amount")
    BigDecimal trade_amount;
    /**
     *order type
     */
    @JsonProperty("orderType")
    String orderType;
    /**
     *associated orders ID
     */
    @JsonProperty("related_orders")
    String related_orders;

    /**
     * trade fees
     */
    @JsonProperty("fee")
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

    public BigDecimal getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(BigDecimal trade_price) {
        this.trade_price = trade_price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(BigDecimal trade_amount) {
        this.trade_amount = trade_amount;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRelated_orders() {
        return related_orders;
    }

    public void setRelated_orders(String related_orders) {
        this.related_orders = related_orders;
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
                .append("trade_price", trade_price)
                .append("price", price)
                .append("trade_amount", trade_amount)
                .append("orderType", orderType)
                .append("related_orders", related_orders)
                .append("fee", fee)
                .toString();
    }
}
