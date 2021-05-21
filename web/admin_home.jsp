<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <script src="js/jquery.js" ></script>
    <script src="js/bootstrap.min.js"></script>
    <title>管理员</title>
    <style>
        .layout{
            width: 900px;
            margin-left: auto;
            margin-right: auto;
        }
        .left{
            width: 200px;
            float: left;
            font-size: 40px;
            margin-left: auto;
            margin-right: auto;
        }
        .right{
            width: 400px;
            font-size: 40px;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>

<div>
    <a href="${pageContext.request.contextPath}/addType.jsp"><input class="btn btn-block" type="button" name="add" id="add" value="添加新分类"></a>
</div>
<div class="layout">
<div class="left">
    <table class="table table-striped">
        <c:forEach items="${types}" var="t">
            <tr>
                <td class="active" style="font-size: 50px">${t.type}</td>
            </tr>
        </c:forEach>


    </table>

</div>
<div class="right">
    <table class="table table-striped">
        <c:forEach items="${sum}" var="s" varStatus="i">
            <tr>
                <td class="active" style="font-size: 50px">浏览量:${s.value}</td>
                <td class="success"><a href="${pageContext.request.contextPath}/adminServlet?typeId=${s.key}&method=deleteType"> <input class="btn btn-default" type="button"   value="删除"></a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</div>
<script>

</script>

</body>
</html>
