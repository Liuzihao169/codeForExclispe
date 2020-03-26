package day22.demo.Filelist;

import java.io.File;
import java.io.FileFilter;

public class Myfilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		
		return pathname.getName().endsWith(".java");
	}

}
