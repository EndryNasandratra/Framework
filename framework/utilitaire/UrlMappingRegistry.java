package framework.utilitaire;

import framework.annotation.GetMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Responsable de la gestion du registre des mappings URL -> Classe/Methode
 * Principe de Responsabilite Unique (SRP)
 */
public class UrlMappingRegistry {
    
    private Map<String, MappingInfo> urlMappings;
    private boolean initialized;
    
    public UrlMappingRegistry() {
        this.urlMappings = new HashMap<>();
        this.initialized = false;
    }
    
    /**
     * Construit le registre des URLs a partir des classes scannees
     * @param classes Liste des classes avec @Controller
     */
    public void buildRegistry(List<Class<?>> classes) {
        if (initialized) {
            System.out.println("Registre deja initialise.");
            return;
        }
        
        urlMappings.clear();
        int urlCount = 0;
        
        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getDeclaredMethods();
            
            for (Method method : methods) {
                if (method.isAnnotationPresent(GetMapping.class)) {
                    GetMapping mapping = method.getAnnotation(GetMapping.class);
                    String url = mapping.value();
                    urlMappings.put(url, new MappingInfo(clazz, method, url));
                    urlCount++;
                }
            }
        }
        
        initialized = true;
        System.out.println("Registre construit: " + urlCount + " URL(s) mappee(s).\n");
    }
    
    /**
     * Recherche un mapping par URL
     * @param url L'URL a rechercher
     * @return MappingInfo ou null si non trouve
     */
    public MappingInfo findByUrl(String url) {
        return urlMappings.get(url);
    }
    
    /**
     * Verifie si le registre est initialise
     */
    public boolean isInitialized() {
        return initialized;
    }
    
    /**
     * Retourne le nombre d'URLs enregistrees
     */
    public int size() {
        return urlMappings.size();
    }
}
