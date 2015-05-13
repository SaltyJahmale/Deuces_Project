<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuwe taak</title>
    </head>
    <body>
        <form method="post" action="taak_toevoegen.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Maak een nieuwe taak</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Taak</td>
                        <td><input type="text" name="taak" value="" /></td>
                    </tr>
                    <tr>
                        <td>Omschrijving</td>
                        <td><input type="text" name="omschrijving" value="" /></td>
                    </tr>
                    <tr>
                        <td>Datum</td>
                        <td><input type="text" name="datum" value="" /></td>
                    </tr>
                    <tr>
                        <td>Categorie</td>
                        <td><input type="text" name="categorie" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        
                        <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>