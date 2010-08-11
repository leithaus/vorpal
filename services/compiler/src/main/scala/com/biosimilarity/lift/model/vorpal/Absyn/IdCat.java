package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class IdCat extends Cat {
  public final String ident_;

  public IdCat(String p1) { ident_ = p1; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.Cat.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.IdCat) {
      com.biosimilarity.lift.model.vorpal.Absyn.IdCat x = (com.biosimilarity.lift.model.vorpal.Absyn.IdCat)o;
      return this.ident_.equals(x.ident_);
    }
    return false;
  }

  public int hashCode() {
    return this.ident_.hashCode();
  }


}
