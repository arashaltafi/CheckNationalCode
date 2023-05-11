<html>
<head>
  <title>بررسی اعتبار کد ملی</title>
  	<link rel="stylesheet" href="style.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="container">
    	<br/>
    	<br/>
    	<br/>
    	
    	<form action="codemeli.php" method="post">
    		<label for="code">کد ملی</label><br>
    		<input type="number" id="code" name="code" placeholder="کد ملی را وارد نمایید ..."><br><br>
    		<br><br><br>
    		<input type="submit" value="Send">
    		
    		
        <div id="result">
          <?php if(isset($meliResult)): ?>
            <?php if($meliResult): ?>
                <h2 align="center" style="color: #00FF00;" class="valid">معتبر</h2>
            <?php else: ?>
                <h2 align="center" style="color: #FF0000;" class="invalid">نا معتبر</h2>
            <?php endif; ?>
          <?php endif; ?>
        </div>
    		
    	</form>
        
        <br/>
    	<br/>
    	<br/>

    
    </div>

</body>
</html>