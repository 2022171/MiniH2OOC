/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minih2ooc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author danie
 */
public class MiniH2OOC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
   
List<String> data = new ArrayList<>();// creating an array to store all the data in the document

int groups = 20; // creating the variable with the number of groups
int groupSize = 5; // variable with the size of each group which is 5 people per group


Random r = new Random(); // This is the object to randomize the group name
String[] teamNames = {"Brazil", "Ireland", "England", "Scotland", "France"}; // creating an array to define the team names that I've chosen

try {
    BufferedReader myFile = new BufferedReader(new FileReader("MOCK_DATA.csv")); // importing the the buffered reader to read all the data from the file
    String line;

    while ((line = myFile.readLine()) != null) { // reading each line of the document
        data.add(line);// add each line to the collection created above

        if (data.size() == groupSize * groups) { // this section i have to check wether i will be able to create the number of groups with the right number of people
            
            for (int i = 1; i < groups; i++) { // looping through the groups
               
                List<String> group = new ArrayList<>();// creating a collection for the groups

                 Collections.shuffle(data); // to shuffle all the data 
                for (int j = 0; j < groupSize; j++) {//// Populate the group with members by removing them from the data list
                    group.add(data.remove(0));
                }

                // Randomly select a team name for the group from the teamNames array
                String randomGroupNames = teamNames[r.nextInt(teamNames.length)];

                // Print the group number, the random team name, and the group members
                System.out.println("Group " + (i + 1) + " (" + randomGroupNames + "): " + group);
            }
        }
    }
} catch (IOException e) {
    // Handle IOException if it occurs (e.g., file not found or error reading the file)
}

}
}