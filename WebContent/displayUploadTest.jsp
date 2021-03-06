<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Upload Files using XMLHttpRequest - Minimal</title>
    <script type="text/javascript">
      function fileSelected() {
        var file = document.getElementById('fileToUpload').files[0];
        var name=fileToUpload.value;
        var fileName = name.substring(name.lastIndexOf(".")+1).toLowerCase();
        if(fileName !="jpg" && fileName !="png"&& fileName !="jpeg"){
            alert("请选择JPG/PNG/PNG格式文件上传！");
            fileToUpload.value="";
            return
        }

        if (file) {
          var fileSize = 0;
          var reader = new FileReader();
          if (file.size > 1024 * 1024)
            fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
          else
            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
          document.getElementById('fileName').innerHTML = 'Name: ' + file.name;
          document.getElementById('fileSize').innerHTML = 'Size: ' + fileSize;
          document.getElementById('fileType').innerHTML = 'Type: ' + file.type;
          reader.onload = function(evt) {
        	  document.getElementById('image').innerHTML = '<img  src="' + evt.target.result + '" />';
            }
            reader.readAsDataURL(file);
        }
      }
      function uploadFile() {
        var fd = new FormData();
        fd.append("fileToUpload", document.getElementById('fileToUpload').files[0]);
        var xhr = new XMLHttpRequest();
        xhr.addEventListener("load", uploadComplete, false);
        xhr.addEventListener("error", uploadFailed, false);
        xhr.addEventListener("abort", uploadCanceled, false);
        xhr.open("POST", "http://120.24.181.248:8080/Dream/otherController/uploadDisplayImage.action?name=display");//修改成自己的接口
        xhr.send(fd);
      }
      function uploadProgress(evt) {
        if (evt.lengthComputable) {
          var percentComplete = Math.round(evt.loaded * 100 / evt.total);
          document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
        }
        else {
          document.getElementById('progressNumber').innerHTML = 'unable to compute';
        }
      }
      function uploadComplete(evt) {
        /* 服务器端返回响应时候触发event事件*/
        alert(evt.target.responseText);
      }
      function uploadFailed(evt) {
        alert("There was an error attempting to upload the file.");
      }
      function uploadCanceled(evt) {
        alert("The upload has been canceled by the user or the browser dropped the connection.");
      }
    </script>
    
     <style type="text/css">
     #image,
     .img,
     img {
     width: 210px;
     height: 90px;
     }
     #image {
     border: 1px solid #000;
     }
  </style>
</head>
<body>
  <form id="form1" enctype="multipart/form-data" method="post" action="Upload.aspx">
    <div class="row">
      <label for="fileToUpload">Select a File to Upload</label><br />
      <input type="file" name="fileToUpload" id="fileToUpload" onchange="fileSelected();"/>
    </div>
    <div id="fileName"></div>
    <div id="fileSize"></div>
    <div id="fileType"></div>
    <div id="image"></div>
    <div class="row">
      <input type="button" onclick="uploadFile()" value="Upload" />
    </div>

  </form>
</body>
</html>