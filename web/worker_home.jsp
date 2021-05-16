<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <script src="js/js3.js"></script>
    <style>
        .layout{

        }
        .div_left{
            width: 50px;

        }
        .div_right{
            width: 1000px;
            margin-left: auto;
            margin-right: auto;

        }
        .td_0{
            width: 1px;
        }
        .td_1{
            width:30% ;
        }
        .td_2{
            width: 20%;
        }
        .td_4{
            width: 10%;
        }
        .td_5{
            width: 10%;
        }
        .td_6{
            width: 10%;
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
                <td><a href="/CAT_war_exploded/typesServlet"><input type="button" id="publish" value="发布文章"></a></td>
            </tr>

        </table>
    </div>
    <div class="div_right">
        <form>
            <table class="table table-striped">
                <c:forEach items="${personArticle}" var="p" varStatus="s">
                    <tr>
                        <td class="td_1">${p.title}</td>
                        <td class="td_2">浏览量:${p.visNum}</td>
                        <td class="td_4">点赞数:${p.likesNum}</td>
                        <td class="td_5">收藏数:${p.collectionNum}</td>
                        <td class="td_6"><a href="/CAT_war_exploded/visitArticle?text=${p.contentText}&articleId=${p.articleId}&workerId=${p.workerId}&visNum=${p.visNum}&picture=${p.contentPicture}&likesNum=${p.likesNum}&collectionNum=${p.collectionNum}&title=${p.title}&type=worker"><input type="button" value="查看内容"></a></td>
                        <td><a href="/CAT_war_exploded/deleteServlet?articleId=${p.articleId}&account=${workerMsg.account}"><input type="button" value="删除"></a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</div>
</body>
</html>