package com.bambi.domain.exception;

import com.bambi.domain.SystemResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
//定义为全局异常处理机制
@RestControllerAdvice//返回值结果都是Json串
public class SysResultExceptionAOP {
    private static Logger logger = LoggerFactory.getLogger(SysResultExceptionAOP.class);
    //当前的AOP所拦截的异常类型
    @ExceptionHandler(RuntimeException.class)
    public SystemResult fail(){
        logger.error("执行统一异常处理类， 出现RuntimeException.class");
        return SystemResult.fail();

    }
}
