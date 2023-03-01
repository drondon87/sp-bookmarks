package org.bookmark.msvc.bookmark.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.bookmark.msvc.bookmark.services.UploadFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Value("${upload.dir}")
    private String uploadDir;
    @Override
    public Resource cargar(String nombreFoto) throws MalformedURLException {
        Path rutaArchivo = getPath(nombreFoto);

        log.info(rutaArchivo.toString());
        Resource recurso = null;

        recurso = new UrlResource(rutaArchivo.toUri());

        if (!recurso.exists() && !recurso.isReadable()) {
            rutaArchivo = Paths.get("src/main/resources/static/images").resolve("not_user.png").toAbsolutePath();
            recurso = new UrlResource(rutaArchivo.toUri());

            log.error("Error no se pudo cargar la imagen: " + nombreFoto);
        }

        return recurso;
    }

    @Override
    public String copiar(MultipartFile archivo) throws IOException {
        String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
        Path rutaArchivo = getPath(nombreArchivo);
        log.info(rutaArchivo.toString());

        Files.copy(archivo.getInputStream(), rutaArchivo);

        return nombreArchivo;
    }

    @Override
    public boolean eliminar(String nombreFoto) {
        if (nombreFoto != null && nombreFoto.length() > 0) {
            Path rutaFotoAnterior = getPath(nombreFoto);
            File archivoFotoAnterior = rutaFotoAnterior.toFile();

            if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
                archivoFotoAnterior.delete();
                return true;
            }

        }
        return false;
    }

    @Override
    public Path getPath(String nombreFoto) {
        return Paths.get(uploadDir).resolve(nombreFoto).toAbsolutePath();
    }
}
