<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
    <script src="js/js3.js"></script>
</head>
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
<h2>${Msg.getMsg()}</h2><span id="time">3</span>秒后自动返回
<span  id="tar" >${Msg.getTarget()}</span>
</body>
</html>
