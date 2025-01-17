import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Disco> discos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = -1;
        do {
            try {
                System.out.println("0. Visual \n1. Terminal");
                System.out.print("Introduce una opción: ");
                opcion = input.nextInt();
                if (opcion > 1){throw new InputMismatchException();}
                input.nextLine();
            }catch (InputMismatchException e){
                input.nextLine();
                System.out.println("Introduce un valor correcto");
                opcion = -1;
            }
            if (opcion == 0){mainVisual();}
            else if (opcion == 1)mainTerminal(input);
        } while (opcion != 0 && opcion != 1);

    }

    private static void mainTerminal(Scanner input) {
        String dato;
        int opcion, capacidad;
        do {
            opcion = inputOpciones(input, "1. Crear disco \n2. Almacenar datos en discos \n3. Buscar datos en discos \n4. Mostrar información \n5. Salir");

            switch (opcion) {
                case 1: //Crear disco
                    int opcion2 = inputOpciones(input, "1.CD \n2.Disco duro \n3.Disco de vinilo \n4.BlueRay");
                    capacidad = inputInt(input, "¿Qué capacidad tiene?");

                    crearDisco(opcion2, capacidad, discos);
                    break;
                case 2: //Almacenar datos en disco
                    if (discos.size() != 0) {
                        do {
                            for (int i = 0; i < discos.size(); i++) {
                                System.out.println((i + 1) + ". " + discos.get(i).getNombre());
                            }

                            opcion2 = inputOpciones(input, "");
                            if (opcion2 > discos.size()){System.out.println("Selecciona una opción válida");}
                        }while (opcion2 > discos.size());
                        System.out.print("Introduce el dato de " + discos.get(opcion2 - 1).getNombre() + ": ");
                        dato = input.nextLine();

                        almacenarDatosTerminal(opcion2, discos, dato);
                    }else System.out.println("No hay ningun disco");
                    break;
                case 3: //Buscar datos en disco
                    if (discos.size() != 0) {
                        do {
                            for (int i = 0; i < discos.size(); i++) {
                                System.out.println((i + 1) + ". " + discos.get(i).getNombre());
                            }
                            opcion2 = inputOpciones(input, "");
                            if (opcion2 > discos.size()) {
                                System.out.println("Selecciona una opción válida");
                            }
                        }while (opcion2 > discos.size());
                        System.out.print("Introduce el dato a buscar en " + discos.get(opcion2 - 1).getNombre()+": ");
                        dato = input.nextLine();

                        buscarDatosTerminal(opcion2, discos, dato);
                    }else System.out.println("No hay ningun disco");
                    break;
                case 4: //Mostrar información de los discos
                    if (discos.size() != 0) {
                        do {
                            for (int i = 0; i < discos.size(); i++) {
                                System.out.println((i + 1) + ". " + discos.get(i).getNombre());
                            }
                            opcion2 = inputOpciones(input, "");
                            if (opcion2 > discos.size()) {System.out.println("Selecciona una opción válida");}
                        }while (opcion2 > discos.size());
                        System.out.println(discos.get(opcion2-1));

                    }else System.out.println("No hay ningun disco");
                    break;
                case 5:
                    System.out.println();
                    break;
                default:
                    System.out.println("Introduce una valor correcto");
            }
        } while (opcion != 5);
    }



    private static void mainVisual() {
        int opcion, opcion2, capacidad;
        String dato;
        String[] discosArray;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Selecciona una opción", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Crear discos", "Almacenar datos en disco", "Buscar datos en discos", "Mostrar información", "Salir"}, 3);
            switch (opcion){
                case 0: //Crear disco
                    opcion2 = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Crear disco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"CD", "Disco duro", "Disco de vinilo", "BlueRay"}, 0)+1;
                    capacidad = intJOP("¿Qué capacidad tiene?");
                    crearDisco(opcion2, capacidad, discos);
                    break;
                case 1: //Almacenar datos en disco
                    if (discos.size() != 0) {
                        discosArray = new String[discos.size()];

                        for (int i = 0; i < discos.size(); i++) {
                            discosArray[i] = (i + 1) + ". " + discos.get(i).getNombre();
                        }
                        opcion2 = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Almacenar datos en disco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, discosArray, 0) + 1;
                        if (opcion2 != 0) {
                            dato = JOptionPane.showInputDialog(null, "Introduce el dato de " + discos.get(opcion2 - 1).getNombre() + " ");
                            if (dato != null){almacenarDatosVisual(opcion2, discos, dato);}
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "No hay ningun disco", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2: //Buscar datos en discos
                    if (discos.size() != 0) {
                        discosArray = new String[discos.size()];
                        for (int i = 0; i < discos.size(); i++) {
                            discosArray[i] = (i + 1) + ". " + discos.get(i).getNombre();
                        }
                        opcion2 = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Almacenar datos en disco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, discosArray, 0) + 1;
                        if (opcion2 != 0) {
                            dato = JOptionPane.showInputDialog(null, "Introduce el dato a buscar en " + discos.get(opcion2 - 1).getNombre() + " ");
                            if (dato != null){buscarDatosVisual(opcion2, discos, dato);}
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "No hay ningun disco", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3: //Mostrar información del disco
                    if (discos.size() != 0) {
                        discosArray = new String[discos.size()];
                        for (int i = 0; i < discos.size(); i++) {
                            discosArray[i] = (i + 1) + ". " + discos.get(i).getNombre();
                        }
                        opcion2 = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Almacenar datos en disco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, discosArray, 0) + 1;
                        if (opcion2 != 0){
                            JOptionPane.showMessageDialog(null, discos.get(opcion2-1));
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "No hay ningun disco", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 4:
                case -1:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error. Introduce un valor válido", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }while (opcion != 4 && opcion != -1);
    }

    private static int intJOP(String mensaje) {
        int num;
        try {
            num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            if (num <= 0){throw new NumberFormatException();}
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Introduce un valor correcto", "Error", JOptionPane.ERROR_MESSAGE);
            num = intJOP(mensaje);
        }
        return num;
    }

    private static int inputOpciones(Scanner input, String menu) {
        int opcion = -1;
        System.out.println(menu);
        System.out.print("Introduce una opción: ");
        try {
            opcion = input.nextInt();
            if (opcion <=0){throw new InputMismatchException();}
            input.nextLine();
        }catch (InputMismatchException e){
            input.nextLine();
            System.out.println("Introduce un valor correcto");
            opcion = inputOpciones(input, menu);
        }
        return opcion;
    }

    private static int inputInt(Scanner input, String pregunta){
        int num = -1;
        System.out.print(pregunta+" ");
        try {
            num = input.nextInt();
            if (num <= 0){throw new InputMismatchException();}
        }catch (InputMismatchException e){
            input.nextLine();
            System.out.println("Introduce un valor correcto");
            num = inputInt(input, pregunta);
        }
        return num;
    }

    private static void crearDisco(int opcion, int capacidad, ArrayList<Disco> list) {
        switch (opcion){
            case 1: //Crear CD
                list.add(new CD(capacidad));
                break;
            case 2: //Crear disco duro
                list.add(new DiscoDuro(capacidad));
                break;
            case 3: //Crear disco de vinilo
                list.add(new LP(capacidad));
                break;
            case 4: //Crear BlueRay
                list.add(new BlueRay(capacidad));
                break;
            default:
                System.out.println("Error. Opcion incorrecta");
        }
    }

    private static void almacenarDatosTerminal(int opcion, ArrayList<Disco> lista, String dato) {
        switch (lista.get(opcion-1).getClass().getSimpleName()){
            case "CD":
                CD cd = (CD) lista.get(opcion-1);
                System.out.println(cd.almacenarDatos(dato));
                break;
            case "DiscoDuro":
                DiscoDuro hdd = (DiscoDuro) lista.get(opcion-1);
                System.out.println(hdd.almacenarDatos(dato));
                break;
            case "LP":
                LP lp = (LP) lista.get(opcion-1);
                System.out.println(lp.almacenarDatos(dato));
                break;
            case "BlueRay":
                BlueRay br = (BlueRay) lista.get(opcion-1);
                System.out.println(br.almacenarDatos(dato));
                break;
        }

    }

    private static void almacenarDatosVisual(int opcion, ArrayList<Disco> lista, String dato) {
        switch (lista.get(opcion-1).getClass().getSimpleName()){
            case "CD":
                CD cd = (CD) lista.get(opcion-1);
                JOptionPane.showMessageDialog(null, cd.almacenarDatos(dato));
                break;
            case "DiscoDuro":
                DiscoDuro hdd = (DiscoDuro) lista.get(opcion-1);
                JOptionPane.showMessageDialog(null, hdd.almacenarDatos(dato));
                break;
            case "LP":
                LP lp = (LP) lista.get(opcion-1);
                JOptionPane.showMessageDialog(null, lp.almacenarDatos(dato));
                break;
            case "BlueRay":
                BlueRay br = (BlueRay) lista.get(opcion-1);
                JOptionPane.showMessageDialog(null, br.almacenarDatos(dato));
                break;
        }

    }

    private static void buscarDatosTerminal(int opcion, ArrayList<Disco> lista, String dato) {
        switch (lista.get(opcion-1).getClass().getSimpleName()){
            case "CD":
                CD cd = (CD) lista.get(opcion-1);
                System.out.println(cd.buscarDatos(dato));
                break;
            case "DiscoDuro":
                DiscoDuro hdd = (DiscoDuro) lista.get(opcion-1);
                System.out.println(hdd.buscarDatos(dato));
                break;
            case "LP":
                LP lp = (LP) lista.get(opcion-1);
                System.out.println(lp.buscarDatos(dato));
                break;
            case "BlueRay":
                BlueRay br = (BlueRay) lista.get(opcion-1);
                System.out.println(br.buscarDatos(dato));
                break;
        }
    }

    private static void buscarDatosVisual(int opcion, ArrayList<Disco> lista, String dato) {
        switch (lista.get(opcion-1).getClass().getSimpleName()){
            case "CD":
                CD cd = (CD) lista.get(opcion-1);
                JOptionPane.showMessageDialog(null, cd.buscarDatos(dato));
                break;
            case "DiscoDuro":
                DiscoDuro hdd = (DiscoDuro) lista.get(opcion-1);
                JOptionPane.showMessageDialog(null, hdd.buscarDatos(dato));
                break;
            case "LP":
                LP lp = (LP) lista.get(opcion-1);
                JOptionPane.showMessageDialog(null, lp.buscarDatos(dato));
                break;
            case "BlueRay":
                BlueRay br = (BlueRay) lista.get(opcion-1);
                JOptionPane.showMessageDialog(null, br.buscarDatos(dato));
                break;
        }
    }
}
