public class BlueRay extends Disco implements LecturaDisco {
    private static int id = 1;

    BlueRay(int capacidad){
        super("BRay", id, capacidad);
        id++;
    }

    @Override
    public int getCapacidadRestante() {
        return capacidad-capacidadUsada;
    }

    @Override
    public void giroDisco() {
        System.out.println("BlueRay girando...");
    }

    @Override
    public String almacenarDatos(String dato) {
        if (capacidadUsada != capacidad){
            giroDisco();
            System.out.println("Almacenando en el blueRay mediante el laser...");
            almacenamiento[capacidadUsada] = dato;
            capacidadUsada++;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return this.toString();
        }else return "El blueRay esta completo y no puede almacenar mas datos";


    }

    @Override
    public String buscarDatos(String dato) {
        int i = 0;
        boolean encontrado = false;
        giroDisco();
        while (i != capacidadUsada && !encontrado){
            if (almacenamiento[i].equals(dato)) {encontrado = true;}
            if (!encontrado){i++;}
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (encontrado){return "El valor \""+dato+"\" se encuentra en la posición "+i+" del blueRay";}
        else return "No se encuentra el valor \""+dato+"\" no se ha encontrado en el blueRay";
    }

    @Override
    public String toString() {
        String contenido = "[";
        for (int i = 0; i < capacidadUsada; i++){
            if (i == 0){contenido += "\""+almacenamiento[i]+"\"";}
            else {
                contenido += ", \"" + almacenamiento[i]+"\"";
            }
        }
        contenido += "]";
        String linea = "*************************";
        return linea+"\nNombre: "+nombre+"\nCapacidad: "+capacidad+"\nContenido: "+contenido+"\nTipo de disco: BlueRay\n"+linea;
    }
}
