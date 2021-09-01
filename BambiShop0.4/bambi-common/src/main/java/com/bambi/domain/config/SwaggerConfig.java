package com.bambi.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 描述：Swagger配置类
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 0:40    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getDocker(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
                .groupName("bambiTeam")
                //判断是否启动Swagger,可以进行一个动态判断，判断当前是否是开发模式
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bambi"))
                .build();
    }

    //配置Swagger信息获取对应的ApiInfo,
    //因为Docker需要传入一个ApiInfo对象，所以专门写一个方法来实现对ApiInfo对象的实例化
    private ApiInfo getApiInfo(){
        return new ApiInfo("BambiShop",
                "bambi商城项目",
                "snapShot 0.4",
                "没什么url，看我的github吧，博客在写了在写了",
                new Contact("Mr.bambi","没有url","没有email"),
                "不知道写些什么",
                "不知道写些什么",
                new ArrayList<>()
        );
    }
}
