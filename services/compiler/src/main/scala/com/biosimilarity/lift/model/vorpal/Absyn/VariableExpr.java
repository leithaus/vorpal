package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public abstract class VariableExpr implements java.io.Serializable {
  public abstract <R,A> R accept(VariableExpr.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Transcription p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.AtomLiteral p, A arg);

  }

}
