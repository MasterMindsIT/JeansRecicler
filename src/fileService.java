import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class fileService {
    Scanner sc = new Scanner(System.in);
    public List<Product> cargarDatos(List<Product> productList){
        String ruta = pathDirectory();
        String nameFile = "/ProductosImportados.csv";
        String fullFiles = ruta+nameFile;
        try {
            FileReader fr = new FileReader(fullFiles);
            BufferedReader br = new BufferedReader(fr);

            String data;
            String[] aux;
            while ((data = br.readLine()) != null) {
                aux = data.split(",");
                Product product=new Product();
                product.setItem(aux[0]);
                product.setPrice(aux[1]);
                product.setDescription(aux[2]);
                product.setCode(aux[3]);
                product.setSize(aux[4]);
                product.setBrand(aux[5]);
                product.setColor(aux[6]);
                productList.add(product);
            }
            fr.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }

    private String pathDirectory() {
        System.out.print("Ingrese la ruta(NO DEBE CONTENER ESPACIOS) donde se encuentra el archivo csv: ");
        return sc.next();
    }
}
