package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class Cons extends Exp {
  public final Exp exp_1, exp_2;

  public Cons(Exp p1, Exp p2) { exp_1 = p1; exp_2 = p2; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.Cons) {
      com.biosimilarity.lift.model.vorpal.Absyn.Cons x = (com.biosimilarity.lift.model.vorpal.Absyn.Cons)o;
      return this.exp_1.equals(x.exp_1) && this.exp_2.equals(x.exp_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.exp_1.hashCode())+this.exp_2.hashCode();
  }


}