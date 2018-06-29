package demo.com.todoandroid.constants;

import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created : zzc
 * Time : 2017/6/14
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public class CommonConstants {
    public static final String NET_KEY_DEVICE_ID = "netKeyDeviceId";
    public static final String SPREF_THEME_ID = "themeId";

    public static String IMAGE_TYPE = "image/";
    public static String VIDEO_TYPE = "video/";
    public static String AUDIO_TYPE = "audio/";
    public static String TEXT_TYPE = "text/";
    public static String APPLICATION_TYPE = "application/";
    public static String APPLICATION_PDF = "application/pdf";

    public static String DOWNLOADS_CONTENT_URI = "content://downloads/public_downloads";

    public static String PRIMARY_TYPE = "primary";
    public static String IMAGES = "images";
    public static String IMAGE = "image";
    public static String VIDEO = "video";
    public static String PDF_EXTENSION = "pdf";

    public static String FOLDER_SEPARATOR = "/";

    public static String ID_COLUMN_VALUE = "_id";
    public static String DATA_COLUMN_VALUE = "_data";

    public static String READ_MODE = "r";

    public static int FALSE_SIZE = -1;

    public static String CONTENT = "content";
    public static String MEDIA_AUTHORITY = "media";
    public static String FILE = "file";

    public static String DOWNLOADS_DIRECTORY_AUTHORITY = "com.android.providers.downloads.documents";
    public static String EXTERNAL_STORAGE_AUTHORITY = "com.android.externalstorage.documents";
    public static String MEDIA_DOCUMENTS_AUTHORITY = "com.android.providers.media.documents";

    public static String GOOGLE_DRIVE_DOCUMENT_AUTHORITY = "com.google.android.apps.docs.storage";

    public static String WRITE_EXTERNAL_PERMISSION = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

    public static String DEFAULT_CACHE_DIRECTORY_NAME = FOLDER_SEPARATOR + "RxFile" + FOLDER_SEPARATOR;


    public static ArrayList<String> IMAGE_FILE_TYPES =
            new ArrayList<>(Arrays.asList("jpg", "png", "bmp", "jpeg", "ico", "gif"));

    public static final String MICRO = "micro";
    public static final String MINI = "mini";

    /*Shared Preferences Keys*/
    public static String SHARED_PREFERENCES_KEY = "file_chooser_preference_key";
    public static String HAS_CONFIGURED_DATA = "has_configured_data_key";
    public static String CACHE_DIRECTORY = "cache_directory_key";

    public static final Map<String, Integer> THUMBNAIL_KINDS = new HashMap<>();

    static {
        THUMBNAIL_KINDS.put(MICRO, MediaStore.Images.Thumbnails.MICRO_KIND);
        THUMBNAIL_KINDS.put(MINI, MediaStore.Images.Thumbnails.MINI_KIND);
    }
}
