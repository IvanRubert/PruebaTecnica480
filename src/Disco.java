class Disco {

    protected String nombre;
    protected final int capacidad;
    protected int capacidadUsada;
    protected String[] almacenamiento;

    Disco(String prefijo, int id, int capacidad){
        nombre = prefijo+calcularNombre(id);
        this.capacidad = capacidad;
        capacidadUsada = 0;
        almacenamiento = new String[capacidad];

    }

    private String calcularNombre(int id){
        if (id < 10){return "00"+id;}
        else if (id<100) {return "0"+id;}
        else return String.valueOf(id);
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCapacidadUsada() {
        return capacidadUsada;
    }

    public String[] getAlmacenamiento() {
        return almacenamiento;
    }
}
