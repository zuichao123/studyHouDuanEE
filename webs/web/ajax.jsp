<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    用户名：
    <input type="text" onblur="validation()" id="name"/>
    <div id="info"></div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        // jQuery方式
        function validation() {
            var name = $('#name').val();
            $.ajax({
                url:"user.do",
                type:"POST",
                data:"name="+name,
                dataType:"text",
                success:function (data) {
                    if(data == "true"){
                        $("#info").html("用户名已存在！");
                    }else {
                        $("#info").html("用户名可以使用。");
                    }
                },
                error:function () {
                    alert("系统繁忙...");
                },
                complete:function () {
                    alert("请求完成。");
                }
            });
        }

        // 原生方式
        function validation2() {
            var name = document.getElementById("name").value;
            // 创建XMLHttpRequest对象
            xmlHttpRequest  = createXMLHttpRequest();
            // 设置回调函数
            xmlHttpRequest.onreadystatechange = callback;
            // 初始化XMLHTTPRequest组件
            var url = "user.do?name=" + name;
            xmlHttpRequest.open("POST", url);
            xmlHttpRequest.send(null);
        }
        function createXMLHttpRequest() {
            if(window.XMLHttpRequest){
                return new XMLHttpRequest();
            }else {
                return new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function callback() {
            if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
                var data = xmlHttpRequest.responseText;
                if(data == "true"){
                    document.getElementById("info").innerHTML = "用户名已存在！";
                }else {
                    document.getElementById("info").innerHTML = "用户名可以使用。";
                }
            }
        }
    </script>
</body>
</html>