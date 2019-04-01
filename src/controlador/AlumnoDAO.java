package controlador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import modelo.Alumno;

public class AlumnoDAO {
	
	//metodos que permiten realizar las Altas, Bajas, Cambios y Consultas
	
	public boolean agregarAlumno(Alumno a) {
		String sql="INSERT INTO Alumnos VALUES('"+a.getNumControl()
		+"', '"+a.getNombre()
		+"', '"+a.getPrimerAp()
		+"', '"+a.getSegundoAp()
		+"', "+a.getSemetre()
		+", '"+a.getCarrera()+"')";
		ConexionBD conexion=new ConexionBD();
		return conexion.ejecutarInstruccion(sql);
	}
	
	public boolean eliminarAlumnos(String nc) {
		String sql ="DELETE FROM Alumnos WHERE NumControl='"+nc+"'";
		ConexionBD conexion=new ConexionBD();
		return conexion.ejecutarInstruccion(sql);
	}
	
	public boolean modificarAlumno(Alumno a) {
		String sql="UPDATE Alumnos SET "
		+"Nombres='"+a.getNombre()
		+"',PrimerAp='"+a.getPrimerAp()
		+"',SegundoAp='"+a.getPrimerAp()
		+"',Semestre='"+a.getSemetre()
		+"',Carrera='"+a.getCarrera()
		+"' WHERE NumControl='"+a.getNumControl()+"'";
		ConexionBD conexion=new ConexionBD();
		return conexion.ejecutarInstruccion(sql);
	}
	
	 //=================== BUSCAR UN REGISTRO ===================
	
		public Alumno buscarAlumno(String nC){
			Alumno alumno=new Alumno();
			String sql = "SELECT * FROM Alumnos WHERE NumControl='"+ nC+"'";
			//SELECT * FROM Alumnos WHERE NumControl='1';
			
			ConexionBD conexion = new ConexionBD();
			ResultSet rs=conexion.ejecutarConsultaRegistros(sql);
			try {
				rs.last();
				alumno.setNumControl(rs.getString(1));
				alumno.setNombre(rs.getString(2));
				alumno.setPrimerAp(rs.getString(3));
				alumno.setSegundoAp(rs.getString(4));
				alumno.setSemetre(rs.getByte(5));
				alumno.setCarrera(rs.getString(6));
			} catch (SQLException e) {
				System.out.println("No se encontro el registro");
				return null;
			}		
			return alumno;
		}
		//=================== BUSCAR MULTIPLES REGISTROS ===================
		
		public ArrayList <Alumno> buscarAlumnos(String filtro){
			ArrayList <Alumno> listaAlumnos=new ArrayList();
			String sql = "SELECT * FROM Alumnos WHERE";
			//RECORRER el ResultSet mientas haya registros
			ConexionBD conexion = new ConexionBD();
			ResultSet rs=conexion.ejecutarConsultaRegistros(sql);
			try {
				rs.first();
				while(!rs.isAfterLast()) {
				Alumno alumno = new Alumno();
				alumno.setNumControl(rs.getString(1));
				alumno.setNombre(rs.getString(2));
				alumno.setPrimerAp(rs.getString(3));
				alumno.setSegundoAp(rs.getString(4));
				alumno.setSemetre(rs.getByte(5));
				alumno.setCarrera(rs.getString(6));
				listaAlumnos.add(alumno);
				rs.next();
				}
			} catch (SQLException e) {
				
			}
			
			return listaAlumnos;
		}

}
