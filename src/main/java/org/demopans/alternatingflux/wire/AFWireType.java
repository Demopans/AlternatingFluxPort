package org.demopans.alternatingflux.wire;

// remember to run gradle reload in IDE to make red text go away
import blusunrize.immersiveengineering.api.tool.IElectricEquipment;
import blusunrize.immersiveengineering.api.wires.Connection;
import blusunrize.immersiveengineering.api.wires.WireType;
import blusunrize.immersiveengineering.api.wires.localhandlers.WireDamageHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.demopans.alternatingflux.AlternatingFlux;
import org.jetbrains.annotations.NotNull;
import org.demopans.alternatingflux.config.AFConfig;

public class AFWireType extends WireType implements WireDamageHandler.IShockingWire {
  /**
   * Constants
   */
  public static final String WIRE_NAME = "AF"; public static final double RENDER_DIAMETER = 0.078125;
  private final AFConfig config;

  public AFWireType(AFConfig config) {
    this.config = config;
  }

  @Override
  public String getUniqueName() {
    return WIRE_NAME; // check source at the other AFWireType:20
  }

  @Override
  public int getColour(Connection connection) {
    return 0;
  }

  @Override
  public double getSlack() {
    return 0;
  }

  @Override
  public int getMaxLength() {
    return 0;
  }

  @Override
  public ItemStack getWireCoil(Connection connection) {return new ItemStack(AlternatingFlux.item_coil, 1, ordinal);} //todo: add the item

  @Override
  public double getRenderDiameter() { return RENDER_DIAMETER; }

  @NotNull
  @Override
  public String getCategory() { return WIRE_NAME; }

  @Override
  public double getDamageRadius() { return config.AFWireConfig.damageRadius; }

  @Override
  public IElectricEquipment.ElectricSource getElectricSource() {
    return null;
  }

  @Override
  public int getTransferRate() {
    return config.AFWireConfig.transferRate;
  }

  @Override
  public double getBasicLossRate(Connection c) {
    return getLossRatio()*c.getLength()/getMaxLength();
  }

  private double getLossRatio() {
    return config.AFWireConfig.lossRatio;
  }

  @Override
  public double getLossRate(Connection c, int transferred) {
    return 0;
  }

  public float getDamageAmount(Entity e, Connection c, int energy){
    return 30F*energy/getTransferRate()*8;
  }
}
