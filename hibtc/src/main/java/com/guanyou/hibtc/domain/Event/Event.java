package com.guanyou.hibtc.domain.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/714:11
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    /**
     *channel
     */
    @JsonProperty("channel")
    private  String channel;
    /**
     * pair
     */
    @JsonProperty("pair")
    private String pair;
    /**
     * code
     */
    @JsonProperty("code")
    private int code;



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("channel", channel)
                .append("pair", pair)
                .append("code", code)
                .toString();
    }

}
