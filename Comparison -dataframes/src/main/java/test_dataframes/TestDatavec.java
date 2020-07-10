package test_dataframes;

import com.google.common.base.Stopwatch;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.transform.TransformProcess;
import org.datavec.api.transform.schema.Schema;

import java.io.File;

public class TestDatavec {
    public static void main(String[] args) throws Exception {
        int numLinesToSkip = 1;
        char delimiter = ',';
        RecordReader recordReader = new CSVRecordReader(numLinesToSkip, delimiter);
        recordReader.initialize(new FileSplit(new File("train.csv")));

        //  we need to know in advance what the fields and their order

        Schema csvSchema = new Schema.Builder()
                .addColumnsInteger("Id", "MSSubClass", "LotArea", "OverallQual", "OverallCond", "YearBuilt",
                        "YearRemodAdd", "BsmtFinSF1", "BsmtFinSF2", "BsmtUnfSF", "TotalBsmtSF", "1stFlrSF",
                        "2ndFlrSF", "LowQualFinSF", "GrLivArea", "BsmtFullBath", "BsmtHalfBath", "FullBath", "HalfBath", "BedroomAbvGr",
                        "KitchenAbvGr", "TotRmsAbvGrd",
                        "Fireplaces", "GarageCars", "GarageArea", "WoodDeckSF", "OpenPorchSF", "EnclosedPorch", "3SsnPorch", "ScreenPorch",
                        "PoolArea", "MiscVal", "MoSold", "YrSold", "SalePrice")
                .addColumnCategorical("MSZoning", "A", "C", "FV", "I", "RH", "RL", "RP",
                        "RM")
                .addColumnString("LotFrontage")
                .addColumnCategorical("Street", "Pave", "Grvl")
                .addColumnCategorical("Alley", "Pave", "Grvl", "NA")
                .addColumnCategorical("LotShape", "  Reg", "IR1", " IR2", " IR3")
                .addColumnCategorical("LandContour", "Lvl", " Bnk", "  HLS", " Low")
                .addColumnCategorical("Utilities", "  AllPub", " NoSewr", " NoSeWa", " ELO")
                .addColumnCategorical("LotConfig", "Inside", "Corner", "CulDSac", "FR2", "FR3")
                .addColumnCategorical("LandSlope", " Gtl", "Mod", "Sev")
                .addColumnCategorical("Neighborhood", " Blmngtn", "Corner", "BrDale", "BrkSide",
                        "ClearCr", "CollgCr", "Crawfor",
                        "Edwards", "Gilbert", "IDOTRR", "MeadowV", "Mitchel",
                        "Names", "NoRidge", "NPkVill", "NridgHt", "NWAmes", "OldTown", "SWISU",
                        "Sawyer", "SawyerW", "Somerst", "StoneBr", "Timber", "Veenker")
                .addColumnCategorical("Condition1", "Artery", " Feedr", "Norm", "RRNn", "RRAn",
                        "PosN", "PosA", "RRNe", "RRAe")
                .addColumnCategorical("Condition2", "Artery", " Feedr", "Norm", "RRNn", "RRAn", "PosN",
                        "PosA", "RRNe", "RRAe")
                .addColumnCategorical("BldgType", "1Fam", "2FmCon", "Duplx", "TwnhsE", "TwnhsI")
                .addColumnCategorical("HouseStyle", "1Story", "1.5Fin", "1.5Unf", "2Story", "2.5Unf", "SFoyer", "SLvl")
                .addColumnCategorical("RoofStyle", " Flat", "Gable", "Gambrel", "Hip", "Mansard", "Shed")
                .addColumnCategorical("RoofMatl", "ClyTile", "CompShg", "Membran", " Metal", "Roll", "Tar&Grv",
                        "WdShake", "WdShngl")
                .addColumnCategorical("Exterior1st", "  AsbShng", "AsphShn", " BrkComm", "BrkFace", "CBlock", "CemntBd", "HdBoard", "ImStucc", "MetalSd", "Other", "Plywood", "PreCast", " Stone",
                        "Stucco", "VinylSd", "Wd Sdng", " WdShing")
                .addColumnCategorical("Exterior2nd", "AsbShng", "AsphShn", "BrkComm",
                        " BrkFace", "CBlock", "CemntBd", "HdBoard", "ImStucc", "MetalSd",
                        "Other", "Plywood", "PreCast", "Stone", "Stucco", "VinylSd", "Wd Sdng",
                        "WdShing")
                .addColumnCategorical("MasVnrType", "BrkCmn", "BrkFace", "CBlock", "None", "Stone")
                .addColumnString("MasVnrArea")
                .addColumnCategorical("ExterQual", "Ex", "Gd", "TA", "Fa", "Roll", "Po")
                .addColumnCategorical("ExterCond", "Ex", "Gd", "TA", "Fa", "Roll", "Po")
                .addColumnCategorical("Foundation", "BrkTil", "CompShg", "CBlock", "PConc", "Slab", "Stone", "Wood")
                .addColumnCategorical("BsmtQual", "Ex", "Gd", "TA", "Fa", "Po", "NA")
                .addColumnCategorical("BsmtCond", "Ex", "Gd", "TA", "Fa", "Po", "NA")
                .addColumnCategorical("BsmtExposure", "Gd", "Av", "Mn", "No", "NA")
                .addColumnCategorical("BsmtFinType1", "GLQ", "ALQ", "BLQ", "Rec", "LwQ", "Unf", "NA")
                .addColumnCategorical("BsmtFinType2", "GLQ", "ALQ", "BLQ", "Rec", "LwQ", "Unf", "NA")
                .addColumnCategorical("Heating", "Floor", "GasA", "GasW", "OthW", "Wall")
                .addColumnCategorical("HeatingQC", "Ex", "Gd", "TA", "Fa", "Po")
                .addColumnCategorical("CentralAir", "N", "Y")
                .addColumnCategorical("Electrical", "SBrkr", "FuseA", "FuseF", "FuseP", "Mix")
                .addColumnCategorical("KitchenQual", "Ex", "Gd", "TA", "Fa", "Po")
                .addColumnCategorical("Functional", "Typ", "Min1", "Min2", "Mod", "Maj1", "Maj2", "Sev", "Sal")
                .addColumnCategorical("FireplaceQu", "Ex", "Gd", "TA", "Fa", "Po", "NA")
                .addColumnCategorical("GarageType", "2Types", "Attchd", "Basment",
                        "BuiltIn", "CarPort", "Detchd", "NA")
                .addColumnString("GarageYrBlt")
                .addColumnCategorical("GarageFinish", "Fin", "RFn", "Unf", "NA")
                .addColumnCategorical("GarageQual", "Ex", "Gd", "TA", "Fa", "Po", "NA")
                .addColumnCategorical("GarageCond", "Ex", "Gd", "TA", "Fa", "Po", "NA")
                .addColumnCategorical("PavedDrive", "Y", "P", "N")
                .addColumnCategorical("PoolQC", "Ex", "Gd", "TA", "Fa", "NA")
                .addColumnCategorical("Fence", " GdPrv", "MnPrv", "GdWo", "MnWw", " NA")
                .addColumnCategorical("MiscFeature", "Elev", "Gar2", "Othr", "Shed", "TenC", "NA")
                .addColumnCategorical("SaleType", "WD", "CWD", "VWD", "New", "Con", "ConLw", "ConLI", "ConLD", "Oth")
                .addColumnCategorical("SaleCondition", "Normal", "Abnorml", "AdjLand", "Alloca", "Family", "Partial")

                //.addColumnString()


                .build();
      /*  System.out.println("Input data schema details:");
        System.out.println(csvSchema);

        System.out.println("\n\nOther information obtainable from schema:");
        System.out.println("Number of columns: " + csvSchema.numColumns());
        System.out.println("Column names: " + csvSchema.getColumnNames());
        System.out.println("Column types: " + csvSchema.getColumnTypes());
*/
        TransformProcess tp = new TransformProcess.Builder(csvSchema)


                .build();
        Schema outputSchema = tp.getFinalSchema();
        System.out.println(outputSchema);


        Stopwatch watch = Stopwatch.createStarted();
        System.out.println("Total time:" + watch);
    }

}


