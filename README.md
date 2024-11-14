Estrutura do Projeto

Classes Principais:

Carro: Representa um carro disponível na loja, com atributos específicos de veículos de quatro rodas.

Moto: Representa uma moto disponível na loja, com atributos específicos de veículos de duas rodas.

Veiculo: Classe base para veículos, contendo os atributos comuns a carros e motos.

Cliente: Representa um cliente da loja, que pode comprar veículos.

Funcionario: Representa um funcionário geral da loja.

Vendedor: Subclasse de Funcionario, representando um vendedor que realiza vendas.

Gerente: Subclasse de Funcionario, com permissões especiais de gerenciamento.

Venda: Classe que representa a venda de um veículo.

Usuario: Classe base para todos os tipos de usuários, incluindo funcionários e clientes.

VeiculoIndisponivelException: Exceção personalizada lançada quando um veículo está indisponível para venda.

LeituraArquivo: Classe responsável pela leitura de dados de veículos e usuários a partir de arquivos.


Main: Classe principal que inicializa e executa o sistema.

Interfaces Gráficas

CatalogoVeiculos: Interface para exibição do catálogo de veículos, permitindo que os clientes visualizem e selecionem veículos.

Menu: Interface principal do sistema, onde é possível navegar entre diferentes funcionalidades.
