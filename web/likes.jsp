<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        <div class="changePic">
            <img id="img" src="image/pic1.jpg" width="100%" height="235px">
        </div>

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
