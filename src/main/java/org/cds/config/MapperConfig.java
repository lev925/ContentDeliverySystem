package org.cds.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.cds.model.Target;
import org.cds.model.web.WebTarget;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class MapperConfig {

 /*   @Component
    public class TargetMapper extends ConfigurableMapper {
        @Override
        protected void configure(MapperFactory factory) {
            factory.classMap(Target.class, WebTarget.class).byDefault()
                    .register();
        }
    }*/
}
