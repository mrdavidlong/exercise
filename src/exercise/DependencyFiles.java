package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;


public class DependencyFiles {
	  public static void main(String[] args) throws IOException {
		  writeSampleFiles();
		  HashSet<String> links = new HashSet<String>();
		  printDependencies("application.js", links);
	  }
	    
	  public static void printDependencies(String filePath, HashSet<String> links) {
	    BufferedReader br = null;
	    String requireSytax = "//= require ";
	    int requireSyntaxLength = requireSytax.length();
	    String sCurrentLine;
	    try {      
	      br = new BufferedReader(new FileReader(filePath));

	      while ((sCurrentLine = br.readLine()) != null) {
	        int requireStartIndex = sCurrentLine.indexOf(requireSytax);
	        if (requireStartIndex >= 0) {
	          String dependentFilePath = sCurrentLine.substring(requireSyntaxLength, sCurrentLine.length());
	          if (links.contains(dependentFilePath) == false) {
	            links.add(dependentFilePath);
	            printDependencies(dependentFilePath, links);
	            System.out.println(dependentFilePath);
	          }
	        }
	      }
	    }
	    catch (IOException e) {
			e.printStackTrace();
		}
	    finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	    if (links.contains(filePath) == false) {
	        links.add(filePath);
	        System.out.println(filePath);
	    }
	  }
	  
	  public static void writeSampleFiles() throws IOException {
	      writeFile("application.js", "//= require ui/login_form.js\n\nnew LoginForm().append();\n");
		  new File("ui").mkdirs();
		  writeFile("ui/login_form.js", "//= require ui/password_field.js\n//= require ui/text_field.js\n\nvar LoginForm = function(){};\nLoginForm.prototype.append = function() {\n    this.usernameField = new TextField();\n    this.passwordField = new PasswordField();\n\n    // �\n};\n");
		  writeFile("ui/password_field.js", "//= require ui/text_field.js\n\nvar PasswordField = function(){};\nPasswordField.prototype = new TextField();\n");
		  writeFile("ui/text_field.js", "var TextField = function(){};");
	  }
	  
	  public static void writeFile(String path, String content) throws IOException {
	    FileWriter writer = new FileWriter(new File(path));
	    writer.write(content);
	    writer.close();
	  }
	}

	/*

	## application.js

	//= require ui/login_form.js

	new LoginForm().append();


	## ui/login_form.js
	//= require ui/password_field.js
	//= require ui/text_field.js

	var LoginForm = function(){};
	LoginForm.prototype.append = function() {
	    this.usernameField = new TextField();
	    this.passwordField = new PasswordField();

	    // �
	};


	## ui/password_field.js
	//= require ui/text_field.js

	var PasswordField = function(){};
	PasswordField.prototype = new TextField();

	## ui/text_field.js
	var TextField = function(){};

	output:
	ui/text_field.js
	ui/password_field.js
	ui/login_form.js
	application.js


	*/