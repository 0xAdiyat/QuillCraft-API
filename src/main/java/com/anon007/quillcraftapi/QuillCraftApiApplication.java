package com.anon007.quillcraftapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuillCraftApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuillCraftApiApplication.class, args);
    }

    /*
     * === STEPS ===
     * Entity -> DTO -> Repository -> Service -> ServiceImplement
     *           -- Add validation                              -- @Service
     *                                                          -- Create DTO to Entity ModelMapper
     *                                                          -- Create Entity to DTO ModelMapper
     *                                                                  -> Controller
     *                                                                      -- @RestController
     *                                                                      -- @RequestMapping("/api/v1/")
     */

}
