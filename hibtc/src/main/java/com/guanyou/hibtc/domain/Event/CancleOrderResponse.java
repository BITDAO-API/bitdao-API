package com.guanyou.hibtc.domain.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.bb.OrderResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/814:55
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancleOrderResponse {

    @JsonProperty("data")
    OrderResponse data;

    public OrderResponse getData() {
        return data;
    }

    public void setData(OrderResponse data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("data", data)
                .toString();
    }
}
