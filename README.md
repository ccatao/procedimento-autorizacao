# procedimento-autorizacao
Projeto Autorização Procedimentos
Projeto criado para facilitar a autorização de procedimentos baseados na idade e no sexo do solicitante.
Através do cadastro dos procedimentos, informa-se o número(procedimento), idade, sexo e situação de autorização (verdadeiro=true ou falso=false).
Sempre que o procedimento não constar no cadastro, o procedimento não é autorizado. 

O projeto foi criado com o próposito inicial de funcionar com H2 Database mas não funcionou, mesmo com os esforços aplicados. 

Devido a dificuldade em encontrar as bibliotecas nas versões adequadas ao funcionamento correto, o projeto acaba por não funcionar adequadamente em nenhum servidor de aplicação (Tomcat 10.0 e Wildfly15). 

Caso o projeto tivesse funcionado de forma adequada, teria-se tido o tempo para adequar as funcionalidades essenciais, melhorá-las e tentar incluir vue.js. O que não foi possível.

Existe um arquivo chamado import.sql do diretório que cria a tabela e preenche os campos necessários para a inicialização

Após recuperar o branch do Git, justar os dados da conexão no arquivo ProcedimentoDao.java para a base de dados a ser utilizada.

A aplicação pode ser inicializada por http://localhost:8080/procedimento-autorizacao/  que irá diretamente para a área de validação.
Um pequeno link escrito Procedimentos, no lado superior direito, leva a área de manutenção onde poderiam ser ajustados informações e inseridos novos procedimentos.
