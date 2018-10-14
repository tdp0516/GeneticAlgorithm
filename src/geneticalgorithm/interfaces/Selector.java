
package geneticalgorithm.interfaces;

import geneticalgorithm.models.Population;

public interface Selector
{
    public Chromosome select(Population population);
}
