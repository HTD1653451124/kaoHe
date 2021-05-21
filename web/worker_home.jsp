<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <title>workerHome </title>
    <script src="js/js3.js"></script>
    <script src="js/jquery.js" ></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        .layout{
            width: 100%;
            height: 100%;
        }
        .div_left{
            width: 5%;
            float: left;
        }
        .div_right{
            width: 90%;
            height: 100%;
            float: left;
        }
        .changePic{
            width: 100%;
            margin-top: 1px;
        }
    </style>

</head>
<body>

<div class="layout">
    <div class="div_left">
        <table>
            <tr>
                <td><h4>${workerMsg.virName},您好！</h4></td>
            </tr>
            <tr>
                <td><a href="${pageContext.request.contextPath}/workerServlet?method=getAllTypes"><input type="button" id="publish" value="发布文章"></a></td>
            </tr>
        </table>
    </div>
    <div class="div_right">
        <div class="changePic">
            <img id="img" src="image/pic1.jpg" width="100%" height="235px">
        </div>
        <form>
            <table class="table table-striped">
                <c:forEach items="${personArticle}" var="p" varStatus="s">
                    <tr>
                        <td class="active">${p.title}</td>
                        <td class="active">浏览量:${p.visNum}</td>
                        <td class="active">点赞数:${p.likesNum}</td>
                        <td class="active">收藏数:${p.collectionNum}</td>
                        <td class="info"><a href="${pageContext.request.contextPath}/userServlet?text=${p.contentText}&articleId=${p.articleId}&workerId=${p.workerId}&visNum=${p.visNum}&picture=${p.contentPicture}&likesNum=${p.likesNum}&collectionNum=${p.collectionNum}&title=${p.title}&virName=${workerMsg.virName}&type=worker&method=visitArticle"><input type="button" value="查看内容"></a></td>
                        <td class="success"><a href="${pageContext.request.contextPath}/workerServlet?articleId=${p.articleId}&account=${workerMsg.account}&method=deleteArticle"><input type="button" value="删除"></a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
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