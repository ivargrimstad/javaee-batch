package eu.agilejava.batch.config;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

/**
 * Configuration for logging.
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Singleton
public class LogProducer {
   
   @Produces
   public Logger producer(InjectionPoint ip) {
      return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
   }

}
