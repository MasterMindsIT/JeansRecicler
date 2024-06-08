import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public void executMenu(){
        Utilidad util = new Utilidad();
        List<Product> lp = new ArrayList<>();
        ProductService ps = new ProductService(lp);
        fileService fs = new fileService();
        int op = -1;
        do {
            //util.clearScreen();
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
                //util.clearScreen();
                menuPrincipal();
                System.out.println("Opción incorrecta");
            }
        }while (test);
        return op;
    }
    static void menuPrincipal(){
        System.out.println("=======================================");
        System.out.println("1 Listar Productos");
        System.out.println("2 Editar Productos");
        System.out.println("3 Importar datos");
        System.out.println("=======================================");
    }

}
