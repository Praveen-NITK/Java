package FLIPKART;
public class CacheImplementation{
    public static void main(String[] args) {

        FlipCacheLibrary cacheLibrary= new CacheData();        

        int []input={1,2,1,3,4,2,5,6,6,7};
        //int []input={1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5 };
        EvictionPolicy lru = new LRU(3);
        EvictionPolicy fifo = new FIFO(3);

        int noOfPageFaultsLru=0;
        int noOfPageFaultsFifo=0;
        for (int i : input) {
            noOfPageFaultsLru+=lru.evictionPolicy(i)?1:0;
            noOfPageFaultsFifo+=fifo.evictionPolicy(i)?1:0;
        }        
        FlipCache cache= new FCache();
        cache.setEvictionPolicy(lru);
        cache.getEvictionPolicy().displayCache(noOfPageFaultsLru);
        cache.setEvictionPolicy(fifo);
        cache.getEvictionPolicy().displayCache(noOfPageFaultsFifo);

        //Not Required for nows
        //cacheLibrary.registerCache(cache);
    }
}