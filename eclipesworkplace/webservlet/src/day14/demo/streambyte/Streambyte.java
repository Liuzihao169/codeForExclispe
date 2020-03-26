package day14.demo.streambyte;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Streambyte extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            //图片的输入输出获得的是绝对路径
              String path=this.getServletContext().getRealPath("1.jpg");
            FileInputStream fis= new FileInputStream(path);
            ServletOutputStream out=response.getOutputStream();
            byte [] buff=new byte [1024];
            int len=0;
            while((len=fis.read(buff))!=0){
            	out.write(buff, 0, len);
            }
            fis.close();
            out.close();
            
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}