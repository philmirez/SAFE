package automation.utilities;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class CsvReader {
	
    private String csvFile = "filePath";
    static BufferedReader br = null;
    static String line = "";
    static String cvsSplitBy = ",";
    static int numLangs;
    public int LangStartPos = 5;
    public int numLangsChecker;
    boolean CSVmatchUserLang = false;

    
    public CsvReader()
    {
    }
    public void setCSVReader(String file)
    {
    	this.csvFile = file;
    }
    public CsvReader(String fileName)
    {
    	this.csvFile = fileName;
    }

    public boolean ReadCSV(List<String> UserLanguages)
    {
    try {
    	
        br = new BufferedReader(new FileReader(this.csvFile));
        line = br.readLine();
            // use comma as separator
            String[] csvHeader = line.split(cvsSplitBy);
            //I only want to check if the languages selected at export is used  commented out code below is for trouble shooting
           Log.Info("CSVpos5 " + csvHeader[LangStartPos] );
/*            if(csvHeader[5] == "French" && csvHeader[6] == "test")
            	numLangsChecker = 0;
            else numLangsChecker = 1;*/
            
            numLangsChecker = UserLanguages.size();
            Log.Info("numLangsChecker" + numLangsChecker);
             for(int i = LangStartPos; i<csvHeader.length;i++)
             {
            	 if(csvHeader[i].equals(UserLanguages.get(i-LangStartPos)))
            		// Log.Info("currentLang: " + UserLanguages.get(i-LangStartPos));
            	 	numLangsChecker--;
             }
             
             //java ternary to check if numLangs is empty this would mean that all langs are accounted for
             Log.Info("numLangsChecker" + numLangsChecker);
             CSVmatchUserLang = (numLangsChecker == 0) ? true:false;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return CSVmatchUserLang;
    }

}
