package automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipFile
{
	CsvReader verification = new CsvReader();
	String INPUT_ZIP_FILE;
    private static String OUTPUT_FOLDER = "<SPECIFY>";
    String OUTPUT_FILE;
    int numExtracts = 0;
    List<String> files = new ArrayList<String>();
 
	public UnZipFile(String inputfile)
	{
	   INPUT_ZIP_FILE = "<SPECIFY>"+inputfile;	
	   unZipIt(INPUT_ZIP_FILE, OUTPUT_FOLDER);
	}

    /**
     * Unzip it
     * @param zipFile input zip file
     * @param output zip file output folder
     */
    public void unZipIt(String zipFile, String outputFolder){

     byte[] buffer = new byte[1024];

     try{

    	//create output directory is not exists
    	File folder = new File(OUTPUT_FOLDER);
    	if(!folder.exists()){
    		folder.mkdir();
    	}

    	//get the zip file content
    	ZipInputStream zis =
    		new ZipInputStream(new FileInputStream(zipFile));
    	//get the zipped file list entry
    	ZipEntry ze = zis.getNextEntry();

    	while(ze!=null){

    	   String fileName = ze.getName();
           File newFile = new File(outputFolder + File.separator + fileName);

           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
           OUTPUT_FILE = "" + newFile.getAbsoluteFile();
           files.add(OUTPUT_FILE);
            //create all non exists folders
            //else FileNotFoundException for compressed folder
            new File(newFile.getParent()).mkdirs();

            FileOutputStream fos = new FileOutputStream(newFile);

            int len;
            while ((len = zis.read(buffer)) > 0) {
       		fos.write(buffer, 0, len);
            }

            fos.close();
            ze = zis.getNextEntry();
            numExtracts++;
    	}

        zis.closeEntry();
    	zis.close();

    	System.out.println("Done: numExtracts" + numExtracts);

    }catch(IOException ex){
       ex.printStackTrace();
    }
   }
    public boolean Verify(List<String> UserSelectLanguages)
    {
    	Log.Info("output file: " + OUTPUT_FILE);
    	boolean eachFileFlag = false;
    	//cant use constructor here if I want to verify CSV multiple times 
    	//need to change this to a method and loop throught it 
		for(String file: files)
		{	
			verification.setCSVReader(file);
			eachFileFlag = verification.ReadCSV(UserSelectLanguages);
		}
/*    	verification = new Multi_Lang_CSVReader(OUTPUT_FILE);
		return verification.ReadCSV(UserSelectLanguages);*/
		return eachFileFlag;
    }
}


