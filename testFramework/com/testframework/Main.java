package testFramework.com.testframework;

import framework.annotation.AnnotationReader;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Demarrage de l'application ===\n");
        
        // Initialisation du systeme au demarrage (scan des URLs une seule fois)
        AnnotationReader.init();
        
        System.out.println("=== Affichage des classes scannees ===\n");
        // Le package de base est defini dans testFramework/resources/config.properties
        AnnotationReader.displayClassesWithAnnotations();
        
        System.out.println("\n=== Test de recherche d'URL ===\n");
        
        // Test avec des URLs existantes
        testUrl("/test");
        testUrl("/hello");
        testUrl("/users");
        testUrl("/users/create");
        testUrl("/admin/dashboard");
        testUrl("/admin/settings");
            // Test same URL with GET and POST
            testUrlWithMethod("/admin/echo", "GET");
            testUrlWithMethod("/admin/echo", "POST");
        
        // Test avec une URL non existante
        testUrl("/nonexistent");
        testUrl("/api/test");
    }
    
    private static void testUrl(String url) {
        System.out.println("\nRecherche de l'URL: " + url);
        AnnotationReader.displayMappingForUrl(url);
    }

    private static void testUrlWithMethod(String url, String method) {
        System.out.println("\nRecherche de l'URL: " + url + " via " + method);
        framework.utilitaire.MappingInfo info = AnnotationReader.findMappingByUrl(url, method);
        if (info == null || !info.isFound()) {
            if (info != null && info.isMethodNotAllowed()) {
                System.out.println("Result: 405 Method Not Allowed. Allowed: " + info.getAllowedMethods());
            } else {
                System.out.println("Result: 404 Not Found");
            }
        } else {
            System.out.println("Result: Found -> Controller=" + info.getClassName() + " method=" + info.getMethodName() + " httpMethod=" + info.getHttpMethod());
        }
    }
}
