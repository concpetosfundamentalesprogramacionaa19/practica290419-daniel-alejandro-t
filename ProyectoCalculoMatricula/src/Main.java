import java.util.Scanner;

/*

Presentar la solución en lenguaje Java

El costo de matricula de un estudiante es de $1330. Pero se debe considerar algunas situaciones:

- Si el estudiante es de Loja o Zamora, se descontara el 20% de la matrícula inicial.

- Si la edad del estudiante es mayor o igual a 17 y menor a 20, al costo de la matrícula inicial se le descontara 10%

- Si el estado civil del estudiante es casado se descontara el 5% del costo de matrícula inicial.

- Si el estudiante tiene una o varias cargas familiares se le descontara el 3% del costo de matrícula inicial.

Al costo final de matrícula se le debe agregar 2% por trámite administrativos.


Nota: los porcentajes deben estar en una clase y paquete diferente; para su importación en la clase Principal.


 */
import valores.Porcentajes;

public class Main {

    public static void main(String[] args) {
        // Crear un obj. de Scanner para recibir la entrada de datos
        Scanner entrada = new Scanner(System.in);
        // Declaracion de variables a usar: descuentoAplicado, ciudadNacimiento, edad, esCasado, numCargasFamiliares, total
        int descuentoAplicado;
        int edad;
        int numCargasFamiliares;
        float total;
        String ciudadNacimiento;
        Boolean esCasado;

        // Declaracion de constantes: valorInicialMatricula
        final float VALOR_INICIAL_MATRICULA = 1330;

        // Inicializamos descuentoAplicado en 0
        descuentoAplicado = 0;

        // Datos a pedir al estudiante:
        // Ciudad de de nacimiento
        System.out.println("Ingrese su ciudad de nacimiento: ");
        ciudadNacimiento = entrada.next().toLowerCase();    // Lo que ingrese el user lo pasa a minusculas

        // Edad
        System.out.println("Ingrese la edad del estudiante: ");
        edad = entrada.nextInt();

        // Consultar si es casado (variable esCasado)
        System.out.println("Esta usted casado? Escriba [SI o NO]");
        if (entrada.next().equalsIgnoreCase("si")){     // Si me ingresa si de escrito de cualquier forma...
            esCasado = true;
        }else{                                                       // Me ingreso un no...
            esCasado = false;
        }

        // Consultar numero de cargas familiares (variable numCargasFamiliares)
        System.out.println("Ingrese su numero de cargas familiares: ");
        numCargasFamiliares = entrada.nextInt();

        // Evaluar cada condicion del estudiante e ir modificando la variable descuentoAplicado:
        // Se evalua: ciudadNacimiento - Si el estudiante es de Loja o Zamora, se descontara el 20%
        if (ciudadNacimiento.equalsIgnoreCase("loja") || ciudadNacimiento.equalsIgnoreCase("zamora")){
            descuentoAplicado += Porcentajes.descLojaZamora;
        }
        // Se evalua: edad - Si la edad del estudiante es mayor o igual a 17 y menor a 20, descuento 10%
        if (edad >= 17 && edad < 20){
            descuentoAplicado += Porcentajes.descEdad;
        }

        // Se evalua: esCasado -  es casado se descontara el 5%
        if (esCasado){
            descuentoAplicado += Porcentajes.descCasado;
        }

        // Se evalua: numCargasFamiliares  - tiene una o varias cargas familiares se le descontara el 3%
        if (numCargasFamiliares >1){
            descuentoAplicado += Porcentajes.descCargaFamiliar;
        }



        // Calculamos el total reduciendo el descuento.
        total = VALOR_INICIAL_MATRICULA - ((VALOR_INICIAL_MATRICULA/100)*descuentoAplicado);

        // Se le debe agregar 2% por trámite administrativos
        total += ((total/100)*2);

        // Mostramos el total
        System.out.println("El total a apagar es de " + total + "$ de matricula.");

    }
}
