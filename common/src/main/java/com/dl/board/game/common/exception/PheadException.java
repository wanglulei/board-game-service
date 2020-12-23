package com.dl.board.game.common.exception;

/**
 * @author xiaoma
 * @version V1.0
 * @Description: TODO
 * @date 2019/8/28 16:14
 */
public class PheadException extends RuntimeException {
    public PheadException() {
        super();
    }

    public PheadException(String message) {
        super(message);
    }

    public PheadException(String message, Throwable cause) {
        super(message, cause);
    }

    public PheadException(Throwable cause) {
        super(cause);
    }

    protected PheadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
