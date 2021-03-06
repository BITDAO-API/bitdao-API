package com.guanyou.hibtc.domain.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.bb.ListTrade;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/714:37
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HisListTrade extends Event{
    @JsonProperty("data")
    List<ListTrade> data;
    @JsonProperty("page")
    Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<ListTrade> getData() {
        return data;
    }

    public void setData(List<ListTrade> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("data", data)
                .append("page", page)
                .append("Event", super.toString())
                .toString();
    }
}
