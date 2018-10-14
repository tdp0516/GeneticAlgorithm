
package geneticalgorithm.models;

import geneticalgorithm.implementations.crossovers.UniformCrossover;
import geneticalgorithm.implementations.generators.BinaryGeneGenerator;
import geneticalgorithm.implementations.mutators.RandomResetMutator;
import geneticalgorithm.implementations.selectors.TournamentSelector;
import geneticalgorithm.interfaces.*;

public class GeneticAlgorithmConfiguration
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
    private static final Mutator defaultMutator = new RandomResetMutator(new BinaryGeneGenerator());
    private static final double defaultCrossoverRate = 0.00;
    private static final double defaultMutationRate = 0.00;
    
    public GeneticAlgorithmConfiguration(Population initialPopulation, double crossoverRate, 
                                        double mutationRate, Selector selector, Crossover crossover, 
                                        Mutator mutator)
    {
        this.initialPopulation = initialPopulation;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.selector = selector;
        this.crossover = crossover;
        this.mutator = mutator;
    }
    
    public GeneticAlgorithmConfiguration(GeneticAlgorithmConfiguration that)
    {
        this(that.initialPopulation, that.crossoverRate, that.mutationRate, that.selector, 
             that.crossover, that.mutator);
    }
    
    public static GeneticAlgorithmConfiguration  getDefaultConfiguration()
    {
        return new GeneticAlgorithmConfiguration(defaultPopulation, defaultCrossoverRate, 
                                                 defaultMutationRate, defaultSelector, 
                                                 defaultCrossover, defaultMutator);
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
    
    public void setMaxNumberOfGenerations(int num)
    {
        this.maxNumOfGenerations = num;
    }
    
    public void setMaxFitnessScore(int num)
    {
        this.maxFitnessScore = num;
    }
    
    public static Population getDefaultPopulation()
    {
        return defaultPopulation;
    }
    
    public static double getDefaultCrossoverRate()
    {
        return defaultCrossoverRate;
    }
    
    public static double getDefaultMutationRate()
    {
        return defaultMutationRate;
    }
    
    public static Selector getDefaultSelector()
    {
        return defaultSelector;
    }
    
    public static Crossover getDefaultCrossover()
    {
        return defaultCrossover;
    }
    
    public static Mutator getDefaultMutator()
    {
        return defaultMutator;
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
    
    public Selector getSelector()
    {
        return this.selector;
    }
    
    public Crossover getCrossover()
    {
        return this.crossover;
    }
    
    public Mutator getMutator()
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
}
