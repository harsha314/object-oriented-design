package com.designpatterns.creationalpatterns.abstractfactory.furniture.products;

public interface FurnitureFactory {
  Chair createChair();

  Table createTable();
}
