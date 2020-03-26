package com.xiaomi.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiaomi.entity.Cart;
import com.xiaomi.entity.Cartitem;
import com.xiaomi.entity.PageBean;
import com.xiaomi.entity.Product;
import com.xiaomi.service.ProductService;
import com.xiaomi.service.imp.ProductServiceImpl;


/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BasicServlet {
		private ProductService productService = new ProductServiceImpl();
	public void productlistbycid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentcount=12;
		int currentpage=0;
		String current=request.getParameter("currentpage");
		if(current==null||current.equals("")){
			currentpage=1;
		}else{
			currentpage=Integer.parseInt(current);
		}
		  PageBean pageBean=productService.getPageBean(currentpage, currentcount);
		 /* for(Product pro:list){
			  System.out.println(pro);
			  
		  }*/
		 
		  request.setAttribute("pageBean", pageBean);
		  request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}
	//商品详情的列表+利用session存储历史历史记录
		public void productinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String pid = request.getParameter("pid");
			String currentpage=request.getParameter("currentpage");
			request.setAttribute("currentpage", currentpage);
			Product product=productService.findProductInfo(pid);
			request.setAttribute("product", product);
		
			HttpSession session = request.getSession();
			/*
			 * 
			 * 
			 * 1.利用session域来存储那个pid 存在一个list集合当中
			 * 2.利用集合里面的pid判断是否存在，来进行操作3.
			 * 3.注意那个peoductlist集合是每次都new一个，不需要把其存在session中
			 *  */
			LinkedList<String>pidlist=( LinkedList<String>)session.getAttribute("pidlist");
			List<Product>historyproductlsit=new ArrayList<Product>();
			if(pidlist==null){
				pidlist=new LinkedList<String>();
				pidlist.add(pid);
				historyproductlsit.add(productService.findProductInfo(pid));
				session.setAttribute("pidlist", pidlist);
				}
			else{
				if(pidlist.contains(pid)){
					pidlist.remove(pid);
					pidlist.addFirst(pid);
					   for(int i=0;i<pidlist.size();i++){
						   historyproductlsit.add(productService.findProductInfo(pidlist.get(i)));
					   }
				}
				else{
					pidlist.addFirst(pid);
					  for(int i=0;i<pidlist.size();i++){
						   historyproductlsit.add(productService.findProductInfo(pidlist.get(i)));
					   }
				}
			}  session.setAttribute("historyproductlsit", historyproductlsit);
			   request.getRequestDispatcher("/product_info.jsp").forward(request, response);
		}
		
		//addProductToCart
		//添加商品数量去购物车
		public void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String pid=request.getParameter("pid");
		   String buyNum=request.getParameter("buyNum");
		   Product product = productService.findProductInfo(pid);
		   double totalsub=(product.getPrice())*(Integer.parseInt(buyNum));
		   Cartitem item=new Cartitem();
		   item.setProduct(product);
		   item.setBuyNum(Integer.parseInt(buyNum));
		   item.setTatalsub(totalsub);
		    HttpSession session = request.getSession();
		   Cart cart=(Cart) session.getAttribute("cart");
		   double newtotalsub=0.0;
		   if(cart==null){
			   cart=new Cart();         //第一次访问 没有cart对象 那么需要创建
		   } 
		   Map<String,Cartitem>cartmap=cart.getCartmap();
		   if(cartmap.containsKey(pid)){        //判断是否存在 ，如果存相同的商品 ，那么更改cartitem的buyNUm和totalsub的值
			    Cartitem cartitem=cartmap.get(pid);
			    //将原来的值取出来 加上现在的
			   int totalbuynum=cartitem.getBuyNum()+Integer.parseInt(buyNum);
			   cartitem.setBuyNum(totalbuynum);
			   //将小计加起来
			   double totalsamesub=cartitem.getTatalsub()+(product.getPrice())*(Integer.parseInt(buyNum));
			   cartitem.setTatalsub(totalsamesub);
			    newtotalsub =(product.getPrice())*(Integer.parseInt(buyNum));
			   cart.setCartmap(cartmap);
		   } else{
			   cartmap.put(pid, item);           //不存在那么久直接添加
			     cart.setCartmap(cartmap);
			     newtotalsub=(product.getPrice())*(Integer.parseInt(buyNum));
		   }
		     double total=cart.getTotal()+newtotalsub;
		     cart.setTotal(total);
		     session.setAttribute("cart", cart);
			/*   Map<String,Cartitem>cartmap=cart.getCartmap();
			   if(cartmap.containsKey(pid)){
				   cartitem=cartmap.get(pid);
				   int n=cartitem.getBuyNum()+Integer.parseInt(buyNum);
				   cartitem.setBuyNum(n);
				   double j=cartitem.getTatalsub()+(product.getShop_price())*(Integer.parseInt(buyNum));
				   cartitem.setTatalsub(j);
				   double k=cart.getTotal()+(product.getShop_price())*(Integer.parseInt(buyNum));
				   cart.setTotal(k);
				  session.setAttribute("cart", cart);
			   }
			   else{
				   cartmap=cart.getCartmap();
				   cartitem.setProduct(product);
				   cartitem.setBuyNum(Integer.parseInt(buyNum));
				   cartitem.setTatalsub(totalsub);
				   double count=cart.getTotal()+cartitem.getTatalsub();
				   cart.setTotal(count);
				   session.setAttribute("cart", cart);
			   }
		   }
		*/
		      response.sendRedirect(request.getContextPath()+"/cart.jsp");
		     }
		//删除购物项
		public  void delItemFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String pid=request.getParameter("pid");
			HttpSession session = request.getSession();
			//从域中拿到存储的cart对象
		    Cart cart= (Cart) session.getAttribute("cart");
		      Map<String,Cartitem>cartmap=cart.getCartmap();
		      cart.setTotal(cart.getTotal()-cartmap.get(pid).getTatalsub());
		      cartmap.remove(pid);
		      cart.setCartmap(cartmap);
		      session.setAttribute("cart", cart); 
		      response.sendRedirect(request.getContextPath()+"/cart.jsp");
		}
}
