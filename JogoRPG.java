//https://www.youtube.com/watch?v=k4cDJkedAVk
// Elisa Chagas Figueiredo    |  RA: 845357
// Gustavo Blanco de Godoi    |  RA: 845972
// Gabriela Andrade Oliveira  |  RA: 845967
// Julia Mourão Gonçalves     |  RA: 845151
package EP;
import java.io.*;
import java.util.Scanner;

public class JogoRPG {
    
    private static final String ARQUIVO_SAVE = "save_progresso.dat";

    public static void main(String[] args) {
        Scanner leitorDeTeclado = new Scanner(System.in);
        Estudante jogador = null;

        System.out.println("===========================================");
        System.out.println("  SOBREVIVÊNCIA NO CAMPUS SOROCABA - RPG   ");
        System.out.println("===========================================");
        System.out.println("1. Iniciar Novo Semestre (Novo Jogo)");
        System.out.println("2. Retomar Semestre (Carregar Jogo)");
        System.out.print("Sua escolha: ");
        
        String opcaoEscolhida = leitorDeTeclado.nextLine();

        if (opcaoEscolhida.equals("2")) {
            jogador = carregarJogo();
        }

        if (jogador == null) {
            System.out.print("Digite o nome do seu estudante: ");
            String nome = leitorDeTeclado.nextLine();
            jogador = new Estudante(nome);
            
            ItemCura pelucia = new ItemCura("Pelúcia do Frederico (Acalma os nervos)", 40);
            CaixaSurpresa<ItemCura> caixaInicial = new CaixaSurpresa<>(pelucia);
            
            jogador.getMochila().guardarItem(caixaInicial.abrirCaixa());
        }

        System.out.println("\nRespire fundo, " + jogador.getNome() + ". O professor acabou de liberar a lista de exercícios!");
        Inimigo bugMips = new Inimigo("Bug terrível de MIPS Assembly", 50, 15);

        while (jogador.estaVivo() && bugMips.estaVivo()) {
            System.out.println("\n=== TURNO DE BATALHA ===");
            System.out.println("1. Atacar o código (Resolver o Bug)");
            System.out.println("2. Procurar item na mochila");
            System.out.println("3. Salvar progresso e fechar IDE (Sair)");
            System.out.print("O que você faz? ");
            
            String acao = leitorDeTeclado.nextLine();
            System.out.println(); // Pula linha

            if (acao.equals("1")) {
                jogador.atacar(bugMips);
                if (bugMips.estaVivo()) {
                    bugMips.atacar(jogador);
                }
            } else if (acao.equals("2")) {
                try {
                    
                    ItemUsavel item = jogador.getMochila().pegarItem();
                    item.usar(jogador);
                    
                    if (bugMips.estaVivo()) {
                        bugMips.atacar(jogador);
                    }
                } catch (MochilaVaziaException erro) {
                    System.out.println("Opa! " + erro.getMessage());
                }
            } else if (acao.equals("3")) {
                salvarJogo(jogador);
                System.out.println("Saindo do jogo...");
                leitorDeTeclado.close();
                return; // Encerra o programa
            } else {
                System.out.println("Opção inválida! Você perdeu o foco por um segundo.");
            }
        }

        System.out.println("\n===========================================");
        if (jogador.estaVivo()) {
            System.out.println("VITÓRIA! O código compilou perfeitamente.");
            System.out.println("Você venceu o " + bugMips.getNome() + "!");
        } else {
            System.out.println("GAME OVER. O erro de compilação te venceu.");
            System.out.println("Dica: Estude mais Estrutura de Dados e tente novamente.");
        }
        
        leitorDeTeclado.close();
    }

    private static void salvarJogo(Estudante estudante) {
        try {
            FileOutputStream arquivoDeSaida = new FileOutputStream(ARQUIVO_SAVE);
            ObjectOutputStream gravadorDeObjeto = new ObjectOutputStream(arquivoDeSaida);
            
            gravadorDeObjeto.writeObject(estudante);
            gravadorDeObjeto.close();
            
            System.out.println("Progresso salvo com sucesso!");
        } catch (IOException erroDeEntradaESaida) {
            System.out.println("Falha ao salvar o jogo: " + erroDeEntradaESaida.getMessage());
        }
    }

    private static Estudante carregarJogo() {
        File arquivo = new File(ARQUIVO_SAVE);
        if (!arquivo.exists()) {
            System.out.println("Nenhum arquivo de save encontrado. Vamos começar do zero.");
            return null;
        }

        try {
            FileInputStream arquivoDeEntrada = new FileInputStream(ARQUIVO_SAVE);
            ObjectInputStream leitorDeObjeto = new ObjectInputStream(arquivoDeEntrada);
            
            Estudante estudanteSalvo = (Estudante) leitorDeObjeto.readObject();
            leitorDeObjeto.close();
            
            System.out.println("Progresso carregado com sucesso! Bem-vindo de volta.");
            return estudanteSalvo;
            
        } catch (IOException | ClassNotFoundException erro) {
            System.out.println("Erro ao carregar o jogo salvo: " + erro.getMessage());
            return null;
        }
    }
}
