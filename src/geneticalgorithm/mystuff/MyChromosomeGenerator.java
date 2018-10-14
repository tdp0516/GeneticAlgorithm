
package geneticalgorithm.mystuff;

import geneticalgorithm.interfaces.*;

public class MyChromosomeGenerator implements ChromosomeGenerator
{
    @Override
    public Chromosome getRandomIndividual()
    {
        return new MyChromosome(20);
    }
}
