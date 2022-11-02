<html>
<body>
<h2>Hello World!</h2>

<input type="button" value="button1" onclick="show('qwer')">
<input type="button" value="button2" onclick="show2()">
<input type="button" value="button3" onclick="ajax()">

</body>

<script>

    var kw = "";

    function show(str){
        alert(str);
        kw = str;
    }

    function show2(){
        alert(kw);
    }

    function ajax(){
        $.ajax({

            url: "xxxx?name=" + kw

        })
    }


</script>

</html>
