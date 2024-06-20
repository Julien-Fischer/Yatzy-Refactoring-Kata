package org.codingdojo.yatzy1.scoring.strategies.impl.numbers;

import org.codingdojo.yatzy1.scoring.strategies.impl.AbstractNumberStrategy;

/**
 * An {@link AbstractNumberStrategy} that scores the sum of the dice that read six.
 */
public class SixesStrategy extends AbstractNumberStrategy {

    public SixesStrategy() {
        super(6);
    }

}
