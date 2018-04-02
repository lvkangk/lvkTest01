package com.lvk.util;

import java.io.Serializable;

/**
 * @author: kangkang.lv
 * @date: 17-3-15 下午3:51
 */
public interface Command extends Serializable {
    void execute();
}
