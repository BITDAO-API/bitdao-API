package com.guanyou.hibtc.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/718:41
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinType {
    @JsonProperty("BTC")
    String BTC;
    @JsonProperty("ETH")
    String ETH;
    @JsonProperty("SCC")
    String SCC;
    @JsonProperty("LION")
    String LION;
    @JsonProperty("ALEX")
    String ALEX;
    @JsonProperty("LTC")
    String LTC;
    @JsonProperty("MONA")
    String MONA;
    @JsonProperty("TRAF")
    String TRAF;
    @JsonProperty("BPTN")
    String BPTN;
    @JsonProperty("BCH")
    String BCH;


    public String getETH() {
        return ETH;
    }

    public void setETH(String ETH) {
        this.ETH = ETH;
    }

    public String getBTC() {
        return BTC;
    }

    public void setBTC(String BTC) {
        this.BTC = BTC;
    }

    public String getSCC() {
        return SCC;
    }

    public void setSCC(String SCC) {
        this.SCC = SCC;
    }

    public String getLION() {
        return LION;
    }

    public void setLION(String LION) {
        this.LION = LION;
    }

    public String getALEX() {
        return ALEX;
    }

    public void setALEX(String ALEX) {
        this.ALEX = ALEX;
    }

    public String getLTC() {
        return LTC;
    }

    public void setLTC(String LTC) {
        this.LTC = LTC;
    }

    public String getMONA() {
        return MONA;
    }

    public void setMONA(String MONA) {
        this.MONA = MONA;
    }

    public String getTRAF() {
        return TRAF;
    }

    public void setTRAF(String TRAF) {
        this.TRAF = TRAF;
    }

    public String getBPTN() {
        return BPTN;
    }

    public void setBPTN(String BPTN) {
        this.BPTN = BPTN;
    }

    public String getBCH() {
        return BCH;
    }

    public void setBCH(String BCH) {
        this.BCH = BCH;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
                .append("BTC", BTC)
                .append("SCC", SCC)
                .append("LION", LION)
                .append("ALEX", ALEX)
                .append("ETH", ETH)
                .append("LTC", LTC)
                .append("MONA", MONA)
                .append("TRAF", TRAF)
                .append("BPTN", BPTN)
                .append("BCH", BCH)
                .toString();
    }
}
