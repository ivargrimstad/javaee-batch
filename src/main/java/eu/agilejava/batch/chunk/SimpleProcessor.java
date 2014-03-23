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
package eu.agilejava.batch.chunk;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Simple processor for batch chunk demo.
 *
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Named("simpleProcessor")
@Dependent
public class SimpleProcessor implements ItemProcessor {

   @Inject
   private Logger logger;

   /**
    * Process the input by doubling it's value.
    *
    * @param item the item received
    * @return a processed item
    * @throws Exception if something fails
    */
   @Override
   public SimpleOutput processItem(Object item) throws Exception {

      SimpleInput input = (SimpleInput) item;

      logger.log(Level.INFO, "processing {0}...", input.getValue());
      Thread.sleep(1000);

      logger.log(Level.INFO, "...processed {0}", input.getValue());

      return new SimpleOutput(2 * input.getValue());
   }
}
