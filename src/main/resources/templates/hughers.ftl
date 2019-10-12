<!DOCTYPE html>
<html lang="zh-CN">
 <head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>古月哥欠</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
 </head>
 <body>
 <div class="container">
   <div class="row">
     <div class="col-md-4">
       <ul class="nav nav-pills nav-stacked">
        <li role="presentaion" class="active"><a href="/hugher/list">列表</a></li>
        <li role="presentaion" ><a href="/hugher/add">新增</a></li>
        <li role="presentaion" ><a href="/hugher/search">搜索</a></li>
       </ul>
     </div>
     <div class="col-md-8">
       <table class="table table-hover">
        <thead>
        <th>ID</th><th>名称</th><th>密码</th><th>头像</th><th>删除</th><th>修改</th>
        </thead>
        <tbody>
          <#list hughers as hugher>
          <tr>
          <td>${hugher.id}</td>
          <td>${hugher.hughername}</td>
          <td>${hugher.password}</td>
          <td>${hugher.avatar}</td>
          <td><a href="/hugher/delete/${hugher.id}">删除</a></td>
          <td><a href="/hugher/modify/${hugher.id}">修改</a></td>
          <td><a href="/hugher/add_avatar/${hugher.id}">上传</a></td>
          </tr>
          </#list>
        </tbody>
       </table>
      </div>
     </div>
    </div>
     <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
 </body>
</html>