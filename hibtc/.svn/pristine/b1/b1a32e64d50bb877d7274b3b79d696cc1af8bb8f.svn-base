package com.guanyou.hibtc.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/813:19
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthInfo {
    /**
     * Key of API secret key(from official website)
     */
    String api_key;
    /**
     * API key (from official website)
     */

    String apiSecret;
    /**
     * The time stamp
     */
    String auth_nonce;
    /**
     * The key of the signature
     */
    String auth_key;

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getAuth_nonce() {
        return auth_nonce;
    }

    public void setAuth_nonce(String auth_nonce) {
        this.auth_nonce = auth_nonce;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("api_key", api_key)
                .append("auth_nonce", auth_nonce)
                .append("auth_key", auth_key)
                .toString();
    }
}
