import java.util.Scanner;
public class u3 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("¿Cuántos invernaderos se van a auditar hoy?: ");
    int invernaderos = sc.nextInt();
    while (invernaderos <= 0) {
    System.out.println("[ERROR] La cantidad debe ser mayor a cero.");
    System.out.print("¿Cuántos invernaderos se van a auditar hoy?: ");
    invernaderos = sc.nextInt();
    }
    double mGlobal = -100.0;
    int iMax = 0;
    for (int invActual = 1; invActual <= invernaderos; invActual++) {
    System.out.println(" AUDITANDO INVERNADERO #" + invActual);

    double sumaTemp = 0;
    int cuentaValidas = 0;
    int alertasCriticas = 0;
    double lSensor = 0;
    while (lSensor != -99) {
        System.out.print("-> Ingrese lectura del sensor (o -99 para finalizar): ");
        lSensor = sc.nextDouble();
        if (lSensor == -99) break;
            if (lSensor < -10.0 || lSensor > 50.0) {
        System.out.println("[ERROR] Lectura fuera de rango físico. Intente de nuevo.");
        } else {
        cuentaValidas = cuentaValidas + 1;
        sumaTemp = sumaTemp + lSensor;

        if (lSensor < 12.0) {
        System.out.println("   FRÍO  Calefactores encendidos.");
        } else if (lSensor <= 28.0) {
            System.out.println("    ÓPTIMO Estado estable.");
        } else {
        System.out.println("    CRÍTICO  ¡Extractores activados!");
        alertasCriticas = alertasCriticas + 1;
        }
    
        if (lSensor > mGlobal) {
        mGlobal = lSensor;
        iMax = invActual;
}
}
}
    System.out.println(" Resumen invernadero #" + invActual + ":");
    if (cuentaValidas == 0) {
        System.out.println("+ Promedio de temperatura: 0.0°C");
        System.out.println("+ Alertas críticas detectadas: 0");
        System.out.println("+ Diagnóstico: ESTADO DEL SECTOR: ESTABLE  SEGURO");
        } else {
        double promedioTemp = sumaTemp/cuentaValidas;
        System.out.println("Promedio de temperatura: " + promedioTemp + "°C");
        System.out.println("Alertas críticas detectadas: " + alertasCriticas);
        if (promedioTemp > 28.0) {
        System.out.println("Diagnóstico: ESTADO DEL SECTOR: PELIGRO POR SOBRECALENTAMIENTO");
        } else {
        System.out.println("Diagnóstico: [ESTADO DEL SECTOR: ESTABLE  SEGURO]");
        }
}
}
    System.out.println("  Reporte global de la jrnada");
    System.out.println("+ Total de invernaderos auditados: " + invernaderos);
    System.out.println("+ Pico de temperatura más alto detectado: " + mGlobal + "°C (Invernadero #" + iMax + ")");
}
}