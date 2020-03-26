package day22.demo.recurison;

import java.io.File;
import java.io.FileFilter;

public class Myfilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		if(pathname.isDirectory())
			return true;
		
		return pathname.getName().endsWith(".java");
	}

}
