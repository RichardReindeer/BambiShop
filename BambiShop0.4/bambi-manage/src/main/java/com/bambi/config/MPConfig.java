package com.bambi.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/15 18:29    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@Configuration    //表示当前类是一个配置文件
public class MPConfig {

    //@Bean 在spring容器中管理的对象称之为bean.
    //@Bean 要求返回值必须是一个对象

    //需要实现一个MP的分页的拦截器对象,交给Spring容器管理
    @Bean    //Map<方法名称,分页对象>
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }
    //将给对象交给Spring容器管理之后,如果需要可以直接注入引用.
    //springBoot整合MybatisPlus时执行分页操作时,自动的完成注入
    //.前提是需要提前实例化对象
}

