package com.lockedme;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		FileService service = new FileService();
		int ch;
		String fn;
		Scanner sc = new Scanner(System.in);
		loop1 : do {
			System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\tLockedme.com");
			System.out.println("\t\t\t\t\t\t\t\t\t\tDeveloped by : Abhishek Singh\n\n\n");
			System.out.println("\n\n\t\tUSER MENU\n\n");
			System.out.println("1.Display all the files in the directory");
			System.out.println("2.File manipulation operations");
			System.out.println("3.Exit");
			System.out.println("enter the choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				service.getFiles();
				break;
			case 2:
				int ch1;
				loop : do {
					
					System.out.println("1.Add a file to the directory");
					System.out.println("2.Delete a file from the directory");
					System.out.println("3.Search for a file in the directory");
					System.out.println("4.Return to the previous menu");
					System.out.println("Enter your choice : ");
					ch1=sc.nextInt();
					switch (ch1) {
					case 1:
						System.out.println("Enter the name of the file to be added : ");
						fn=sc.next();
						service.addFile(fn);
						break;
					case 2:
						boolean x=false;
						System.out.println("Enter the name of the file to be deleted : ");
						fn=sc.next();
						
						x=service.deleteFile(fn);
						if(x)
							System.out.println("File "+fn+" has been deleted");
						else
							System.out.println("File "+fn+" could not be found in the directory");
						break;
					case 3:
						boolean y=false;
						System.out.println("Enter the name of the file which you want to find : ");
						fn=sc.next();
						y=service.search(fn);
						if(y)
							System.out.println("File "+fn+" exists in the directory");
						else
							System.out.println("File "+fn+" doesn't exist in the directory");
						break;
					case 4:
						break loop;

					default:
						break;
					}
					
				}while(ch!=4);
				break;				
			case 3:
				break loop1;
			}
		} while (ch < 5);
	}

}
