package TFC.Blocks.Terrain;

import java.util.List;

import TFC.Blocks.BlockTerra;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPeat extends BlockTerra
{
	public BlockPeat(int i)
	{
		super(i, Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List list)
	{
		list.add(new ItemStack(this,1,0));
	}

	@Override
    public void registerIcons(IconRegister registerer)
    {
		blockIcon = registerer.registerIcon("soil/Peat");
    }
}
