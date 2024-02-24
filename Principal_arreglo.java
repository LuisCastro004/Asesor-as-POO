package tema_1_2;

/**
 *
 * @author kike
 */
public class Principal_arreglo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //crear el objeto para arreglo
        Arreglo objArr = new Arreglo();
        int clave;
        //insetar datos
        objArr.insertar(1, "Arturo", "Martinez", "Marzo");
        objArr.insertar(2, "Braulio", "Herrera", "Septiembre");
        objArr.insertar(3, "Gael", "Mota", "Marzo");
        objArr.insertar(4, "Alberto", "Partida", "Febrero");
        objArr.ordenamientoNom();
        System.out.println(objArr.visualizaArreglo());
        System.out.println("Los datos de Gael son: ");
        System.out.println(objArr.visualizaDatosCve("3"));
        System.out.println("Que personas se ingresaron eb \"Marzo\": ");
        System.out.println(objArr.visualizaDatosMes("Marzo"));
        //eliminar datos
        System.out.println("Eliminando a: \"Alberto\"");
        System.out.println("Eliminacion por clave");
        clave = objArr.buscarClave("4");
        if (clave >= 0) {
            objArr.eliminarCve(clave);
            System.out.println(objArr.visualizaArreglo() + "\n");
        } else {
            System.out.println("Dato no encontrado");
        }

        /*Opcion 1: Eliminar de un arreglo por primer apellido
        System.out.println("Eliminacion por apellido, opcion 1");
        objArr.eliminarPA("Herrera");
        System.out.println(objArr.visualizaArreglo() + "\n");*/
        /*Opcion 2:Eliminar de un arreglo por primer apelllido
        System.out.println("Eliminacion por apellido, opcion 2");
        System.out.println("Eliminando a: \"Gael\"");
        clave = objArr.buscarApellido("Mota");
        System.out.println("clave a eliminar: " + clave);
        if (clave >= 0) {
            objArr.eliminarCve(clave);
            System.out.println(objArr.visualizaArreglo() + "\n");
        } else {
            System.out.println("Dato no encontrado");
        }*/
    }

}
