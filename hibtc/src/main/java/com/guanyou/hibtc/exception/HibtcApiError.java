package com.guanyou.hibtc.exception;


import com.guanyou.hibtc.constant.HibtcApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Hibtc API error object.
 */
public class HibtcApiError {


  /**
   * Error code.
   */
  private int code;

  /**
   * Error message.
   */
  private String msg;

  private  String msg_code;

  public String getMsg_code() {
    return msg_code;
  }

  public void setMsg_code(String msg_code) {
    this.msg_code = msg_code;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, HibtcApiConstants.TO_STRING_BUILDER_STYLE)
        .append("code", code)
        .append("msg", msg)
        .toString();
  }
}
