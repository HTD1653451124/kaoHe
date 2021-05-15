<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
        <form>
            <table>
                <c:forEach items="${allComment}" var="com">
                    <tr>
                        <td>${com.user_virName}:${com.content}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
    <div class="div_buttom">
        <a href="tourist.jsp"><input type="button" name="bt_return" id="bt_return" value="返回"></a>
    </div>
</div>

</body>
</html>
