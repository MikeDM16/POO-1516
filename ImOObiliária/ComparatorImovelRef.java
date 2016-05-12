import java.util.Comparator;
public class ComparatorImovelRef implements Comparator<Imovel> {
    
    public int compare(Imovel i1, Imovel i2) {
        return i1.getId().compareTo(i2.getId());
    }
}