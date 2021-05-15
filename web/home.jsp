<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
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
    .td_right{
      padding-top: 50px;
    }

    #search{
      width: 1200px;
      height: 30px;
    }
  </style>
</head>
<body>
<div class="ho_layout">
  <div class = "ho_left">
    <form action="#" method="post">
      <table>
        <tr>
          <td><label>${user.virName}</label></td>
        </tr>
        <tr>
          <td><input type="button" name="likes" id="likes" value="赞过"></td>
        </tr>
        <tr>
          <td><input type="button" name="collection" id="collection" value="收藏"></td>
        </tr>
      </table>
    </form>
  </div>
  <div class="ho_right">

      <table>
        <div class="changePic">
          <img id="img" src="image/pic1.jpg" width="100%" height="235px">
        </div>
      </table>
    <table>
        <form method="post" action="/CAT_war_exploded/search">
        <tr>
          <td class="hidden"><input style="display: none" name="account" value="${user.account}"></td>
          <td><input type="text" name="search" id="search" placeholder="请输入关键词搜索"></td>
          <td><input type="submit" name="btn_search" value="搜索"></td>
        </tr>
        </form>
    </table>
    <table>
        <c:forEach items="${articles}" var="m">
        <tr>
          <td class="td_right"><a href="/CAT_war_exploded/visitArticle?text=${m.contentText}&article_id=${m.article_id}&worker_id=${m.worker_id}&visNum=${m.visNum}&picture=${m.contentPicture}&likes_num=${m.likes_num}&collection_num=${m.collection_num}&title=${m.title}&user_id=${user.user_id}">${m.title}</a> 点赞数:${m.likes_num} 收藏数:${m.collection_num}</td>
        </tr>
        </c:forEach>
    </table>

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


  // var likesId = document.getElementById("likes");
  // var collectionId = document.getElementById("collection");
  // $(function (){
  //   likesId.onclick = function (){
  //
  //   }
  // })

  // var bt_search = document.getElementById("bt_search");
  // var searchText = document.getElementById("search");





</script>
</body>
</html>
