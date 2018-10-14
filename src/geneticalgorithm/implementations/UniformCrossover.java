
package geneticalgorithm.implementations;

import geneticalgorithm.interfaces.*;
import java.util.Random;

public class UniformCrossover implements Crossover
{
    @Override
    public Chromosome crossover(double crossoverRate, Chromosome parent1, Chromosome parent2)
    {
        Chromosome child = parent1.clone();
        Random rand = new Random();
        
        for(int i = 0; i < parent2.size(); i++)
        {
            if(rand.nextDouble() > crossoverRate)
            {
                child.replaceGene(i, parent2.getGene(i));
            }
        }
        
        return child;
    }
}
