package com.guanyou.hibtc.exception;

/**
 * An exception which can occur while invoking methods of the Hibtc API.
 */
public class HibtcApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
/**
   * Error response object returned by Hibtc API.
   */
  private HibtcApiError error;

  /**
   * Instantiates a new Hibtc api exception.
   *
   * @param error an error response object
   */
  public HibtcApiException(HibtcApiError error) {
    this.error = error;
  }

  /**
   * Instantiates a new Hibtc api exception.
   */
  public HibtcApiException() {
    super();
  }

  /**
   * Instantiates a new Hibtc api exception.
   *
   * @param message the message
   */
  public HibtcApiException(String message) {
    super(message);
  }

  /**
   * Instantiates a new Hibtc api exception.
   *
   * @param cause the cause
   */
  public HibtcApiException(Throwable cause) {
    super(cause);
  }

  /**
   * Instantiates a new Hibtc api exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public HibtcApiException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @return the response error object from Hibtc API, or null if no response object was returned (e.g. server returned 500).
   */
  public HibtcApiError getError() {
    return error;
  }

  @Override
  public String getMessage() {
    if (error != null) {
      return error.getMsg();
    }
    return super.getMessage();
  }
}
