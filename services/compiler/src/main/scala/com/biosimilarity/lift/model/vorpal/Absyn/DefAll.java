package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class DefAll extends LDef {
  public final Def def_;

  public DefAll(Def p1) { def_ = p1; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.LDef.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.DefAll) {
      com.biosimilarity.lift.model.vorpal.Absyn.DefAll x = (com.biosimilarity.lift.model.vorpal.Absyn.DefAll)o;
      return this.def_.equals(x.def_);
    }
    return false;
  }

  public int hashCode() {
    return this.def_.hashCode();
  }


}