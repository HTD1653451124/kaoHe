<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">

  <title>健康有你</title>
  <script src="js/js3.js"></script>
  <style>
    .ho_right{
      width: 1200px;
      margin-right: auto;
      margin-left: auto;
    }
    .td_right{
      padding-top: 50px;
    }
    .changePic{
      width: 1200px;
      margin-left: auto;
      margin-right: auto;
    }
    #search{
      width: 1200px;
      height: 30px;
    }
  </style>

</head>
<body>
<div class="ho_layout">

  <div class="ho_right">
    <div class="changePic">
      <img id="img" src="image/pic1.jpg" width="100%" height="235px">
    </div>

    <table>
        <c:forEach items="${articles}" var="m" >
          <tr>
            <td class="td_right"><a href="${pageContext.request.contextPath}/userServlet?text=${m.contentText}&articleId=${m.articleId}&workerId=${m.workerId}&visNum=${m.visNum}&picture=${m.contentPicture}&likesNum=${m.likesNum}&collectionNum=${m.collectionNum}&title=${m.title}&type=tourist&method=visitArticle">${m.title}</a></td>
          </tr>
        </c:forEach>
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
