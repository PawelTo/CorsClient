package pl.pawel.app.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.PostConstruct;

@EnableCaching
@Slf4j
public class CacheConfiguration {

    @PostConstruct
    public void postConstruct(){log.info("Enabling Cache");}
}
