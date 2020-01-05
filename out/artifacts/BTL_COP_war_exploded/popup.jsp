<!DOCTYPE html>
<head>
		<meta charset="utf-8" />
		<title>Modal popup demo</title>
	  	<link rel="stylesheet" href="tranloan.css">	
		<!-- <script type="text/javascript" src="jquery-1.4.4.min.js"></script> -->
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="jquery.popup.js"></script>	
		<script type="text/javascript" >
			$(window).load(function() {
			  $('#myModal').tranloan($('#myModal').data());
			});
		</script>	
		
	</head>
	<body>	
		<div id="myModal" class="tranloan-modal">
			<img src="http://2.bp.blogspot.com/-eLSsK_4fUzg/Uk9dEo40_4I/AAAAAAAABfM/LcB3n6svA_s/s1600/popup-faceseo.jpg" />
			<a class="close-tranloan-modal">X</a>
		</div>			
	</body>
</html>