package com.guanyou.hibtc.ws;

/**
 * HibtcApiCallback is a functional interface used together with the HibtcApiAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return type from the callback
 */

public interface HibtcApiCallback<T> {

    /**
     * Called whenever a response comes back from the Hibtc API.
     *
     * @param response the expected response T
     */
    void onResponse(T response);


    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {
    }
}