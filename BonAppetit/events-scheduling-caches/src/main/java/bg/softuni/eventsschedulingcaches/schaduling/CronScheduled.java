package bg.softuni.eventsschedulingcaches.schaduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronScheduled {

    private Logger LOGGER= LoggerFactory.getLogger(CronScheduled.class);

    @Scheduled(cron ="*/10 * * * * *", zone="Europe/Berlin")
    public void onCron() {
       LOGGER.info("On crone");
    }
}
