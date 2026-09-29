package EP;

public class Estudante extends Personagem { //HERANÇA
    
    private Mochila mochilaDoEstudante;

    public Estudante(String nome) {
        super(nome, 100, 20);
        this.mochilaDoEstudante = new Mochila();
    }

    public Mochila getMochila() {
        return mochilaDoEstudante;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca usando lógica de programação contra " + alvo.getNome() + "!");
        alvo.receberDano(getPoderDeAtaque());
        System.out.println("-> " + alvo.getNome() + " sofreu " + getPoderDeAtaque() + " de dano. (Vida restante: " + alvo.getPontosDeVida() + ")");
    }
}
