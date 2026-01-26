package testFramework.com.testframework;

import framework.utilitaire.FormMapper;
import framework.utilitaire.ValidationResult;
import testFramework.com.testframework.controller.UserController;
import testFramework.com.testframework.model.UserForm;

import java.util.HashMap;
import java.util.Map;

public class FormMappingTest {

    public static void main(String[] args) {
        testBasicMapping();
        testValidationMissingAndInvalid();
        testControllerHandling();
        testEdgeCases();
    }

    private static void testBasicMapping() {
        Map<String, Object> formData = new HashMap<>();
        formData.put("username", "john");
        formData.put("email", "john@example.com");
        formData.put("password", "secret123");

        UserForm user = FormMapper.map(formData, UserForm.class);

        System.out.println("=== Test de mapping basique ===");
        System.out.println("username=" + user.getUsername());
        System.out.println("email=" + user.getEmail());
        System.out.println("password=" + user.getPassword());
    }

    private static void testValidationMissingAndInvalid() {
        Map<String, Object> formData = new HashMap<>();
        formData.put("username", "");
        formData.put("email", "wrong-email");
        formData.put("password", "123");

        UserForm user = FormMapper.map(formData, UserForm.class);
        boolean ok = user.isValid();
        ValidationResult result = user.getLastValidationResult();

        System.out.println("=== Test de validation (manquants / invalides) ===");
        System.out.println("isValid=" + ok);
        for (Map.Entry<String, String> e : result.getFieldErrors().entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    private static void testControllerHandling() {
        Map<String, Object> formData = new HashMap<>();
        formData.put("username", "alice");
        formData.put("email", "alice@example.com");
        formData.put("password", "password123");

        UserController controller = new UserController();
        UserForm user = controller.handleRegistration(formData);

        System.out.println("=== Test de contrôleur ===");
        System.out.println("isValid=" + user.isValid());
        System.out.println("username=" + user.getUsername());
        System.out.println("email=" + user.getEmail());
    }

    private static void testEdgeCases() {
        Map<String, Object> emptyMap = new HashMap<>();
        UserForm emptyUser = FormMapper.map(emptyMap, UserForm.class);

        Map<String, Object> nullMap = null;
        UserForm nullUser = FormMapper.map(nullMap, UserForm.class);

        Map<String, Object> extraFields = new HashMap<>();
        extraFields.put("username", "bob");
        extraFields.put("email", "bob@example.com");
        extraFields.put("password", "secret456");
        extraFields.put("unusedField", "ignored");

        UserForm extraUser = FormMapper.map(extraFields, UserForm.class);

        System.out.println("=== Test de cas limites ===");
        System.out.println("emptyUser valid=" + emptyUser.isValid());
        System.out.println("nullUser valid=" + nullUser.isValid());
        System.out.println("extraUser username=" + extraUser.getUsername());
        System.out.println("extraUser email=" + extraUser.getEmail());
    }
}
