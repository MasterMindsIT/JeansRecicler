import java.util.List;
import java.util.Scanner;

public class ProductService {
    Scanner sc = new Scanner(System.in);
    private List<Product> listProducts;

    public ProductService(List<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public void listProducts(List<Product> listProducts){
        for (Product product : listProducts) {
            System.out.println(product.toString());
        }
    }
    public void editProduct(List<Product> listProducts){
        if(!listProducts.isEmpty()) {
            int position;
            do {
                String code = selectProduct();
                position = obtainProduct(listProducts, code);
            } while (position < 0);
            Product products = listProducts.get(position);
            viewItemProducts(products);
            int op = selectAttributeProduct();
            if(op>0 && op<7){
            String newValue = newValueAttributeProduct();
            if (op == 1) {
                products.setItem(newValue);
            } else if (op == 2) {
                products.setPrice(newValue);
            } else if (op == 3) {
                products.setDescription(newValue);
            } else if (op == 4) {
                products.setCode(newValue);
            } else if (op == 5) {
                products.setSize(newValue);
            } else if (op == 6) {
                products.setBrand(newValue);
            } else if (op == 7) {
                products.setColor(newValue);
            }
            listProducts.add(position, products);
            }
        }else{
            System.out.println("No existe ningún producto para editar;");
        }
    }

    private String newValueAttributeProduct() {
        String valor;

        System.out.print("Ingrese el nuevo valor: ");
        valor = sc.next();

        return valor;
    }

    private int selectAttributeProduct() {
        System.out.print("SELECCIONE EL ITEM A MODIFICAR INGRESNDO EL NÚMERO,(un número distinto para salir): ");
        return sc.nextInt();
    }

    private void viewItemProducts(Product products) {
        System.out.println("DESCRIPCIÓN DEL PRODUCTO");
        System.out.println("1.-"+products.getItem());
        System.out.println("2.-"+products.getPrice());
        System.out.println("3.-"+products.getDescription());
        System.out.println("4.-"+products.getCode());
        System.out.println("5.-"+products.getSize());
        System.out.println("6.-"+products.getBrand());
        System.out.println("7.-"+products.getColor());

    }

    private int obtainProduct(List<Product> listProducts, String code) {
        int indProduct = -1;
        Product findProduct;
        for (int i=0; i<listProducts.size();i++) {
            findProduct = listProducts.get(i);
            if(findProduct.getCode().equals(code)){
                return i;
            }
        }
        return indProduct;
    }

    private String selectProduct() {
        System.out.print("Ingrese el código del producto a editar: ");
        return sc.nextLine();
    }
}
