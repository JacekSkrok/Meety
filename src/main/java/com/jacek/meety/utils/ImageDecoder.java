package com.jacek.meety.utils;

import com.jacek.meety.models.Host;

import java.util.Base64;

public class ImageDecoder {

    public static void decodeImage(Host host) {
        if (host.getHostPhoto() != null) {
            byte[] photoData = host.getHostPhoto();
            byte[] decodedPhoto = Base64.getDecoder().decode(photoData);
            host.setHostPhoto(decodedPhoto);
        }
    }
}
