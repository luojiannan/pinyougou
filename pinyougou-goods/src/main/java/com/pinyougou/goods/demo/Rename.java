package com.pinyougou.goods.demo;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class Rename {

    public static void main(String[] args) {
        File file = new File("E:\\百度云盘Download\\long珠Z蓝光国日双语\\11打败魔人普乌篇");
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (ArrayUtils.isEmpty(files)) {
                return;
            }
            String path = file.getAbsolutePath();
            for (File childFile : files) {
                String oldName = childFile.getName();
                if (StringUtils.isEmpty(oldName)) {
                    continue;
                }
                String[] strings = oldName.split("\\.");
                if (StringUtils.isNotBlank(strings[1]) && !strings[1].equals("pdf")) {
                    continue;
                }
                String newName = strings[0] + ".mkv";
                childFile.renameTo(new File(path + "\\" + newName));
            }
        }
    }
}
