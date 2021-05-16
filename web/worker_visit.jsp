<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看文章</title>
    <script src="js/js3.js"></script>
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
        <form method="post" action="${pageContext.request.contextPath}/workerServlet?method=deleteComment">
            <table>
                <c:forEach items="${allComment}" var="com">
                    <tr>
                        <td>${com.userVirName}:${com.content}</td>
                        <td class="hidden"><input style="display: none" name="commentId" value="${com.commentId}"></td>
                        <td class="hidden"><input style="display: none" name="articleId" value="${article.articleId}"></td>
                        <td><input type="submit" name="delete" id="delete" value="删除"></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
    <div class="div_buttom">
        <a href="worker_home.jsp"><input type="button" name="bt_return" id="bt_return" value="返回"></a>
    </div>
</div>


</body>
</html>
