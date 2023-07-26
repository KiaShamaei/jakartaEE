<html>
<body>
<h2>Hello World!</h2>
<form name="myform" >
    <input name="number" type="text">
    <input name="result" type="text">
    <input type="button" value="ajaxSend" onclick="loadValue()">

</form>
<script>
    var xhr = new XMLHttpRequest() ;
    function  loadValue(){
        if(xhr.readyState == 0 || xhr.readyState == 4 ){
            xhr.open("GET" , "asyncServlet?number=" + myform.number.value) ;
            xhr.onreadystatechange = callbackFunction;
            xhr.send()
        }
    }
    function callbackFunction (){
        if(xhr.readyState == 4){
            myform.result.value = xhr.responseText
        }
    }
</script>
</body>
</html>
