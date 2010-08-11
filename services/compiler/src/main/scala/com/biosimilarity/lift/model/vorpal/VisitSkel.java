package com.biosimilarity.lift.model.vorpal;
import com.biosimilarity.lift.model.vorpal.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class LGrammarVisitor<R,A> implements LGrammar.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LGr p, A arg)
    {
      /* Code For LGr Goes Here */

      for (LDef x : p.listldef_) {
      }

      return null;
    }

  }
  public class LDefVisitor<R,A> implements LDef.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.DefAll p, A arg)
    {
      /* Code For DefAll Goes Here */

      p.def_.accept(new DefVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.DefSome p, A arg)
    {
      /* Code For DefSome Goes Here */

      for (String x : p.listident_) {
      }
      p.def_.accept(new DefVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LDefView p, A arg)
    {
      /* Code For LDefView Goes Here */

      for (String x : p.listident_) {
      }

      return null;
    }

  }
  public class GrammarVisitor<R,A> implements Grammar.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Grammar p, A arg)
    {
      /* Code For Grammar Goes Here */

      for (Def x : p.listdef_) {
      }

      return null;
    }

  }
  public class DefVisitor<R,A> implements Def.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Rule p, A arg)
    {
      /* Code For Rule Goes Here */

      p.label_.accept(new LabelVisitor<R,A>(), arg);
      p.cat_.accept(new CatVisitor<R,A>(), arg);
      for (Item x : p.listitem_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Comment p, A arg)
    {
      /* Code For Comment Goes Here */

      //p.string_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Comments p, A arg)
    {
      /* Code For Comments Goes Here */

      //p.string_1;
      //p.string_2;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Internal p, A arg)
    {
      /* Code For Internal Goes Here */

      p.label_.accept(new LabelVisitor<R,A>(), arg);
      p.cat_.accept(new CatVisitor<R,A>(), arg);
      for (Item x : p.listitem_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Token p, A arg)
    {
      /* Code For Token Goes Here */

      //p.ident_;
      p.reg_.accept(new RegVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.PosToken p, A arg)
    {
      /* Code For PosToken Goes Here */

      //p.ident_;
      p.reg_.accept(new RegVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Entryp p, A arg)
    {
      /* Code For Entryp Goes Here */

      for (String x : p.listident_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Separator p, A arg)
    {
      /* Code For Separator Goes Here */

      p.minimumsize_.accept(new MinimumSizeVisitor<R,A>(), arg);
      p.cat_.accept(new CatVisitor<R,A>(), arg);
      //p.string_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminator p, A arg)
    {
      /* Code For Terminator Goes Here */

      p.minimumsize_.accept(new MinimumSizeVisitor<R,A>(), arg);
      p.cat_.accept(new CatVisitor<R,A>(), arg);
      //p.string_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Coercions p, A arg)
    {
      /* Code For Coercions Goes Here */

      //p.ident_;
      //p.integer_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Rules p, A arg)
    {
      /* Code For Rules Goes Here */

      //p.ident_;
      for (RHS x : p.listrhs_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Function p, A arg)
    {
      /* Code For Function Goes Here */

      //p.ident_;
      for (Arg x : p.listarg_) {
      }
      p.exp_.accept(new ExpVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Layout p, A arg)
    {
      /* Code For Layout Goes Here */

      for (String x : p.liststring_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop p, A arg)
    {
      /* Code For LayoutStop Goes Here */

      for (String x : p.liststring_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop p, A arg)
    {
      /* Code For LayoutTop Goes Here */


      return null;
    }

  }
  public class ItemVisitor<R,A> implements Item.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminal p, A arg)
    {
      /* Code For Terminal Goes Here */

      //p.string_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.NTerminal p, A arg)
    {
      /* Code For NTerminal Goes Here */

      p.cat_.accept(new CatVisitor<R,A>(), arg);

      return null;
    }

  }
  public class CatVisitor<R,A> implements Cat.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListCat p, A arg)
    {
      /* Code For ListCat Goes Here */

      p.cat_.accept(new CatVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.IdCat p, A arg)
    {
      /* Code For IdCat Goes Here */

      //p.ident_;

      return null;
    }

  }
  public class LabelVisitor<R,A> implements Label.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabNoP p, A arg)
    {
      /* Code For LabNoP Goes Here */

      p.labelid_.accept(new LabelIdVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabP p, A arg)
    {
      /* Code For LabP Goes Here */

      p.labelid_.accept(new LabelIdVisitor<R,A>(), arg);
      for (ProfItem x : p.listprofitem_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabPF p, A arg)
    {
      /* Code For LabPF Goes Here */

      p.labelid_1.accept(new LabelIdVisitor<R,A>(), arg);
      p.labelid_2.accept(new LabelIdVisitor<R,A>(), arg);
      for (ProfItem x : p.listprofitem_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LabF p, A arg)
    {
      /* Code For LabF Goes Here */

      p.labelid_1.accept(new LabelIdVisitor<R,A>(), arg);
      p.labelid_2.accept(new LabelIdVisitor<R,A>(), arg);

      return null;
    }

  }
  public class LabelIdVisitor<R,A> implements LabelId.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Id p, A arg)
    {
      /* Code For Id Goes Here */

      //p.ident_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Wild p, A arg)
    {
      /* Code For Wild Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListE p, A arg)
    {
      /* Code For ListE Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListCons p, A arg)
    {
      /* Code For ListCons Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ListOne p, A arg)
    {
      /* Code For ListOne Goes Here */


      return null;
    }

  }
  public class ProfItemVisitor<R,A> implements ProfItem.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ProfIt p, A arg)
    {
      /* Code For ProfIt Goes Here */

      for (IntList x : p.listintlist_) {
      }
      for (Integer x : p.listinteger_) {
      }

      return null;
    }

  }
  public class IntListVisitor<R,A> implements IntList.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Ints p, A arg)
    {
      /* Code For Ints Goes Here */

      for (Integer x : p.listinteger_) {
      }

      return null;
    }

  }
  public class ArgVisitor<R,A> implements Arg.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Arg p, A arg)
    {
      /* Code For Arg Goes Here */

      //p.ident_;

      return null;
    }

  }
  public class ExpVisitor<R,A> implements Exp.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Cons p, A arg)
    {
      /* Code For Cons Goes Here */

      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.App p, A arg)
    {
      /* Code For App Goes Here */

      //p.ident_;
      for (Exp x : p.listexp_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.Var p, A arg)
    {
      /* Code For Var Goes Here */

      //p.ident_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitInt p, A arg)
    {
      /* Code For LitInt Goes Here */

      //p.integer_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitChar p, A arg)
    {
      /* Code For LitChar Goes Here */

      //p.char_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitString p, A arg)
    {
      /* Code For LitString Goes Here */

      //p.string_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.LitDouble p, A arg)
    {
      /* Code For LitDouble Goes Here */

      //p.double_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.List p, A arg)
    {
      /* Code For List Goes Here */

      for (Exp x : p.listexp_) {
      }

      return null;
    }

  }
  public class RHSVisitor<R,A> implements RHS.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RHS p, A arg)
    {
      /* Code For RHS Goes Here */

      for (Item x : p.listitem_) {
      }

      return null;
    }

  }
  public class MinimumSizeVisitor<R,A> implements MinimumSize.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.MNonempty p, A arg)
    {
      /* Code For MNonempty Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.MEmpty p, A arg)
    {
      /* Code For MEmpty Goes Here */


      return null;
    }

  }
  public class RegVisitor<R,A> implements Reg.Visitor<R,A>
  {
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RSeq p, A arg)
    {
      /* Code For RSeq Goes Here */

      p.reg_1.accept(new RegVisitor<R,A>(), arg);
      p.reg_2.accept(new RegVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAlt p, A arg)
    {
      /* Code For RAlt Goes Here */

      p.reg_1.accept(new RegVisitor<R,A>(), arg);
      p.reg_2.accept(new RegVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RMinus p, A arg)
    {
      /* Code For RMinus Goes Here */

      p.reg_1.accept(new RegVisitor<R,A>(), arg);
      p.reg_2.accept(new RegVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RStar p, A arg)
    {
      /* Code For RStar Goes Here */

      p.reg_.accept(new RegVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RPlus p, A arg)
    {
      /* Code For RPlus Goes Here */

      p.reg_.accept(new RegVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.ROpt p, A arg)
    {
      /* Code For ROpt Goes Here */

      p.reg_.accept(new RegVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.REps p, A arg)
    {
      /* Code For REps Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RChar p, A arg)
    {
      /* Code For RChar Goes Here */

      //p.char_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAlts p, A arg)
    {
      /* Code For RAlts Goes Here */

      //p.string_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RSeqs p, A arg)
    {
      /* Code For RSeqs Goes Here */

      //p.string_;

      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RDigit p, A arg)
    {
      /* Code For RDigit Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RLetter p, A arg)
    {
      /* Code For RLetter Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RUpper p, A arg)
    {
      /* Code For RUpper Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RLower p, A arg)
    {
      /* Code For RLower Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.lift.model.vorpal.Absyn.RAny p, A arg)
    {
      /* Code For RAny Goes Here */


      return null;
    }

  }
}