<!DOCTYPE html>
<%@page import="com.petstore.web.controller.model.DogProfileEntity"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Profile</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
     <style type="text/css">
    .bs-example{
    	margin-left:120px;
    	
    }
    
    .parentimage { 
	width: 60px;
	height: 60px; 
	-webkit-transition: all .3s ease-out;
	-moz-transition: all .3s ease-out;
	-o-transition: all .3s ease-out;
	transition: all .3s ease-out;
} 
.parentimage:hover {
	-moz-transform: scale(2);
	-webkit-transform: scale(2);
	-o-transform: scale(2);
	-ms-transform: scale(2);
	transform: scale(2);
} 
    
</style>
</head>
<body>
<a href="uploadProfile.jsp"><img alt="" src="img/hello.gif" height="120px;">Upload</a>

<a href="showProfiles.do"><img alt="" src="img/show-dogs.png" height="120px;" style="margin-left: 200px;"> <span style="font-size: 20px;">Profiles</span></a>
<hr/>

	<span style="color: red;font-size: 16px;">${message}</span>
  <div class="bs-example">
    <table class="table table-bordered" style="width: 90%;">
        <thead>
            <tr style="background-color: rgba(1, 171, 114, 0.18);">
                <th>SNo</th>
                <th>Name</th>
                <th>Email</th>
                <th>Breed</th>
                <th>Color</th>
                <th>Price</th>
                  <th>Photo</th>
                  <th>Action</th>
            </tr>
        </thead>
        
        <%
        List<DogProfileEntity>  dogProfileList=(List<DogProfileEntity>)request.getAttribute("dogProfileList");
        int count=1;
        for(DogProfileEntity entity:dogProfileList) {
        %>
        <tbody>
            <tr>
                <td><%=count++ %></td>
                <td><%=entity.getName() %></td>
                <td><%=entity.getEmail() %></td>
                  <td><%=entity.getBreed() %></td>
                      <td><%=entity.getColor() %></td>
                   <td><%=entity.getPrice() %></td>
           <td>
            <a href="donwnloadImage.do?did=<%=entity.getDid() %>"> 
        		   <img src="findDogImageByDid.do?did=<%=entity.getDid() %>" height="60px;" class="parentimage" >
           </a>
            
             <a href="javascript:" id="addEmployee"  data-toggle="modal" data-target="#uploadImagePopup"> <img src="img/change.png" height="20px;"/></a>
           </td>
           
              <td>
              <a href="deleteDogByEmail.do?email=<%=entity.getEmail() %>">
              <img alt="" src="img/delete.png" height="24px;">
               </a>
               /
              <img alt="" src="img/edit1.png" height="24px;">
              </td>
            </tr>
            <%
            }
        %>
        </tbody>
    </table>
</div>


        <!-- Modal -->
  <div class="modal fade" id="uploadImagePopup" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">
          <img src="img/addPro.png"/> 
          Upload  Image Popup	</h4>
        </div>
        <div class="modal-body">
        <form  action="changeDogImage.do" method="post" name="uploadImageForm"  id="uploadImageForm"  enctype="multipart/form-data">
          <input type="hidden" name="did"/>	
          <div class="form-group">
            <label>Image :</label>
            <input type="file" class="form-control" id="image" placeholder="Select Image"  name="photo">
        </div>
    <div class="modal-footer">
          <button type="submit" class="btn btn-danger" data-dismiss="modal"  id="uploadImageButton">Upload Image</button>
        </div>
         </form>
        </div>
      </div>
      
    </div>
  </div>
</body>
</html>