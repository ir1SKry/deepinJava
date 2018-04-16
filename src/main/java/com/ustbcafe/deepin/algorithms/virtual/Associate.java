package com.ustbcafe.deepin.algorithms.virtual;

import java.util.List;

/**
 * Created by Rudy Steiner on 2018/3/25.
 */
public interface Associate<C,B> {
    void associate(List<C> c, B b);
    void associate(C c, B b);
}
