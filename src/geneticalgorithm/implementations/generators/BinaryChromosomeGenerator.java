
package geneticalgorithm.implementations.generators;

import geneticalgorithm.implementations.chromosomes.BinaryChromosome;
import geneticalgorithm.interfaces.Chromosome;

public class BinaryChromosomeGenerator extends IntegerChromosomeGenerator
{
    public BinaryChromosomeGenerator(int size)
    {
        super(size, 1, 0);
    }
    
    @Override
    public Chromosome getRandomIndividual()
    {
        return BinaryChromosome.generateRandomChromosome(this.getChromosomeSize());
    }
}
