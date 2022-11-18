package com.adidas.runner;


public final class World {

  private static boolean flag = true;


  public static void setFlag (boolean val) {

    World.flag = val;
  }


  public static boolean getFlag () {

    return flag;
  }

}
