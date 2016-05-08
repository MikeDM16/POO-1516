import java.util.Comparator;
public class ComparatorImovel implements Comparator<Imovel> {
    
    public int compare(Imovel i1, Imovel i2) {
        if (i1.equals(i2)) return 1;
        return 0;
    }
}