<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <script src="js/jquery.js" ></script>
    <script src="js/bootstrap.min.js"></script>
    <title>Title</title>
    <style>
        .div{
            width: 500px;
            height: 500px;
            margin-left: auto;
            margin-right: auto;
        }
    </style>

</head>
<body>

<div class="div" >
    <form method="post" action="${pageContext.request.contextPath}/adminServlet?method=addType" name="form2" id="form2">
        <input type="text" placeholder="请输入类别" name="text" id="text">
        <input type="submit" id="bt"  value="提交">
    </form>
</div>

</body>
</html>
