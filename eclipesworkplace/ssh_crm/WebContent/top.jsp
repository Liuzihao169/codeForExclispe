<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD id=Head1>
<TITLE>顶部</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	PADDING-RIGHT: 0px;
	PADDING-LEFT: 0px;
	PADDING-BOTTOM: 0px;
	MARGIN: 0px;
	PADDING-TOP: 0px;
	BACKGROUND-COLOR: #2a8dc8
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

TD {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

DIV {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

P {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}
</STYLE>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=10><IMG src="images/new_001.jpg" border=0></TD>
					<TD background=images/new_002.jpg><FONT size=5><B>客户关系管理系统v1.0</B></FONT></TD>
					<TD background=images/new_002.jpg>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD align=right height=35></TD>
								</TR>
								<c:if test="${empty user}">
										<TR>
									<TD height=35 align="right">
										当前用户：XXXX
										&nbsp;&nbsp;&nbsp;&nbsp;
										<A href="#" target=_top><FONT color=red>修改密码</FONT></A>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<A href="#" target=_top><FONT color=red>安全退出</FONT></A>
									</TD>
								</TR>
								</c:if>
								<c:if test="${!empty user}">
										<TR>
									<TD height=35 align="right">
										当前用户：${user.user_code }
										&nbsp;&nbsp;&nbsp;&nbsp;
										<A href="#" target=_top><FONT color=red>修改密码</FONT></A>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<A href="#" target=_top><FONT color=red>安全退出</FONT></A>
									</TD>
								</TR>								
								</c:if>
							
							</TBODY>
						</TABLE>
					</TD>
					<TD width=10><IMG src="images/new_003.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>