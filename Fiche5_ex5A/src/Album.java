import java.lang.Thread.Builder;

public class Album {

  private final String titre, nomArtiste, label, producter, paysArtiste, version, genre;
  private final int anneeParution, anneeParutionOriginale, debitQualiteStandard, debitEnModeAbonne;
  private final boolean isRemasterise;

  public Album(Builder builder) {
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


  public static class Builder {
    private final String titre, nomArtiste;
    private String label, producter, paysArtiste, version, genre;
    private int anneeParution, anneeParutionOriginale, debitQualiteStandard, debitEnModeAbonne;
    private boolean isRemasterise;

    public Builder(String titre, String nomArtiste) {
      this.titre = titre;
      this.nomArtiste = nomArtiste;
    }

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

    public Album build() {
      return new Album(this);
    }

  }

}
