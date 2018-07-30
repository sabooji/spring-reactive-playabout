package uk.co.syntaxa.springreactiveplayabout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import uk.co.syntaxa.springreactiveplayabout.web.HealthHandler;

@SpringBootApplication
@EnableWebFlux
public class Playabout {

    @Bean
    HealthHandler healthHandler() {
        return new HealthHandler();
    }

    @Bean
    RouterFunction<ServerResponse> healthRouterFunction(HealthHandler healthHandler) {
        return RouterFunctions.route(RequestPredicates.path("/ping"), healthHandler::ping);
    }

    public static void main(String[] args) {
        SpringApplication.run(Playabout.class, args);
    }
}