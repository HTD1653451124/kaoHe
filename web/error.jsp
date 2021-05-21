<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
    <script src="js/js3.js"></script>
</head>
<style>
    .div_error{
        width: 300px;
        margin-right: auto;
        margin-left: auto;
    }
</style>
<script>

    var second = 3;
    var tar = "<%=session.getAttribute("target")%>";
    function changeTime(){
        second--;
        if (second<=0){
            location.href=tar;
        }
        var time = document.getElementById("time");
        time.innerHTML=second +"";
    }
    setInterval(changeTime,1000);

</script>
<body>
<div class="div_error">
    <h2>${Msg.getMsg()}</h2><span id="time">3</span>秒后自动返回
</div>

</body>
</html>
