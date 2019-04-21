package com.ustbcafe.deepin.algorithms.graph;

import java.nio.file.Path;

public interface Paths {

  boolean hasPathTo(int v);
  Iterable<Integer> pathTo(int v);
}
