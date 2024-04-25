package phase.phase_epic_cat.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CatWorkplaceBlock extends Block
{

    public static final BooleanProperty IS_CAT_PRESENT = BooleanProperty.of("is_cat_present");

    public CatWorkplaceBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(IS_CAT_PRESENT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(IS_CAT_PRESENT);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(Text.literal("Hello, world!"), false);
            world.setBlockState(pos, state.with(IS_CAT_PRESENT, true));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (world.getBlockState(pos).get(IS_CAT_PRESENT)){
            System.out.println("CAT IS PRESENT!!!");
        }

        world.setBlockState(pos, state.with(IS_CAT_PRESENT, false));
        super.onSteppedOn(world, pos, state, entity);
    }
}
