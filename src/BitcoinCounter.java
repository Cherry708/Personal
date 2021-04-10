import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BitcoinCounter {
    public static void main(String[] args) throws FileNotFoundException {

        int posicion = 2;
        String lineaContenido = "";
        String[] listaContenido;
        ArrayList<Float> listaCantidad = new ArrayList<>();


        File fichero = new File("D:/A_Proyectos/ProgramacionJava/Personal/report_MINING-BTC-EUR-MONTH_20200128-20210325.csv");
        Scanner scannerFichero = new Scanner(fichero);



        scannerFichero.nextLine();
        while (scannerFichero.hasNextLine()){
            lineaContenido = scannerFichero.nextLine();
            listaContenido = lineaContenido.split(",");
            listaCantidad.add(Float.parseFloat(listaContenido[posicion]));
        }

        System.out.println(listaCantidad.get(listaCantidad.size()-1));

    }
}
