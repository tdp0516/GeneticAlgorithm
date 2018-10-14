package geneticalgorithm;

import geneticalgorithm.models.*;
import geneticalgorithm.exceptions.GeneticAlgorithmException;
import geneticalgorithm.implementations.generators.BinaryChromosomeGenerator;
import geneticalgorithm.interfaces.*;
import java.time.LocalDateTime;

public class GeneticAlgorithm
{
    private GeneticAlgorithmConfiguration configuration;
    
    public GeneticAlgorithm(GeneticAlgorithmConfiguration config)
    {
        this.configuration = config;
    }
    
    public GeneticAlgorithm()
    {
        this(GeneticAlgorithmConfiguration.getDefaultConfiguration());
    }
    
    public GeneticAlgorithm(Population population) 
    { 
        this.configuration = GeneticAlgorithmConfiguration.getDefaultConfiguration();
        this.configuration.setInitialPopulation(population);
    }
    
    public GeneticAlgorithm(Selector selector, Crossover crossover, Mutator mutator)
    {
        this.configuration = GeneticAlgorithmConfiguration.getDefaultConfiguration();
        this.configuration.setSelector(selector);
        this.configuration.setCrossover(crossover);
        this.configuration.setMutator(mutator);
    }
    
    public GeneticAlgorithm(double crossoverRate, double mutationRate)
    {
        this.configuration = GeneticAlgorithmConfiguration.getDefaultConfiguration();
        this.configuration.setCrossoverRate(crossoverRate);
        this.configuration.setMutationRate(mutationRate);
    }
    
    public void setMaxNumOfGenerations(int maxNum)
    {
        this.configuration.setMaxNumberOfGenerations(maxNum);
    }
    
    public void setMaxFitnessScore(int maxScore)
    {
        this.configuration.setMaxFitnessScore(maxScore);
    }
    
    public void setInitialPopulation(Population population)
    {
        this.configuration.setInitialPopulation(population);
    }
    
    public void setCrossoverRate(double crossoverRate)
    {
        this.configuration.setCrossoverRate(crossoverRate);
    }
    
    public void setMutationRate(double mutationRate)
    {
        this.configuration.setMutationRate(mutationRate);
    }
    
    public void setSelector(Selector selector)
    {
        this.configuration.setSelector(selector);
    }
    
    public void setCrossover(Crossover crossover)
    {
        this.configuration.setCrossover(crossover);
    }
    
    public void setMutator(Mutator mutator)
    {
        this.configuration.setMutator(mutator);
    }
    
    public Population getInitialPopulation()
    {
        return this.configuration.getInitialPopulation();
    }
    
    public double getCrossoverRate()
    {
        return this.configuration.getCrossoverRate();
    }
    
    public double getMutationRate()
    {
        return this.configuration.getMutationRate();
    }
    
    public Selector getSelector(Selector selector)
    {
        return this.configuration.getSelector();
    }
    
    public Crossover getCrossover(Crossover crossover)
    {
        return this.configuration.getCrossover();
    }
    
    public Mutator getMutator(Mutator mutator)
    {
        return this.configuration.getMutator();
    }
    
    public Integer getMaxNumOfGenerations()
    {
        return this.configuration.getMaxNumOfGenerations();
    }
    
    public Integer getMaxFitnessScore()
    {
        return this.configuration.getMaxFitnessScore();
    }
    
    private Chromosome select(Population population)
    {
        return this.configuration.getSelector().select(population);
    }
    
    private Chromosome crossover(Chromosome parent1, Chromosome parent2)
    {
        return this.configuration.getCrossover().crossover(this.getCrossoverRate(), 
                                                           parent1, parent2);
    }
    
    private void mutate(Chromosome individual)
    {
        this.configuration.getMutator().mutate(this.getMutationRate(), individual);
    }
    
    public GeneticAlgorithmResults evolve(double crossoverRate, double mutationRate)
            throws GeneticAlgorithmException
    {
        this.setCrossoverRate(crossoverRate);
        this.setMutationRate(mutationRate);
        
        return this.evolve();
    }
    
    public GeneticAlgorithmResults evolve(Population population, double crossoverRate, 
                                          double mutationRate) throws GeneticAlgorithmException
    {
        this.setInitialPopulation(population);
        this.setCrossoverRate(crossoverRate);
        this.setMutationRate(mutationRate);
        
        return this.evolve();
    }
    
    public GeneticAlgorithmResults evolve() throws GeneticAlgorithmException
    {
        // Check for potential initialization errors
        if(this.getInitialPopulation() == null || this.getInitialPopulation().size() == 0)
        {
            throw new GeneticAlgorithmException("Initial population has not been set");
        }
        else if(this.getMaxFitnessScore() == null && this.getMaxNumOfGenerations() == null)
        {
            throw new GeneticAlgorithmException("No exit condition has been set");
        }
        else if(this.getCrossoverRate() == 0.00)
        {
            throw new GeneticAlgorithmException("Crossover rate is set to 0.00");
        }
        
        GeneticAlgorithmResults results = new GeneticAlgorithmResults(LocalDateTime.now());
        Population current = new Population(this.getInitialPopulation()), 
                   nextGeneration = new Population();

        while(true)
        {
            for(int i = 0; i < current.size(); i++)
            {
                // Select 2 parent individuals
                Chromosome parent1 = this.select(current);
                Chromosome parent2 = this.select(current);
        
                // Merge them into a child individual
                Chromosome child = this.crossover(parent1, parent2);
        
                this.mutate(child);
        
                nextGeneration.add(child);
            }
            
            results.addGeneration(current);
            current = new Population(nextGeneration);
            nextGeneration.clear();
            
            // Break out at either exit condition
            if(this.getMaxNumOfGenerations() != null && 
               results.getNumberOfGenerations() == this.getMaxNumOfGenerations())
            {
                break;
            }
            else if(this.getMaxFitnessScore() != null &&
                    results.getHighestFitnessScore() >= this.getMaxFitnessScore())
            {
                break;
            }
        }
        
        return results;
    }
            
    public static void main(String[] args)
    {
        GeneticAlgorithm ga = new GeneticAlgorithm(.75, 0.05);
        ga.setInitialPopulation(Population.getRandomPopulation(50, new BinaryChromosomeGenerator(50)));
        ga.setMaxNumOfGenerations(1000);
        ga.setMaxFitnessScore(50);
        
        try
        {
            GeneticAlgorithmResults results = ga.evolve();
            
            System.out.println(results.getNumberOfGenerations());
            System.out.println(results.getBestIndividual());
        }
        catch(GeneticAlgorithmException gaex)
        {
            System.err.println(gaex);
        }
    }
}
