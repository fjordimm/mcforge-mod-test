package io.github.fjordimm.bayunga.util;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UtilVoxelShape
{
    private UtilVoxelShape() {} // To mark class as static

    public static VoxelShape rotateShapeFromBottom(VoxelShape shape)
    {
        VoxelShape[] temp = {Shapes.empty()};

        shape.forAllBoxes((aX, aY, aZ, bX, bY, bZ) -> temp[0] = Shapes.or(temp[0], Shapes.box(aZ, aY, 1-bX, bZ, bY, 1-aX)));

        return temp[0];
    }
}
