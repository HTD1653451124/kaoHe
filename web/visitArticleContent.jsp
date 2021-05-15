<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文章</title>
    <script src="js/js3.js"></script>
    <style>
        .message{
            width: 500px;
           margin-right: auto;
            margin-left: auto;
        }
        .div_comment{
            width: 650px;
            margin-right: auto;
            margin-left: auto;
        }
        .title{
            width: 200px;
            margin-left: auto;
            margin-right: auto;
        }
        .info{
            width: 100px;
            margin-left: auto;
            margin-right: auto;
        }
        .comment{
            width: 600px;
            height: 200px;
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
        #btn_comment{
            width: 100px;
            margin-left: auto;
            margin-right: auto;
        }

    </style>

</head>
<body>
<div class="layout">
    <div class="message">
        <h2 class="title">${article.title}</h2>
        <br>
        <h4 class="info"><input type="button" name="likes" id="likes1" value="点赞"></h4>
        <h4 class="info"><input type="button" name="collection" id="collection1" value="收藏"></h4>
        <br>
        <p>${article.contentText}</p>
    </div>
<hr/>
    <div class="div_allComment">
        <c:forEach items="${allComment}" var="com">
            <h6>${com.user_virName}:${com.content}</h6>
        </c:forEach>
    </div>
    <div class="div_comment">
        <form method="post">
            <textarea name="comment" class="comment" id="comment" placeholder="写点评论吧"></textarea>
            <input type="button" name="btn_comment" id="btn_comment" value="确认评论">
        </form>
    </div>
    <div class="div_buttom">
        <a href="home.jsp"><input type="button" name="bt_return" id="bt_return" value="返回"></a>
    </div>
</div>

<script>
    var likes = document.getElementById("likes1");
    var collection = document.getElementById("collection1");
    var comment = document.getElementById("btn_comment");

    var isl = ${islikes};
    var isc = ${isCollection};

    if (isl=="1"){
        document.getElementById("likes1").value="取消点赞";
    }else{
        document.getElementById("likes1").value="点赞";
    }

    if (isc=="1"){
        document.getElementById("collection1").value="取消收藏";
    }else{
        document.getElementById("collection1").value="收藏";
    }

    function checkComment(){
        //检查评论是否为空
        var ele = document.getElementById("comment").value;
        if (ele==""&&ele.value==null){
            return false;
        }else {
            return true;
        }
    }
    $(function (){
        //点击点赞事件
        likes.onclick = function (){
            $.ajax({
                type:'POST',
                data:"user_id=${user_id}&article_id=${article.article_id}&account=${user.account}",
                url :'/CAT_war_exploded/likes',
                success :function(data) {
                    var ele = document.getElementById("likes1").value;
                    if (ele==="点赞"){
                        document.getElementById("likes1").value="取消点赞";
                    }
                    if (ele==="取消点赞"){
                        document.getElementById("likes1").value="点赞";
                    }
                },
                error :function(e) {
                }
            });
        }
        //点击收藏事件
        collection.onclick = function (){
            $.ajax({
                type:'POST',
                data:"user_id=${user_id}&article_id=${article.article_id}&account=${user.account}",
                url :'/CAT_war_exploded/collection',
                success :function(data) {
                    var ele = document.getElementById("collection1").value;
                    if (ele==="收藏"){
                        document.getElementById("collection1").value="取消收藏";
                   }
                   if (ele==="取消收藏"){
                       document.getElementById("collection1").value="收藏";
                   }
                },
                error :function(e) {
              }
           });
        }
        //点击评论事件
        comment.onclick = function (){
            if (checkComment()){
                var inputContent = document.getElementById("comment").value;
                $.ajax({
                    type:'POST',
                    data:"user_id=${user_id}&article_id=${article.article_id}&vName=${user.virName}&account=${user.account}&content="+inputContent,
                    url :'/CAT_war_exploded/comment',
                    success:function (data){
                        alert("评论成功");
                    }
                });
            }else {
                alert("输入为空");
            }
        }
    })

</script>
</body>
</html>