<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <title>健康有你</title>
  <script src="js/js3.js"></script>
  <style>
    .ho_left{
      float: left;
    }
    .ho_right{
      float: left;
      padding-left: 50px;
      box-sizing: border-box;
    }
    .active{
      padding-top: 30px;
    }

    #search{
      width: 1200px;
      height: 30px;
      margin-top: 25px;
    }
    #btn_search{
      margin-top: 25px;
    }
  </style>
</head>
<body>
<div class="ho_layout">
  <div class = "ho_left">
      <table class="table table-striped">
        <tr>
          <td><label>${user.virName}</label></td>
        </tr>
        <tr>
           <td class="success"><a href="${pageContext.request.contextPath}/userServlet?method=visitLikes&account=${user.account}&userId=${user.userId}"><input class="btn btn-default" type="button" name="liked" id="liked" value="赞过"></a></td>
        </tr>
        </tr>
          <td class="success"><a href="${pageContext.request.contextPath}/userServlet?method=visitCollection&account=${user.account}&userId=${user.userId}"><input class="btn btn-default" type="button" name="collected" id="collected" value="收藏"></a></td>
        </tr>
      </table>
  </div>
  <div class="ho_right">
      <table>
        <div class="changePic">
          <img id="img" src="image/pic1.jpg" width="100%" height="225px">
        </div>
      </table>
    <table>
        <form method="post" action="${pageContext.request.contextPath}/userServlet?rows=5&method=search">
        <tr>
          <td class="hidden"><input style="display: none" name="account" value="${user.account}"></td>
          <td><input class="form-control" type="text" name="search" id="search" placeholder="请输入关键词搜索"></td>
          <td><input class="btn btn-default" type="submit" name="btn_search" id="btn_search" value="搜索"></td>
        </tr>
        </form>
    </table>
    <table class="table table-striped">
        <c:forEach items="${pb.list}" var="m">
            <tr>
              <td class="active"><a href="${pageContext.request.contextPath}/userServlet?text=${m.contentText}&articleId=${m.articleId}&workerId=${m.workerId}&visNum=${m.visNum}&picture=${m.contentPicture}&likesNum=${m.likesNum}&collectionNum=${m.collectionNum}&title=${m.title}&userId=${user.userId}&method=visitArticle">${m.title}</a></td>
                <td class="info"> 点赞数:${m.likesNum} </td>
                <td class="info">收藏数:${m.collectionNum}</td>
            </tr>
        </c:forEach>
    </table>

      <nav aria-label="Page navigation">
          <ul class="pagination">
              <c:forEach begin="1" end="${pb.totalPage}" var="i">
                  <li><a href="${pageContext.request.contextPath}/userServlet?currentPage=${i}&rows=5&account=${user.account}&lg_type=user&password=${user.password}&method=${method}&text=${text}">${i}</a></li>
              </c:forEach>
          </ul>
      </nav>
      <span>共计${pb.totalCount}条记录</span>
  </div>
</div>

<script>//轮播图
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

<script src="js/jquery.js" ></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
