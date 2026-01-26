package testFramework.com.testframework.model;

public class Lieu {
    private Long id;
    private String ville;
    private String pays;

    public Lieu() {}

    public Lieu(Long id, String ville, String pays) {
        this.id = id;
        this.ville = ville;
        this.pays = pays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public static Lieu fromId(String id) {
        if (id == null || id.trim().isEmpty()) return null;
        Long lieuId;
        try {
            lieuId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            return null;
        }

        if (lieuId == 1L) return new Lieu(1L, "Paris", "France");
        if (lieuId == 2L) return new Lieu(2L, "Lyon", "France");
        if (lieuId == 3L) return new Lieu(3L, "Marseille", "France");

        return null;
    }
}
