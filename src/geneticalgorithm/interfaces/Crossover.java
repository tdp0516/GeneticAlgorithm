
package geneticalgorithm.interfaces;

public interface Crossover
{
    public Chromosome crossover(double crossoverRate, Chromosome parent1, Chromosome parent2);
}
