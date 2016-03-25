<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My Thing</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style>
      #jb-container {
        width: 940px;
        margin: 50px auto;
        padding: 10px;
        border: 1px solid #bcbcbc;
      }
      #jb-header {
        padding: 20px;
        margin-bottom: 20px;
        border: 1px solid #bcbcbc;
      }

      #jb-content {
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }

      #jb-footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      
      .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
     }
     .modal-footer {
      background-color: #f9f9f9;
       }
    </style>

<script>
//$(document).ready(function() {

var Base64 = {

		// private property
		_keyStr : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",

		// public method for encoding
		encode : function (input) {
			var output = "";
			var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
			var i = 0;

			while (i < input.length) {

			  chr1 = input.charCodeAt(i++);
			  chr2 = input.charCodeAt(i++);
			  chr3 = input.charCodeAt(i++);

			  enc1 = chr1 >> 2;
			  enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
			  enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
			  enc4 = chr3 & 63;

			  if (isNaN(chr2)) {
				  enc3 = enc4 = 64;
			  } else if (isNaN(chr3)) {
				  enc4 = 64;
			  }

			  output = output +
				  this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
				  this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);

			}

			return output;
		},

		// public method for decoding
		decode : function (input)
		{
		    var output = "";
		    var chr1, chr2, chr3;
		    var enc1, enc2, enc3, enc4;
		    var i = 0;

		    input = input.replace(/[^A-Za-z0-9+/=]/g, "");

		    while (i < input.length)
		    {
		        enc1 = this._keyStr.indexOf(input.charAt(i++));
		        enc2 = this._keyStr.indexOf(input.charAt(i++));
		        enc3 = this._keyStr.indexOf(input.charAt(i++));
		        enc4 = this._keyStr.indexOf(input.charAt(i++));

		        chr1 = (enc1 << 2) | (enc2 >> 4);
		        chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
		        chr3 = ((enc3 & 3) << 6) | enc4;

		        output = output + String.fromCharCode(chr1);

		        if (enc3 != 64) {
		            output = output + String.fromCharCode(chr2);
		        }
		        if (enc4 != 64) {
		            output = output + String.fromCharCode(chr3);
		        }
		    }

		    return output;
		}
	}

	
//in JavaScript Code
function changeSourceView(obj){
	var encodeStr = Base64.encode( obj.value );
	var decodeStr = Base64.decode( encodeStr );
	
	
     if(event.keyCode == 13){
		 document.write(encodeStr);
     }
     $.ajax({
    	    url: 'admin/loginCheck',
    	    data: { 'c_posterName' : encodeStr},
    	    type: "post",
    	    cache: false,
    	    success: function (data, stat, xhr) {      
    	    	
    	       
    		alert("success");
    		
    		
    	    },
    	    error: function (xhr, stat, err) {
    	       alert("fail login");
    	  console.log(err);
    	    }
    	});
}


//});
</script>


  </head>
  <body>

    <div id="jb-container">
      <div id="jb-header">
        <div><h1>보물 찾기</h1></div> <div><button type="button" class="btn btn-default btn-lg" id="myBtn">Login</button></div>
      </div>
      
      <div id="jb-content">
        <h2>내용</h2>
        <p>보물 찾기 이벤트관리를 위한 웹페이지 입니다.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet. Proin gravida velit dictum dui consequat malesuada. Aenean et nibh eu purus scelerisque aliquet nec non justo. Aliquam vitae aliquet ipsum. Etiam condimentum varius purus ut ultricies. Mauris id odio pretium, sollicitudin sapien eget, adipiscing risus.</p>
      </div>
      
      <div id="jb-footer">
        <p>우찬 수영 종찬 구현 상민 윤정 시훈 기열 지훈</p>
      </div>
      
       <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
          <div class="modal-dialog">    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        
          <form name="mainForm" action="abcd">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter name">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input onkeydown="changeSourceView(this)" name="source" type="text" class="form-control" id="psw" placeholder="Enter password">
            </div>

              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
      
    </div>
  </div> 
</div>
 
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>
  </body>
</html>