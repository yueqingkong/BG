package block.guess.utils.file;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;

import block.guess.base.BaseApp;

/**
 * 文件管理工具类
 */
public class FileUtils {

    /*****************************************   创建文件  ****************************************************/
    /**
     * 获取系统文件根路径
     */
    public static String getBaseFileDir() {
        Context context = BaseApp.getBaseApp().getBaseContext();
        return BFileUtil.getExternalFileDir(context);
    }

    public static String path(String name, String suffix) {
        if (TextUtils.isEmpty(name)) {
            name = "b";
        }
        if (TextUtils.isEmpty(suffix)) {
            suffix = "";
        }

        String path = getBaseFileDir() + File.separator + name + suffix;
        return path;
    }

    /**
     * 创建指定路径文件
     *
     * @param path
     * @return
     */
    public static File create(String path) {
        return BFileUtil.createNewFile(path);
    }

    /**
     * 创建临时文件
     *
     * @param name   文件名(不传,默认为随机数)
     * @param suffix 文件后缀名(.jpeg/,jpg...)
     * @return
     */
    public static File tempFile(String name, String suffix) {
        if (TextUtils.isEmpty(name)) {
            name = String.valueOf(Math.random() * 100000);
        }
        if (TextUtils.isEmpty(suffix)) {
            suffix = "";
        }

        String temp = "temp" + File.separator + name + suffix;
        return BFileUtil.createNewFile(getBaseFileDir() + File.separator + temp);
    }
    /*****************************************   文件名处理  ****************************************************/


    /*****************************************   文件处理  ****************************************************/
    /**
     * 文件复制
     *
     * @param source
     * @param dest
     */
    public static void copy(File source, File dest) {
        BFileUtil.copy(source, dest);
    }

    /**
     * 文件在本地是否存在
     *
     * @param path
     * @return
     */
    public static boolean isExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * 写入文件
     *
     * @param file
     * @param bytes
     */
    public static void write(File file, byte[] bytes) {
        BFileUtil.write(file, bytes);
    }

    /**
     * 读文件
     *
     * @param file
     * @return
     */
    public static byte[] read(File file) {
        return BFileUtil.read(file);
    }

    /**
     * 删除文件
     *
     * @param file
     */
    public static void delete(File file) {
        BFileUtil.delete(file);
    }
}
