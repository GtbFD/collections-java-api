package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livros;

    private CatalogoLivros(){
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public void pesquisarPorAutor(String autor){
        List<Livro> livrosBuscados = new ArrayList<>();
        if (!livros.isEmpty()) {
            for (Livro livro : livros) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosBuscados.add(livro);
                }
            }
            System.out.println(livrosBuscados);
        }
    }

    public void pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosBuscados = new ArrayList<>();

        if (!livros.isEmpty()){
            for (Livro livro : livros){
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal){
                    livrosBuscados.add(livro);
                }
            }
            System.out.println(livrosBuscados);
        }
    }

    public void pesquisarPorTitulo(String titulo){
        Livro livroBuscado = null;
        if (!livros.isEmpty()) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livroBuscado = livro;
                    break;
                }
            }
            System.out.println(livroBuscado);
        }
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);

        catalogoLivros.pesquisarPorAutor("Autor 4");

        catalogoLivros.pesquisarPorIntervaloAnos(2020, 2021);

        catalogoLivros.pesquisarPorTitulo("Livro 1");
    }
}
