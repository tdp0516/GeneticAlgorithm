
package geneticalgorithm.implementations.mutators;

import geneticalgorithm.interfaces.*;
import java.util.Random;

public class SwapMutator implements Mutator
{
    @Override
    public void mutate(double mutationRate, Chromosome individual)
    {
        Random rand = new Random();
        
        if(rand.nextDouble() <= mutationRate)
        {
            int randIndex1 = rand.nextInt(individual.size());
            int randIndex2 = rand.nextInt(individual.size());
            Gene gene1 = individual.getGene(randIndex1).clone();
            Gene gene2 = individual.getGene(randIndex2).clone();
            
            individual.replaceGene(randIndex1, gene2);
            individual.replaceGene(randIndex2, gene1);
        }
    }
}
