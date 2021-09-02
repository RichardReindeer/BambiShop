package com.bambi.domain.exception;

/**
 * 描述：
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 2:25    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
public class NoParamFromWebException extends Exception{
    public NoParamFromWebException() {
        super();
    }

    public NoParamFromWebException(String message) {
        super(message);
    }

    public NoParamFromWebException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoParamFromWebException(Throwable cause) {
        super(cause);
    }
}
