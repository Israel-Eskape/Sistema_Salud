package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {
    private String  usuario    =""; //;= "postgres";       
    private String  clave      ="";// = "77israel77"; //se ingresa la contraseña de postgres de acuerdo a su configuración
    private String  servidor   ="";
	private String  baseDatos ;
    private static Connection conexion  = null;
 
    //CONSTRUCTOR
    //Recibe el nombre de la base de datos
		
	public ConectionDB(String baseDatos, String host,String usuario,String clave) {
		this.baseDatos = baseDatos;
                this.usuario = usuario;
                this.clave = clave;
		this.servidor="jdbc:postgresql://"+host+":"+ 5432+"/"+baseDatos;
		ConexionBd();
	}
	
	protected void ConexionBd(){
            
        //Registrar el driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("43 ERROR AL REGISTRAR EL DRIVER");
            System.exit(0); //parar la ejecución
        }
 
        //Establecer la conexión con el servidor
        try {
            conexion = DriverManager.getConnection(this.servidor,
                        this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("52 ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecución
        }
        System.out.println("Conectado a "+baseDatos);
    }
 
    //Devuelve el objeto Connection que se usará en la clase Controller
    public Connection getConexion() {
        return conexion;
    }
    
	public void closeConexion(){
		if ( getConexion() != null){
			try {
				getConexion().close();
			} catch(SQLException e){
				System.err.println("Error al cerrar la bd "+ e);
			}
		}
	}
}