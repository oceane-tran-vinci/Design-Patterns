public class Album {
  // 1) Champs du "Product" (Album) : immuables => final
  private final String titre, nomArtiste, label, producter, paysArtiste, version, genre;
  private final int anneeParution, anneeParutionOriginale, debitQualiteStandard, debitEnModeAbonne;
  private final boolean isRemasterise;

  // 2) Constructeur PRIVATE : on ne construit Album que via Builder.build()
  private Album(Builder builder) {
    // On copie toutes les valeurs du builder vers l'objet final
    this.titre = builder.titre;
    this.nomArtiste = builder.nomArtiste;
    this.label = builder.label;
    this.producter = builder.producter;
    this.paysArtiste = builder.paysArtiste;
    this.version = builder.version;
    this.genre = builder.genre;
    this.anneeParution = builder.anneeParution;
    this.anneeParutionOriginale = builder.anneeParutionOriginale;
    this.debitQualiteStandard = builder.debitQualiteStandard;
    this.debitEnModeAbonne = builder.debitEnModeAbonne;
    this.isRemasterise = builder.isRemasterise;
  }

  // 3) Getters (pas de setters)
  public String getTitre() {
    return titre;
  }

  public String getNomArtiste() {
    return nomArtiste;
  }

  public String getLabel() {
    return label;
  }

  public String getProducter() {
    return producter;
  }

  public String getPaysArtiste() {
    return paysArtiste;
  }

  public String getVersion() {
    return version;
  }

  public String getGenre() {
    return genre;
  }

  public int getAnneeParution() {
    return anneeParution;
  }

  public int getAnneeParutionOriginale() {
    return anneeParutionOriginale;
  }

  public int getDebitQualiteStandard() {
    return debitQualiteStandard;
  }

  public int getDebitEnModeAbonne() {
    return debitEnModeAbonne;
  }

  public boolean isRemasterise() {
    return isRemasterise;
  }


  // 4) Builder interne (static = pas besoin d'une instance d'Album pour l'utiliser)
  public static class Builder {
    // 4.1 Champs obligatoires => final
    private final String titre, nomArtiste;

    // 4.2 Champs optionnels (par défaut null / 0 / false)
    private String label, producter, paysArtiste, version, genre;
    private int anneeParution, anneeParutionOriginale, debitQualiteStandard, debitEnModeAbonne;
    private boolean isRemasterise;

    //4.3 Constructeur qui prend que les attributs obligatoire
    public Builder(String titre, String nomArtiste) {
      this.titre = titre;
      this.nomArtiste = nomArtiste;
    }

    //4.3 Les méthodes chainables (les “setter-like”)
    public Builder label (String label) {
      this.label = label;
      return this;
    }

    public Builder producter (String producter) {
      this.producter = producter;
      return this;
    }

    public Builder paysArtiste(String paysArtiste) {
      this.paysArtiste = paysArtiste;
      return this;
    }

    public Builder version(String version) {
      this.version = version;
      return this;
    }

    public Builder genre(String genre) {
      this.genre = genre;
      return this;
    }

    public Builder anneeParution(int anneeParution) {
      this.anneeParution = anneeParution;
      return this;
    }

    public Builder anneeParutionOriginale(int anneeParutionOriginale) {
      this.anneeParutionOriginale = anneeParutionOriginale;
      return this;
    }

    public Builder debitQualiteStandard(int debitQualiteStandard) {
      this.debitQualiteStandard = debitQualiteStandard;
      return this;
    }

    public Builder debitEnModeAbonne(int debitEnModeAbonne) {
      this.debitEnModeAbonne = debitEnModeAbonne;
      return this;
    }

    public Builder isRemasterise(boolean isRemasterise) {
      this.isRemasterise = isRemasterise;
      return this;
    }

    //4.4 La méthode build()
    public Album build() {
      return new Album(this);
    }
  }

}
