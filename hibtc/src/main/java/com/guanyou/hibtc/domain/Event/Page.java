package com.guanyou.hibtc.domain.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/918:04
 * @Modified by:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {

    @JsonProperty("countNumber")
    int countNumber;
    @JsonProperty("countPage")
    int countPage;
    @JsonProperty("pageNumber")
    int pageNumber;
    @JsonProperty("pageSize")
    int pageSize;

    public int getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(int countNumber) {
        this.countNumber = countNumber;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
