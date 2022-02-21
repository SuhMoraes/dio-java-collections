package set;


import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de episódio);

Série 1 = Nome: Agentes da SHIELDS, genero: fantasia, tempoEpisodio: 60
Série 2 = nome: This Is Us, genero: drama, tempoEpisodio: 60
Série 3 = nome: Brooklin 99, genero: comédia, tempoEpisodio: 25

 */
public class OrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("---\tOrdem aleatória\t---");
        Set<Serie> series = new HashSet<>() {{
            add(new Serie("Agentes da SHIELDS", "fantasia", 60));
            add(new Serie("This Is Us","drama", 60));
            add(new Serie("Brooklin 99", "comédia", 25));
        }};

        for(Serie serie: series) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("---\tOrdem de inserção\t---");
        Set<Serie> series2 = new LinkedHashSet<>() {{
            add(new Serie("Agentes da SHIELDS", "fantasia", 60));
            add(new Serie("This Is Us","drama", 60));
            add(new Serie("Brooklin 99", "comédia", 25));
        }};

        for(Serie serie: series2) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem Natural\t---");
        Set<Serie> series3 = new TreeSet<>(series);
        for(Serie serie: series3) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> series4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        // Adicionando elementos dentro do set
        series4.addAll(series);

        for(Serie serie: series4) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{\n" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Serie serie = (Serie) o;

        if (nome != null ? !nome.equals(serie.nome) : serie.nome != null) return false;
        if (genero != null ? !genero.equals(serie.genero) : serie.genero != null) return false;
        return tempoEpisodio != null ? tempoEpisodio.equals(serie.tempoEpisodio) : serie.tempoEpisodio == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (tempoEpisodio != null ? tempoEpisodio.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Serie serie) {

        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if( tempoEpisodio !=0 ) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());
    }


}
