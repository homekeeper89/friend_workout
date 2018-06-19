<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <div class="modal fade" id="upload-modal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">X</button>
          <h4 class="modal-title">proof yourself</h4>
        </div>
        <div class="modal-body">
          <p>오늘의 운동을 인증해주세요!!</p>
          <p>몸이나 얼굴이 나온 사진은 안됩니다. 그저 내가 오늘 운동 왔다는 것만 보여주세요</p>
          <p>사진 업로드로 인해 발생되는 피해에 대해 책임지지 않습니다.</p>
          <form id = "modal-pic" action = "/files" method = "post" enctype = "multipart/form-data">
          	<input type = 'file' name = 'file'>
          	<label>간단한 제목</label><input type = "text" name = "b_title"><br>
          	<label>간단한 내용</label><input type = "text" name = "b_content"><br>
          	<label>작성자</label><input type = "text" name = "u_name" value = "${login.u_name}" readonly><br>
          	<input type = 'submit' value = 'send'>
          </form>
        </div>	
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>