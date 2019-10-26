<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center text-warning">
                旅游清单
            </h1>
            <h3 class="text-left text-success">
                欢迎您:${name}<button type="button" style="float: right" class="btn btn-default btn-info" onclick="location.href='/trip/add-ui'">添加</button>
            </h3>
            <h1 id="tripInfo"></h1>
            <table class="table">
                <thead>
                <tr>
                    <th>出发地</th>
                    <th>目标地</th>
                    <th>出发时间</th>
                    <th>结束时间</th>
                    <th>行程信息</th>
                    <th>行程美图</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list tripInfo.list as trip>
                <tr class="info">
                    <td>${trip.startLandName}</td>
                    <td>${trip.targetLandName}</td>
                    <td>${trip.startDate?date}</td>
                    <td>${trip.endDate?date}</td>
                    <td>${trip.tripList}</td>
                    <td>
                        <img style="width: 100px;height: 100px;" src="${trip.tripPic}" />
                    </td>
                    <td>${trip.created?date}</td>
                    <td>${trip.updated?date}</td>
                    <td>
                        <button type="button" class="btn btn-info" onclick="location.href='/trip/update-ui?id=${trip.id}&startLand=${trip.startLand}&targetLand=${trip.targetLand}'">修改</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-default btn-danger" onclick="del(this,${trip.id})">删除</button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <ul class="pagination">
                <#if tripInfo.hasPreviousPage>
                <li>
                    <a href="/trip/list?page=1">首页</a>
                </li>
                <li>
                    <a href="/trip/list?page=${tripInfo.prePage}">上一页</a>
                </li>
                </#if>
                <#if tripInfo.pageNum lt tripInfo.pages>
                <li>
                    <a href="/trip/list?page=${tripInfo.nextPage}">下一页</a>
                </li>
                <li>
                    <a href="/trip/list?page=${tripInfo.pages}">尾页</a>
                </li>
                </#if>
            </ul>
        </div>
    </div>
</div>

<script>
    function del(obj,id) {

        $.ajax({
            url:"/trip/delete?id="+id,
            data:null,
            type:"Get",
            dataType: "json",
            success: function(result){
                if(result.code == 0) {
                    // 3.1 如果删除成功: 动态删除当前行数据.
                    $(obj).parent().parent().remove();
                }else{
                    // 3.2 如果删除失败: 给用户一个提示.
                    $("#tripInfo").html(result.msg);
                }
            },
            error: function(){
                alert("服务器爆炸!!");
            }
            }
        );
    }
</script>
</body>
</html>