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
          <p>Upload your pic</p>
          <form id = "modal-pic" action = "/files" method = "post" enctype = "multipart/form-data">
          	<input type = 'file' name = 'file'>
          	<input type = 'submit' value = 'send'>
          </form>
        </div>	
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>