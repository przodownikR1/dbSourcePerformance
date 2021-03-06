/*
 * Copyright (C) 2016 Scalatech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.java.scalatech.timeTest;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import com.google.common.base.Stopwatch;

@Slf4j
public class TimedTest implements MethodRule {

    @Override
    public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {
        return new TimedTestStatement(base, method);
    }

    private class TimedTestStatement extends Statement {

        private final Statement testStatement;
        private final FrameworkMethod method;

        public TimedTestStatement(final Statement base, final FrameworkMethod method) {
            testStatement = base;
            this.method = method;

        }

        @Override
        public void evaluate() throws Throwable {
            Stopwatch stopWatch = Stopwatch.createStarted();
            testStatement.evaluate();
            stopWatch = stopWatch.stop();
            long took = stopWatch.elapsed(TimeUnit.MILLISECONDS);
            log.info("test {} : {} ms took ", method.getName(), took);

            final Timed timed = method.getAnnotation(Timed.class);

            if (timed != null) {
                if (took > timed.timeThreshold()) { throw new AssertionError("method :" + method + " took too long :  " + took
                        + ",  should took only less than : " + timed.timeThreshold());

                }

            }
        }
    }
}