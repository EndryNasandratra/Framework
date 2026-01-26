package testFramework.com.testframework.model;

public class Departement {
    private Long id;
    private String nomDept;

    public Departement() {}

    public Departement(Long id, String nomDept) {
        this.id = id;
        this.nomDept = nomDept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomDept() {
        return nomDept;
    }

    public void setNomDept(String nomDept) {
        this.nomDept = nomDept;
    }

    public static Departement fromId(String id) {
        if (id == null || id.trim().isEmpty()) return null;
        Long deptId;
        try {
            deptId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            return null;
        }

        if (deptId == 1L) return new Departement(1L, "Informatique");
        if (deptId == 2L) return new Departement(2L, "Ressources Humaines");
        if (deptId == 3L) return new Departement(3L, "Marketing");

        return null;
    }
}
