package eu.agilejava.batch.simple;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
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

   @Inject StepContext stepCtx;
   
   @Override
   public String process() throws Exception {
      logger.log(Level.INFO, "processing simple batchlet [{0} - {1}]...", new Object[]{jobCtx.getJobName(), jobCtx.getBatchStatus().toString()});
      Thread.sleep(1000);
      logger.log(Level.INFO, "Step: {0}", stepCtx.getStepName());
      logger.log(Level.INFO, "...processed simple batchlet");
      return "DONE";
   }
}
