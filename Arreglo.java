package tema_1_2;

public class Arreglo {

    private String arr[][];
    private int cve;
    private String nombre;
    private String primerAp;
    private String mes;

    public Arreglo() {
        this.arr = null;
    }

    public Arreglo(int c, String nom, String pap, String m) {
        this.cve = c;
        this.nombre = nom;
        this.primerAp = pap;
        this.mes = m;
    }

    /**
     * @return el arreglo
     */
    private String[][] getArr() {
        return this.arr;
    }

    /**
     * @param arr
     */
    private void setArr(String[][] arr) {
        this.arr = arr;
    }

    /**
     * @return la clave
     */
    private int getCve() {
        return this.cve;
    }

    /**
     * @param clave
     */
    private void setCve(int cve) {
        this.cve = cve;
    }

    /**
     * @return el nombre
     */
    private String getNombre() {
        return this.nombre;
    }

    /**
     * @param nom
     */
    private void setNombre(String nom) {
        this.nombre = nom;
    }

    /**
     * @return el primer apellido
     */
    private String getprimerAp() {
        return this.primerAp;
    }

    /**
     * @param p
     */
    private void setprimerAp(String p) {
        this.primerAp = p;
    }

    /**
     * @return el mes
     */
    private String getmes() {
        return this.mes;
    }

    /**
     * @param m
     */
    private void setmes(String m) {
        this.mes = m;
    }

    /**
     * El metodo insertar, se realiza en dos momentos de forma general: 1.
     * Cuando el arreglo esta vacio 2. Cuando el arreglo ya contiene algun
     * registro
     *
     * @param c :es la clave
     * @param nom :es el nombre
     * @param ap :primer apellido
     * @param m :es el mes
     */
    public void insertar(int c, String nom,
            String ap, String m) {
        String cve = Integer.toString(c);
        if (this.getArr() == null) {
            //el arreglo esta vacio
            //crear un arreglo vacio de 4 posiciones
            this.setArr(new String[1][4]);
            //se llena el arreglo principal
            this.arr[0][0] = cve;
            this.arr[0][1] = nom;
            this.arr[0][2] = ap;
            this.arr[0][3] = m;
        } else {
            //ya tiene alguna informacion, se anexa
            String tmp[][] = new String[this.getArr().length + 1][this.getArr()[0].length];
            System.arraycopy(this.getArr(), 0, tmp,
                    0, this.getArr().length);
            //asignar los datos al arreglo
            tmp[this.getArr().length][0] = cve;
            tmp[this.getArr().length][1] = nom;
            tmp[this.getArr().length][2] = ap;
            tmp[this.getArr().length][3] = m;
            //se guardan los datos
            this.setArr(tmp);
        }

    }

    /**
     * El metodo ordenamientoNom()
     */
    public void ordenamientoNom() {
        boolean ordenado = false;
        int cuentaI = 0;
        int i;
        while (!ordenado) {
            //recorer el arreglo
            for (i = 0; i < this.getArr().length - 1; i++) {
                if (this.getArr()[i][1].compareToIgnoreCase(
                        this.getArr()[i + 1][1]) > 0) {
                    //primera columna 0
                    String f = this.getArr()[i][0];
                    this.getArr()[i][0] = this.getArr()[i + 1][0];
                    this.getArr()[i + 1][0] = f;
                    //segunda columna 1
                    String z = this.getArr()[i][1];
                    this.getArr()[i][1] = this.getArr()[i + 1][1];
                    this.getArr()[i + 1][1] = z;
                    //tercera columna 2
                    String w = this.getArr()[i][2];
                    this.getArr()[i][2] = this.getArr()[i + 1][2];
                    this.getArr()[i + 1][2] = w;
                    //cuarta columna 3
                    String y = this.getArr()[i][3];
                    this.getArr()[i][3] = this.getArr()[i + 1][3];
                    this.getArr()[i + 1][3] = y;
                    cuentaI++;
                }
            }
            if (cuentaI == 0) {
                ordenado = true;
            }

            cuentaI = 0;
        }

    }

    /**
     * El metodo buscarClave
     *
     * @param cve : clave a buscar
     */
    public int buscarClave(String cve) {
        String s = "";
        int k;
        cve = cve.replaceAll(" ", "");
        if (this.getArr() == null) {
            return -1;//arreglo esta vacio
        } else {
            for (k = 0; k < this.getArr()[0].length; k++) {
                if (cve.equals(this.getArr()[k][0])) {
                    return k;//fue encontrado
                }
            }
        }
        return -2; //no encontrado
    }
    
