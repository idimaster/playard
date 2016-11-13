package wget.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;

/**
 * Created by fluff on 7/27/16.
 */
public class Wget {
    public void start() {
        final ActorSystem system = ActorSystem.create("wget");
        final ActorRef greeter = system.actorOf(Props.create(Worker.class, "worker"));
        final Inbox inbox = Inbox.create(system);
    }
}
