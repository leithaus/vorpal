package com.biosimilarity.lift.model.vorpal;
import com.biosimilarity.lift.model.vorpal.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* LGrammar */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LGr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.LGrammar p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* LDef */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.DefAll p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.DefSome p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LDefView p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.LDef p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Grammar */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Grammar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.Grammar p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Def */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Rule p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Comment p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Comments p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Internal p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Token p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.PosToken p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Entryp p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Separator p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminator p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Coercions p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Rules p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Function p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Layout p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.Def p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Item */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminal p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.NTerminal p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.Item p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Cat */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListCat p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.IdCat p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.Cat p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Label */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabNoP p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabP p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabPF p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabF p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.Label p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* LabelId */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Id p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Wild p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListE p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListCons p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListOne p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.LabelId p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ProfItem */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ProfIt p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.ProfItem p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* IntList */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Ints p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.IntList p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Arg */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Arg p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.Arg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Exp */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Cons p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.App p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Var p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitInt p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitChar p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitString p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitDouble p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.List p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RHS */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RHS p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.RHS p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* MinimumSize */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.MNonempty p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.MEmpty p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.MinimumSize p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Reg */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RSeq p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAlt p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RMinus p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RStar p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RPlus p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ROpt p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.REps p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RChar p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAlts p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RSeqs p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RDigit p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RLetter p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RUpper p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RLower p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAny p, A arg) { return visitDefault(p, arg); }


    public R visitDefault(com.biosimilarity.lift.model.vorpal.Absyn.Reg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
