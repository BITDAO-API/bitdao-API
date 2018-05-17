package com.guanyou.hibtc.domain.bb;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/423:29
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook {
    /**
     * timestamp
     */
    @JsonProperty("timestamp")
    Long timestamp;

    /**
     * List of bids (price/qty).
     */
    @JsonProperty("bids")
    private List<String []> bids;

    /**
     * List of asks (price/qty).
     */
    @JsonProperty("asks")
    private List<String []> asks;

    /**
     * List of change (price/qty).
     */
    @JsonProperty("change")
    private List<String []> change;


    public List<String []> getBids() {
        return bids;
    }

    public void setBids(List<String []> bids) {
        this.bids = bids;
    }

    public List<String []> getAsks() {
        return asks;
    }

    public void setAsks(List<String []> asks) {
        this.asks = asks;
    }

    public List<String []> getChange() {
        return change;
    }

    public void setChange(List<String []> change) {
        this.change = change;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("timestamp", timestamp)
                .append("bids", bids)
                .append("asks", asks)
                .append("change",change )
                .toString();
    }
}
