package com.biosimilarity.lift.model.vorpal;
import com.biosimilarity.lift.model.vorpal.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  com.biosimilarity.lift.model.vorpal.Absyn.LGrammar.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.LGrammar,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.LDef.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.LDef,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.Grammar.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.Grammar,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.Def.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.Def,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.Item.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.Item,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.Cat.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.Cat,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.Label.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.Label,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.LabelId.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.LabelId,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.ProfItem.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.ProfItem,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.IntList.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.IntList,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.Arg.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.Arg,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.Exp.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.Exp,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.RHS.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.RHS,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.MinimumSize.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.MinimumSize,A>,
  com.biosimilarity.lift.model.vorpal.Absyn.Reg.Visitor<com.biosimilarity.lift.model.vorpal.Absyn.Reg,A>
{
/* LGrammar */
    public LGrammar visit(com.biosimilarity.lift.model.vorpal.Absyn.LGr p, A arg)
    {
      ListLDef listldef_ = new ListLDef();
      for (LDef x : p.listldef_) {
        listldef_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.LGr(listldef_);
    }

/* LDef */
    public LDef visit(com.biosimilarity.lift.model.vorpal.Absyn.DefAll p, A arg)
    {
      Def def_ = p.def_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.DefAll(def_);
    }
    public LDef visit(com.biosimilarity.lift.model.vorpal.Absyn.DefSome p, A arg)
    {
      ListIdent listident_ = p.listident_;
      Def def_ = p.def_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.DefSome(listident_, def_);
    }
    public LDef visit(com.biosimilarity.lift.model.vorpal.Absyn.LDefView p, A arg)
    {
      ListIdent listident_ = p.listident_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.LDefView(listident_);
    }

/* Grammar */
    public Grammar visit(com.biosimilarity.lift.model.vorpal.Absyn.Grammar p, A arg)
    {
      ListDef listdef_ = new ListDef();
      for (Def x : p.listdef_) {
        listdef_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.Grammar(listdef_);
    }

/* Def */
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Rule p, A arg)
    {
      Label label_ = p.label_.accept(this, arg);
      Cat cat_ = p.cat_.accept(this, arg);
      ListItem listitem_ = new ListItem();
      for (Item x : p.listitem_) {
        listitem_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.Rule(label_, cat_, listitem_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Comment p, A arg)
    {
      String string_ = p.string_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Comment(string_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Comments p, A arg)
    {
      String string_1 = p.string_1;
      String string_2 = p.string_2;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Comments(string_1, string_2);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Internal p, A arg)
    {
      Label label_ = p.label_.accept(this, arg);
      Cat cat_ = p.cat_.accept(this, arg);
      ListItem listitem_ = new ListItem();
      for (Item x : p.listitem_) {
        listitem_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.Internal(label_, cat_, listitem_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Token p, A arg)
    {
      String ident_ = p.ident_;
      Reg reg_ = p.reg_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.Token(ident_, reg_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.PosToken p, A arg)
    {
      String ident_ = p.ident_;
      Reg reg_ = p.reg_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.PosToken(ident_, reg_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Entryp p, A arg)
    {
      ListIdent listident_ = p.listident_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Entryp(listident_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Separator p, A arg)
    {
      MinimumSize minimumsize_ = p.minimumsize_.accept(this, arg);
      Cat cat_ = p.cat_.accept(this, arg);
      String string_ = p.string_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Separator(minimumsize_, cat_, string_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminator p, A arg)
    {
      MinimumSize minimumsize_ = p.minimumsize_.accept(this, arg);
      Cat cat_ = p.cat_.accept(this, arg);
      String string_ = p.string_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Terminator(minimumsize_, cat_, string_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Coercions p, A arg)
    {
      String ident_ = p.ident_;
      Integer integer_ = p.integer_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Coercions(ident_, integer_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Rules p, A arg)
    {
      String ident_ = p.ident_;
      ListRHS listrhs_ = new ListRHS();
      for (RHS x : p.listrhs_) {
        listrhs_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.Rules(ident_, listrhs_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Function p, A arg)
    {
      String ident_ = p.ident_;
      ListArg listarg_ = new ListArg();
      for (Arg x : p.listarg_) {
        listarg_.add(x.accept(this,arg));
      }
      Exp exp_ = p.exp_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.Function(ident_, listarg_, exp_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.Layout p, A arg)
    {
      ListString liststring_ = p.liststring_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Layout(liststring_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop p, A arg)
    {
      ListString liststring_ = p.liststring_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop(liststring_);
    }
    public Def visit(com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop();
    }

/* Item */
    public Item visit(com.biosimilarity.lift.model.vorpal.Absyn.Terminal p, A arg)
    {
      String string_ = p.string_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Terminal(string_);
    }
    public Item visit(com.biosimilarity.lift.model.vorpal.Absyn.NTerminal p, A arg)
    {
      Cat cat_ = p.cat_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.NTerminal(cat_);
    }

/* Cat */
    public Cat visit(com.biosimilarity.lift.model.vorpal.Absyn.ListCat p, A arg)
    {
      Cat cat_ = p.cat_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.ListCat(cat_);
    }
    public Cat visit(com.biosimilarity.lift.model.vorpal.Absyn.IdCat p, A arg)
    {
      String ident_ = p.ident_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.IdCat(ident_);
    }

/* Label */
    public Label visit(com.biosimilarity.lift.model.vorpal.Absyn.LabNoP p, A arg)
    {
      LabelId labelid_ = p.labelid_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.LabNoP(labelid_);
    }
    public Label visit(com.biosimilarity.lift.model.vorpal.Absyn.LabP p, A arg)
    {
      LabelId labelid_ = p.labelid_.accept(this, arg);
      ListProfItem listprofitem_ = new ListProfItem();
      for (ProfItem x : p.listprofitem_) {
        listprofitem_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.LabP(labelid_, listprofitem_);
    }
    public Label visit(com.biosimilarity.lift.model.vorpal.Absyn.LabPF p, A arg)
    {
      LabelId labelid_1 = p.labelid_1.accept(this, arg);
      LabelId labelid_2 = p.labelid_2.accept(this, arg);
      ListProfItem listprofitem_ = new ListProfItem();
      for (ProfItem x : p.listprofitem_) {
        listprofitem_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.LabPF(labelid_1, labelid_2, listprofitem_);
    }
    public Label visit(com.biosimilarity.lift.model.vorpal.Absyn.LabF p, A arg)
    {
      LabelId labelid_1 = p.labelid_1.accept(this, arg);
      LabelId labelid_2 = p.labelid_2.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.LabF(labelid_1, labelid_2);
    }

/* LabelId */
    public LabelId visit(com.biosimilarity.lift.model.vorpal.Absyn.Id p, A arg)
    {
      String ident_ = p.ident_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Id(ident_);
    }
    public LabelId visit(com.biosimilarity.lift.model.vorpal.Absyn.Wild p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.Wild();
    }
    public LabelId visit(com.biosimilarity.lift.model.vorpal.Absyn.ListE p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.ListE();
    }
    public LabelId visit(com.biosimilarity.lift.model.vorpal.Absyn.ListCons p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.ListCons();
    }
    public LabelId visit(com.biosimilarity.lift.model.vorpal.Absyn.ListOne p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.ListOne();
    }

/* ProfItem */
    public ProfItem visit(com.biosimilarity.lift.model.vorpal.Absyn.ProfIt p, A arg)
    {
      ListIntList listintlist_ = new ListIntList();
      for (IntList x : p.listintlist_) {
        listintlist_.add(x.accept(this,arg));
      }
      ListInteger listinteger_ = p.listinteger_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.ProfIt(listintlist_, listinteger_);
    }

/* IntList */
    public IntList visit(com.biosimilarity.lift.model.vorpal.Absyn.Ints p, A arg)
    {
      ListInteger listinteger_ = p.listinteger_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Ints(listinteger_);
    }

/* Arg */
    public Arg visit(com.biosimilarity.lift.model.vorpal.Absyn.Arg p, A arg)
    {
      String ident_ = p.ident_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Arg(ident_);
    }

/* Exp */
    public Exp visit(com.biosimilarity.lift.model.vorpal.Absyn.Cons p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.Cons(exp_1, exp_2);
    }
    public Exp visit(com.biosimilarity.lift.model.vorpal.Absyn.App p, A arg)
    {
      String ident_ = p.ident_;
      ListExp listexp_ = new ListExp();
      for (Exp x : p.listexp_) {
        listexp_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.App(ident_, listexp_);
    }
    public Exp visit(com.biosimilarity.lift.model.vorpal.Absyn.Var p, A arg)
    {
      String ident_ = p.ident_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.Var(ident_);
    }
    public Exp visit(com.biosimilarity.lift.model.vorpal.Absyn.LitInt p, A arg)
    {
      Integer integer_ = p.integer_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.LitInt(integer_);
    }
    public Exp visit(com.biosimilarity.lift.model.vorpal.Absyn.LitChar p, A arg)
    {
      Character char_ = p.char_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.LitChar(char_);
    }
    public Exp visit(com.biosimilarity.lift.model.vorpal.Absyn.LitString p, A arg)
    {
      String string_ = p.string_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.LitString(string_);
    }
    public Exp visit(com.biosimilarity.lift.model.vorpal.Absyn.LitDouble p, A arg)
    {
      Double double_ = p.double_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.LitDouble(double_);
    }
    public Exp visit(com.biosimilarity.lift.model.vorpal.Absyn.List p, A arg)
    {
      ListExp listexp_ = new ListExp();
      for (Exp x : p.listexp_) {
        listexp_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.List(listexp_);
    }

/* RHS */
    public RHS visit(com.biosimilarity.lift.model.vorpal.Absyn.RHS p, A arg)
    {
      ListItem listitem_ = new ListItem();
      for (Item x : p.listitem_) {
        listitem_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.lift.model.vorpal.Absyn.RHS(listitem_);
    }

/* MinimumSize */
    public MinimumSize visit(com.biosimilarity.lift.model.vorpal.Absyn.MNonempty p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.MNonempty();
    }
    public MinimumSize visit(com.biosimilarity.lift.model.vorpal.Absyn.MEmpty p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.MEmpty();
    }

/* Reg */
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RSeq p, A arg)
    {
      Reg reg_1 = p.reg_1.accept(this, arg);
      Reg reg_2 = p.reg_2.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.RSeq(reg_1, reg_2);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RAlt p, A arg)
    {
      Reg reg_1 = p.reg_1.accept(this, arg);
      Reg reg_2 = p.reg_2.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.RAlt(reg_1, reg_2);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RMinus p, A arg)
    {
      Reg reg_1 = p.reg_1.accept(this, arg);
      Reg reg_2 = p.reg_2.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.RMinus(reg_1, reg_2);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RStar p, A arg)
    {
      Reg reg_ = p.reg_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.RStar(reg_);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RPlus p, A arg)
    {
      Reg reg_ = p.reg_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.RPlus(reg_);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.ROpt p, A arg)
    {
      Reg reg_ = p.reg_.accept(this, arg);

      return new com.biosimilarity.lift.model.vorpal.Absyn.ROpt(reg_);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.REps p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.REps();
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RChar p, A arg)
    {
      Character char_ = p.char_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.RChar(char_);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RAlts p, A arg)
    {
      String string_ = p.string_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.RAlts(string_);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RSeqs p, A arg)
    {
      String string_ = p.string_;

      return new com.biosimilarity.lift.model.vorpal.Absyn.RSeqs(string_);
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RDigit p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.RDigit();
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RLetter p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.RLetter();
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RUpper p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.RUpper();
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RLower p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.RLower();
    }
    public Reg visit(com.biosimilarity.lift.model.vorpal.Absyn.RAny p, A arg)
    {

      return new com.biosimilarity.lift.model.vorpal.Absyn.RAny();
    }

}