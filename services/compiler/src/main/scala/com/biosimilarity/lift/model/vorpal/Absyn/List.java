package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class List extends Exp {
  public final ListExp listexp_;

  public List(ListExp p1) { listexp_ = p1; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.List) {
      com.biosimilarity.lift.model.vorpal.Absyn.List x = (com.biosimilarity.lift.model.vorpal.Absyn.List)o;
      return this.listexp_.equals(x.listexp_);
    }
    return false;
  }

  public int hashCode() {
    return this.listexp_.hashCode();
  }


}