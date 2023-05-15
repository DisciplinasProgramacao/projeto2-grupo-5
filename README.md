[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10667532)
# Projeto 2
Trabalho LPM e Grafos 

## Correção e comentários

### Nota: 13,6

Grafo de teste

![Grafo de teste](docs/grafoTeste.png)

---

- Salvar dá exceção: **Cannot invoke "java.util.ArrayList.get(int)" because "this.adjacencia" is null**
- Carregar retorna grafo de ordem 0 e não encontra nenhum vértice.
- Não há documentação para o tipo de arquivo usado.
- BFS não adiciona arestas no grafo visitado.
- DFS também não. Pelo código, não 'desce' antes de empilhar vizinhos.
- Remoção de aresta dá exceção quando ela não existe.
- App existe, mas encerra após a primeira iteração.

---

- Aderência às classes do diagrama: 2/2 pontos
- Requisitos de grafos corretamente implementados: 7,1/12 pontos
  - Carregar/salvar		0/2 pontos
  - Grafo completo e subgrafo 3/3 pontos
  - Grafo direcionado/não direcionado 1,8/2 pontos
  - Busca em largura e profundidade 1,5/4 pontos
  - App para uso 0,8/1 ponto
- Documentação de código: 4/4 pontos
  - (apesar de não ter a documentação do arquivo.)
- Testes (quantidade e qualidade): 0,5/2 pontos
  - só encontrei para grafo completo.

## Alunos integrantes da equipe

* Ana Carolina de Carvalho Corrêa
* Breno Rosa Almeida
* Jordana de Souza Meireles
* Henrique Pinto Santos
* Pedro Talma Toledo

## Professores responsáveis

* João Caram Santos de Oliveira

