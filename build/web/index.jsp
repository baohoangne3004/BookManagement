<%-- 
    Document   : index
    Created on : Apr 10, 2022, 12:02:17 AM
    Author     : HoangKM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Choose below option:</h1>
        <form action="addbook">
            <input type="submit" value="Add 5 book to DB" />
        </form>
        <form action="getbook">
            <div>
                <input type="radio" name="option" id="1" value="1" /> 
                <label for="1">Get books ordered by title and print to browser (or console)</label>
            </div>
            
            <div>
                <input type="radio" name="option" id="2" value="2" /> 
                <label for="2">Find book with max unit price.</label>
            </div>
            
            <div>
                <input type="radio" name="option" id="3" value="3" /> 
                <label for="3">Find summary of 3 cheapest books.</label>
            </div>
            <input type="submit" value="Show" />
        </form>
    </body>
</html>
