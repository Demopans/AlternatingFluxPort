package org.demopans.alternatingflux.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.demopans.alternatingflux.AlternatingFlux;

import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = AlternatingFlux.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AFConfig {
  public static class AFWire{
    public final int length;
    public final double loss;

    public final int capacity;
    public AFWire(ForgeConfigSpec.Builder builder, int capacity) {
      this.length = builder.define("length",64).get();
      this.loss = builder.define("loss",0.00025).get();
      this.capacity = builder.define("capacity",2<<18).get();

      //this.powerLossForm = builder.define("powerLossForm","(1 - flux^2 * loss / capacity^2)*lengthWire").get(); // figure out how to parse equation into java syntax
    }

    private double powerLossForm(int lengthWire, int flux) {return (1 - flux * flux * loss / capacity*capacity)*lengthWire;}
  }
}
