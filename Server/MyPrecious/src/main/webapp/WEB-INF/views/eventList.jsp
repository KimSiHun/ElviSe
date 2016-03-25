<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Event List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style type="text/css">
</style>
</head>
<body>

	<div class="container">  
		<div class="page-header">
			<h1>이벤트 리스트 관리 페이지</h1>
		</div>



		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#myModal">이벤트 만들기</button>

		<!-- 등록한 이벤트 관리  -->
		
		<h2>이벤트 현황</h2>
		<div class="well well-lg" style="height: 120px;">
   			<form class="form-inline" role="form" action="goitem">
    		<div class="form-group">
     		<label for="event_name">이벤트명:</label>
      		<input type="text" class="form-control" id="event_name" placeholder="EX)경기대 축제">
    		    		
      		<label for="begin_time">시작시간:</label>
      		<input type="text" class="form-control" id="begin_time" placeholder="00:00">
    		
      		<label for="end_time">종료 시간:</label>
      		<input type="text" class="form-control" id="end_time" placeholder="00:00">
    		
      		<label for="location">수령 장소:</label>
      		<input type="text" class="form-control" id="location" placeholder="ex)도서관 앞">
    		</div>
   		 	<p>
   		 	<div class="Btn-group">
			<button type="submit" class="btn btn-default" style="float: right;">Enter</button>

  		</form>
  		    <button type="button" class="btn btn-default" style="float: right;">E-Modify</button>
    		<button type="button" class="btn btn-default" style="float: right;">Delete</button>
  			</div>
  			</p>
  	</div>
  	
		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">이벤트</h4>
					</div>
					<div class="modal-body" style="height:400px">

						<form id="makeEventForm" role="form" method="get" action="golist">
							<div class="form-group">
								<label for="event_name">이벤트명</label> <input id="input_event_name" type="text"
									class="form-control">
							</div>
							<div class="row">
								<div class="col-xs-3">
									<label for="begin_time">시작시간</label> <input id="input_begin_time" type="text"
										class="form-control" placeholder="00:00">
								</div>
								<div class="col-xs-3">
									<label for="end_time">종료시간</label> <input id="input_end_time" type="text"
										class="form-control" placeholder="00:00">
								</div>
								<div class="col-xs-4">
									<label for="location">수령장소</label> <input id="input_location" type="text"
										class="form-control" placeholder="ex)도서관 앞">
								</div>
							</div>


							<div class="form-group">
								<label for="eventQR">QR code</label> 
								
							</div>
							
							<!-- 여기는 QRCode 이미지 나타날 자리 -->
							<div><img id="qrcode" src="" /></div>





						</form>




					</div>
					<div class="modal-footer">
						<button id="createBtn" class="btn btn-default">create</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
	
	$(document).ready(function(){
		
		$('#createBtn').click(function(){
			
			// input에 입력하는 값들을 변수에 저장
			var event_name = $('#input_event_name').val();
			var begin_time = $('#input_begin_time').val();
			var end_time = $('#input_end_time').val();
			var location = $('#input_location').val();
			
			// 한글처리인데 이게 필요할까?
			event_name = encodeURIComponent(event_name);
			begin_time = encodeURIComponent(begin_time);
			end_time = encodeURIComponent(end_time);
			location = encodeURIComponent(location);
			
			// 주소가 너무 길어서 헷갈리니까 기본 URL을 변수에 저장
		    googleQRUrl = "https://chart.googleapis.com/chart?chs=177x177&cht=qr&chl=";
		    
		    // 그냥 콘솔에서 한번 검사
			console.log(event_name, begin_time, end_time, location);
			
				// QR코드 이미지 url을 만들어서 id="qrcode" 여기 src에 넣기
		    	$('#qrcode').attr('src', googleQRUrl + "이벤트명:" + event_name + "/ 시작시간:" + begin_time + "/ 종료시간:" + end_time + "/ 수령장소:" + location + '&choe=UTF-8');

				// base64 인코딩을 위해 주소값을 다시 변수에 저장
				var qrCodeForEncode = $('#qrcode').attr('src'); 
							
		    	// 콘솔에 확인
				console.log(qrCodeForEncode);
		    	
		    	// Base64 인코딩 디코딩을 위한 변수
		    	var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9\+\/\=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/\r\n/g,"\n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}}

				// Define the string
			//	var qrcode_base64Encode = qrCodeForEncode;
				

				// Encode the String
				var qrcode_base64Encode = Base64.encode(qrCodeForEncode);
				
				// 인코딩 된 값을 확인
				console.log(qrcode_base64Encode); // Outputs: "SGVsbG8gV29ybGQh"
				
				// 디코딩
				//var qrcode_base64Decode = Base64.decode(qrcode_base64Encode);
				//console.log(qrcode_base64Decode);
				
				
				$('#makeEventForm').submit();
				
		    
		});
		
		
	 
	   
	 
	});
	
	
	
	
	</script>


</body>
</html>