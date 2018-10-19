package ui;

import tl.Gestor;

import java.util.Scanner;

public class Main {

    static Gestor migestor = new Gestor();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        migestor = new Gestor();

        System.out.println("1-Registrar persona fisica \n 2-Registrar persona juridica \n 3-Listar persona fisicas \n 4- Listar personas juridicas \n 5-Listar personas \n 6-Salir");

        int opcion = sc.nextInt();

        while (opcion < 6) {

            switch (opcion) {

                case 1:
                    registrarFisica();
                    break;

                case 2:
                    registrarJuridica();
                    break;
                case 3:
                    verFisico();
                    break;
                case 4:
                    verJuridico();
                    break;
                case 5:
                    verPersonas();
                    break;
                default:
                    System.out.println("Vuelva pronto");
            }

            System.out.println("1-Registrar persona fisica \n 2-Registrar persona juridica \n 3-Listar persona fisicas \n 4- Listar personas juridicas \n 5-Salir");
            opcion = sc.nextInt();
        }
        System.out.println("Vuelva pronto");
    }

    public static void registrarFisica(){
        Scanner sc = new Scanner(System.in);

        String nombre;
        String identificacion;
        String apellido;
        String estadoCivil;

        System.out.println("Digite el nombre");
        nombre = sc.nextLine();

        System.out.println("Digite la identificacion");
        identificacion = sc.nextLine();

        System.out.println("Digite el apellido");
        apellido = sc.nextLine();

        System.out.println("Digite el estado civil");
        estadoCivil = sc.nextLine();

        migestor.insertarPersonaFisica(nombre, identificacion, apellido, estadoCivil);
    }

    public static void registrarJuridica(){
        Scanner sc = new Scanner(System.in);

        String nombre;
        String identificacion;
        String responsable;
        String industria;

        System.out.println("Digite el nombre");
        nombre = sc.nextLine();

        System.out.println("Digite la identificacion");
        identificacion = sc.nextLine();

        System.out.println("Digite el nombre del responsable");
        responsable = sc.nextLine();

        System.out.println("Digite el nombre de la industria");
        industria = sc.nextLine();

        migestor.insertarPersonaJuridica(nombre, identificacion, responsable, industria);
    }

    public static void verFisico(){
        String[] datos;
        datos = migestor.getListaFisica();
        for(String data : datos){
            System.out.println(data);
        }
    }

    public static void verJuridico(){
        String[] datos;
        datos = migestor.getListaJuridica();
        for(String data : datos){
            System.out.println(data);
        }
    }

    public static void verPersonas(){
        String[] datos;
        datos = migestor.getListaPersonas();
        for(String data : datos){
            System.out.println(data);
        }
    }
}
