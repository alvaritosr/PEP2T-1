import java.util.Scanner;

public class PEP2T_1_ASR
{
    // Variables de clase para el saldo y el tope
    static float saldo;
    static float tope;

    // Constructor vacío
    PEP2T_1_ASR() {}

    // Método para mostrar el encabezado del programa
    public void start()
    {
        System.out.println("\t\tPROGRAMA CAJERO AUTOMATICO");
        System.out.println("\t\t\tMenú de opciones\n");
    }

    // Método para mostrar el menú de opciones
    public void menu()
    {
        System.out.println("1º) Retirada de dinero");
        System.out.println("2º) Ingreso de dinero");
        System.out.println("3º) Salir\n");
        System.out.print("Seleccione una opcion: ");
    }

    // Método para verificar y mostrar el saldo actual
    public void verificar()
    {
        System.out.println("Su saldo actual es de " + saldo + "€");
    }

    // Método para verificar y mostrar el tope establecido
    public void tope()
    {
        System.out.println("Tiene establecido ahora un tope de " + tope);
    }

    // Método para realizar una retirada de dinero
    public void opcion1()
    {
        Scanner input = new Scanner(System.in);
        verificar();
        System.out.print("Teclee dinero a retirar: ");
        float retirado = input.nextFloat();
        if (retirado > tope)
        {
            tope();
            System.out.println("Su saldo actual es de " + saldo + "€\n");
        }
        else
        {
            System.out.println("Usted retiró " + retirado);
            saldo -= retirado;
            System.out.println("Su saldo actual es de " + saldo + "€\n");
        }
    }

    // Método para realizar un ingreso de dinero
    public void opcion2()
    {
        Scanner input = new Scanner(System.in);
        verificar();
        System.out.print("Teclee dinero a ingresar: ");
        float ingreso = input.nextFloat();
        System.out.println("Usted ingresó " + ingreso + "€");
        saldo += ingreso;
        System.out.println("Su saldo actual es de " + saldo + "€\n");
    }

    // Método para salir del programa
    public void opcion3()
    {
        System.out.println("Saliendo del programa.");
        System.exit(0);
    }

    // Método principal que inicia el programa
    public static void main(String[] args)
    {
        // Obtener saldo y tope desde los argumentos de la línea de comandos
        saldo = Float.parseFloat(args[0]);
        tope = Float.parseFloat(args[1]);

        Scanner input = new Scanner(System.in);
        PEP2T_1_ASR cajero = new PEP2T_1_ASR();

        // Bucle infinito que muestra el menú y procesa la opción seleccionada
        while (true)
        {
            cajero.start();
            cajero.menu();
            int opcion = input.nextInt();
            switch (opcion)
            {
                case 1:
                    cajero.opcion1();
                    break;
                case 2:
                    cajero.opcion2();
                    break;
                case 3:
                    cajero.opcion3();
                    break;
                default:
                    System.out.println("Esta opción no es válida");
            }
        }
    }
}
