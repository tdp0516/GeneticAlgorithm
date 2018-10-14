
package geneticalgorithm.models;

import geneticalgorithm.interfaces.*;
import java.util.*;

public class Population
{
    private List<Chromosome> individuals;
    
    public Population()
    {
        this.individuals = new ArrayList<>();
    }
    
    public Population(Population that)
    {
        this();
        
        for(int i = 0; i < that.size(); i++)
        {
            this.individuals.add(that.get(i).clone());
        }
    }
    
    public static Population getRandomPopulation(int size, ChromosomeGenerator generator)
    {
        Population pop = new Population();
        
        for(int i = 0; i < size; i++) pop.add(generator.getRandomIndividual());
        
        return pop;
    }
    
    public Chromosome get(int i)
    {
        return this.individuals.get(i);
    }
    
    public void add(Chromosome individual)
    {
        this.individuals.add(individual);
    }
    
    public void remove(Chromosome individual)
    {
        this.individuals.remove(individual);
    }
    
    public List<Chromosome> toList()
    {
        return this.individuals;
    }
    
    public int size()
    {
        return this.individuals.size();
    }
    
    public Chromosome getBestIndividual()
    {
        Chromosome best = this.individuals.get(0);
        int highestScore = best.calcFitnessScore();
        
        for(int i = 1; i < this.individuals.size(); i++)
        {
            if(this.individuals.get(i).calcFitnessScore() > highestScore)
            {
                best = this.individuals.get(i);
                highestScore = best.calcFitnessScore();
            }
        }
        
        return best;
    }
    
    public Chromosome getWorstIndividual()
    {
        Chromosome worst = this.individuals.get(0);
        int highestScore = worst.calcFitnessScore();
        
        for(int i = 1; i < this.individuals.size(); i++)
        {
            if(this.individuals.get(i).calcFitnessScore() > highestScore)
            {
                worst = this.individuals.get(i);
                highestScore = worst.calcFitnessScore();
            }
        }
        
        return worst;
    }
    
    public int getHighestFitnessScore()
    {
        return this.getBestIndividual().calcFitnessScore();
    }
    
    public int getLowestFitnessScore()
    {
        return this.getWorstIndividual().calcFitnessScore();
    }
    
    public int getAverageFitnessScore()
    {
        int sum = 0;
        
        for(int i = 0; i < this.individuals.size(); i++)
        {
            sum += this.individuals.get(i).calcFitnessScore();
        }
        
        return sum / this.individuals.size();
    }
    
    public void clear()
    {
        this.individuals.clear();
    }
}
