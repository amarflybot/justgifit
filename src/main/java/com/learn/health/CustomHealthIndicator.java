package com.learn.health;

import com.justgifit.JustGifItProperties;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by amarendra on 06/10/16.
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Inject
    private JustGifItProperties properties;

    @Override
    public Health health() {
        if(properties.getLocation().canWrite()){
            return Health.up().withDetail("Writable", "Dir:"+properties.getLocation().getAbsolutePath()).build();
        }
        else {
            return Health.down().withDetail("Non-Writable", "Dir:"+properties.getLocation().getAbsolutePath()).build();
        }
    }
}
