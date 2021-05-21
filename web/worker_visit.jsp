<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <title>查看文章</title>
    <script src="js/js3.js"></script>
    <script src="js/jquery.js" ></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        .message{
            width: 500px;
            margin-right: auto;
            margin-left: auto;
        }

        .title{
            width: 200px;
            margin-left: auto;
            margin-right: auto;
        }

        .div_buttom{
            width: 100px;
            margin-left: auto;
            margin-right: auto;
        }
        .div_allComment{
            width: 500px;
            margin-right: auto;
            margin-left: auto;
        }
        .hidden{
            width: 1px;
        }


    </style>
</head>
<body>
<div class="layout">
    <div class="message">
        <h2 class="title">${article.title}</h2>
        <br>
        <p>${article.contentText}</p>
    </div>
    <hr/>
    <div class="div_allComment">
            <table>
                <c:forEach items="${allComment}" var="com">
                    <tr>
                        <td>${com.userVirName}:${com.content}<a href="${pageContext.request.contextPath}/workerServlet?commentId=${com.commentId}&articleId=${article.articleId}&method=deleteComment"><input class="btn btn-default" type="button" name="delete" id="delete" value="删除"></a></td>
                    </tr>
                </c:forEach>
            </table>
    </div>
    <div class="div_buttom">
        <a href="worker_home.jsp"><input class="btn btn-default" type="button" name="bt_return" id="bt_return" value="返回"></a>
    </div>
</div>


</body>
</html>
