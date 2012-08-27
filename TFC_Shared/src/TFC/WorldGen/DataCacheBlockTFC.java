package TFC.WorldGen;

public class DataCacheBlockTFC
{
    /** The array of biome types stored in this BiomeCacheBlock. */
    public DataLayer[] data;
    
    private int index;

    /** The x coordinate of the BiomeCacheBlock. */
    public int xPosition;

    /** The z coordinate of the BiomeCacheBlock. */
    public int zPosition;

    /** The last time this BiomeCacheBlock was accessed, in milliseconds. */
    public long lastAccessTime;
    
    /** The BiomeCache object that contains this BiomeCacheBlock */
    final DataCache theDataCache;

    public DataCacheBlockTFC(DataCache datacache, GenLayerTFC indexLayers, int par2, int par3,int ind)
    {
        this.theDataCache = datacache;

        this.data = new DataLayer[256];
        this.xPosition = par2;
        this.zPosition = par3;
        index = ind;
        DataCache.getChunkManager(datacache).getDataLayerAt(datacache, data, indexLayers, par2 << 4, par3 << 4, 16, 16, false, index);
    }

    /**
     * Returns the BiomeGenBase related to the x, z position from the cache block.
     */
    public DataLayer getDataLayerAt(int par1, int par2)
    {
        return this.data[par1 & 15 | (par2 & 15) << 4];
    }
}
