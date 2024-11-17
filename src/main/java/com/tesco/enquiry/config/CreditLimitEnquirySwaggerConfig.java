/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Manju at 04-Sep-2023
 * Description:this class will be used
 *
 */

public class CreditLimitEnquirySwaggerConfig {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors .basePackage("com.tesco.enquiry.controller"))
                .paths(PathSelectors.regex("/v1/*"))
                .build().apiInfo(apiInfoMetaData());
    }

    private ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder().title("Enrollment Service")
                .description("API Endpoint Decoration")
                .contact(new Contact("Dev-Team", "https://www.dev-team.com/", "dev-team@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

}
