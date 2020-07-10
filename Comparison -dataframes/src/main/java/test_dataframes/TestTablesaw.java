package test_dataframes;

import com.google.common.base.Stopwatch;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;


public class TestTablesaw {
    public static void main(String[] args) throws Exception {

        CsvReadOptions.Builder builder =
                CsvReadOptions.builder("train.csv")
                        .separator(',')										// table is tab-delimited
                        .header(true);											// no header

        CsvReadOptions options = builder.build();

        Table t1 = Table.read().usingOptions(options);
        System.out.println(t1);
        Stopwatch watch = Stopwatch.createStarted();


        System.out.println("Total time: " + watch);

    }


}
