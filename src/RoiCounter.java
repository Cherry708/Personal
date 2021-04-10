import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RoiCounter {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "";
        String campo = "";
        String contenido = "";
        String[] listaContenido;
        String[] listaCampos;
        double cantidad = 0;
        boolean ejecucion = true;
        boolean noEntrada = true;
        boolean noCampo = true;


        File fichero;
        Scanner inputFichero;

        Scanner inputUsuario = new Scanner(System.in);

        while (ejecucion) {
            boolean primeraVez = true;
            while (noEntrada) {

                try {

                    System.out.println("Introduce el nombre del archivo, debe estar alojado en este directorio:");
                    path = inputUsuario.nextLine();

                    fichero = new File(path);
                    inputFichero = new Scanner(fichero);

                    //Estas forman parte del formato de la hoja de cálculo y se han de ignorar
                    inputFichero.nextLine();
                    inputFichero.nextLine();


                    noEntrada = false;

                    while (noCampo){

                        try {
                            System.out.println("Introduce el nombre del campo: ");
                            campo = inputUsuario.nextLine();

                            contenido = inputFichero.nextLine();
                            listaCampos = contenido.split(",");

                            while (inputFichero.hasNextLine()) {
                                contenido = inputFichero.nextLine();
                                listaContenido = contenido.split(",");

                                if (listaCampos[5].equals(campo)) {
                                    cantidad = Double.parseDouble(listaContenido[5]) + cantidad;
                                    noCampo = false;
                                    ejecucion = false;
                                } else if (listaContenido[3].equals(campo)) {
                                    cantidad = Double.parseDouble(listaContenido[4]) + cantidad;
                                    noCampo = false;
                                    ejecucion = false;
                                } else if (primeraVez) {
                                    primeraVez = false;
                                }
                            }

                        }catch (NoSuchElementException e){}
                    }



            } catch(IllegalArgumentException e){
                System.out.println("Error de entrada.");
            } catch(FileNotFoundException e){
                System.out.println("No se ha encontrado el fichero.");
                System.out.println("Recuerda que:");
                System.out.println("1. El fichero debe estar en el mismo directorio que este código.");
                System.out.println("2. Se diferencinas mayúsculas de minúsculas.");
                System.out.println("3. Has de escribir la extensión del fichero.");
                System.out.println();
            }
        }

    }

            System.out.println(cantidad);
}
    }
