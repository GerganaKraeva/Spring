package bg.softuni.eventsschedulingcaches.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @EventListener
    public void onHelloWorldEvent(HelloWorldEvent helloWorldEvent) {
        System.out.println("Message received: "+helloWorldEvent.getMessage());
    }
}
