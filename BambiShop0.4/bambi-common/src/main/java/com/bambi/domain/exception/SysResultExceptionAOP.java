package com.bambi.domain.exception;

import com.bambi.domain.SystemResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 描述：全局异常处理类，使用AOP实现业务增强
 * AOP = 切入点表达式(IF) +通知(方法)
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/5 3:03    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@RestControllerAdvice//返回值结果都是Json串
public class SysResultExceptionAOP {

    @ExceptionHandler(RuntimeException.class)
    public SystemResult fail(){
        return SystemResult.fail();
    }
}
