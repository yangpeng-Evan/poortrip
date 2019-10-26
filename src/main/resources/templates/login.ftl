<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center">
                穷游登录界面
            </h1>
        </div>
        <div>
            <h1 id="loginInfo"></h1>
        </div>
        <br />
        <div class="col-md-12 column">
            <form class="form-horizontal" role="form" id="form">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input name="username" class="form-control" id="username" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password"  class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" id="password" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="loginBtn"  type="button" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $("#loginBtn").click(function () {
        var data = $("#form").serialize();
        $.post(
            "/user/login",
            data,
            function(result) {
                if (result.code == 0) {
                    location.href = "/poor/index";
                } else {
                    $("#loginInfo").html(result.msg);
                }
            },
            "json"
        );
    });
</script>
</body>
</html>