package list;

import java.util.*;

public class ExemploList {

    public static void main(String[] args) {

        //List<Double> notas = new ArrayList<>(); -- Antes do Java 5
        //List<Double> notas = new ArrayList<Double>(); -- Geneics(jdk 5) - Diamonde Operator<>

        System.out.println("Crie uma lista e adicione as 5 notas: ");
        ArrayList<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(5.0);
        notas.add(5.5);
        notas.add(6.3);
        notas.add(10.0);
        System.out.println(notas);
        System.out.println(notas.toString());

        System.out.println();
        System.out.print("Exiba a posição da nota 7.0: " + notas.indexOf(5.5d) + "\n");

        System.out.println();
        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8.0);
        System.out.println(notas);

        System.out.println();
        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5.0),6.0 );
        System.out.println(notas);

        System.out.println();
        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5.0));

        System.out.println();
        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        for (Double nota : notas) {
            System.out.println(nota);
        }

        System.out.println();
        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas.toString());

        System.out.println();
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println();
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println();
        System.out.println("Exiba a soma dos valores");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("A soma: " + soma);

        System.out.println();
        System.out.println("Exiba a media das notas: " + soma/notas.size());

        System.out.println();
        System.out.println("Remova a nota 0: ");
        notas.remove(0);
        System.out.println(notas);

        System.out.println();
        System.out.println("Remova notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()) {
            Double next = iterator1.next();
            if(next < 7 ) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println();
        System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);

        System.out.println();
        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());
    }

}
