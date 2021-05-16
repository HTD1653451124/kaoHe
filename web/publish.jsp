<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <title>发布文章</title>
    <script src="js/jquery.js" ></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/js3.js"></script>
<style>
    .div_top{
        width: 300px;
        margin-right: auto;
        margin-left: auto;
    }
    .div_middle{
        margin-top: 30px;

    }
    .div_bottom{
        width: 100px;
        margin-left: auto;
        margin-right: auto;
    }
    .title{
        width: 200px;
        height: 30px;
    }
    #textContent{

        width: 100%;
        height: 300px;
    }

</style>
</head>
<body>
<form action="/CAT_war_exploded/publishServlet" class="form1" id="form1" method="post">
    <div class="div_top" id="div_top">
        <textarea style="display: none" name="workerId">${workerMsg.workerId}</textarea>
        <textarea style="display: none" name="account">${workerMsg.account}</textarea>
        <p>${workerMsg.virName},分享你的知识吧!</p>
        <input type="text" class="title" id="title" name="title" placeholder="标题">
    </div>
    <div>
        <select name="types">
            <c:forEach items="${types}" var="t">
                <option  value="${t.typesId}">${t.type}</option>
            </c:forEach>
        </select>
    </div>
    <div class="div_middle" id="editor" name="editor">
    <textarea  name="textContent" id="textContent" class="textContent"></textarea>
    </div>
    <div class="div_bottom">
        <input type="submit" name="btn" id="btn" value="发布">
    </div>
</form>
</body>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script type="text/javascript">
    var title = document.getElementById("title").value;
    var text = document.getElementById("textContent").value;
    var btn = document.getElementById("btn");
    var form = document.getElementById("form1");
    function check(){
        if (title == "" && title.value==null && text == "" && text.value==null){
            return false;
        }else {
            return true;
        }
    }
    $(function (){
        btn.onclick = function (){
            if (check()){
                form.submit();
            }else {

            }

        }
    })

</script>
</html>