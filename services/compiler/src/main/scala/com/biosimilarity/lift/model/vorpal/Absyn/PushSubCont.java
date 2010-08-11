package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class PushSubCont extends ContinueExpr {
  public final Expression expression_1, expression_2;

  public PushSubCont(Expression p1, Expression p2) { expression_1 = p1; expression_2 = p2; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.ContinueExpr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.PushSubCont) {
      com.biosimilarity.lift.model.vorpal.Absyn.PushSubCont x = (com.biosimilarity.lift.model.vorpal.Absyn.PushSubCont)o;
      return this.expression_1.equals(x.expression_1) && this.expression_2.equals(x.expression_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.expression_1.hashCode())+this.expression_2.hashCode();
  }


}
