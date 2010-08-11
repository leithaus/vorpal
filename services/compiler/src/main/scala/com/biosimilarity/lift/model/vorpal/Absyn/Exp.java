package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public abstract class Exp implements java.io.Serializable {
  public abstract <R,A> R accept(Exp.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Cons p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.App p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Var p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitInt p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitChar p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitString p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitDouble p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.List p, A arg);

  }

}
