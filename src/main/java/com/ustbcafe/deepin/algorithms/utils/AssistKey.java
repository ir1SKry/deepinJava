package com.ustbcafe.deepin.algorithms.utils;

import com.ustbcafe.deepin.algorithms.matrix.MatrixChain;

/**
 * Created by Rudy Steiner on 2017/4/5.
 */
public class AssistKey {
    private volatile int hashCode;
    private int i;
    private int j;
    public AssistKey(int i, int j) {
        this.i = i;
        this.j = j;
    }
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + i;
            result = 31 * result + j;
            hashCode = result;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof AssistKey) {
            AssistKey ak = (AssistKey) obj;
            if (ak.i == this.i && ak.j == this.j)
                return true;
        }
        return false;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

}
