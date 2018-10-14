
package geneticalgorithm.mystuff;

import geneticalgorithm.interfaces.*;
import java.util.Random;

public class MyGeneGenerator implements GeneGenerator
{
    @Override
    public Gene getRandomGene()
    {
        return new MyGene(new Random().nextInt(2));
    }
}
