package ce204_hw3_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompileAndRun {

	
	public void file_create(String class_name, String text_area, String codeLanguage_Extention) {
	    try {
	      File myObj = new File(class_name + codeLanguage_Extention);
	      FileWriter myWriter = new FileWriter(class_name + codeLanguage_Extention);
	      myWriter.write(text_area);
	      myWriter.close();
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	
	public void compiler(String class_name, String codeLanguage_Extention) {
		   
        ProcessBuilder processBuilder = new ProcessBuilder();
        System.out.println(System.getProperty("user.dir"));
        
        if (codeLanguage_Extention == ".java") {
        	processBuilder.command("cmd.exe", "/c", "javac "+ class_name + codeLanguage_Extention);
		}
		
		else if (codeLanguage_Extention == ".cpp") {
			processBuilder.command("cmd.exe", "/c", "g++ "+ class_name + codeLanguage_Extention + " -o " + class_name);
		}
		
		else if (codeLanguage_Extention == ".cs") {
			processBuilder.command("cmd.exe", "/c", "csc "+ class_name + codeLanguage_Extention);
			System.out.println("çalıştı");
		}	
        

        try {

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
	
	 public void runner(String class_name, String codeExtention_String) {
			Runtime rt = Runtime.getRuntime();
		    try {
		    	
		    	if (codeExtention_String == ".java") {
		    		rt.exec("cmd.exe /c start cmd.exe /k \"java "+ class_name);
				}
				
				else if (codeExtention_String == ".cpp") {
					rt.exec("cmd.exe /c start cmd.exe /k \"" + class_name + ".exe");
				}
				
				else if (codeExtention_String == ".cs") {
					rt.exec("cmd.exe /c start cmd.exe /k \"" + class_name + ".exe");
				}	
		    	

		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}
	
	
}
