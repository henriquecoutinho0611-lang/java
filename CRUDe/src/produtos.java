public class produtos {

    String nome;
    int largura;
    int altura;
    int profundidade;
    String descricao;
  }


class produtosController {

   Validacao validacao = new Validacao();
   produtos[] listaprodutos = new produtos[100];
   int contador = -1;

  public void coletaDados(){
 

     

  while (true) {

produtos produto = new produtos();

     produto.nome = validacao.validarString("Digite o nome do produto");
     produto.largura = validacao.validarInt("Digite a largura do produto");
     produto.altura = validacao.validarInt("Digite a altura do produto");
     produto.profundidade = validacao.validarInt("Digite a profundidade do produto");
     produto.descricao = validacao.validarString("Digite a descrição do produto");
 
     listaprodutos[contador] = produto;
     contador++;

     boolean continuar = validacao.validarSimNao("Deseja cadastrar outro produto? (sim/nao)");
      if(!continuar){
        break;
      }
    }
  
  }

/**
 * 
 */
public void deletaProduto(){
 
 String nomeproduto = validacao.validarString("Digite o nome do produto que deseja deletar");
      

     if (contador >= 0) {

       for(int i = 0; i < contador; i++ ){

        if (listaprodutos[i].nome.equals(nomeproduto)){

         System.out.println(listaprodutos);
        

         boolean decisao = validacao.validarSimNao("deseja deletar?");

       if (decisao){

         for (int j = i; j < contador - 1; j++) {
                listaprodutos[j] = listaprodutos[j + 1];
            }


       
            listaprodutos[contador - 1] = null;
            contador--;

       System.out.print("produto deletado");
      
    } 
  } 
  
  }

     } else{
    System.out.println("produto nao encontado");
  } return;


} 
public void listaProdutos(){

  if(contador >= 0){

    for(int i = 0; i < contador; i++){
     System.out.println("--------------------------------");
     System.out.println( listaprodutos[i].nome);
     System.out.println(listaprodutos[i].largura);
     System.out.println(listaprodutos[i].altura);
     System.out.println(listaprodutos[i].profundidade);
     System.out.println(listaprodutos[i].descricao);
     System.out.println("--------------------------------");
    

    }
  }
}







}






  
