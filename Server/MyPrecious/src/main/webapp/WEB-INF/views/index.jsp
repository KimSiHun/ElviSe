<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My Precious</title>
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
      #jb-sidebar-left {
        width: 160px;
        padding: 20px;
        margin-right: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-content {
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar-right {
        width: 160px;
        padding: 20px;
        margin-bottom: 20px;
        float: right;
        border: 1px solid #bcbcbc;
      }
      #jb-footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
    </style>
    <script>
    $(document).ready(function() { 
        $('#demo1').click(function() { 
            $.blockUI({ message: $('#loginForm') }); 
     
            setTimeout($.unblockUI, 2000); 
        }); 
    }); 
    </script>
  </head>
  <body>

    <div id="jb-container">
      <div id="jb-header">
        <div><h1>보물 찾기</h1></div><div align="right"><button id="#demo1">login</button></div>
      </div>
      
      <div id="jb-content">
        <h2>내용</h2>
        <p>보물 찾기 이벤트관리를 위한 웹페이지 입니다.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mollis nulla. Phasellus lacinia tempus mauris eu laoreet. Proin gravida velit dictum dui consequat malesuada. Aenean et nibh eu purus scelerisque aliquet nec non justo. Aliquam vitae aliquet ipsum. Etiam condimentum varius purus ut ultricies. Mauris id odio pretium, sollicitudin sapien eget, adipiscing risus.</p>
      </div>
      
      <div id="jb-footer">
        <p>우찬 수영 종찬 구현 상민 윤정 시훈 기열 지훈</p>
      </div>
    </div>
  </body>
</html>