<!DOCTYPE html>
<html lang="en" xmlns:fmt="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>旅游信息修改页面</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center text-warning">
                旅游信息修改页面
            </h1>
            <h3 class="text-left text-success">
                欢迎您:${name}
            </h3>
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="startLand" class="col-sm-2 control-label">出发地</label>
                    <div class="col-sm-10">
                        <select id="startLand" class="form-control">
                            <#list cityList as city>
                            <option value = "${startLand.id}" <#if city.id=startLand.id>selected</#if>>${city.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="targetLand" class="col-sm-2 control-label">目标地</label>
                    <div class="col-sm-10">
                        <select id="targetLand" class="form-control">
                            <#list cityList as city>
                                <option value="${city.id}" <#if city.id=targetLand.id>selected</#if>>${city.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="startDate" class="col-sm-2 control-label">出发时间</label>
                    <div class="col-sm-10">
                        <input id="startDate" type="date" class="form-control" value="${trip.startDate?string("yyyy-MM-dd")}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="endDate" class="col-sm-2 control-label">结束时间</label>
                    <div class="col-sm-10">
                        <input id="endDate"  type="date" class="form-control" value="${trip.endDate?string("yyyy-MM-dd")}" />
                    </div>
                </div>


                <div class="form-group">
                    <label for="tripInfo" class="col-sm-2 control-label">行程信息</label>
                    <div class="col-sm-10">
                        <textarea id="tripInfo" type="date" class="form-control">${trip.tripList}</textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="tripPic" class="col-sm-2 control-label">行程美照</label>
                    <div class="col-sm-10">
                        <img style="width: 200px;height: 200px;" src="${trip.tripPic}" />
                        <input id="tripPic" type="file" class="form-control" value="2019-10-21" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-default">修改</button>
                        <button type="button" class="btn btn-default">返回</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>