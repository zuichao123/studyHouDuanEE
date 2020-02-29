<%--
  Created by IntelliJ IDEA.
  User: southwind
  Date: 2019-02-20
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
<body>
<div class="layui-container" style="width: 700px;height: 600px;margin-top: 0px;padding-top: 60px;">
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/user/findAll'
            ,title: '菜单列表'
            ,cols: [[
                    {field:'id', width:100, title: '编号', sort: true}
                    ,{field:'username', width:200, title: '菜品'}
                    ,{field:'password', width:100, title: '密码'}
                    ,{field:'age', width:100, title: '年龄'}
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:200}
                ]]
            ,page: true
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                window.location.href="/user/findById/"+data.id;
            }
            if(obj.event === 'delete'){
                layer.confirm('真的删除行么', function(index){
                    window.location.href="/user/deleteById/"+data.id;
                    layer.close(index);
                });
            }
        });
    });
</script>

</div>


</body>
</html>
