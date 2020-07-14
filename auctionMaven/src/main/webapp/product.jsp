<%@ page import="club.banyuan.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
    <form action="product.do" method="post">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>
    <div class="forms">
        <label for="name">名称</label>
        <input name="" type="text" class="nwinput" id="name"/>
        <label for="names">描述</label>
        <input name="" type="text" id="names" class="nwinput"/>
        <label for="time">开始时间</label>
        <input name="" type="text" id="time" class="nwinput"/>
        <label for="end-time">结束时间</label>
        <input name="" type="text" id="end-time" class="nwinput" />
        <label for="price">起拍价</label>
        <input name="" type="text" id="price" class="nwinput" />
        <a href="select.jsp"><input name="" type="button"  value="查询" class="spbg buttombg f14  sale-buttom"/></a>
    </div>
    <div class="items">
        <ul class="rows even strong">
            <li>名称</li>
            <li class="list-wd">描述</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno">操作</li>
        </ul>

        <%
            List<Product> list = (List<Product>)session.getAttribute("list");
            for (Product product : list) {
                out.print("<ul class=\"rows\">\n" +
                        "            <li><a href=\"国书\" title=\"\">"+product.getProductName()+"</a></li>\n" +
                        "            <li class=\"list-wd\">"+product.getDescription()+"</li>\n" +
                        "            <li>"+product.getStartTime()+"</li>\n" +
                        "            <li>"+product.getEndTime()+"</li>\n" +
                        "            <li>"+product.getStartPrice()+"</li>\n" +
                        "            <li class=\"borderno red\"><a href=\"#\">"+product.getOperate()+"</a></li>\n" +
                        "        </ul>");
            }
        %>

        <div class="page">
            <a href="#" title="">首页</a>
            <a href="#" title="">上一页</a>
            <span class="red">前5页</span>
            <a href="#" title="">1</a>
            <a href="#" title="">2</a>
            <a href="#" title="">3</a>
            <a href="#" title="">4</a>
            <a href="#" title="">5</a>
            <a href="#" title="">下一页</a>
            <a href="#" title="">尾页</a>
        </div>
    </div>
    <!-- main end-->
    </form>
</div>
</body>
</html>
