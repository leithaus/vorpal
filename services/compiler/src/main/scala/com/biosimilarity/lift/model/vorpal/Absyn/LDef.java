package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public abstract class LDef implements java.io.Serializable {
  public abstract <R,A> R accept(LDef.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.DefAll p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.DefSome p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LDefView p, A arg);

  }

}