  /**
     * El metodo buscarApellido
     *
     * @param ap : apellido a buscar
     */
    public int buscarApellido(String ap) {
        String s = "";
        int k;
        ap = ap.replaceAll(" ", "");
        if (this.getArr() == null) {
            return -1;//arreglo esta vacio
        } else {
            for (k = 0; k < this.getArr()[0].length; k++) {
                if (ap.equals(this.getArr()[k][2])) {
                    return k;//fue encontrado
                }
            }
        }
        return -2; //no encontrado
    }    

    /**
     * La funcion visualizaDatosCve realizar una busqueda de un dato, si fue
     * encontrado regresamos en una variable de texto los elementos.
     *
     * @param d: la clave a encontrar
     * @return un texto
     */
    public String visualizaDatosCve(String d) {
        String s = "";
        int i;
        if (this.getArr() == null) {
            return ""; //el arreglo esta vacio
        } else {
            for (i = 0; i < this.getArr().length; i++) {
                if (d.equals(this.getArr()[i][0])) {
                    s += "| Clave: " + this.getArr()[i][0] + " ";
                    s += "| Nombre: " + this.getArr()[i][1] + " ";
                    s += "| Primer Apellido: " + this.getArr()[i][2] + " ";
                    s += "| Mes: " + this.getArr()[i][3] + "|\n";
                    return s; //fue encontrado
                }
            }
        }
        if (s.isEmpty()) {
            s = "Clave no encontrada!!";
        }

        return s;
    }

    /**
     * La funcion visualizaDatosMes realizar una busqueda de un dato, si fue
     * encontrado regresamos en una variable de texto los elementos.
     *
     * @param d: la clave a encontrar
     * @return un texto
     */
    public String visualizaDatosMes(String d) {
        String s = "";
        int i;
        if (this.getArr() == null) {
            return ""; //el arreglo esta vacio
        } else {
            for (i = 0; i < this.getArr().length; i++) {
                if (d.equals(this.getArr()[i][3])) {
                    s += "| Clave: " + this.getArr()[i][0] + " ";
                    s += "| Nombre: " + this.getArr()[i][1] + " ";
                    s += "| Primer Apellido: " + this.getArr()[i][2] + " ";
                    s += "| Mes: " + this.getArr()[i][3] + "|\n";
                }
            }
        }
        if (s.isEmpty()) {
            s = "Clave no encontrada!!";
        }

        return s;
    }
    
    /**
     * Método eliminarCve, elimina una fila por su clave
     *
     * @param cve: la clave a eliminar
     */
    public void eliminarCve(int cve) {
        if (this.getArr().length == 1) {
            this.setArr(null); //el arreglo vacio
        } else {
            String tmp[][] = new String[this.getArr().length - 1][4];
            int j = 0, i;
            for (i = 0; i < this.getArr().length; i++) {
                if (  i != cve) {
                    tmp[j][0] = this.getArr()[i][0];
                    tmp[j][1] = this.getArr()[i][1];
                    tmp[j][2] = this.getArr()[i][2];
                    tmp[j][3] = this.getArr()[i][3];
                    j++;
                }
            }
            //actualizar el arreglo debido a que se elimino la
            //fila deseada
            this.setArr(tmp);
        }
    }
    
   /**
     * Método eliminarPA, elimina una fila por su clave
     *
     * @param ap: el primer apellido
     */
    public void eliminarPA(String ap) {
        if (this.getArr().length == 1) {
            this.setArr(null); //el arreglo vacio
        } else {
            String tmp[][] = new String[this.getArr().length - 1][4];
            int j = 0, i;
            for (i = 0; i < this.getArr().length; i++) {
                if (this.getArr()[i][2].compareTo(ap) != 0) {
                    tmp[j][0] = this.getArr()[i][0];
                    tmp[j][1] = this.getArr()[i][1];
                    tmp[j][2] = this.getArr()[i][2];
                    tmp[j][3] = this.getArr()[i][3];
                    j++;
                }
            }
            //actualizar el arreglo debido a que se elimino la
            //fila deseada
            this.setArr(tmp);
        }
    }
    
    /**
     * La función visualizaArreglo(), muestra todo el contenido del 
     * arreglo.
     * @return el arreglo
    */
    public String visualizaArreglo(){
        String s="";
        int f, c;
        if(this.getArr() != null){
            for(f=0; f < this.getArr().length; f++){
                for(c=0; c < this.getArr()[f].length; c++){
                    if(c == 0)
                        s+="| Clave : "+ this.getArr()[f][c]+" ";
                    if(c == 1)
                        s+="| Nombre : "+ this.getArr()[f][c]+" ";
                    if(c == 2)
                        s+="| Primer Apellido : "+ this.getArr()[f][c]+" ";
                    if(c == 3)
                        s+="| Mes : "+ this.getArr()[f][c]+" \n";                   
                }
            }
        }
        else{
            s = "No hay datos";
        }
        return s;
    }

}
