<%--
  Created by IntelliJ IDEA.
  User: HTD
  Date: 2021/5/11
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>注册</title>
  <script src="js/js3.js"></script>
  <style>
    body{
      background: url("image/login/login_bg.jpg") no-repeat center ;
      background-size: 2300px;
    }
    .rg_layout{
      width: 800px;
      height: 400px;
      border: 10px solid #EEEEEE;
      background-color: white;
      margin: auto;
      margin-top: 100px;
    }
    .rg_middle{
      /*border: 3px solid red;*/
      margin: auto;
      margin-left: 200px;

    }
    .td_left{
      width: 100px;
      height: 50px;
      text-align: center;
    }
    #tips{
      color: red;
      margin-left:250px ;
    }
  </style>
  <script>
    //检查输入是否为空
    function checkVirName(){
      var ele = document.getElementById("virname").value;
      if (ele == "" && ele.value == null){
        $("#virname").css("border","1px solid red");
        return false;
      }else {
        //昵称不为空
        $("#virname").css("border","");
        return  true;
      }
    }

    //检查账号是否合法
    function chenkAccount(){
      var ele = document.getElementById("account");
      var input1 = ele.value;
      var  reg_account = /^\d{8,20}$/;//账号是8到20位的数字
      var boolean = reg_account.test(input1);
      if (boolean){
        //格式正确
        $("#account").css("border","");
      }else {
        //格式错误
        $("#account").css("border","1px solid red");
      }
      return boolean;
    }
    //检查密码是否合法
    function checkPassword(){
      var ele = document.getElementById("password");
      var input1 = ele.value;
      var  reg_account = /^\w{8,20}$/;//密码是8到20位
      var boolean = reg_account.test(input1);
      if (boolean){
        //格式正确
        $("#password").css("border","");
      }else {
        //格式错误
        $("#password").css("border","1px solid red");
      }
      return boolean;
    }
    //检查两次输入的密码是否一致
    function checkRePassword(){
      var password = document.getElementById("password").value;
      var rePassword = document.getElementById("re_password").value;
      if (password == rePassword){
        $("#re_password").css("border","");
        return true;
      }else {
        $("#re_password").css("border","1px solid red");
        return false;
      }

    }

    $(function (){
      var form = document.getElementById("reg_form");
      var bt_det = document.getElementById("bt_determin");
      bt_det.onclick = function (){
        //表单数据校验
        if (chenkAccount() && checkPassword() && checkRePassword()&& checkVirName()){
            form.submit(function (){
              if (chenkAccount() && checkPassword() && checkRePassword()&& checkVirName()){
                $.post("regisUser",$(this).serialize(),function (data){

                })
              }
              return false ;
            })
        }else {
          alert("输入有误");
          return false;
        }

      }

      //失去焦点时
      $("#virname").blur(checkVirName);
      $("#account").blur(chenkAccount);
      $("#password").blur(checkPassword);
      $("#re_password").blur(checkPassword);
      $("#re_password").blur(checkRePassword);
      $("#account").blur(function (){
        var ele = document.getElementById("account");
        var account = ele.value;
        $.post("findUserAccount",{account:account},function (data){
          var span = $("#s_account");
          if (data.userExist){
            //用户名存在
            span.css("color","red");
            span.html(data.msg);
          }else {
            //用户名不存在
            span.css("color","green");
            span.html(data.msg);
          }
        })
      })

    })


  </script>

</head>
<body>
<div class="rg_layout" >


  <div class="rg_middle">
    <div id="error_msg" style="color: red ;text-align: center" ></div>
    <form  action = "/CAT_war_exploded/regisUser" id="reg_form" method = "post">
      <table>
        <tr>
          <td class="td_left"><label>昵称</label></td>
          <td class="td_right"><input type="text" name="virname" id="virname"></td>
        </tr>
        <tr>
          <td class="td_left"><label>账号</label></td>
          <td class="td_right"><input type="text" name="account" id="account" placeholder="请输入8到20位数字"><span id="s_account"></span></td>

        </tr>
        <tr>
          <td class="td_left"><label>密码</label></td>
          <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入8到20位"></td>
        </tr>
        <tr>
          <td class="td_left"><label>确认密码</label></td>
          <td class="td_right"><input type="password" name="re_password" id="re_password"></td>
        </tr>
        <tr>
          <td class="td_left"><input type="radio" name="gender" value="male" checked> 男</td>
          <td class="td_right"><input type="radio" name="gender" value="female" >女</td>
        </tr>
        <tr>
          <td class="td_left"><input type="radio" name="reg_type" value="user" checked>普通用户</td>
          <td class="td_right"><input type="radio" name="reg_type" value="worker" >打工仔</td>
        </tr>
        <tr>
          <td> <input type="submit" id= "bt_determin" value="确认"></td>
          <td> <a href="login.jsp"><input type="button" id = "bt_return" value="返回"></a></td>
        </tr>
      </table>
    </form>

  </div>
  <div class="alert alert-warning alert-dismissible" role="alert" id="tips">
    <strong>${reg_msg}</strong>
  </div>

</div>



</body>
</html>