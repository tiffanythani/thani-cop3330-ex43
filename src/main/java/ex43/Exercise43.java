/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tiffany Thani
 */
package ex43;
import java.io.*;
import java.util.Scanner;


public class Exercise43
{
    public static void main(String[] args)
    {
        //the variables store the intermediate and required data
        //also creating a scanner object to input data from the user
        Scanner scan = new Scanner(System.in);
        String currentPath, author, siteName;
        char javaScript = 'N';
        char CSS = 'N';
        //asks user to type the website name
        System.out.print("Site name: ");
        siteName = scan.nextLine();
        //asks user to type author name
        System.out.print("Author: ");
        author = scan.nextLine();
        //asks user if they want a javascript folder
        System.out.print("Do you want a folder for JavaScript? ");
        javaScript = scan.next().charAt(0);
        //asks user if they want a css folder
        System.out.print("Do you want a folder for CSS? ");
        CSS = scan.next().charAt(0);
        //gets the current directory to make the website folder in that directory
        currentPath = System.getProperty("user.dir");
        currentPath += "\\"+siteName;
        //creates a file object with the currentPath
        File website = new File(currentPath);
        //makes the website for entered website name
        boolean websiteCreated = website.mkdir();
        if(websiteCreated)
        {
            System.out.println("Created " + currentPath);
            try
            {
                FileWriter skeletonWriter = new FileWriter(new File(currentPath+"\\index.html"));
                skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                skeletonWriter.write("\t<meta author=\""+author+"\">\n");
                skeletonWriter.write("\t<title>"+siteName+"</title>\n");
                skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");
                skeletonWriter.close();
                System.out.println("Created " + currentPath+"\\index.html");
                if(javaScript == 'y' || javaScript == 'Y')
                {
                    File javaScriptFolder = new File(currentPath+"\\js");
                    boolean javaScriptCreated = javaScriptFolder.mkdir();
                    //if javascript folder is created then the success message will be printed
                    if(javaScriptCreated)
                        {
                        System.out.println("Created " + javaScriptFolder+"\\");
                        }
                    else
                        {
                        System.out.println("Js folder not created!!");
                        }
                }

                //checks if the user wants a CSS folder
                if(CSS == 'y' || CSS == 'Y')
                {
                    File cssFolder = new File(currentPath+"\\css");
                    boolean cssCreated = cssFolder.mkdir();
                    if(cssCreated)
                        {
                        System.out.println("Created " + cssFolder+"\\");
                        }
                    else
                        {
                        System.out.println("CSS folder not created!!");
                        }
                }
            }
            catch(IOException e)
                {
                System.out.println("index.html not created as required!!");
                }
        }
        else
            {
            System.out.println("The website folder has not been created!!");
            }
        scan.close();
    }
}