package com.jackwu.gateway.config.swagger;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author jackwu
 */
@Slf4j
@Primary
@Configuration
@ConditionalOnProperty(prefix = "edu.swagger", value = "enable", matchIfMissing = true)
public class EduGatewaySwaggerAutoConfiguration implements SwaggerResourcesProvider {

    public static final String API_URI = "/api-docs";

    private final RouteLocator routeLocator;

    private final GatewayProperties gatewayProperties;

    public EduGatewaySwaggerAutoConfiguration(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
        this.routeLocator = routeLocator;
        this.gatewayProperties = gatewayProperties;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        //取出gateway的route
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        //结合配置的route-路径(Path)，和route过滤，只获取有效的route节点
        Predicate<RouteDefinition> gatewayFilterPredicate = routeDefinition ->
                routes.contains(routeDefinition.getId()) && routeDefinition.getId().contains("swagger");

        Consumer<RouteDefinition> gatewayForeachConsumer = routeDefinition ->
                routeDefinition.getPredicates().stream()
                               .filter(predicateDefinition ->
                                       ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                               .forEach(predicateDefinition -> resources.add(swaggerResource(routeDefinition.getId(),
                                       predicateDefinition.getArgs()
                                                          .get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                                          .replace("/**", API_URI))));
        gatewayProperties.getRoutes().stream()
                         .filter(gatewayFilterPredicate)
                         .forEach(gatewayForeachConsumer);

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
