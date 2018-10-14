
package geneticalgorithm.implementations;

import geneticalgorithm.models.Population;
import geneticalgorithm.interfaces.Selector;
import java.util.Random;
import geneticalgorithm.interfaces.Chromosome;

public class TournamentSelector implements Selector
{
    private int size;
    
    public TournamentSelector(int size)
    {
        this.size = size;
    }
    
    @Override
    public Chromosome select(Population population)
    {
        Population tournament = new Population();
        Random rand = new Random();
        
        for(int i = 0; i < this.size; i++)
        {
            Chromosome randIndividual = population.get(rand.nextInt(size));
            tournament.add(randIndividual);
        }
        
        return tournament.getBestIndividual();
    }
}
