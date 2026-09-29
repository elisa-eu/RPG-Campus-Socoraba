🎓 Sobrevivência no Campus Sorocaba - RPG

Um jogo de RPG em texto desenvolvido em Java para a matéria de Programação Orientada a Objetos da minha faculdade.

Usei:
- Herança e Classes Abstratas: A arquitetura baseia-se na superclasse abstrata `Personagem`, que encapsula atributos comuns (pontos de vida, poder de ataque) e obriga a implementação do método `atacar()`. Esta classe é estendida pelas subclasses `Estudante` e `Inimigo`, dessa forma consigo reaproveitar o código.
- Polimorfismo e Interfaces: A interface `ItemUsavel` dita o contrato para os itens do jogo, sendo implementada pela classe `ItemCura`. O polimorfismo também se faz presente na sobrescrita (`@Override`) do método de ataque, que possui comportamentos e mensagens exclusivas para estudantes e inimigos.
- Tipos Genéricos (Generics):Implementação da classe `CaixaSurpresa<T>`, permitindo instanciar caixas que podem conter qualquer tipo de objeto.
- Tratamento de Exceções Customizadas: Criação da classe `MochilaVaziaException` (que herda de `Exception`) para evitar erros de execução caso o jogador tente retirar um item de um inventário vazio.
- Persistência de Dados e Serialização: O estado do jogo (incluindo o jogador, sua vida atual e os itens na mochila) pode ser salvo e retomado posteriormente. Isso foi construído utilizando as classes `ObjectOutputStream`, `ObjectInputStream` e a interface `Serializable`, gravando o estado dos objetos no arquivo binário `save_progresso.dat`.
