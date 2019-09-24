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
        if(number > 0 && number < 10) return new int [][]{{number,0}};
        if(number > 9) return new int [][]{{1,1}};
        return new int[][]{};
    }

    @Parameterized.Parameters
    public static Object [][] cases (){
        return new Object[][]{
                {0, new int[][]{}},
                {1, new int[][]{{1,0}}},
                {5, new int[][]{{5,0}}},
                {10, new int [][]{{1,1}}}
        };
    }

    private int thousands(int number) {
        return number/1000;
    }

    private int hundreds(int number) {
        return (number%1000)/100;
    }

    private int tens(int number) {
        return (number%100)/10;
    }

    private int ones(int number) {
        return number%10;
    }

}


