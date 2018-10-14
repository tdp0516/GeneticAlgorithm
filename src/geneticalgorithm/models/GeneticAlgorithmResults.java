
package geneticalgorithm.models;

import geneticalgorithm.interfaces.Chromosome;
import geneticalgorithm.models.Population;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    
    public int getHighestFitnessScore()
    {
        return this.getBestIndividual().calcFitnessScore();
    }
}
