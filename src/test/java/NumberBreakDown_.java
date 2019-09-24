import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(Parameterized.class)
public class NumberBreakDown_ {
    private final int number;
    private final int[][] breakdown;

    public NumberBreakDown_ (int number, int[][] breakdown){
        this.number = number;
        this.breakdown = breakdown;
    }

    @Test
    public void execute (){
        assertThat(breakOf(number)).isEqualTo(breakdown);
    }

    private int[][] breakOf(int number) {
        return null;
    }

    @Parameterized.Parameters
    public static Object [][] cases (){
        return new Object[][]{
                {0, new int[][]{}},
                {1, new int[][]{{1,0}}},
                {10, new int [][]{{1,2}}}
        };
    }

}


