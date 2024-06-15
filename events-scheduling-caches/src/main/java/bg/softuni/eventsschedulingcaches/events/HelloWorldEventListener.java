package bg.softuni.eventsschedulingcaches.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldEventListener implements ApplicationListener<HelloWorldEvent> {

    private int counter = 0;

    @Override
    public void onApplicationEvent(HelloWorldEvent event) {
        counter++;
        System.out.println(counter + " events were received. Last message: " + event.getMessage());
    }
}
