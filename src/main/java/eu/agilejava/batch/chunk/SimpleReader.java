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

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Simple reader for batch chunk demo.
 *
 * @author Ivar Grimstad <ivar.grimstad@gmail.com>
 */
@Dependent
@Named("simpleReader")
public class SimpleReader extends AbstractItemReader {

   @Inject
   private Logger logger;

   private int pos = 0;
   private int[] numbers;

   @Override
   public void open(Serializable checkpoint) throws Exception {
      numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
   }

   /**
    * Reads the next item from array.
    *
    * @return the next item
    * @throws Exception if read fails
    */
   @Override
   public Object readItem() throws Exception {

      if (pos < numbers.length) {
         logger.log(Level.INFO, "reading {0}", numbers[pos]);
         return new SimpleInput(numbers[pos++]);
      }

      return null;
   }
}
