package com.amt.controllers;

import com.amt.entities.ImageEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Created by MedMalek on 01/11/2015.
 */
@RestController
@Repository
@Transactional(readOnly = false)
public class UploadController {
    private static final Log LOGGER = LogFactory.getLog(UploadController.class);

    @Autowired
    DataSource dataSource;
    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value = "/upload",
                    method = RequestMethod.POST)
    public @ResponseBody String uploadFiles(@RequestParam("file") MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        ImageEntity image = new ImageEntity();
        image.setImage(bytes);
        em.persist(image);
        return image.getId().toString();
    }
}
