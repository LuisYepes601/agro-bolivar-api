/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Helpers.Cloudinary;

import com.cloudinary.Transformation;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luis
 */
public class CloudinaryFileUtils {

    public static Map<String, Object> ProfilePhtotoUser(String nameUser, String nameFile) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "biblionepo/usuarios/perfil_/"
                .concat(nameFile)
                .concat("/")
                .concat(nameUser));
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(400)
                .height(400));

        return utils;

    }

    public static Map<String, Object> prymaryFileBoock(String nameFile) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "biblionepo/boock/primary_/".concat(nameFile));
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(600)
                .height(600));

        return utils;

    }

    public static Map<String, Object> galleryFileProduct(String nameFile) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "products/gallery/".concat(nameFile));
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(400)
                .height(400));

        return utils;

    }

    public static Map<String, Object> fileArtistEvent(String nameFile) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "events/artist/".concat(nameFile));
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(700)
                .height(700));

        return utils;

    }

    public static Map<String, Object> portadaLibro(String nameFile) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "libros/portada/".concat(nameFile));
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(700)
                .height(700));

        return utils;

    }

    public static Map<String, Object> libro(String nameFile) {

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "libro/" + nameFile);
        utils.put("resource_type", "image");

        return utils;
    }
}
