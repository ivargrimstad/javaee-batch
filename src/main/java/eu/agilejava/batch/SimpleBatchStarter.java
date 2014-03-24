/**
 * The MIT License
 *
 * Copyright 2014 Ivar Grimstad <ivar.grimstad@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eu.agilejava.batch;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.operations.JobOperator;
import javax.batch.operations.JobSecurityException;
import javax.batch.operations.JobStartException;
import javax.batch.operations.NoSuchJobExecutionException;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Starter utility class for batch demo.
 *
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Dependent
public class SimpleBatchStarter {

   @Inject
   private Logger logger;

   public void startBatches() throws JobSecurityException, JobStartException, NoSuchJobExecutionException {
      JobOperator jobOperator = BatchRuntime.getJobOperator();

      logger.log(Level.INFO, "starting simple");
      Long executionId = jobOperator.start("simple", new Properties());
      JobExecution jobExecution = jobOperator.getJobExecution(executionId);

      logger.log(Level.INFO, "Started simple job with id {0}", jobExecution.getExecutionId());
      logger.log(Level.INFO, "Status simple {0}", jobExecution.getBatchStatus());

//      logger.log(Level.INFO, "starting chunk");
//      Long chunkExecutionId = jobOperator.start("chunk", new Properties());
//      JobExecution chunkJobExecution = jobOperator.getJobExecution(chunkExecutionId);
//
//      logger.log(Level.INFO, "Status chunk {0}", chunkJobExecution.getBatchStatus());
//      logger.log(Level.INFO, "Started chunk job with id {0}", chunkJobExecution.getExecutionId());
   }

}
