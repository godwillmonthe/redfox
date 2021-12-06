<html>
    <head>
        <title>Upload Image</title>
    </head>
    
    <body>
        
        <form action="uploadImage" method="post" enctype="multipart/form-data">
        	<input type="number" name="id" required><br>
            <input type="file" name="image" required="required"/><br/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>