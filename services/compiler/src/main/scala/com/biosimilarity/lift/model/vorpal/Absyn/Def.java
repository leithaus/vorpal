package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public abstract class Def implements java.io.Serializable {
  public abstract <R,A> R accept(Def.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Rule p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Comment p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Comments p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Internal p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Token p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.PosToken p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Entryp p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Separator p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminator p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Coercions p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Rules p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Function p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Layout p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop p, A arg);
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop p, A arg);

  }

}
