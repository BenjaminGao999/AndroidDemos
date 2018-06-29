package demo.com.todoandroid.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * auth zzc
 * date 2018/2/1
 * desc ${desc}
 */

public class ImageUtilsEx {
    private ImageUtilsEx() {
    }

    public static boolean compressFromFile(File originFile, int maxWidth, int maxHeight, float ratio, File aimFile) {
        if (aimFile == null) return false;
        Bitmap bitmap = decodeFromFile(originFile, maxWidth, maxHeight);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(aimFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, (int) (ratio * 100), fos);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Bitmap decodeFromFile(File file, int maxWidth, int maxHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;
        int scale = 1;
        if (originalWidth > originalHeight && originalWidth > maxWidth) {
            scale = originalWidth / maxWidth;
        } else if (originalWidth < originalHeight && originalHeight > maxHeight) {
            scale = originalHeight / maxHeight;
        }
        if (scale <= 0)
            scale = 1;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }
}
