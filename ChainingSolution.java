

class ChainingSolution{

    public static void main(String[] args) {

        int [] values = new int[] { 77, 22, 394, 90, 10, 33, 45 };
        Chaining chainingSolution = new Chaining();
        chainingSolution.setSize(values.length + 1);
        chainingSolution.initChainedHashTable();
        chainingSolution.constructHashTableWithArrayOfKeys(values);
        chainingSolution.displayHashTable();

    }
}
