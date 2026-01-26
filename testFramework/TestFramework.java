package testFramework;

import framework.annotation.GetMapping;
import framework.annotation.AnnotationReader;

public class TestFramework {
    
    @GetMapping("/index")
    public void indexMethod() {
        // Methode avec annotation @GetMapping
    }
    
    @GetMapping("/home")
    public void homeMethod() {
        // Autre methode avec annotation @GetMapping
    }
    
    @GetMapping("/users")
    public void usersMethod() {
        // Troisieme methode avec annotation @GetMapping
    }
    
    public void methodWithoutAnnotation() {
        // Methode sans annotation
    }
    
    public static void main(String[] args) {
        System.out.println("=== Test des annotations @GetMapping ===");
        
        // Lire les annotations de la classe TestFramework
        AnnotationReader.readGetMappingAnnotations(TestFramework.class);
        
        System.out.println("=== Fin du test ===");
    }
}
