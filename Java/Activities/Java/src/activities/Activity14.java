package activities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		String filePath = "newfile.txt";
		boolean fstatus = false;
		File file = new File(filePath);
		if (!file.exists()) {   // checks whether the file is Exist or not
			file.createNewFile();   // here if file not exist new file created 
			fstatus = true;
		}

		if(fstatus)
		{
			System.out.println("File has been created successfully.");
		}
		else
		{
			System.out.println("File alreay exists.");
		}		

		String sentence = "This sentence will be written in the file";

		// Create a File Write object
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);

		// Write the sentence in the file.
		bw.write(sentence);
		bw.close();

		// Read the sentence from the file and print on the console.
		BufferedReader br = Files.newBufferedReader(Paths.get(filePath));
		System.out.println("The file contains text: "+br.readLine());

		//get the file Object
		File fileUtil = FileUtils.getFile(filePath);
		//Read file
		System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

		// Create Directory.
		File dir = new File("resources");

		// Copy files to the directory
		FileUtils.copyFileToDirectory(file, dir);

		//Get file from new directory
		File newFile = FileUtils.getFile(dir, "newfile.txt");

		// Read from the file.
		String newData = FileUtils.readFileToString(newFile, "UTF8");
		
		// Print data on console.
		System.out.println("Data from new file :"+newData);
		
	}

}
