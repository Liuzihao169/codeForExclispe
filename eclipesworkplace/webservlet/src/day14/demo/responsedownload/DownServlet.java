package day14.demo.responsedownload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.
	     	  String filename=request.getParameter("filename");
	     	  //告诉客户端这是什么类型发文件 
		      response.setContentType(this.getServletContext().getMimeType(filename));
		      //告诉客户端不要解析 以文件的形式打开
		      response.setHeader("Content-Disposition", "attachment;filename="+filename );
		      String path=this.getServletContext().getRealPath("download/"+filename);
		      InputStream inp=new FileInputStream(path);
		      //自动会往浏览器中写数据
		      ServletOutputStream out=response.getOutputStream();
		      int len=0;
 	   	             byte [] buff=new byte[1024];
		      while((len=inp.read(buff))!=-1){
		    	  out.write(buff,0,len);
		      }
		      inp.close();
		      
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}