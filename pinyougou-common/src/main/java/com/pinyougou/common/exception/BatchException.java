package com.pinyougou.common.exception;

/**
 * @author Link
 */
public class BatchException extends DaoException {

    public BatchException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
