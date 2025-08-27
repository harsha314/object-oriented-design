package com.designpatterns.creationalpatterns.abstractfactory.furniture;

import com.designpatterns.creationalpatterns.abstractfactory.furniture.products.Chair;
import com.designpatterns.creationalpatterns.abstractfactory.furniture.products.FurnitureFactory;
import com.designpatterns.creationalpatterns.abstractfactory.furniture.products.ModernFurnitureFactory;
import com.designpatterns.creationalpatterns.abstractfactory.furniture.products.Table;
import com.designpatterns.creationalpatterns.abstractfactory.furniture.products.VictorianFurnitureFactory;

public class Demo {
  public static void main(String[] args) {
    FurnitureFactory furnitureFactory = new ModernFurnitureFactory();

    Table table = furnitureFactory.createTable();
    table.placeItem();
    System.out.println("Table style : " + table.getStyle());
    Chair chair = furnitureFactory.createChair();
    chair.sitOn();
    System.out.println("Chair style : " + chair.getStyle());

    FurnitureFactory victorianFurnitureFactory = new VictorianFurnitureFactory();
    Table victorianTable = victorianFurnitureFactory.createTable();
    table.placeItem();
    System.out.println("table style : " + victorianTable.getStyle());
    Chair victorianChair = victorianFurnitureFactory.createChair();
    chair.sitOn();
    System.out.println("Chair Style : " + victorianChair.getStyle());
  }
}
