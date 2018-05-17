package com.guanyou.hibtc.domain.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.bb.Ticker;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/79:40
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTicker extends Event{

    /**
     *ticker
     */
    @JsonProperty("data")
    private Ticker data;

    public Ticker getData() {
        return data;
    }

    public void setData(Ticker data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("data", data)
                .append("Event", super.toString())
                .toString();
    }


}
