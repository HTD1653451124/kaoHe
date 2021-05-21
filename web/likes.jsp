<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <title> </title>
    <script src="js/js3.js"></script>
    <script src="js/jquery.js" ></script>
    <script src="js/bootstrap.min.js"></script>
    <style>

        .ho_top{
            width: 1200px;
            margin-left: auto;
            margin-right: auto;
        }
        .ho_middle{
            width: 300px;
            margin-right: auto;
            margin-left: auto;
        }
    </style>
</head>
<body>

<div class="ho_layout">

    <div class="ho_top">
        <div class="changePic">
            <img id="img" src="image/pic1.jpg" width="100%" height="235px">
        </div>
    </div>
    <div class = "ho_middle">
        <table class="table table-striped">
            <c:forEach items="${articles}" var="m">
                <tr>
                    <td class="success"><a href="${pageContext.request.contextPath}/userServlet?text=${m.contentText}&articleId=${m.articleId}&workerId=${m.workerId}&visNum=${m.visNum}&picture=${m.contentPicture}&likesNum=${m.likesNum}&collectionNum=${m.collectionNum}&title=${m.title}&userId=${user.userId}&method=visitArticle">${m.title}</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td class="success"><a href="home.jsp"><input class="btn btn-default" type="button" class="btn btn-default" value="返回"></a></td>
            </tr>

        </table>


    </div>

</div>
<script>
    var  num = 1;
    function changePic(){
        num++;
        if (num>3){
            num = 1;
        }
        var pic = document.getElementById("img");
        pic.src = "image/pic"+num+".jpg";
    }
    setInterval(changePic,3000);
</script>
</body>
</html>
