<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $.ajax({
                url:"json.do",
                type:"POST",
                data:"",
                dataType:"JSON",
                success:function (data) {
                    // $("#id").text(data.id);
                    // $("#name").text(data.name);
                    // $("#pwd").text(data.pwd);

                    $("#num").text(data.num);
                    $("#name2").text(data.name);
                    $("#age").text(data.age);
                    $("#address").text(data.address);
                }
            });
        });
    </script>
</head>
<body>
<div id="id"></div>
<div id="name"></div>
<div id="pwd"></div>
<hr/>
<div id="num"></div>
<div id="name2"></div>
<div id="age"></div>
<div id="address"></div>
</body>
</html>
