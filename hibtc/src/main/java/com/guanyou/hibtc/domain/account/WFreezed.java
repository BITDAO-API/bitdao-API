package com.guanyou.hibtc.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/814:19
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WFreezed extends CoinType {

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("CoinType", super.toString())
                .toString();
    }
}
