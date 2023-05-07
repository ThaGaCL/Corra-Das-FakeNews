# Corra das Fake News
## Universidade Federal do Paraná
### CI1062 - Paradigmas de Programação

#### 1. Introdução
Corra das Fake News é um jogo de computador colaborativo para até quatro pessoas com
o objetivo de combater as fake news. Cada jogador deve assumir o papel de leitor de
notícias, percorrendo as posições de um tabuleiro, evitando ou eliminando as fake news que
encontrar pelo caminho. O jogo termina quando todas as fake news forem eliminadas e pelo
menos um jogador sobreviver.
#### 2. Regras do Jogo
O jogo possui dois personagens principais, os jogadores e as fake news e é baseado em
um sistema de turnos, onde cada jogador presente no tabuleiro executa um
movimento/ação para fugir das fake news ou para elimina-las. No decorrer do jogo, itens
são distribuídos pelo tabuleiro para auxiliar os jogadores, mas cuidado, alguns itens podem
ser boatos que vão te deixar desinformado.
#### 3. Jogadores
Existe apenas um tipo de jogador conforme descrito a seguir:
1. Os jogadores (no mínimo 1, no máximo 4) devem ser posicionados no tabuleiro
conforme mostrado na Figura 1 da Seção 6 - Tabuleiros do Jogo.
2. Um jogador possui somente a habilidade de se movimentar no tabuleiro, uma vez por
turno, nos sentidos norte, sul, leste e oeste. Se um item for encontrado após o
movimento, o mesmo deve ser armazenado pelo jogador.
3. Um jogador pode executar uma ação por turno desde que tenha um item armazenado.
Lembrando que a ação só pode ser executada antes do jogador realizar seu
movimento no tabuleiro. Cada item possibilitará ao jogador uma das seguintes ações:
1) denunciar fake news, 2) fugir, 3) ler uma notícia real ou 4) ouvir um boato. Mais
detalhes sobre as ações são apresentadas na Seção 5 - Itens do Jogo.
4. Fake news
Os inimigos no jogo são as fake news que se encontram espalhadas no tabuleiro (no
mínimo 6).
1. Existem 3 (três) tipos de fake news, diferenciadas pela forma como se movimentam:
a) Fake news 1 (F1): movimenta uma casa em um dos sentidos: norte, sul, leste ou
oeste.
b) Fake news 2 (F2): movimenta duas casas em um dos sentidos: norte, sul, leste ou
oeste.
c) Fake news 3 (F3): movimenta uma casa nos sentidos diagonais noroeste,
nordeste, sudoeste e sudeste.
2. Caso uma fake news saia da margem do tabuleiro ou colida com outra, a mesma é
eliminada.
3. Caso a fake news colida com um jogador, esse jogador é eliminado.
4. Caso uma fake news colida com um item presente em uma posição do tabuleiro, a
mesma elimina o item do tabuleiro e cria uma cópia dela mesma em uma das 8 (oito)
posições adjacentes livres, ou seja, a fake news é duplicada.
5. Itens do jogo
Os itens do jogo estão sempre visíveis no tabuleiro e representados por “??” (dois sinais de
interrogação), conforme ilustrado na Figura 1 da Seção 6 - Tabuleiros do Jogo.
1. Inicialmente, 2 (dois) itens são adicionados ao tabuleiro em posições aleatórias.
2. Quando um jogador se movimentar para uma posição do tabuleiro que houver um
item, o jogador deve armazenar esse item e eliminá-lo do tabuleiro. Na sequência,
um novo item qualquer deverá surgir em outra posição do tabuleiro.
3. Os tipos de itens e a ação de cada um deles são:
a. Denunciar fake news: esse item oferece a ação de denunciar qualquer fake
news em volta do jogador, eliminando-as (se houver) nas 8 (oito) posições
adjacentes à posição do jogador.
b. Fugir: esse item permite que o jogador mude para qualquer outra posição do
tabuleiro.
c. Ler uma notícia real: esse item permite que o jogador elimine uma fake news
qualquer presente no tabuleiro.
d. Ouvir um boato: esse item infelizmente é feito para atrapalhar os jogadores.
Caso um jogador o armazene, no próximo turno o movimento desse jogador é
realizado de forma aleatória.
6. Tabuleiro do jogo
O cenário do jogo é formado por um tabuleiro 9x9, conforme ilustrado na Figura 1.
1. Os jogadores iniciam o jogo nas posições representadas no tabuleiro (posições J1,
J2, J3 e/ou J4).
2. Cada posição do tabuleiro corresponde a um setor que o jogador deve percorrer, até
que todas as fake news sejam eliminadas, restando pelo menos um jogador.
3. Cada setor possui uma posição no tabuleiro ([x,y]) e um item, conforme descrito na
Seção 5 - Itens do Jogo.
4. Podem existir 2 (dois) tipos de setores:
a. Setor normal: não existe nenhuma restrição, ou seja, todos os movimentos e
ações dos jogadores e das fake news podem ser executadas.
b. Setor restrito: representado pelos caracteres “XX”. Este setor não pode ser
acessado por jogadores ou fake news. Caso um destes se movimente para
este setor, o mesmo é eliminado do jogo.
5. Os setores restritos, representados por “XX”, devem ser definidos antes de iniciar o
jogo e colocados de forma visível em quatro posições quaisquer do tabuleiro,
conforme ilustrado na Figura 1.
6. Devem ser criadas no mínimo 6 (seis) fake news no tabuleiro, sendo duas de cada
tipo (F1, F2 e F3).
7. As fake news, inicialmente, devem ser colocadas em qualquer posição do tabuleiro
com exceção dos setores situados nas bordas (linha 1, linha 9, coluna 1 e coluna 9),
conforme ilustrado na Figura 1.
Figura 1 – Exemplo ilustrativo do tabuleiro do jogo onde, inicialmente, as seis fake news,
dois itens e quatro setores restritos ocupam posições aleatórias do tabuleiro.
7. Turno
O jogo deve funcionar em sistema de turnos, alternando entre jogadores e fake news. Um
turno finaliza quando todos os jogadores e fake news completarem seus movimentos.
1. Os jogadores possuem até 20 turnos para eliminar todas as fake news.
2. Os jogadores iniciam nas posições determinadas na Figura 1, e devem selecionar
um movimento para outro setor diferente do atual. O primeiro a jogar é sempre o
jogador 1 (J1), seguido pelo jogador 2 (J2), jogador 3 (J3) e/ou jogador 4 (J4).
3. Quando um jogador se movimentar para um setor que contém um item:
a. O item deve ser armazenado pelo jogador e eliminado do tabuleiro;
b. Um novo item qualquer deve ser gerado e colocado no tabuleiro em uma posição
aleatória. Lembrando que sempre devem existir 2 itens espalhados pelo tabuleiro.
c. Caso o item seja “Ouvir um boato”, o jogador é movimentado para uma das 8
posições do tabuleiro adjacentes à sua posição atual (de forma aleatória).
d. No caso dos outros itens (denunciar fake news, fugir, ler uma notícia real), o
jogador pode utilizá-los no início do próximo turno antes de se movimentar.
e. A movimentação do jogador para outro setor encerra o seu turno.
4. Após finalizar os turnos dos jogadores, as fake news que estiverem no tabuleiro
iniciam seu turno de movimentação. Cada fake news se movimenta uma única vez e
de forma aleatória no tabuleiro (F1, F2 e F3). O jogo deve exibir uma mensagem
informando o movimento realizado por cada fake news (com um intervalo de no
mínimo 2 segundos).
5. Caso uma fake news entre em um setor que contenha um item, esta fake news é
duplicada em uma das posições 8 (oito) adjacentes à posição que ela se encontra. O
item atual deve ser removido do tabuleiro e um novo item deve surgir em uma
posição qualquer do tabuleiro.
6. Após todas as fake news se movimentarem, um novo turno é iniciado, começando
pelo jogador 1 (J1).
7. O jogo termina em dois casos:
a. Quando todas as fake news forem eliminadas do tabuleiro, restando pelo
menos um jogador.
b. Quando todos os jogadores forem eliminados.
