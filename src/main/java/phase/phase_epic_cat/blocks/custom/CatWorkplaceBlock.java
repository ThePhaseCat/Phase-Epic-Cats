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


    //this block will be a crafting table where you combine a special type of egg
    //with any block/item in the game to get a cat egg that you can place down
    //and it will spawn a cat
    //so uh yeah that's the plan now instead of randomly changing stuff
    public static final BooleanProperty IS_CAT_PRESENT = BooleanProperty.of("is_cat_present");

    public CatWorkplaceBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(IS_CAT_PRESENT, false));

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(IS_CAT_PRESENT);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(Text.literal("Hello, world!"), false);
            world.setBlockState(pos, state.with(IS_CAT_PRESENT, true));
            System.out.println(world.getTimeOfDay() % 24000);
            //if that yields 1000, then we can spawn cats?
            System.out.println(world.getTimeOfDay());
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

    //method that runs at a certain time in game?

}
