package com.lockedme;

public class MyFile implements Comparable<MyFile>{
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MyFile(String fileName) {
		super();
		this.fileName = fileName;
	}
	public MyFile() {
	
	}

	@Override
	public int compareTo(MyFile f) {
		
		 if (this.fileName.compareTo(f.fileName) != 0) {
	            return this.fileName.compareTo(f.fileName);
	        }
		 else
			 return 0;
	}

}
