<h1>Seção 21 - Acesso ao banco de dados usando JDBC</h1>
<ol>
<li>Criar a base de dados</li>
<li>Baixar MySql java connector</li>
<li>criar em c: uma pasta para guardar bibliotecas externas</li>
<li>adicionar biblioteca no eclipse window -> preferences -> java -> build path -> user libraries</li>
<li>acresentar a biblioteca no projeto java. </li>
<li>criar arquivo db.properties</li>
</ol>
<h3>Padrão de projeto DAO (Data Access Object)</h3>
<p>Para cada entidade, haverá um objeto responsável por fazer acesso a dados relacionados a esta entidade.</p>
<p>Cada DAO será definido por uma interface.</p>
<p>A injeção de dependência pode ser feita por meio do padrão de projeto Factory</p>