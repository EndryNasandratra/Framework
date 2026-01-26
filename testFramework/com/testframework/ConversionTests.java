package testFramework.com.testframework;

import framework.utilitaire.ConversionService;
import framework.utilitaire.ConverterRegistry;
import testFramework.com.testframework.model.Departement;
import testFramework.com.testframework.model.EmployeDTO;
import testFramework.com.testframework.model.Lieu;

public class ConversionTests {

    public static void main(String[] args) {
        testDepartementConverter();
        testLieuConverter();
        testRegistry();
        testConversionService();
        testBindingSimulation();
    }

    private static void testDepartementConverter() {
        Departement d = Departement.fromId("2");
        System.out.println("Test DepartementConverter: " + (d != null && d.getId() == 2L && "Ressources Humaines".equals(d.getNomDept())));
    }

    private static void testLieuConverter() {
        Lieu l = Lieu.fromId("1");
        System.out.println("Test LieuConverter: " + (l != null && l.getId() == 1L && "Paris".equals(l.getVille())));
    }

    private static void testRegistry() {
        ConverterRegistry registry = new ConverterRegistry();
        boolean ok1 = registry.getConverter(String.class, Departement.class) == null;
        boolean ok2 = !registry.canConvert(String.class, Lieu.class);
        System.out.println("Test ConverterRegistry (vide): getConverter=" + ok1 + ", canConvert(Lieu)=" + ok2);
    }

    private static void testConversionService() {
        ConversionService cs = ConversionService.getInstance();
        Departement d = cs.convert("2", Departement.class);
        System.out.println("Test ConversionService simple: " + (d != null && d.getId() == 2L));
    }

    private static void testBindingSimulation() {
        ConversionService cs = ConversionService.getInstance();

        EmployeDTO dto = new EmployeDTO();
        dto.setNom("Alice");
        dto.setAge(25);
        dto.setDept(cs.convert("1", Departement.class));
        dto.setLieu(cs.convert("2", Lieu.class));

        boolean ok = "Alice".equals(dto.getNom())
                && dto.getAge() == 25
                && dto.getDept() != null && dto.getDept().getId() == 1L
                && dto.getLieu() != null && dto.getLieu().getId() == 2L;

        System.out.println("Test binding simulation: " + ok);
    }
}
