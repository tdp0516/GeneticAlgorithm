
package geneticalgorithm.mystuff;

import geneticalgorithm.interfaces.*;
import java.util.*;

public class MyChromosome implements Chromosome
{
    private List<Gene> genes;
    
    public MyChromosome(MyChromosome that)
    {
        this.genes = new ArrayList<>();
        
        for(int i = 0; i < that.genes.size(); i++)
        {
            this.genes.add(that.genes.get(i));
        }
    }
    
    public MyChromosome(int num)
    {
        this.genes = new ArrayList<>();
        Random rand = new Random();
        
        for(int i = 0; i < num; i++)
        {
            this.genes.add(new MyGene(rand.nextInt(2)));
        }
    }
    
    @Override
    public int calcFitnessScore()
    {
        int sum = 0;
        
        for(int i = 0; i < this.genes.size(); i++)
        {
            sum += ((MyGene)this.genes.get(i)).getNum();
        }
        
        return sum;
    }

    @Override
    public Gene getGene(int i)
    {
        return this.genes.get(i);
    }

    @Override
    public void addGene(Gene gene)
    {
        this.genes.add(gene);
    }

    @Override
    public int size()
    {
        return this.genes.size();
    }

    @Override
    public void removeGene(Gene chromosome)
    {
        this.genes.remove(chromosome);
    }

    @Override
    public Chromosome clone()
    {
        return new MyChromosome(this);
    }

    @Override
    public void replaceGene(int i, Gene chromosome)
    {
        this.genes.set(i, chromosome);
    }

    @Override
    public void removeGeneAt(int i)
    {
        this.genes.remove(i);
    }
}
