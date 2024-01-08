package com.tech.blog.helper;

import java.awt.print.Printable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {
	public static boolean deleteFile(String path) {
		boolean f = false;
		try {
			File file = new File(path);
			f = file.delete();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	public static boolean saveFile(InputStream is,String path) {
		boolean f=false;
		try {
			byte b[]=new byte[is.available()];
			is.read(b);
			FileOutputStream fs=new FileOutputStream(path);
			fs.write(b);
			fs.flush();
			fs.close();
			f=true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
///TechBlog/src/main/webapp/pics
}
