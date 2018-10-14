
package geneticalgorithm.implementations;

import geneticalgorithm.interfaces.Mutator;
import java.util.Random;
import geneticalgorithm.interfaces.GeneGenerator;
import geneticalgorithm.interfaces.Chromosome;

public class RandomResetMutator implements Mutator
{
    GeneGenerator generator;
    
    public RandomResetMutator(GeneGenerator generator)
    {
        this.generator = generator;
    }
    
    @Override
    public void mutate(double mutationRate, Chromosome individual)
    {
        Random rand = new Random();
        
        if(rand.nextDouble() <= mutationRate)
        {
            individual.replaceGene(rand.nextInt(individual.size()), 
                                        generator.getRandomGene());
        }
    }
}
