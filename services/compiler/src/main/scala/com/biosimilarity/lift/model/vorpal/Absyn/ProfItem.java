package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public abstract class ProfItem implements java.io.Serializable {
  public abstract <R,A> R accept(ProfItem.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ProfIt p, A arg);

  }

}
