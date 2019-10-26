<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center text-warning">
                旅游信息添加页面
            </h1>
            <h3 class="text-left text-success">
                欢迎您:${name}
            </h3>
            <form class="form-horizontal" role="form" id="tripForm">
                <div class="form-group">
                    <label for="startLand" class="col-sm-2 control-label">出发地</label>
                    <div class="col-sm-10">
                        <select name="startLand" id="startLand" class="form-control">
                            <option>--请选择--</option>
                            <#list cityList as city>
                            <option value="${city.id}">${city.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="targetLand" class="col-sm-2 control-label">目标地</label>
                    <div class="col-sm-10">
                        <select name="targetLand" id="targetLand" class="form-control">
                            <option>--请选择--</option>
                            <#list cityList as city>
                                <option value="${city.id}">${city.name}</option>
                            </#list>

                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="startDate" class="col-sm-2 control-label">出发时间</label>
                    <div class="col-sm-10">
                        <input name="startDate" id="startDate" type="date" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="endDate" class="col-sm-2 control-label">结束时间</label>
                    <div class="col-sm-10">
                        <input name="endDate" id="endDate" type="date" class="form-control" />
                    </div>
                </div>


                <div class="form-group">
                    <label for="tripInfo" class="col-sm-2 control-label">行程信息</label>
                    <div class="col-sm-10">
                        <textarea name="tripList" id="tripInfo" type="date" class="form-control" ></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="tripPic" class="col-sm-2 control-label">行程美照</label>

                    <div class="col-sm-10">
                        <img id="img" src="http://localhost/img/adsadasdaas.img" />
                        <input id="hiddenPic" name="tripPic" type="hidden" />
                        <input id="tripPic" onchange="preview(this)" type="file" class="form-control" />
                        <button type="button" class="btn btn-default" onclick="uploadPic()">上传图片</button>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-default" onclick="tripSubmit()">添加</button>
                        <button type="button" class="btn btn-default">返回</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/js/jquery.min.js"></script>
<script>

    // 添加全部信息
    function tripSubmit(){
        //1. 获取form表单中的全部内容
        var data = $("#tripForm").serialize(); // 将携带name属性的表单项拼接为key=value&key=value..
        //2. 发送ajax请求到后台,并传递全部的参数.
        $.post(
            "/trip/add",
            data,
            function(result){
                if(result.code == 0){
                    location.href = "/trip/list";
                }
            },
            "json"
        );
    }

    // 动态显示图片
    function preview(file){
        if (file.files && file.files[0]){
            reader = new FileReader();
            reader.onload = function(evt){
                $("#img").attr("src",evt.target.result);
            }
            reader.readAsDataURL(file.files[0]);
        }
        /*else{
            prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
        }*/
    }

    function uploadPic() {

        //1. 创建FormData对象
        var formData = new FormData();
        //2. 向formData中封装文件上传项.
        formData.append("file",$("#tripPic")[0].files[0]);
        //3. 发送ajax请求.
        $.ajax({
            url: "/pic/upload",
            data: formData,
            type: "POST",
            dataType: "json",
            success: function(result){
                if(result.code == 0){
                    $("#img").attr("src",result.data);
                    $("#hiddenPic").val(result.data);
                }else{
                    alert("服务器爆炸,请灭火!!!");
                }
            },
            erorr: function(){
                alert("服务器爆炸,请灭火!!!");
            },
            contentType: false,
            processData: false
        });
    }

</script>
</body>
</html>