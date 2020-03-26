package com.xiaomi.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.xiaomi.entity.PageBean;
import com.xiaomi.entity.Product;
import com.xiaomi.service.AdminService;
import com.xiaomi.service.imp.AdminServiceImpl;
import com.xiaomi.utils.CommentUtils;



/**
 */
public class AdminServlet extends BasicServlet {
	//查询所有的productlist商品的详细信息
	private AdminService adminService=new AdminServiceImpl();
	public  void findAllproductlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/*AdminService service = new AdminService();
		List<Product>productlist=service.findAllproductlist();
		request.setAttribute("productlist", productlist);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);*/
		String currentpage=request.getParameter("currentpage");
		int currentpage1=0;
		if(currentpage==null||"".equals(currentpage)){
			currentpage1=1;
		}
		else{
			currentpage1=Integer.parseInt(currentpage);
		}
		int currentcount=7;
		request.setAttribute("currentpage",currentpage1);
		
		PageBean pagebean=adminService.getPagebean( currentpage1, currentcount);
		//System.out.println(pagebean);
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}
	//添加商品的功能
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //接受文件上传的多表单
		//创建磁盘文件项工厂
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//创建磁盘核心类
		ServletFileUpload upload=new ServletFileUpload(factory);
		//设置上传编码
		upload.setHeaderEncoding("UTF-8");
		try {
			//解析request
			List<FileItem>fileitem=upload.parseRequest(request);
			Product product=new Product();
			Map<String,Object>map=new HashMap<String,Object>();
			for(FileItem item:fileitem){
				boolean formField = item.isFormField();//判断是否是普通文件
				if(formField){
					//是普通文件
					String filename=item.getFieldName();
					String filenamevalue=item.getString("UTF-8");
					map.put(filename, filenamevalue);
				}else{
					//不是普通文件
		        	String filedname=item.getName();
					InputStream in=item.getInputStream();
					String path=this.getServletContext().getRealPath("/load");
					//此时filedname是包括后缀名的 确保名字不唯一
					String pimageName=CommentUtils.getUuid()+filedname;
					OutputStream out=new FileOutputStream(path+"//"+ pimageName);
					//文件名字
					map.put("pimage", "load/"+pimageName);
					IOUtils.copyLarge(in, out);
					out.close();
					in.close();
					//删除临时文件
					item.delete();
				}
			}
			try {
				BeanUtils.populate(product, map);
				product.setPid(CommentUtils.getUuid());
				adminService.addproduct(product);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//转发到list页面
		response.sendRedirect(request.getContextPath()+"/admin?method=findAllproductlist");
	}
	public void delProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String pid=request.getParameter("pid");
			adminService.delProduct(pid);
			//删除成功后 返回要返回list页  重定向到 
			response.sendRedirect(request.getContextPath()+"/admin?method=findAllproductlist");
	}
	//执行更新操作的时候进行数据回显
	public void updateProductUi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得前台要更新的 productId
		String pid = request.getParameter("pid");
		Product product = adminService.updateProductUI(pid);
		//将product存在request域当中 然后转发到edit页面
		request.setAttribute("product", product);
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}
	//更新商品
	public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //接受文件上传的多表单
		//创建磁盘文件项工厂
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//创建磁盘核心类
		ServletFileUpload upload=new ServletFileUpload(factory);
		//设置上传编码
		upload.setHeaderEncoding("UTF-8");
		try {
			//解析request
			List<FileItem>fileitem=upload.parseRequest(request);
			Product product=new Product();
			Map<String,Object>map=new HashMap<String,Object>();
			for(FileItem item:fileitem){
				boolean formField = item.isFormField();//判断是否是普通文件
				if(formField){
					//是普通文件
					String filename=item.getFieldName();
					String filenamevalue=item.getString("UTF-8");
					map.put(filename, filenamevalue);
				}else{
					//不是普通文件
		        	String filedname=item.getName();
					InputStream in=item.getInputStream();
					String path=this.getServletContext().getRealPath("/load");
					//此时filedname是包括后缀名的 确保名字不唯一
					String pimageName=CommentUtils.getUuid()+filedname;
					OutputStream out=new FileOutputStream(path+"//"+ pimageName);
					//文件名字
					map.put("pimage", "load/"+pimageName);
					IOUtils.copyLarge(in, out);
					out.close();
					in.close();
					//删除临时文件
					item.delete();
				}
			}
			try {
				BeanUtils.populate(product, map);
				adminService.updateProduct(product);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//转发到list页面
		response.sendRedirect(request.getContextPath()+"/admin?method=findAllproductlist");
	}
	}

	
