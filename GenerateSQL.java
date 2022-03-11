/**@author James March */
//Small program used to generate SQL commands based off of an array
//Example code is what i used to create the tags db
//feel free to edit and use!

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;   // Import the FileWriter class

public class GenerateSQL{

    public Scanner keyboard = new Scanner(System.in);

    //this string denotes the table the SQL will be generated for
    private String table, file;
    private String[] values;

    public String getTable(){
        System.out.println("enter name of the table you want to use ");
        return keyboard.nextLine();
    }

    public String getFilename(){
        boolean validFile = false;
        String filename;
        do{
            System.out.println("Enter the name of the file you want to read: ");
            filename = "input/" + keyboard.nextLine();
            try {
                File myObj = new File(filename);
                Scanner file = new Scanner(myObj);
                file.close();
                validFile = true;
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        while(!validFile);
        keyboard.close();
        return filename;
    }

    public String[] getValues(){
        try{
            File txt = new File(file);
            Scanner fileOpen = new Scanner (txt);
            ArrayList<String> data = new ArrayList<String>();

            while(fileOpen.hasNextLine()){
                data.add(fileOpen.nextLine());
            }
            System.out.println(data);
            fileOpen.close();
            return data.toArray(new String[]{});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    /**
     * generate is used to generate the SQL commands itself line by line
     * @param values the array of values to insert into the table
     */
    public void generateSQL(){
        for (int i = 0; i < values.length; i++){
            String SQL = ("INSERT INTO " + table + " VALUES (" + (i+1) + ", \"" 
                + values[i] + "\");");
            values[i] = SQL;
            System.out.println(values[i]);
        }
    }

    public void outputToFile(){
        try{
            File output = new File("output/" + table + ".txt");
            FileWriter writer = new FileWriter(output);
            for(int i = 0; i < values.length; i++){
                writer.write(values[i] +"\n");
            }
            writer.close();
            System.out.println("Success");
                System.out.println("SQL ready commands can be found at " +
                    output.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void mainSequence(){
        this.table = getTable();
        this.file = getFilename();
        this.values = getValues();
        generateSQL();
        outputToFile();
    }
    public static void main(String[] args){    
        GenerateSQL test = new GenerateSQL();
        test.mainSequence();
    }
}