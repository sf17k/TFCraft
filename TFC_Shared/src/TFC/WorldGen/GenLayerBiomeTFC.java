package TFC.WorldGen;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;
import net.minecraft.src.WorldType;

public class GenLayerBiomeTFC extends GenLayerTFC
{
	public static BiomeGenBase[] biomeArray = new BiomeGenBase[] {TFCBiome.desert, TFCBiome.forest, TFCBiome.extremeHills, TFCBiome.swampland, TFCBiome.plains, TFCBiome.taiga,
	    TFCBiome.desert3,TFCBiome.desert4,TFCBiome.desert5,TFCBiome.desert6,
		TFCBiome.desert7,TFCBiome.desert8, TFCBiome.desert2,TFCBiome.desert9,
		TFCBiome.hills2,TFCBiome.hills3,TFCBiome.hills4,
		TFCBiome.hills5,TFCBiome.hills6,TFCBiome.hills7,
		TFCBiome.hills8,TFCBiome.hills9,TFCBiome.hills10,
		TFCBiome.forest2,TFCBiome.forest3,TFCBiome.forest4,TFCBiome.forest5,TFCBiome.forest6,TFCBiome.forest7,TFCBiome.forest8,TFCBiome.forest9,
		TFCBiome.plains2,TFCBiome.plains3,TFCBiome.plains4,TFCBiome.plains5,TFCBiome.plains6,TFCBiome.plains7,TFCBiome.plains8,TFCBiome.plains9,TFCBiome.plains10,
		TFCBiome.taiga2,TFCBiome.taiga3,TFCBiome.taiga4,TFCBiome.taiga5,TFCBiome.taiga6,TFCBiome.taiga7,TFCBiome.taiga8,TFCBiome.taiga9,TFCBiome.taiga10,
		TFCBiome.swamp2,TFCBiome.swamp3,TFCBiome.swamp4,TFCBiome.swamp5,TFCBiome.swamp6,TFCBiome.swamp7,TFCBiome.swamp8,TFCBiome.swamp9,TFCBiome.swamp10,
		TFCBiome.jungle, TFCBiome.jungleHills};

	/** this sets all the biomes that are allowed to appear in the overworld */
	private BiomeGenBase[] allowedBiomes;

	public GenLayerBiomeTFC(long par1, GenLayer par3GenLayer, WorldType par4WorldType)
	{
		super(par1);
		this.allowedBiomes = biomeArray;
		this.parent = (GenLayerTFC) par3GenLayer;

		if (par4WorldType == WorldType.DEFAULT_1_1)
		{
			this.allowedBiomes = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga};
		}
	}

	/**
	 * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
	 * amounts, or biomeList[] indices based on the particular GenLayer subclass.
	 */
	public int[] getInts(int par1, int par2, int par3, int par4)
	{
		int[] var5 = this.parent.getInts(par1, par2, par3, par4);
		int[] var6 = IntCache.getIntCache(par3 * par4);

		for (int var7 = 0; var7 < par4; ++var7)
		{
			for (int var8 = 0; var8 < par3; ++var8)
			{
				this.initChunkSeed((long)(var8 + par1), (long)(var7 + par2));
				int var9 = var5[var8 + var7 * par3];

				if (var9 == 0)
				{
					var6[var8 + var7 * par3] = 0;
				}
				else if (var9 == BiomeGenBase.mushroomIsland.biomeID)
				{
					var6[var8 + var7 * par3] = var9;
				}
				else if (var9 == 1)
				{
					var6[var8 + var7 * par3] = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;
				}
				else
				{
					var6[var8 + var7 * par3] = TFCBiome.plains.biomeID;
				}
			}
		}

		return var6;
	}
}
