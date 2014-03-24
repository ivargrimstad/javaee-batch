package eu.agilejava.batch.simple;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Simple batchlet for batch step demo.
 *
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Dependent
@Named("simpleBatchlet")
public class SimpleBatchlet extends AbstractBatchlet {

   @Inject
   private Logger logger;

   @Inject
   private JobContext jobCtx;

   @Override
   public String process() throws Exception {
      logger.log(Level.INFO, "processing simple batchlet...");
      Thread.sleep(1000);
      logger.log(Level.INFO, "...processed simple batchlet");
      return "DONE";
   }
}
