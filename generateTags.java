/**@author James March */
//Small program used to generate SQL commands based off of an array
//Example code is what i used to create the tags db
//feel free to edit and use!

public class generateTags{

    //this string denotes the table the SQL will be generated for
    private String table = "tags";

    //replace this array with whatever array you want to convert
    private String[] values = {
            "Accounting",
            "Aerospace Engineering",
            "Agriculture",
            "Anthropology",
            "Archaeology",
            "Architecture",
            "Art & Design",
            "Biology",
            "Business",
            "Chemical Engineering",
            "Chemistry",
            "Civil Engineering",
            "Classical Studies",
            "Computer Science",
            "Creative Arts",
            "Criminology",
            "Dentistry",
            "Economics",
            "Education",
            "Electrical and Electronic Engineering",
            "Engineering and Technology",
            "English",
            "Flim / Photography",
            "Finance",
            "Food Science",
            "Game Design",
            "Geography",
            "Geology",
            "History",
            "Hospitality",
            "Journalism",
            "Languages",
            "Law",
            "Marketing",
            "Materials Science",
            "Mathematics",
            "Mechanical Engineering",
            "Media Studies",
            "Medicine",
            "Midwifery",
            "Molecular Biology",
            "Music",
            "Nursing",
            "Optometry",
            "Paramedic Sciences",
            "Pharmacology & Toxicology",
            "Philosophy",
            "Physical Sciences",
            "Physiology",
            "Politics",
            "Psychology",
            "Publishing",
            "Radiography",
            "Social Studies",
            "Social Work",
            "Software Engineering",
            "Sport",
            "Teaching",
            "Theology",
            "Veterinary Science",
            "Zoology"};

    /**
     * generate is used to generate the SQL commands itself line by line
     * @param values the array of values to insert into the table
     */
    public void generate(String[] tags){
        for (int i = 1; i < tags.length+1; i++){
            System.out.println("INSERT INTO " + table + " VALUES (" + i + ", " 
                + tags[i-1] + ");");
        }
    }
    public static void main(String[] args){    
        generateTags test = new generateTags();
        test.generate(test.values);
    }
}