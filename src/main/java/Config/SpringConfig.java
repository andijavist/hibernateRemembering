package Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"DAO","Entity_DB_model","service_layer"})
public class SpringConfig {
}
