<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="js/js3.js"></script>
    <style>
        body{
            background: url("image/login/login_bg.jpg") no-repeat center ;
            background-size: 2500px ;
        }
        .lg_layout{
            width: 400px;
            height: 300px;
            /*//border: 10px solid #EEEEEE;*/
            /*//background-color: white;*/
            margin: auto;
            margin-top: 20px;
        }
        .lg_left{
            float: left;
            color: red;
        }
        .lg_left > p:first-child{
            font-size: 25px;
        }
        .lg_middle{

            float: left;
            margin-top: 100px;
            margin-left: 70px;
        }
        .lg_right{

            float: right;
            color: #F5A9A9;
        }

        .td_left{
            width: 100px;
            height: 50px;
            text-align: center;
            color:#2A0A0A;
            font-size: 25px;
        }
        #vis_login,#bt_reg,#user_login,#worker_login{
            width: 150px;
            height: 40px;
            background-color:#00BFFF ;
            margin-top: 20px;
        }
        #account,#password{
            width: 200px;
            height: 35px;
            border-radius: 5px;
        }
        #tips{
            font-size: 40px;
        }
    </style>
    <script>

        function checkAccount(){
            var ele = document.getElementById("account").value;
            if (ele == "" && ele.value == null){
                $("#account").css("border","3px solid red");
                return false;
            }else {
                $("#account").css("border","");
                return true;
            }
        }
        function checkPassword(){
            var ele = document.getElementById("password").value;
            if (ele == "" && ele.value == null){
                $("#password").css("border","3px solid red");
                return false;
            }else {
                $("#password").css("border","");
                return true;
            }
        }
        $(function (){
            var u_login = document.getElementById("user_login");
            var form = document.getElementById("form");
            //点击登录
            u_login.onclick = function (){
                if (checkAccount() && checkPassword()){
                    form.submit(function (){
                        if (checkAccount() && checkPassword()){
                            $.post("${pageContext.request.contextPath}/userServlet?method=login",$(this).serialize(),function (data){
                                alert(data.msg);
                            })
                        }
                        return false;
                    })
                }else {
                    alert("输入有误");
                }

            }
            $("#account").blur(checkAccount);
            $("#password").blur(checkPassword);
        })
    </script>
</head>
<body>
<div class = "lg_layout">
    <div class = "lg_left">
        <p>WELCOME</p>
    </div>
    <div class = "lg_middle">
        <div class="lg_form">
            <form action="${pageContext.request.contextPath}/userServlet?method=login" method="post" id="form">
                <table >
                    <!--                    账号输入-->
                    <tr>
                        <td class="td_left"><label for="account">账号</label></td>
                        <td class="td_right"><input type="text" name = "account" id = "account" placeholder="请输入账号"></td>
                    </tr>

                    <!--                    密码输入-->
                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="password" name = "password" id = "password" placeholder="请输入密码"></td>
                    </tr>
                    <tr>
                        <td ><input type="radio" name="lg_type" value="user" checked>普通用户</td>
                        <td ><input type="radio" name="lg_type" value="worker">打工仔</td>
                    </tr>

                    <!--                  登录和注册按钮-->
                    <tr>
                        <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/touristServlet?method=getTourArticle"><input type="button" id = "vis_login" value="游客登陆"></a></td>
                    </tr>

                    <tr>
                        <td colspan="2" align="center"><a href="register.jsp"><input type="button" id = "bt_reg" value="注册"> </a></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="button" id = "user_login" value="登录" ></td>
                    </tr>

                </table>
            </form>
        </div>

    </div>
    <div class = "lg_right">
        <P>健康关爱，我们常在</P>
    </div>
    <div class="alert alert-warning alert-dismissible" role="alert" id="tips">
        <strong>${login_msg}</strong>
    </div>
</div>
</body>
</html>