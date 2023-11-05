
package interfaces;

import alumnos.Alumno;

//Interface Dao con los metodos abstractos los cuales se implementaran en la clase DAOAlumnoImplementacion
public interface DAOAlumno {
    
    public void registar(Alumno alumno);
    public void modificar(Alumno alumno);
    public void eliminar(Alumno alumno);
    public void buscar(Alumno alumno);
    
    
}
