
package geneticalgorithm.mystuff;

import geneticalgorithm.interfaces.Gene;

public class MyGene implements Gene
{
    private int num;
    
    public MyGene(int num)
    {
        this.num = num;
    }
    
    public int getNum()
    {
        return this.num;
    }
    
    public void setNum(int num)
    {
        this.num = num;
    }
    
    public String toString()
    {
        return Integer.toString(num);
    }
}
