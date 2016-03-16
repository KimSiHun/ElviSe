<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1000px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-4 sidenav">
      <h4>WebTeam's Blog</h4>
      <ul class="nav nav-pills nav-stacked">
      </ul>
      
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
          <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">register</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
      
      <div class="row">
        <div class="col-xs-6 col-md-4">테이블 공간</div>
        <div class="col-xs-6 col-md-4">테이블 공간</div>
        <div class="col-xs-6 col-md-4">테이블 공간</div>   
     </div>
      
    </div>

    <div class="col-sm-8">
      <h4><small>Items</small></h4>
      <hr>
      
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
      <!-- 지도 들어가야 할 공간 -->
  
      <div class="row">
        
        
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>