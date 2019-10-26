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
            <h1 class="text-center">
                城市信息页面
            </h1>
        </div>
        <h3 class="text-left text-success">
            欢迎您:${name}
        </h3>
        <br />
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>城市名称</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list pageInfo.list as city>
            <tr class="info">
                <td>${city.id}</td>
                <td>${city.name}</td>
                <td>${city.created?date}</td>
                <td>${city.update?date}</td>
                <td>
                    <button type="button" class="btn btn-info">修改</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" class="btn btn-default btn-danger">删除</button>
                </td>
            </tr>
            </#list>

            </tbody>
        </table>
        <ul class="pagination">
            <#if pageInfo.hasPreviousPage>
                <li>
                    <a href="/city/list?page=1">首页</a>
                </li>
                <li>
                    <a href="/city/list?page=${pageInfo.prePage}">上一页</a>
                </li>
            </#if>
            <#if pageInfo.pageNum lt pageInfo.pages>
                <li>
                    <a href="/city/list?page=${pageInfo.nextPage}">下一页</a>
                </li>
                <li>
                    <a href="/city/list?page=${pageInfo.pages}">尾页</a>
                </li>
            </#if>
        </ul>
    </div>
</div>
</body>
</html>