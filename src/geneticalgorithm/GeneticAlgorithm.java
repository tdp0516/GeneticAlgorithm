package geneticalgorithm;

import geneticalgorithm.mystuff.*;
import geneticalgorithm.models.*;
import geneticalgorithm.exceptions.GeneticAlgorithmException;
import geneticalgorithm.implementations.*;
import geneticalgorithm.interfaces.*;
import java.time.LocalDateTime;

public class GeneticAlgorithm
{
    private Population initialPopulation;
    private double crossoverRate;
    private double mutationRate;
    private Selector selector;
    private Crossover crossover;
    private Mutator mutator;
    private Integer maxNumOfGenerations;
    private Integer maxFitnessScore;
    
    private static final Population defaultPopulation = new Population();
    private static final Selector defaultSelector = new TournamentSelector(5);
    private static final Crossover defaultCrossover = new UniformCrossover();
    private static final Mutator defaultMutator = new RandomResetMutator(new MyGeneGenerator());
    private static final double defaultCrossoverRate = 0.00;
    private static final double defaultMutationRate = 0.00;
    
    public GeneticAlgorithm(Population population, Selector selector, Crossover crossover, 
                            Mutator mutator, double crossoverRate, double mutationRate)
    {
        this.initialPopulation = population;
        this.selector = selector;
        this.crossover = crossover;
        this.mutator = mutator;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
    }
    
    public GeneticAlgorithm()
    {
        this(defaultPopulation, defaultSelector, defaultCrossover, defaultMutator, 
            defaultCrossoverRate, defaultMutationRate);
    }
    
    public GeneticAlgorithm(Population population) 
    { 
        this(population, defaultSelector, defaultCrossover, defaultMutator,
             defaultCrossoverRate, defaultMutationRate);
    }
    
    public GeneticAlgorithm(Selector selector, Crossover crossover, Mutator mutator)
    {
        this(defaultPopulation, selector, crossover, mutator, 
             defaultCrossoverRate, defaultMutationRate);
    }
    
    public GeneticAlgorithm(double crossoverRate, double mutationRate)
    {
        this(defaultPopulation, defaultSelector, defaultCrossover, defaultMutator,
             crossoverRate, mutationRate);
    }
    
    public void setMaxNumOfGenerations(int maxNum)
    {
        this.maxNumOfGenerations = maxNum;
    }
    
    public void setMaxFitnessScore(int maxScore)
    {
        this.maxFitnessScore = maxScore;
    }
    
    public void setInitialPopulation(Population population)
    {
        this.initialPopulation = population;
    }
    
    public void setCrossoverRate(double crossoverRate)
    {
        this.crossoverRate = crossoverRate;
    }
    
    public void setMutationRate(double mutationRate)
    {
        this.mutationRate = mutationRate;
    }
    
    public void setSelector(Selector selector)
    {
        this.selector = selector;
    }
    
    public void setCrossover(Crossover crossover)
    {
        this.crossover = crossover;
    }
    
    public void setMutator(Mutator mutator)
    {
        this.mutator = mutator;
    }
    
    public Population getInitialPopulation()
    {
        return this.initialPopulation;
    }
    
    public double getCrossoverRate()
    {
        return this.crossoverRate;
    }
    
    public double getMutationRate()
    {
        return this.mutationRate;
    }
    
    public Selector getSelector(Selector selector)
    {
        return this.selector;
    }
    
    public Crossover getCrossover(Crossover crossover)
    {
        return this.crossover;
    }
    
    public Mutator getMutator(Mutator mutator)
    {
        return this.mutator;
    }
    
    public Integer getMaxNumOfGenerations()
    {
        return this.maxNumOfGenerations;
    }
    
    public Integer getMaxFitnessScore()
    {
        return this.maxFitnessScore;
    }
    
    private Chromosome select(Population population)
    {
        return this.selector.select(population);
    }
    
    private Chromosome crossover(Chromosome parent1, Chromosome parent2)
    {
        return this.crossover.crossover(this.crossoverRate, parent1, parent2);
    }
    
    private void mutate(Chromosome individual)
    {
        this.mutator.mutate(this.mutationRate, individual);
    }
    
    public GeneticAlgorithmResults evolve(double crossoverRate, double mutationRate)
            throws GeneticAlgorithmException
    {
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        
        return this.evolve();
    }
    
    public GeneticAlgorithmResults evolve(Population population, double crossoverRate, 
                                          double mutationRate) throws GeneticAlgorithmException
    {
        this.initialPopulation = population;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        
        return this.evolve();
    }
    
    public GeneticAlgorithmResults evolve() throws GeneticAlgorithmException
    {
        // Check for potential initialization errors
        if(this.initialPopulation == null || this.initialPopulation.size() == 0)
        {
            throw new GeneticAlgorithmException("Initial population has not been set");
        }
        else if(this.maxFitnessScore == null && this.maxNumOfGenerations == null)
        {
            throw new GeneticAlgorithmException("No exit condition has been set");
        }
        else if(this.crossoverRate == 0.00)
        {
            throw new GeneticAlgorithmException("Crossover rate is set to 0.00");
        }
        
        GeneticAlgorithmResults results = new GeneticAlgorithmResults(LocalDateTime.now());
        Population current = new Population(this.initialPopulation), 
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
            if(this.maxNumOfGenerations != null && 
               results.getNumberOfGenerations() == this.maxNumOfGenerations)
            {
                break;
            }
            else if(this.maxFitnessScore != null &&
                    results.getHighestFitnessScore() >= this.maxFitnessScore)
            {
                break;
            }
        }
        
        return results;
    }
            
    public static void main(String[] args)
    {
        GeneticAlgorithm ga = new GeneticAlgorithm(.75, 0.05);
        ga.setInitialPopulation(Population.getRandomPopulation(50, new MyChromosomeGenerator()));
        ga.setMaxNumOfGenerations(1000);
        ga.setMaxFitnessScore(20);
        
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
