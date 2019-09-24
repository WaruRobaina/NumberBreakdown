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
        //if (number >= 1000) return times(thousands(number), THOUSANDS) + times(hundreds(number), HUNDREDS);
        //if (number >= 100) return times(hundreds(number), HUNDREDS) + times(tens(number), TENS);
        //return times(tens(number), TENS) + times(ones(number), ONES);

        if(number > 99) return new int[][] {{hundreds(number),2},{tens(number),1},{ones(number),0}};
        if(number > 9) return new int[][]{{tens(number),1},{ones(number),0}};
        if(number > 0) return new int [][]{{ones(number),0}};
        return new int[][]{};
    }

    private String times(int offset, String[] constants) {
        if (offset == 0) return "";
        return constants[offset-1];
    }

    @Parameterized.Parameters
    public static Object [][] cases (){
        return new Object[][]{
                {0, new int[][]{}},
                {1, new int[][]{{1,0}}},
                {5, new int[][]{{5,0}}},
                {10, new int [][]{{1,1},{0,0}}},
                {25, new int [][]{{2,1},{5,0}}}
        };
    }

    /*
    private int thousands(int number) {
        return number/1000;
    }
*/
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


