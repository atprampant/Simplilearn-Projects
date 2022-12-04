package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileService {
	MyFile myfile=new MyFile();
	List<MyFile> files=new ArrayList<>();
	public List<MyFile> saveNames()			//Method to save list of files in the directory into an array list
	{
		File f=new File("E://Lockedme.com");
		String[] list=f.list();
		for(String name:list)
			files.add(new MyFile(name));
		return files;
	}
	
	public void getFiles()					//Method to display files in the directory in an ascending order
	{
		File f=new File("e://Lockedme.com");
		String[] fs=f.list();
		Arrays.sort(fs);
		for(String file:fs)
		{
			System.out.println(file);
		}
	}
	public void addFile(String fileName) throws IOException {		//Method to add a new file to the directory
		File f=new File("E://Lockedme.com//"+fileName+".txt");
		f.createNewFile();		
	}
	public boolean deleteFile(String fileName)   //Method to delete a specific file
	{
		String fn;
		String fnwd;		//for getting filename without the file extension
		boolean isDeleted=false;
		files=saveNames();
		for(MyFile file:files)
		{
			fn=file.getFileName();
			fnwd=fn.split("\\.")[0];	//Splitting the file name from the file extension using split on "."
			if(fileName.equals(fnwd))
			{
				File fl=new File("E:\\Lockedme.com\\"+file.getFileName());
				fl.delete();
				isDeleted=true;
			}				
		}
		return isDeleted;
	}
	public boolean search(String fileName)    //Method to search for a specific file
	{	String fn,fnwd;
		boolean isFound=false;
		files=saveNames();
		for(MyFile file:files)
		{
			fn=file.getFileName();
			fnwd=fn.split("\\.")[0];
			if(fileName.equals(fnwd))
			{
				File fl=new File("E:\\Lockedme.com\\"+file.getFileName());
				if(fl.exists())
					isFound=true;
			}	
		}
		return isFound;
	}
	
}
