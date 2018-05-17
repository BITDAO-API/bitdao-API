package com.guanyou.hibtc.domain.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/815:28
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancleSubResponse extends Event{
    @JsonProperty("data")
    int data;
    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("data", data)
                .append("Event", super.toString())
                .toString();
    }
}
