package com.builtbroken.hiddenlever;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 08/02/2018.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void doLoadModels() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(HiddenLever.torchLever), 0, new ModelResourceLocation(HiddenLever.torchLever.getRegistryName(), "inventory"));
    }
}