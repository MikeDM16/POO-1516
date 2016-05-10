import java.util.Comparator;
public class ComparatorImovelPreco implements Comparator<Imovel> {
    
    public int compare(Imovel i1, Imovel i2) {
        return (int)(i1.getPrecoPedido() - i2.getPrecoPedido());
    }
}