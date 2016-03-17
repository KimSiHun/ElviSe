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
  <script type="text/javascript" src="http://apis.daum.net/maps/maps3.js?apikey=5a3b393c51ad7571d6a92599bd57a77e"></script>
  
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
    
    #mapDiv{
    border:#E8FFFF;
    width: 98%;
    height: 450px;
    
    }

 table {
    width: 100%;
    border-collapse: collapse;
  }
  
  th {
  text-align: center;
  }
  
  th, td {
  	
    border-top: 1px solid #bcbcbc;
    border-bottom: 1px solid #bcbcbc;
    padding: 5px 10px;
  }
    
  </style>
  
  <script type="text/javascript">
  
  $(document).ready(function(){
		$("button").click(function(){
			var keyWord = $("#keyWord").val();			
			keyWord = encodeURIComponent(keyWord);
			
			var url = "https://apis.daum.net/local/v1/search/keyword.json?apikey=5a3b393c51ad7571d6a92599bd57a77e&query="+keyWord;
			
			$.getJSON(url + "&callback=?" , function(json){
				
				var items = json.channel.item;
				$.each(items, function(i, it){
					var latitude = it.latitude;
					var longitude = it.longitude;
					
					var pos = latitude + "," + longitude;
					
					if(i == 0){
						var container = document.getElementById('mapDiv'); //지도를 담을 영역의 DOM 레퍼런스
						var options = { //지도를 생성할 때 필요한 기본 옵션
							center: new daum.maps.LatLng(latitude, longitude), //지도의 중심좌표.
							level: 3 //지도의 레벨(확대, 축소 정도)
						};
	
						var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
					}
				});	
			});				
		});
		$("#keyWord").val("");
	});
  
  </script>
  
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
      
<table>

<caption>아이템 목록</caption>

  <thead>
  <tr>
    <th>아이템</th>
    <th>리스트</th>		
    <th>아뭘랑</th>
  </tr>
  </thead>
  
  <tbody>
  <tr>
    <td>2행1열</td>
    <td>2행2열</td>		
    <td>2행3열</td>
  </tr>
  <tr>
    <td>3행1열</td>
    <td>3행2열</td>		
    <td>3행3열</td>
  </tr>
  <tr>
    <td>4행1열</td>
    <td>4행2열</td>		
    <td>4행3열</td>
  </tr>
  <tr>
    <td>5행1열</td>
    <td>5행2열</td>		
    <td>5행3열</td>
  </tr>
  </tbody>
</table>

<br><br><br><br><br>


      
    </div>

    <div class="col-sm-8">
      <h4><small>아이템 위치</small></h4>
      <div><input id="keyWord" placeholder="장소 입력">
			
		<button type="button" class="btn btn-default">검색</button></div>
		<hr>
		<br>
      
      <div id="mapDiv"></div>
     
  
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