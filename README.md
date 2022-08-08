# biblioteca-universitaria-lpvs2
Projeto final de LPVS2
<h1>Biblioteca Universitária</h1>

<h3>Requisitos do Projeto:</h3>
<ol>
  <li>Escreva uma aplicação gráfica em Java para gerenciar empréstimos de obras em uma biblioteca universitária.</li>
  <li>Existem três tipos de obras nessa biblioteca: livros, trabalhos acadêmicos (monografias de graduação, dissertações de mestrado, etc.) e revistas.</li>
  <li>Para cadastrar uma obra, o bibliotecário deve informar:
    <ul>
      <li>Título</li>
      <li>Autores (dois, no máximo e, pelo menos, um deve ser informado)</li>
      <li>Ano de publicação (valor positivo)</li>
      <li>Tipo da obra</li>
      <li>Quantidade disponível</li>
    </ul>
  </li>
  <li>A aplicação não deve permitir que duas ou mais obras com o mesmo título sejam inseridas.</li>
  <li>As operações de empréstimo e devolução devem ser realizadas com base no título de uma obra já cadastrada.</li>
  <li>Para que um empréstimo seja efetuado, deve-se informar a data de realização do empréstimo e os exemplares a serem emprestados (não é necessária a identificação do usuário).</li>
  <li>Cada empréstimo pode ter, no máximo, três exemplares de obras diferentes entre si (em um empréstimo, não é possível emprestar dois ou mais exemplares da mesma obra).</li>
  <li>Para cada empréstimo efetuado, a aplicação deverá armazenar a data prevista para devolução e atualizar a quantidade de exemplares disponíveis das obras emprestadas.</li>
  <li>Além disso, deve haver uma estratégia que permita identificar, para um empréstimo, quais são as obras que foram emprestadas.</li>
  <li>Para que uma devolução seja efetuada, deve-se informar a data de realização da devolução e as obras a serem devolvidas.</li>
  <li>Para cada devolução efetuada, a aplicação deverá calcular e armazenar a multa, se houver.<br>A tabela abaixo mostra, para cada tipo de obra, a quantidade máxima de dias permitida para o empréstimo e o valor da multa por dia de atraso.</li>
</ol>

<table>
  <tr>
    <th>Tipo de obra</th>
    <th>Qtd. max dias</th>
    <th>Multa/dia</th>
  </tr>
  <tr>
    <td>Livro</td>
    <td>10</td>
    <td>R$ 2,00</td>
  </tr>
  <tr>
    <td>Trabalho acadêmico</td>
    <td>15</td>
    <td>R$ 0,50</td>
  </tr>
  <tr>
    <td>Revista</td>
    <td>20</td>
    <td>R$ 0,30</td>
  </tr>
</table>
