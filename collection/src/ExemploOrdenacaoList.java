import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {

        List<Gato> gatos = new ArrayList<>(){{
            add(new Gato("Pipoca", 3, "Preto"));
            add(new Gato("Requeijão", 5, "Amarelo"));
            add(new Gato("Flocos", 1, "Preto e Branco"));
        }};

        System.out.println("---\tOrdem de Inserção\t---");
        System.out.println(gatos);
        System.out.println();

        System.out.println("---\t Ordem Aleatória\t ---");
        Collections.shuffle(gatos);
        System.out.println(gatos);
        System.out.println();

        System.out.println("---\t Ordem Natural (Nome)\t ---");
        Collections.sort(gatos);
        System.out.println(gatos);
        System.out.println();

        System.out.println("---\t Ordem Idade\t ---");
        Collections.sort(gatos, new Gato.ComparatorIdade());
        System.out.println(gatos);

        System.out.println("---\t Ordem Cor\t ---");
        Collections.sort(gatos, new Gato.ComparatorCor());

        System.out.println("---\t Ordem Nome/Cor/Idade\t ---");
        Collections.sort(gatos, new Gato.ComparatorNomeCorIdade());
        System.out.println(gatos);


    }
}

class Gato implements Comparable<Gato> {

    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public Gato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "\n Gato{" +
                " nome=' " + nome + '\'' +
                ", idade= " + idade +
                ", cor=' " + cor + '\'' +
                '}';
    }

    // Class que compara os nomes
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }

    // Class que compara a idade
    static class ComparatorIdade implements Comparator<Gato> {

        @Override
        public int compare(Gato g1, Gato g2) {
            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }


    public static class ComparatorCor implements Comparator<Gato>{
        
        @Override
        public int compare(Gato g1, Gato g2) {
            return g1.getCor().compareToIgnoreCase(g2.getCor());
        }
    }

    // Comparando por Nome, Cor, Idade
    static class ComparatorNomeCorIdade implements Comparator<Gato> {

        @Override
        public int compare(Gato g1, Gato g2) {
            // 1° Comparativo -- Critério de desempate
            int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
            if ( nome != 0) return nome;

            // 2° Comparativo -- Critério de desempate
            int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
            if( cor != 0 ) return cor;

            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }
}

