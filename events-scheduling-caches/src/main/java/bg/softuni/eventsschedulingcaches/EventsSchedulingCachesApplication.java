package bg.softuni.eventsschedulingcaches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventsSchedulingCachesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsSchedulingCachesApplication.class, args);
    }

}
