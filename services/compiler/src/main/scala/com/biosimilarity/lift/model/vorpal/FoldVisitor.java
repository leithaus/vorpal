package com.biosimilarity.lift.model.vorpal;

import com.biosimilarity.lift.model.vorpal.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* LGrammar */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LGr p, A arg) {
      R r = leaf(arg);
      for (LDef x : p.listldef_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* LDef */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.DefAll p, A arg) {
      R r = leaf(arg);
      r = combine(p.def_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.DefSome p, A arg) {
      R r = leaf(arg);
      r = combine(p.def_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LDefView p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Grammar */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Grammar p, A arg) {
      R r = leaf(arg);
      for (Def x : p.listdef_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* Def */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Rule p, A arg) {
      R r = leaf(arg);
      r = combine(p.label_.accept(this, arg), r, arg);
      r = combine(p.cat_.accept(this, arg), r, arg);
      for (Item x : p.listitem_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Comment p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Comments p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Internal p, A arg) {
      R r = leaf(arg);
      r = combine(p.label_.accept(this, arg), r, arg);
      r = combine(p.cat_.accept(this, arg), r, arg);
      for (Item x : p.listitem_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Token p, A arg) {
      R r = leaf(arg);
      r = combine(p.reg_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.PosToken p, A arg) {
      R r = leaf(arg);
      r = combine(p.reg_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Entryp p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Separator p, A arg) {
      R r = leaf(arg);
      r = combine(p.minimumsize_.accept(this, arg), r, arg);
      r = combine(p.cat_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminator p, A arg) {
      R r = leaf(arg);
      r = combine(p.minimumsize_.accept(this, arg), r, arg);
      r = combine(p.cat_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Coercions p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Rules p, A arg) {
      R r = leaf(arg);
      for (RHS x : p.listrhs_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Function p, A arg) {
      R r = leaf(arg);
      for (Arg x : p.listarg_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Layout p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Item */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminal p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.NTerminal p, A arg) {
      R r = leaf(arg);
      r = combine(p.cat_.accept(this, arg), r, arg);
      return r;
    }

/* Cat */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListCat p, A arg) {
      R r = leaf(arg);
      r = combine(p.cat_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.IdCat p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Label */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabNoP p, A arg) {
      R r = leaf(arg);
      r = combine(p.labelid_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabP p, A arg) {
      R r = leaf(arg);
      r = combine(p.labelid_.accept(this, arg), r, arg);
      for (ProfItem x : p.listprofitem_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabPF p, A arg) {
      R r = leaf(arg);
      r = combine(p.labelid_1.accept(this, arg), r, arg);
      r = combine(p.labelid_2.accept(this, arg), r, arg);
      for (ProfItem x : p.listprofitem_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabF p, A arg) {
      R r = leaf(arg);
      r = combine(p.labelid_1.accept(this, arg), r, arg);
      r = combine(p.labelid_2.accept(this, arg), r, arg);
      return r;
    }

/* LabelId */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Id p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Wild p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListE p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListCons p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListOne p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* ProfItem */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ProfIt p, A arg) {
      R r = leaf(arg);
      for (IntList x : p.listintlist_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* IntList */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Ints p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Arg */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Arg p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Exp */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Cons p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.App p, A arg) {
      R r = leaf(arg);
      for (Exp x : p.listexp_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Var p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitInt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitChar p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitString p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitDouble p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.List p, A arg) {
      R r = leaf(arg);
      for (Exp x : p.listexp_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* RHS */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RHS p, A arg) {
      R r = leaf(arg);
      for (Item x : p.listitem_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* MinimumSize */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.MNonempty p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.MEmpty p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Reg */
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RSeq p, A arg) {
      R r = leaf(arg);
      r = combine(p.reg_1.accept(this, arg), r, arg);
      r = combine(p.reg_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAlt p, A arg) {
      R r = leaf(arg);
      r = combine(p.reg_1.accept(this, arg), r, arg);
      r = combine(p.reg_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RMinus p, A arg) {
      R r = leaf(arg);
      r = combine(p.reg_1.accept(this, arg), r, arg);
      r = combine(p.reg_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RStar p, A arg) {
      R r = leaf(arg);
      r = combine(p.reg_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RPlus p, A arg) {
      R r = leaf(arg);
      r = combine(p.reg_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ROpt p, A arg) {
      R r = leaf(arg);
      r = combine(p.reg_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.REps p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RChar p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAlts p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RSeqs p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RDigit p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RLetter p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RUpper p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RLower p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAny p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
