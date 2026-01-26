package testFramework.com.testframework.controller;

import framework.annotation.Controller;
import framework.annotation.GetMapping;
import framework.annotation.PostMapping;
import framework.annotation.ModelAttribute;
import framework.annotation.RequestParam;
import framework.utilitaire.ModelAndView;
import framework.http.MultipartFile;
import testFramework.com.testframework.model.UploadForm;

import jakarta.servlet.http.HttpServletRequest;

import java.io.File;

@Controller
public class UploadController {

    @GetMapping("/aiza/form")
    public ModelAndView showUploadForm() {
        ModelAndView mv = new ModelAndView("upload-form");
        mv.addObject("form", new UploadForm());
        return mv;
    }

    // Test via @RequestParam direct
    @PostMapping("/aiza/request-param")
    public ModelAndView handleRequestParam(@RequestParam("title") String title,
                                           @RequestParam("file") MultipartFile file,
                                           HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("upload-result");
        mv.addObject("mode", "requestParam");
        mv.addObject("title", title);
        mv.addObject("fileName", file != null ? file.getOriginalFilename() : null);
        mv.addObject("fileSize", file != null ? file.getSize() : 0L);
        mv.addObject("contentType", file != null ? file.getContentType() : null);
        // Sauvegarde directe du fichier dans /uploads
        String savedPath = null;
        try {
            if (file != null && !file.isEmpty()) {
                String uploadDirPath = request.getServletContext().getRealPath("/uploads");
                File uploadDir = new File(uploadDirPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String originalName = file.getOriginalFilename();
                if (originalName == null || originalName.isEmpty()) {
                    originalName = "uploaded.bin";
                }

                File dest = new File(uploadDir, originalName);
                file.transferTo(dest);
                savedPath = request.getContextPath() + "/uploads/" + originalName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("savedPath", savedPath);

        return mv;
    }

    // Test via @ModelAttribute
    @PostMapping("/aiza/model-attribute")
    public ModelAndView handleModelAttribute(@ModelAttribute UploadForm form,
                                             HttpServletRequest request) {
        MultipartFile file = form.getFile();
        ModelAndView mv = new ModelAndView("upload-result");
        mv.addObject("mode", "modelAttribute");
        mv.addObject("title", form.getTitle());
        mv.addObject("fileName", file != null ? file.getOriginalFilename() : null);
        mv.addObject("fileSize", file != null ? file.getSize() : 0L);
        mv.addObject("contentType", file != null ? file.getContentType() : null);
        // Sauvegarde directe du fichier dans /uploads
        String savedPath = null;
        try {
            if (file != null && !file.isEmpty()) {
                String uploadDirPath = request.getServletContext().getRealPath("/uploads");
                File uploadDir = new File(uploadDirPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String originalName = file.getOriginalFilename();
                if (originalName == null || originalName.isEmpty()) {
                    originalName = "uploaded.bin";
                }

                File dest = new File(uploadDir, originalName);
                file.transferTo(dest);
                savedPath = request.getContextPath() + "/uploads/" + originalName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("savedPath", savedPath);

        return mv;
    }

}
