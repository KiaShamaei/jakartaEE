<!DOCTYPE HTML>
<html>
<head>
    <title>webSocket</title>
</head>
<body>
<form name="myForm">
    <input type="text" name="name" >
    <input type="button" onclick="send()">
</form>

<script>
    var ws = new WebSocket("ws://localhost:8080/myEndpoint")
    ws.onmessage = function (e){
        document.forms.myForm.name.value = e.data ;
    }
    function send(){
        ws.send(document.forms.myForm.name.value)
    }

</script>
</body>
</html>
