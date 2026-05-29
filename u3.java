import java.util.Scanner;
public class u3{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuantos invernaderos se van a auditar hoy?");
        int invernaderos = sc.nextInt();
        if(invernaderos==0){
            System.out.print("[ERROR] La cantidad debe ser mayor a cero.");
            System.out.print("¿Cuantos invernaderos se van a auditar hoy?");
            invernaderos = sc.nextInt();
        }
    for(int i=0;i<invernaderos;i++){
    
    }
    }       
}