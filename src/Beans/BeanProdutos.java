package Beans;

/*
 @author Tiago e Paulo
 */
public class BeanProdutos {
    
    public int    idProdutos            = 0;    //0
    public int    idEmpresa             = 0;    //1
    public int    codigoGrupo           = 0;    //2
    public int    codigoEmpresa         = 0;    //3
    public int    codigoProduto         = 0;    //4
    public int    produtoInativo        = 0;    //5
    public int    codigoFornecedor      = 0;    //6
    public String dataCadastro          = "";   //7
    public String descricaoProduto      = "";   //8
    public String codigoDeBarras        = "";   //9
    public String dataDeVencimento      = "";   //10
    public double valorDeCompra         = 0;    //11
    public double valorDeVenda          = 0;    //12
    public String tipoDeProduto         = "";   //13
    public int    codigoFabricante      = 0;    //14
    public int    codigoGrupoProduto    = 0;    //15
    public int    codigoSubGrupoProduto = 0;    //16
    public double quantidadeMinima      = 0;    //17
    public double quantidadeIdeal       = 0;    //18
    public double quantidadeAtual       = 0;    //19
    public String observacoes           = "";   //20
    public String dataAlterou           = "";   //21
    public String horaAlterou           = "";   //22
    public int    usuarioAlterou        = 0;    //23
    public int    idEmpresaAlterou      = 0;    //24
    public int    codigoGrupoAlterou    = 0;    //25
    public int    codigoEmpresaAlterou  = 0;    //26
    public byte[] imagemProduto         = null; //27

    public byte[] getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(byte[] imagemProduto) {
        this.imagemProduto = imagemProduto;
    }
    
}

