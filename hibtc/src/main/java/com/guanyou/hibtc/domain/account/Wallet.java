package com.guanyou.hibtc.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/718:14
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wallet {
    /**
     *available assets in the wallet
     */
    @JsonProperty("free")
    WFree free;
    /**
     *assets on zed (not available for use)
     */
    @JsonProperty("freezed")
    WFreezed freezed;

    public WFree getFree() {
        return free;
    }

    public void setFree(WFree free) {
        this.free = free;
    }

    public WFreezed getFreezed() {
        return freezed;
    }

    public void setFreezed(WFreezed freezed) {
        this.freezed = freezed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("free", free)
                .append("freezed", freezed)
                .toString();
    }
}
