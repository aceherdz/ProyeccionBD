package prybd.lib.ejemplo;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import prybd.lib.conjunto.Dependencia;
import prybd.lib.conjunto.Proyeccion;

final class ComoUsarla {

    public static void main(String[] args) {

        Set<String> atributos = new LinkedHashSet<>(Arrays.asList("C,D,E,I,J,K,L".split(",")));
        Set<Dependencia> dependencias = new LinkedHashSet<>();

        dependencias.add(generarDependencia("C-D"));
        dependencias.add(generarDependencia("E-J"));
        dependencias.add(generarDependencia("I-J"));
        dependencias.add(generarDependencia("J-K"));
        dependencias.add(generarDependencia("K-J"));
        dependencias.add(generarDependencia("D,K-L"));

        Proyeccion proyeccion = new Proyeccion(dependencias, atributos);

        Set<String> subCojuntoAttr = new LinkedHashSet<>(Arrays.asList("C,E,I,L".split(",")));

        System.out.println(proyeccion.obtenerProyeccion(subCojuntoAttr));

    }

    public static Dependencia generarDependencia(String linea) {

        if (!linea.isEmpty()) {
            String[] dependencia = linea.split("-");
            if (linea.endsWith(",")) {
                linea = linea.substring(0, linea.length() - 1);
            }

            if (!dependencia[0].isEmpty() && !dependencia[1].isEmpty()) {
                return new Dependencia(new LinkedHashSet<>(Arrays.asList(dependencia[0].split(","))),
                        new LinkedHashSet<>(Arrays.asList(dependencia[1].split(","))));
            }
        }

        return null;
    }

}
