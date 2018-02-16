## AW - Tarea 9.2

Mostrar información individual de un restaurante
Tarea

Starting from the web project of restaurants made in Task 9.1,
  you have to implement a <b>User Login </b>and a <b>User Logout</b> .
  
  
     * To implement the login, you will need a login page to ask the name and password of the user.
            For security reasons, this information will be sent to the server as a POST message,
            and password will be a password type input. HTTPS protocol is also needed, 
            but we won’t implement it at the web server.
            
            * Para implementar el inicio de sesión, necesitará una página de inicio de sesión para preguntar el nombre y la contraseña del usuario.
                Por razones de seguridad, esta información se enviará al servidor como un mensaje POST,
                y la contraseña será una entrada de tipo de contraseña. Protocolo HTTPS también es necesario,
                pero no lo implementaremos en el servidor web.
            
            
     * The user and password information will be validated in a Servlet throw the USUARIS table, 
            where the password is stored in SHA256 format. The Servlet will query 
            if the username exists and if the SHA256 of the password given by the user and the 
            SHA256 database password are the same. If don’t, the server will return an error 
            that will be shown to the user, and if it’s all ok, we will set a session attribute 
            with an object that represents the user (username, name and email).
            
            * La información de usuario y contraseña se validará en un Servlet arrojar la tabla USUARIS,
                donde la contraseña se almacena en formato SHA256. El servlet consultará
                si el nombre de usuario existe y si el SHA256 de la contraseña dada por el usuario y el
                La contraseña de la base de datos SHA256 es la misma. Si no lo hace, el servidor devolverá un error
                eso se mostrará al usuario, y si todo está bien, estableceremos un atributo de sesión
                con un objeto que representa al usuario (nombre de usuario, nombre y correo electrónico).
            
            
     * If the user is logged in, the pages (index.jsp and restaurant.jsp) will show the username 
            and a logout button. To show the same HTML information in the JSP pages, 
            it’s very useful the use of the include JSP directive.
            
            * Si el usuario está conectado, las páginas (index.jsp y restaurant.jsp) mostrarán el nombre de usuario
                y un botón de cerrar sesión. Para mostrar la misma información HTML en las páginas JSP,
                es muy útil el uso de la directiva incluir JSP.
            
            
     * The logout button will call a logout servlet that will call the 
            request.getSession().invalidate() method to finish that session.
            
            * El botón de cierre de sesión llamará a un servlet de cierre de sesión que llamará al
                request.getSession (). Método invalidate () para finalizar esa sesión


SHA256 Java function:
________________________________________________________________________

public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();        
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch(Exception ex){
        throw new RuntimeException(ex);
    }
}
________________________________________________________________________

La base de datos de producción de "restaurantes" tiene los siguientes parámetros de conexión:

            SERVIDOR: 35.205.41.45
            PUERTO: 1521
            DB: XE
            USUARIO: usuario
            CONTRASEÑA: usuario
