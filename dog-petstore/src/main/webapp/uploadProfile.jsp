<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Profile</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
     
</head>
<body>
<a href="uploadProfile.jsp"><img alt="" src="img/hello.gif" height="120px;">Upload</a>

 <a href="showDogProfile.do"><img alt="" src="img/show-dogs.png" height="120px;" style="margin-left: 200px;"> <span style="font-size: 20px;">Profiles</span></a>
<hr/>

	<span style="color: red;font-size: 16px;">${message}</span>
    <div style="margin-left: 30px;">
    <form action="uploadDog.do" method="post">
    	<table>
    	<tr>
    	<td>
        <div class="form-group">
            <label>Name  : </label>
            <input type="text" class="form-control"  name="name" placeholder="name" style="width: 300px;display: inline;margin-left: 40px;"/>
              <br/>   <br/>
        </div>
        <div class="form-group">
            <label>Email :</label>
            <input type="text" class="form-control"  name="email" placeholder="email" style="margin-left: 40px;width: 400px;display: inline;margin-right: 40px;" ng-model="email"/>
              <br/>   <br/>
        </div>
        
          <div class="form-group">
            <label>Breed :</label>
             <select name="breed" class="form-control" style="margin-left: 40px;width: 240px;display: inline;margin-right: 40px;">
             		<option>chihuahua</option>
             		<option>labrador</option>
             		<option>pit bull</option>
             		<option>pug</option>
             		<option>dalmatian</option>
             		<option>golden retriever</option>
             </select>
               <br/>   <br/>
        </div>
        
         <div class="form-group">
            <label>Color :</label>
             <select name="color" class="form-control" style="margin-left: 40px;width: 240px;display: inline;margin-right: 40px;">
             		<option>white</option>
             		<option>black</option>
             		<option>brown</option>
             		<option>red</option>
             		<option>yellow</option>
             </select>
             <label>price :</label>
             <input name="price" class="form-control" style="margin-left: 40px;width: 200px;display: inline;margin-right: 10px;">$
               <br/>   <br/>
        </div>
        
        
           <div class="form-group">
            <label>Photo :</label>
             <input type="file" name="photo" class="form-control" style="margin-left: 40px;width: 240px;display: inline;margin-right: 40px;">
               <br/>   <br/>
        </div>
        
          <div class="form-group">
            <label>Description :</label>
           	<textarea  class="form-control"  rows="" cols="" name="description"  class="form-control" style="width: 400px;">
           	</textarea>
               <br/>   <br/>
        </div>
          <button type="submit" class="btn btn-danger" style="display: inline;margin-right: 40px;">Upload Profile</button>
            <button type="button" class="btn btn-danger" style="display: inline;" ng-click="clearSearch();">Clear</button>
        </td>
         <td>
         		<img alt="" src="img/captain-america2.png"  width="300px;"/>
         </td>
        </tr>
        
        </table>
    </form>
    <br/><br/>
    </div>
</body>
</html>