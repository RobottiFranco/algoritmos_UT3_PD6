package com.example;

/**
 * Hello world!
 */
public final class App {

    private Lista<String> sucursales = new Lista<String>();

    public void agregar(String sucursal) {
        this.sucursales.insertar(new Nodo<String>(sucursal, sucursal));
    }

    public boolean quitarSucursal(Comparable sucursal) {
        return this.sucursales.eliminar(sucursal);
    }

    public Nodo<String> buscar(Comparable sucursal) {
        if (this.sucursales.buscar(sucursal) == null) {
            return null;
        }
        return this.sucursales.buscar(sucursal);
    }

    public String listarSucursales() {
        return this.sucursales.imprimir();
    }

    public String listarSucursales(String separador) {
        return this.sucursales.imprimir(separador);
    }

    public int cantidadDeSucursales() {
        return this.sucursales.cantElementos();
    }

    public boolean estaVacio() {
        return this.sucursales.esVacia();
    }

    public static void main(String[] args) {
        App d = new App();
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("suc1.txt");
        /* 1- */
        for (String string : archivo) {
            d.agregar(string);
        }
        System.out.println(d.sucursales.cantElementos());
        /* d- 107 */

        /* 2- */
        d.quitarSucursal("Chicago");
        System.out.println(d.sucursales.cantElementos());
        System.out.println(d.listarSucursales());
        /* c- Shenzhen */

        /* 3- */
        d = new App();
        archivo = ManejadorArchivosGenerico.leerArchivo("suc2.txt");
        for (String string : archivo) {
            d.agregar(string);
        }
        d.quitarSucursal("Shenzen");
        d.quitarSucursal("Tokio");
        System.out.println(d.sucursales.cantElementos());
        System.out.println(d.listarSucursales());
        /* ??? */

        /* 4- */
        d = new App();
        archivo = ManejadorArchivosGenerico.leerArchivo("suc3.txt");
        for (String string : archivo) {
            d.agregar(string);
        }
        System.out.println(d.listarSucursales(";_"));
        /* d- Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver;_ */
    }
}
