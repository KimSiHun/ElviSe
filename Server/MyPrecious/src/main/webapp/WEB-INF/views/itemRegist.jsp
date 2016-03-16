<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>event Regist<title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>상품 등록 페이지</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">상품 등록</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Item register</h2>
        </div>
        
      <div class="modal-body">
         
        <div class="form-group">
        
      	<label for="product_name">상품명</label>
     	<input type="text" class="form-control" id="product_name">
    	
    	<p>
    	<label class="control-label">상품 이미지</label>
		<input id="input-4" name="input4[]" type="file" multiple class="file-loading">
    	<label class="QRcode_URL">QR 코드URL</label>
    	<input type="text" class="form-control" id="QRcode_URL">
		<p>
		<label class="control-label">QR 코드 이미지</label>
		<input id="input-4" name="input4[]" type="file" multiple class="file-loading">
    	
    	</div>
         
         
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
<script>
$(document).on('ready', function() {
    $("#input-4").fileinput({showCaption: true});
});
</script>
</body>
</html>