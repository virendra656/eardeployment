<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EJB3 JPA Jboss - codesstore.blogspot.com</title>
    </head>
    <body>

        <form action="ManageStudentServlet" method="POST">

            <table border="0" width="100%">
                <tr>
                    <td colspan="3">  ${message}</td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td>:</td>
                    <td><input type="text" name="fname" value="" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td>:</td>
                    <td><input type="text" name="lname" value="" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>:</td>
                    <td><input type="text" name="email" value="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="Add" name="Add" /></td>
                </tr>
            </table>

        </form>

    </body>
</html>