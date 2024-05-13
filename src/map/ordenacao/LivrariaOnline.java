package map.ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> acervo;

    public LivrariaOnline(){
        acervo = new HashMap<String, Livro>();
    }

    public void adicionarLivro(String link, Livro livro){
        acervo.put(link, livro);
    }

    public void removerLivro(String titulo){
        Map.Entry<String, Livro> livroARemover = null;
        if (!acervo.isEmpty()) {
            for (Map.Entry<String, Livro> livro : acervo.entrySet()) {
                if (livro.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    livroARemover = livro;
                    break;
                }
            }
            acervo.remove(livroARemover.getValue());
        }else{
            throw new RuntimeException("Map vazio!");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> acervoParaOdenarPorPreco = new ArrayList<>(acervo.entrySet());
        Collections.sort(acervoParaOdenarPorPreco, new OrdenarLivroPorPreco());

        Map<String, Livro> acervoOdenadoPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> livro : acervoParaOdenarPorPreco){
            acervoOdenadoPorPreco.put(livro.getKey(), livro.getValue());
        }

        return acervoOdenadoPorPreco;
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor){
        List<Livro> livrosDoAutor = new ArrayList<>();

        if (!acervo.isEmpty()) {
            for (Map.Entry<String, Livro> livro : acervo.entrySet()) {
                if (livro.getValue().getAutor().equalsIgnoreCase(autor)) {
                    livrosDoAutor.add(livro.getValue());
                }
            }
            return livrosDoAutor;

        }
        throw new RuntimeException("Map vazio!");
    }

    public Livro obterLivroMaisCaro(){
        Livro livroMaisCaro = null;

        List<Map.Entry<String, Livro>> acervoParaOdenarPorPreco = new ArrayList<>(acervo.entrySet());
        Collections.sort(acervoParaOdenarPorPreco, new OrdenarLivroPorPreco());
        Collections.reverse(acervoParaOdenarPorPreco);

        for (Map.Entry<String, Livro> livro : acervoParaOdenarPorPreco){
            livroMaisCaro = livro.getValue();
            break;
        }

        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato(){
        Livro livroMaisBarato = null;

        List<Map.Entry<String, Livro>> acervoParaOdenarPorPreco = new ArrayList<>(acervo.entrySet());
        Collections.sort(acervoParaOdenarPorPreco, new OrdenarLivroPorPreco());

        for (Map.Entry<String, Livro> livro : acervoParaOdenarPorPreco){
            livroMaisBarato = livro.getValue();
            break;
        }

        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: " + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        System.out.println(livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa));

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.acervo);
    }
}
