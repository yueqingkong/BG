package block.guess.utils.file;

import android.content.Context;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 文件操作的基础工具类
 */
public class BFileUtil {

    /**
     * 系统文件目录
     *
     * @param context 上下文
     * @return /data/data/<application package>/files
     */
    public static String getFileDir(Context context) {
        return String.valueOf(context.getFilesDir());
    }

    /**
     * 系统缓存目录
     *
     * @param context 上下文
     * @return /data/data/<application package>/cache
     */
    public static String getCacheDir(Context context) {
        return String.valueOf(context.getCacheDir());
    }

    /**
     * Sdcard文件目录
     *
     * @param context 上下文
     * @return /mnt/sdcard/Android/data/<application package>/files
     */
    public static String getExternalFileDir(Context context) {
        return String.valueOf(context.getExternalFilesDir(""));
    }

    /**
     * Sdcard缓存目录
     *
     * @param context 上下文
     * @return /mnt/sdcard/Android/data/<application package>/cache
     */
    public static String getExternalCacheDir(Context context) {
        return String.valueOf(context.getExternalCacheDir());
    }


    /**
     * 公共文件夹
     *
     * @return /mnt/sdcard/Download
     */
    public static String getPublicDownloadDir() {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        return file.getAbsolutePath();
    }

    /**
     * @return 存储卡是否挂载(存在)
     */
    public static boolean isMountSdcard() {
        String status = Environment.getExternalStorageState();
        return status.equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 创建新文件
     *
     * @param string
     * @return
     */
    public static File createNewFile(String string) {
        File file = new File(string);
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                return null;
            }
        }
        try {
            if (!file.exists() && !file.createNewFile()) {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
        return file;
    }

    /**
     * 文件复制
     *
     * @param source
     * @param dest
     */
    public static void copy(File source, File dest) {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputChannel.close();
                outputChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字节写入文件
     *
     * @param file
     * @param bytes
     */
    public static void write(File file, byte[] bytes) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件
     *
     * @param file
     * @return
     */
    public static byte[] read(File file) {
        byte[] buffer = null;

        FileInputStream fis = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            fis = new FileInputStream(file);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fis = null;
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bos = null;
            }
        }
        return buffer;
    }

    /**
     * 删除文件
     *
     * @param file
     * @return
     */
    public static boolean delete(File file) {
        boolean flag = false;
        if (file.isFile() && file.exists()) {
            flag = file.delete();
        }
        return flag;
    }

    /**
     * 删除文件夹下所以文件
     *
     * @param dir
     */
    public static void cleanFile(File dir) {
        try {
            if (dir != null && dir.exists() && dir.isDirectory()) {
                for (File file : dir.listFiles()) {
                    if (file != null && file.exists() && file.isDirectory()) {
                        cleanFile(file);
                    } else {
                        file.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件夹大小
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static long folderSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isDirectory()) {
                    size = size + folderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}
