import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List<Product> lp = new ArrayList<>();
        ProductService ps = new ProductService(lp);
        fileService fs = new fileService();
        int op = -1;
        do {
            //clearScreen();
            menuPrincipal();
            op = chooseOption();
            if(op==1){
                ps.listProducts(lp);
            } else if (op==2) {
                ps.editProduct(lp);
            } else if (op==3) {
                fs.cargarDatos(lp);
            }
        }while (op!=4);
        System.out.println("Hasta la próxima");

    }

    private static int chooseOption() {
        boolean test=true;
        int op;
        do {
        System.out.print("Ingrese una opción: ");
        op = sc.nextInt();
        if(op>0 && op<5){
            test=false;
        }else {
            //clearScreen();
            menuPrincipal();
            System.out.println("Opción incorrecta");
        }
        }while (test);
        return op;
    }

    private static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            System.out.println(os);
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    static void menuPrincipal(){
        System.out.println("=======================================");
        System.out.println("1 Listar Productos");
        System.out.println("2 Editar Productos");
        System.out.println("3 Importar datos");
        System.out.println("=======================================");
    }
    
    
    
}