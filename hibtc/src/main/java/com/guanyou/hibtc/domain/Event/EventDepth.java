package com.guanyou.hibtc.domain.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.bb.OrderBook;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/714:09
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDepth extends Event {
    /**
     * The default number of decimal places for the price
     */
    @JsonProperty("prec-len")
    int prec_len;
    /**
     * The list of decimal places
     */
    @JsonProperty("prec-list")
    String[] prec_list;

    /**
     * Returns the entire list and updates the changed list.
     */
    @JsonProperty("data")
    OrderBook data;

    public int getPrec_len() {
        return prec_len;
    }

    public void setPrec_len(int prec_len) {
        this.prec_len = prec_len;
    }

    public String[] getPrec_list() {
        return prec_list;
    }

    public void setPrec_list(String[] prec_list) {
        this.prec_list = prec_list;
    }

    public OrderBook getData() {
        return data;
    }

    public void setData(OrderBook data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("prec_len", prec_len)
                .append("prec_list", prec_list)
                .append("data", data)
                .append("Event", super.toString())
                .toString();
    }
}
