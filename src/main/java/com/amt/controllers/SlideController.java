package com.amt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SlideController {
    private static final List<Object> FIRST_PAGE_SLIDE = new ArrayList<>();
    @Autowired
    private ResourceLoader resourceLoader;

    static {
        for (int i = 1; i < 5; i++) {
            FIRST_PAGE_SLIDE.add(new MapBuilder<String, String>().put("url", "demos/sliderbg_0" + i + ".jpg").build());
        }
    }

    @RequestMapping("\\slide")
    public
    @ResponseBody
    List<Object> getSlideshowImages() {
        return FIRST_PAGE_SLIDE;
    }

    static class MapBuilder<T, V> {
        Map<T, V> toReturn = new HashMap<>();

        public MapBuilder<T, V> put(T key, V object) {
            toReturn.put(key, object);
            return this;
        }

        public Map<T, V> build() {
            return toReturn;
        }
    }
}
