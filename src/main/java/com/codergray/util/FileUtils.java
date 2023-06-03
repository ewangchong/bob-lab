package com.codergray.util;

import java.io.File;
import java.io.FilenameFilter;

public class FileUtils {

	public static void main(String[] args) {
		File cRoot = new File("D:\\my documents\\项目文档\\DIFF");
		
		File[] fArray = cRoot.listFiles(new FileExtensionFilter("diff"));
		
		for(File f: fArray){
			System.out.println(f.getName());
		}
	}	
}

class FileExtensionFilter implements FilenameFilter
{
	private String extension;
	
	public FileExtensionFilter(String extension)
	{
		this.extension = extension;
	}
	
	public boolean accept(File dir, String name)
	{
		return name.endsWith(extension);
	}
}
