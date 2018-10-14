
package geneticalgorithm.models;

import geneticalgorithm.interfaces.Chromosome;
import java.time.LocalDateTime;
import java.util.*;

public class GeneticAlgorithmResults
{
    private List<Population> populations;
    private final LocalDateTime runDate;
    private long runTimeInSeconds;
    
    public GeneticAlgorithmResults(LocalDateTime runDate)
    {
        this.runDate = runDate;
        this.populations = new ArrayList<>();
    }
   
    public LocalDateTime getRunDate()
    {
        return this.runDate;
    }
    
    public long getRunTimeInSeconds()
    {
        return this.runTimeInSeconds;
    }
    
    public double getRunTimeInMinutes()
    {
        return this.runTimeInSeconds / 60.0;
    }
    
    public void setRunTime(long startTime, long endTime)
    {
        this.runTimeInSeconds = endTime - startTime;
    }
    
    public int getNumberOfGenerations()
    {
        return this.populations.size();
    }
    
    public void addGeneration(Population population)
    {
        this.populations.add(new Population(population));
    }
    
    public Chromosome getBestIndividual()
    {
        Chromosome best = this.populations.get(0).getBestIndividual();
        int highestScore = this.populations.get(0).getHighestFitnessScore();
        
        for(int i = 1; i < this.populations.size(); i++)
        {
            int currentHighest = this.populations.get(i).getHighestFitnessScore();
            
            if(currentHighest > highestScore)
            {
                best = this.populations.get(i).getBestIndividual();
                highestScore = currentHighest;
            }
        }
        
        return best;
    }
    
    public Chromosome getWorstIndividual()
    {
        Chromosome worst = this.populations.get(0).getBestIndividual();
        int lowestScore = this.populations.get(0).getHighestFitnessScore();
        
        for(int i = 1; i < this.populations.size(); i++)
        {
            int currentLowest = this.populations.get(i).getHighestFitnessScore();
            
            if(currentLowest < lowestScore)
            {
                worst = this.populations.get(i).getBestIndividual();
                lowestScore = currentLowest;
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
        int count = 0;
        
        for(int i = 0; i < this.populations.size(); i++)
        {
            Population current = this.populations.get(i);
            
            for(int j = 0; j < current.size(); j++)
            {
                sum += current.get(j).calcFitnessScore();
                count++;
            }
        }
        
        return sum / count;
    }
}
