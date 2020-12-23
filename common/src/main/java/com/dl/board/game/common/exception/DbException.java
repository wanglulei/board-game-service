package com.dl.board.game.common.exception;

/**
 * @author ALONG
 * @date 19-7-15 下午12:01
 */
public class DbException extends RuntimeException {
    public DbException(String message, Throwable cause) {
        super(message, cause);
    }
}
