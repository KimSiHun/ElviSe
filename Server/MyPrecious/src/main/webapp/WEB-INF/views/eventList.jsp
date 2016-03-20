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

						<form role="form" action="golist">
							<div class="form-group">
								<label for="event_name">이벤트명</label> <input type="text"
									class="form-control" id="event_name">
							</div>
							<div class="row">
								<div class="col-xs-3">
									<label for="begin_time">시작시간</label> <input type="text"
										class="form-control" placeholder="00:00">
								</div>
								<div class="col-xs-3">
									<label for="end_time">종료시간</label> <input type="text"
										class="form-control" placeholder="00:00">
								</div>
								<div class="col-xs-4">
									<label for="location">수령장소</label> <input type="text"
										class="form-control" placeholder="ex)도서관 앞">
								</div>
							</div>


							<div class="form-group">
								<label for="eventQR_link">QR code</label> <input type="text"
									class="form-control" id="eventQR_link">
							</div>





						</form>




					</div>
					<div class="modal-footer">
						<button  class="btn btn-default">create</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>


</body>
</html>