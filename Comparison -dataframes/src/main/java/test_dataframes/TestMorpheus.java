package test_dataframes;

import com.google.common.base.Stopwatch;
import com.zavtech.morpheus.frame.DataFrame;


public class TestMorpheus {
    public static void main(String[] args) {
        DataFrame<Object, String> frame = DataFrame.read().csv("train.csv");
        frame.out().print();
        System.out.println();

        Stopwatch watch = Stopwatch.createStarted();


        System.out.println("Total time: " + watch);
    }
}
