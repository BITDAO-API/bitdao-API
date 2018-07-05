package com.guanyou.hibtc.domain.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.bb.KLine;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/714:22
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventKLine extends Event {

    @JsonProperty("data")
    List<KLine> data;

    public List<KLine> getData() {
        return data;
    }

    public void setData(List<KLine> data) {
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
