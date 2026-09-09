package entities;

public class Produtos {

    private int id;
    private int comprimento;
    private String nome;
    private int largura;
    private int altura;
    private int profundidade;
    private  String descricao;
    private String obs;

    public void setNome(String nome) {
      this.nome = nome;
    }

    public void setLargura(int largura) {
      this.largura = largura;
    }

    public void setAltura(int altura) {
      this.altura = altura;
    }

    public void setProfundidade(int profundidade) {
      this.profundidade = profundidade;
    }

    public void setDescricao(String descricao) {
      this.descricao = descricao;
    }

    public void setObs(String obs) {
      this.obs = obs;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getcomprimento() {
        return comprimento;
    }
    public String getNome() {
      return nome;
    }

    public int getLargura() {
      return largura;
    }

    public int getAltura() {
      return altura;
    }

    public int getProfundidade() {
      return profundidade;
    }

    public String getDescricao() {
      return descricao;
    }

    public String getObs() {
      return obs;
    }
    public int getId() {
        return id;
    }
  }





/** public void deletaProduto(){
 
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




*/

  
